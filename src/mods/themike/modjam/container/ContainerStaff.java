package mods.themike.modjam.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerStaff extends Container {
	
	private static IInventory inventory;
	private static EntityPlayer player;
	
	public ContainerStaff(EntityPlayer par1, IInventory par2) {		
		player = par1;
		inventory = par2;
		
		this.addSlotToContainer(new Slot(inventory, 0, 80, 37));
		
		int var3;
		
		for(var3 = 0; var3 < 3; ++var3) {
			for(int var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(player.inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}
		
		for(var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(player.inventory, var3, 8 + var3 * 18, 142));
		}
		
		ItemStack staff = player.getHeldItem();
		if(staff != null) {
			if(staff.getTagCompound() != null) {
				if(staff.getTagCompound().getTag("item") != null) {
					inventory.setInventorySlotContents(0, ItemStack.loadItemStackFromNBT((NBTTagCompound) staff.getTagCompound().getTag("item")));
				}
			}
		}
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		Slot slotInQuestion = (Slot) this.inventorySlots.get(slot);
		ItemStack stackCopy = null;
		
		if(slotInQuestion != null && slotInQuestion.getHasStack()) {
			ItemStack stackInSlot = slotInQuestion.getStack();
			stackCopy = stackInSlot.copy();
			
			if(slot == 0) {
				if(!this.mergeItemStack(stackInSlot, 1, this.inventorySlots.size(), true)) {
					return null;
				}
			} else if(!this.mergeItemStack(stackInSlot, 0, 0, false)) {
				return null;
			}
			return stackCopy;
		}
		return null;
	}
	
	@Override
	public void onCraftGuiClosed(EntityPlayer par1) {
		ItemStack staff = player.getHeldItem();
		if(staff != null) {
			ItemStack rune = inventory.getStackInSlot(0);
			if(rune != null) {
				NBTTagCompound tag = new NBTTagCompound();
				rune.writeToNBT(tag);
				staff.getTagCompound().setTag("item", tag);
			}
		}
	}

}
