package net.luis.xores.common.material;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.resources.ResourceLocation;

public class MaterialType {
	
	protected final ResourceLocation name;
	protected final MaterialType.Type type;
	protected final Predicate<Material> predicate;
	
	public MaterialType(String name, MaterialType.Type type, Predicate<Material> predicate) {
		this(new ResourceLocation(name), type, predicate);
	}
	
	public MaterialType(ResourceLocation name, MaterialType.Type type, Predicate<Material> predicate) {
		this.name = name;
		this.type = type;
		this.predicate = predicate;
	}
	
	public ResourceLocation getName() {
		return this.name;
	}
	
	public MaterialType.Type getType() {
		return this.type;
	}
	
	public boolean test(Material material) {
		return this.predicate.test(material);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		} else if (object instanceof MaterialType materialType) {
			if (materialType.getName().equals(this.name)) {
				return materialType.getType() == this.getType();
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.name.toString();
	}
	
	@Nullable
	public static MaterialType byName(ResourceLocation name) {
		return MaterialTypes.NAME_TO_TYPE.get(name);
	}
	
	public static enum Type {
		
		MATERIAL("material"),
		ITEM("item"),
		TAG("tag");
		
		protected final String name;
		
		private Type(String name) {
			this.name = name;
		}
		
	}
	
}
