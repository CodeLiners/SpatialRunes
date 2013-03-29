package mods.themike.modjam;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModJamTab extends CreativeTabs {

	public ModJamTab() {
		super("modJam");
	}
	
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ModJam.item, 1, 0);
	}

}
