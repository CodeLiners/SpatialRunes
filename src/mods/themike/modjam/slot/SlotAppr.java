package mods.themike.modjam.slot;

import mods.themike.modjam.items.ItemRune;
import mods.themike.modjam.rune.RuneRegistry;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAppr extends Slot {

	public SlotAppr(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	@Override 
	public boolean isItemValid(ItemStack stack) {
		if(stack == null) {
			return true;
		} else if(stack.getItem() instanceof ItemRune) {
			if(RuneRegistry.getrunes()[stack.getItemDamage()].getLevel() <= 25) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
