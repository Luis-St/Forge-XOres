package net.luis.xores.common.material.set;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.luis.xores.common.material.Material;
import net.luis.xores.common.material.MaterialType;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;

public class ToolSet {
	
	public static final ToolSet EMPTY = new ToolSet.Builder().build();
	
	public static final MaterialType PICKAXE = new MaterialType("pickaxe");
	public static final MaterialType AXE = new MaterialType("axe");
	public static final MaterialType SHOVEL = new MaterialType("shovel");
	public static final MaterialType HOE = new MaterialType("hoe");
	
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
	
	public List<MaterialType> getTypes() {
		return Lists.newArrayList(PICKAXE, AXE, SHOVEL, HOE);
	}
	
	public boolean has(MaterialType type) {
		if (type == PICKAXE) {
			return this.pickaxe.isPresent();
		} else if (type == AXE) {
			return this.axe.isPresent();
		} else if (type == SHOVEL) {
			return this.shovel.isPresent();
		} else if (type == HOE) {
			return this.hoe.isPresent();
		}
		return false;
	}
	
	public boolean hasAll() {
		for (MaterialType type : this.getTypes()) {
			if (!this.has(type)) {
				return false;
			}
		}
		return true;
	}
	
	@Nullable
	public DiggerItem get(MaterialType type) {
		if (type == PICKAXE) {
			return this.pickaxe.get();
		} else if (type == AXE) {
			return this.axe.get();
		} else if (type == SHOVEL) {
			return this.shovel.get();
		} else if (type == HOE) {
			return this.hoe.get();
		}
		return null;
	}
	
	public void ifPresent(MaterialType type, Consumer<Item> consumer) {
		if (this.has(type)) {
			consumer.accept(this.get(type));
		}
	}
	
	public void ifPresent(MaterialType firstType, MaterialType secondType, BiConsumer<Item, Item> consumer) {
		if (this.has(firstType) && this.has(secondType)) {
			consumer.accept(this.get(firstType), this.get(secondType));
		}
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
