pluginManagement {
	plugins {
		id("net.luis.lm") version "1.1.0"
	}
	
	repositories {
		gradlePluginPortal()
		maven {
			name = "NeoForged"
			url = uri("https://maven.neoforged.net/releases")
		}
		maven {
			url = uri("https://maven.luis-st.net/plugins/")
		}
	}
}
