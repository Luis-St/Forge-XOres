import java.text.SimpleDateFormat
import java.util.Date

plugins {
	idea
	`maven-publish`
	id("net.neoforged.gradle.userdev") version "7.0.+"
	id("org.spongepowered.mixin") version "0.7.+"
	id("com.github.joschi.licenser") version "0.6.0"
	id("io.github.themrmilchmann.curseforge-publish") version "0.6.1"
}

val mavenUsername: String? = System.getenv("MAVEN_USERNAME")
val mavenPassword: String? = System.getenv("MAVEN_PASSWORD")
val curseforgeToken: String? = System.getenv("CURSEFORGE_TOKEN")

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

println("Java: ${System.getProperty("java.version")}, JVM: ${System.getProperty("java.vm.version")} (${System.getProperty("java.vendor")}), Arch: ${System.getProperty("os.arch")}")

minecraft {
	mappings("official", property("MinecraftVersion").toString())

	reobf = false
	copyIdeResources = true

	accessTransformers {
		file("src/main/resources/META-INF/accesstransformer.cfg")
	}

	runs {
		configureEach {
			workingDirectory(project.file("run"))

			property("neoforge.logging.markers", "REGISTRIES")
			property("neoforge.logging.console.level", "debug")
			property("neoforge.enabledGameTestNamespaces", "xores")
		}

		create("client")

		create("server")

		create("gameTestServer")

		create("data") {
			property("xores.data.include", "mod")

			programArguments.addAll(
				"--mod", "xores",
				"--all",
				"--output", file("src/generated/resources/").absolutePath,
				"--existing", file("src/main/resources/").absolutePath
			)
		}

		create("dataPackRarer") {
			property("xores.data.include", "rarer")
			parent(runs["data"])
		}

		create("dataPackVeryRare") {
			property("xores.data.include", "very_rare")
			parent(runs["data"])
		}
	}
}

mixin {
	config("xores.mixins.json")
	debug.export = true
}

sourceSets {
	main {
		resources {
			srcDir("src/generated/resources")
		}
	}
}

dependencies {
	implementation("net.neoforged:neoforge:${property("NeoForgeVersion")}")

	implementation("net.sf.jopt-simple:jopt-simple:5.0.4") {
		version {
			strictly("5.0.4")
		}
	}

	annotationProcessor("org.spongepowered:mixin:0.8.7:processor")
}

tasks.compileJava {
	dependsOn(tasks.updateLicenses)
}

license {
	header = file("header.txt")
	include("**/*.java")
}

java {
	withSourcesJar()
}

val ver = "${property("MinecraftVersion")}-${property("ModVersion")}"

curseforge {
	apiToken = curseforgeToken ?: ""
	publications {
		register("curseForge") {
			projectId = "584702"

			artifacts.register("main") {
				displayName = "XOres-$ver"
				from(tasks.named("jar"))
			}
		}
	}
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			groupId = "net.luis"
			artifactId = "XOres"
			version = ver
			artifact(tasks.jar)
			artifact(tasks.named("sourcesJar"))
		}
	}
	repositories {
		if (mavenUsername != null && mavenPassword != null) {
			maven {
				url = uri("https://maven.luis-st.net/forge/")
				credentials {
					username = mavenUsername
					password = mavenPassword
				}
			}
		} else {
			println("No credentials provided. Publishing to maven.luis-st.net not possible.")
		}
	}
}

val resourceTargets = listOf("META-INF/neoforge.mods.toml")
val replaceProperties = mapOf(
	"MinecraftVersion" to property("MinecraftVersion"),
	"MinecraftVersionRange" to property("MinecraftVersionRange"),
	"NeoForgeVersion" to property("NeoForgeVersion"),
	"NeoForgeVersionRange" to property("NeoForgeVersionRange"),
	"NeoForgeLoaderRange" to property("NeoForgeLoaderRange"),
	"ModVersion" to property("ModVersion")
)

tasks.processResources {
	inputs.properties(replaceProperties)
	val modifiedProperties = replaceProperties.toMutableMap()
	modifiedProperties["project"] = project

	filesMatching(resourceTargets) {
		expand(modifiedProperties)
	}
}

tasks.jar {
	archiveFileName = "XOres-$ver.jar"
	manifest {
		attributes(
			mapOf(
				"Specification-Title" to "XOres",
				"Specification-Version" to property("ModVersion"),
				"Implementation-Title" to project.name,
				"Implementation-Timestamp" to SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ").format(Date()),
				"Mod-Author" to "Luis-st",
				"Mod-ID" to "xores",
				"MixinConfigs" to "xores.mixins.json"
			)
		)
	}
}

tasks.named<Jar>("sourcesJar") {
	outputs.upToDateWhen { false }
}

tasks.withType<JavaCompile>().configureEach {
	options.encoding = "UTF-8"
}

sourceSets.forEach {
	val dir = layout.buildDirectory.dir("sourcesSets/${it.name}")
	it.output.setResourcesDir(dir)
	it.java.destinationDirectory = dir
}
