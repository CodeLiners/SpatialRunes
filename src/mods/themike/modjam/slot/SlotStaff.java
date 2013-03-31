package mods.themike.modjam.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class SlotStaff extends Slot {

	private static EntityPlayer player;
	private static IInventory inventory;
	
	public SlotStaff(EntityPlayer par1, IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
		player = par1;
		inventory = par1iInventory;
	}
	
	public void onSlotChanged() {
		System.out.println("Hello Runes, SlotStaff!");

		ItemStack staff = player.getHeldItem();
		if(staff != null) {
			ItemStack rune = inventory.getStackInSlot(0);
			if(rune != null) {
				NBTTagCompound tag = new NBTTagCompound();
				rune.writeToNBT(tag);
				staff.setTagCompound(new NBTTagCompound());
				staff.getTagCompound().setTag("item", tag);
			}
		}
	}

}
