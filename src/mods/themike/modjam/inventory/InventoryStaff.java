package mods.themike.modjam.inventory;

import themike.core.util.ItemHelper;
import mods.themike.modjam.ModJam;
import mods.themike.modjam.items.ItemRune;
import mods.themike.modjam.items.ItemStaff;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InventoryStaff implements IInventory {
	
	public ItemStack[] inventory = new ItemStack[1];

	EntityPlayer player = null;
	long time = 0;
	
	public InventoryStaff(EntityPlayer par1) {
		player = par1;
		time = player.inventory.getStackInSlot(player.inventory.currentItem).getTagCompound().getLong("timestamp");
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
		System.out.println("Hello!");
		if(i == 0) {
			save();
		}
	}
	
	public void save() {
		
		int timestamp = ItemHelper.findTimeStamp(player.inventory, new ItemStack(ModJam.staff), time);
		
		if(timestamp != -1) {
			ItemStack staff = player.inventory.getStackInSlot(timestamp);

			if(!player.worldObj.isRemote && staff != null) {
				ItemStack rune = getStackInSlot(0);
				if(rune != null) {
					NBTTagCompound tag = new NBTTagCompound();
					rune.writeToNBT(tag);
					if (staff.getTagCompound() == null) staff.setTagCompound(new NBTTagCompound());
					staff.getTagCompound().setTag("item", tag);
					player.inventory.setInventorySlotContents(ItemHelper.findTimeStamp(player.inventory, new ItemStack(ModJam.staff), time), staff);
				} else {
					staff.setTagCompound(new NBTTagCompound());
				}
			}
		}
		
	}
	
	public void clear() {
		System.out.println("Clearing");
		
		int timestamp = ItemHelper.findTimeStamp(player.inventory, new ItemStack(ModJam.staff), time);
		
		if(timestamp != -1) {
			ItemStack staff = player.inventory.getStackInSlot(timestamp);

			if(!player.worldObj.isRemote && staff != null) {
				staff.getTagCompound().removeTag("item");
			}
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
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

}
