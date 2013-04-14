package mods.themike.modjam.inventory;

import mods.themike.modjam.items.ItemRune;
import mods.themike.modjam.items.ItemStaff;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InventoryStaff implements IInventory {
	
	public ItemStack[] inventory = new ItemStack[1];

	EntityPlayer player = null;
	
	public InventoryStaff(EntityPlayer par1) {
		player = par1;
		
	}
	
	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		
		clear();
		
		if(inventory[i] != null){
			if(inventory[i].stackSize <= j){
				ItemStack invStack = inventory[i].copy();
				inventory[i] = null;
				return invStack;
			}else{
				ItemStack invStack1 = inventory[i].splitStack(j);
				if(inventory[i].stackSize == 0){
					inventory[i] = null;
				}
				return invStack1;
			}
		}
		
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return inventory[i];
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
		save();
	}
	
	public void save() {
		
		ItemStack staff = player.getHeldItem();

		if(staff != null) {
			ItemStack rune = getStackInSlot(0);
			if(rune != null) {
				NBTTagCompound tag = new NBTTagCompound();
				rune.writeToNBT(tag);
				if (staff.getTagCompound() == null) staff.setTagCompound(new NBTTagCompound());
				staff.getTagCompound().setTag("item", tag);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, staff);
			} else {
				staff.setTagCompound(new NBTTagCompound());
			}
		}
		
	}
	
	public void clear() {
		System.out.println("Clearing");
		ItemStack staff = player.getHeldItem();

		if(staff != null && staff.getItem() instanceof ItemStaff) {
			staff.setTagCompound(new NBTTagCompound());
		}
		
	}

	@Override
	public String getInvName() {
		return "Staff";
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public void onInventoryChanged() {
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {

	}
	

	@Override
	public void closeChest() {

	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

}
