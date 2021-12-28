package net.luis.xores.data.newmaterial.stuff;

import java.util.Optional;

import net.luis.xores.data.newmaterial.Material;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;

public class ToolSet {
	
	public static final ToolSet EMPTY = new ToolSet.Builder().build();
	
	protected final Optional<Material> toolMaterial;
	protected final Optional<PickaxeItem> pickaxe;
	protected final Optional<AxeItem> axe;
	protected final Optional<ShovelItem> shovel;
	protected final Optional<HoeItem> hoe;
	
	ToolSet(Optional<Material> toolMaterial, Optional<PickaxeItem> pickaxe, Optional<AxeItem> axe, Optional<ShovelItem> shovel, Optional<HoeItem> hoe) {
		this.toolMaterial = toolMaterial;
		this.pickaxe = pickaxe;
		this.axe = axe;
		this.shovel = shovel;
		this.hoe = hoe;
	}
	
	public boolean hasToolMaterial() {
		return this.toolMaterial.isPresent();
	}
	
	public Material getToolMaterial() {
		return this.toolMaterial.get();
	}
	
	public boolean hasPickaxe() {
		return this.pickaxe.isPresent();
	}
	
	public PickaxeItem getPickaxe() {
		return this.pickaxe.get();
	}
	
	public boolean hasAxe() {
		return this.axe.isPresent();
	}
	
	public AxeItem getAxe() {
		return this.axe.get();
	}
	
	public boolean hasShovel() {
		return this.shovel.isPresent();
	}
	
	public ShovelItem getShovel() {
		return this.shovel.get();
	}
	
	public boolean hasHoe() {
		return this.hoe.isPresent();
	}
	
	public HoeItem getHoe() {
		return this.hoe.get();
	}
	
	public static class Builder {
		
		protected Material toolMaterial = null;
		protected PickaxeItem pickaxe = null;
		protected AxeItem axe = null;
		protected ShovelItem shovel = null;
		protected HoeItem hoe = null;
		
		ToolSet.Builder toolMaterial(Material toolMaterial) {
			this.toolMaterial = toolMaterial;
			return this;
		}
		
		public ToolSet.Builder toolMaterial(Item toolMaterial) {
			return this.toolMaterial(Material.item(toolMaterial));
		}
		
		public ToolSet.Builder toolMaterial(Named<Item> toolMaterial) {
			return this.toolMaterial(Material.tag(toolMaterial));
		}
		
		public ToolSet.Builder pickaxe(PickaxeItem pickaxe) {
			this.pickaxe = pickaxe;
			return this;
		}
		
		public ToolSet.Builder axe(AxeItem axe) {
			this.axe = axe;
			return this;
		}
		
		public ToolSet.Builder shovel(ShovelItem shovel) {
			this.shovel = shovel;
			return this;
		}
		
		public ToolSet.Builder hoe(HoeItem hoe) {
			this.hoe = hoe;
			return this;
		}
		
		public ToolSet build() {
			return new ToolSet(Optional.ofNullable(this.toolMaterial), Optional.ofNullable(this.pickaxe), Optional.ofNullable(this.axe), Optional.ofNullable(this.shovel), Optional.ofNullable(this.hoe));
		}
		
	}
	
}
