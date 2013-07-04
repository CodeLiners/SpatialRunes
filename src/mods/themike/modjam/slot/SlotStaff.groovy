package mods.themike.modjam.slot

import mods.themike.modjam.api.runes.*
import mods.themike.modjam.items.ItemRune
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.inventory.Slot
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound

class SlotStaff extends Slot {

	private boolean isAppr
	
	SlotStaff(IInventory inventory, int par2, int par3, int par4, boolean par5) {
		super(inventory, par2, par3, par4)
		isAppr = par5
	}
	
	@Override 
	boolean isItemValid(ItemStack stack) {
		if(stack == null) {
			return true
		} else if(stack.getItem() instanceof ItemRune) {
			if(isAppr) {
				if(RuneRegistry.getrunes()[stack.getItemDamage()].getLevel() <= 25) {
					return true
				} else {
					return false
				}
			}
			return true
		} else {
			return false
		}
	}

}
