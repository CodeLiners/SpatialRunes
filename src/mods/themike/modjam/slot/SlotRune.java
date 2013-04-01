package mods.themike.modjam.slot;

import mods.themike.modjam.items.ItemRune;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotRune extends Slot {
	
	private static ItemStack item = null;
	
	
	public SlotRune(ItemStack par1Item, IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
		item = par1Item;
	}
	
	@Override 
	public boolean isItemValid(ItemStack stack) {
		if(stack == null) {
			return true;
		} else if(stack.getItem() == item.getItem() && stack.getItemDamage() == item.getItemDamage()) {
			return true;
		} else {
			return false;
		}
	}

}
