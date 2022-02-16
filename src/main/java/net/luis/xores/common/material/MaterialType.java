package net.luis.xores.common.material;

import javax.annotation.Nullable;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;

/**
 * used to add a {@link Material} to a {@link MaterialSet}
 * 
 * @see {@link MaterialTypes}
 * 
 * @author Luis-st
 * 
 * @see {@link Material}
 * @see {@link MaterialSet}
 */

public class MaterialType {
	
	/**
	 * the name of the {@link MaterialType} as a {@link ResourceLocation}
	 */
	protected final ResourceLocation name;
	
	/**
	 * the type of the {@link MaterialType}
	 */
	protected final MaterialType.Type type;
	
	/**
	 * @see {@link MaterialType#MaterialType(ResourceLocation, Type)}
	 */
	public MaterialType(String name, MaterialType.Type type) {
		this(new ResourceLocation(name), type);
	}
	
	/**
	 * constructor for the {@link MaterialType}
	 */
	public MaterialType(ResourceLocation name, MaterialType.Type type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * getter for the name
	 * @return {@link MaterialType#name}
	 */
	public ResourceLocation getName() {
		return this.name;
	}
	
	/**
	 * getter for the type
	 * @return {@link MaterialType#type}
	 */
	public MaterialType.Type getType() {
		return this.type;
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
	
	/**
	 * @return the {@link MaterialType} for the given {@link ResourceLocation},<br>
	 * {@code null} if the there is no {@link MaterialType} for the name
	 */
	@Nullable
	public static MaterialType byName(ResourceLocation name) {
		return MaterialTypes.NAME_TO_TYPE.get(name);
	}
	
	/**
	 * the {@link Type} for a {@link MaterialType},<br>
	 * used for all {@link MaterialType}s
	 * 
	 * @author Luis-st
	 * 
	 * @see {@link MaterialType}
	 */
	public static enum Type {
		
		/**
		 * {@link Type} for all {@link MaterialType}s which only accepts both {@link Item}s and {@link Named} tags
		 */
		MATERIAL("material"),
		
		/**
		 * {@link Type} for all {@link MaterialType}s which only accepts {@link Item}s
		 */
		ITEM("item"),
		
		/**
		 * {@link Type} for all {@link MaterialType}s which only accepts {@link Named} tags
		 */
		TAG("tag");
		
		/**
		 * the name of the {@link Type} as a {@link String}
		 */
		protected final String name;
		
		/**
		 * constructor for the {@link Type}
		 */
		private Type(String name) {
			this.name = name;
		}
		
		/**
		 * getter for the name
		 * @return {@link Type#name}
		 */
		public String getName() {
			return this.name;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
	}
	
}
