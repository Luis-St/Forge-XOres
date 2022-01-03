package net.luis.xores.common.material;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

public class MaterialType {
	
	protected static final Map<String, MaterialType> TYPES = Maps.newHashMap();
	
	protected final String name;
	
	public MaterialType(String name) {
		this.name = name;
		TYPES.put(name, this);
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			
		} else if (object instanceof MaterialType materialType) {
			if (materialType.getName().equals(this.name)) {
				return true;
			}
		}
		return false;
	}
	
	public static List<MaterialType> getTypes() {
		return TYPES.values().stream().collect(Collectors.toList());
	}
	
	@Nullable
	public static MaterialType byName(String name) {
		return TYPES.get(name);
	}
	
}
