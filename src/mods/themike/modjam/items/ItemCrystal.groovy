package mods.themike.modjam.items

import net.minecraft.item.ItemStack
import mods.themike.modjam.*
import themike.core.item.ItemBase

class ItemCrystal extends ItemBase {
	
	ItemCrystal(int par1) {
		super(par1, "spatialrunes", "essence")
		this.setCreativeTab(ModJam.tab)
		this.setMaxStackSize(1)
	}
	
	@Override
	boolean hasEffect(ItemStack stack) {
		return true	
	}

}
