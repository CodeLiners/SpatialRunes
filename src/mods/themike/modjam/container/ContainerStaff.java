
package mods.themike.modjam.container;

import mods.themike.modjam.ModJam;
import mods.themike.modjam.inventory.InventoryStaff;
import mods.themike.modjam.slot.SlotStaff;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerStaff extends Container {
					
	private IInventory inventory;
	private EntityPlayer player;
	private long timestamp; 
	
	public ContainerStaff(EntityPlayer par1, IInventory par2) {		
		player = par1;
		inventory = par2;
		
		if(par1.getHeldItem().getItemDamage() == 0) {
			this.addSlotToContainer(new SlotStaff(inventory, 0, 80, 22, true));
		} else {
			this.addSlotToContainer(new SlotStaff(inventory, 0, 80, 22, false));
		}						
		int var3;
		
		for(var3 = 0; var3 < 3; ++var3) {
			for(int var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(player.inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18 - 17));
			}
		}
		
		for(var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(player.inventory, var3, 8 + var3 * 18, 125));
		}
		
		ItemStack staff = player.getHeldItem();
		InventoryStaff staffInv = (InventoryStaff) inventory;
		if(staff != null) {
			if(staff.getTagCompound() != null && staff.getTagCompound().getTag("item") != null) {
				staffInv.inventory[0] = ItemStack.loadItemStackFromNBT((NBTTagCompound) staff.getTagCompound().getTag("item"));
			}
		}
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		Slot slotObject = (Slot) inventorySlots.get(slot);
		if(slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			ItemStack stack = stackInSlot.copy();
			ItemStack newStack = stackInSlot.splitStack(1);
			if(slot <= 1) {
				if(!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true))
					return null;
			} else if(slot > 0 && stack.itemID == ModJam.runes.itemID && !getSlot(0).getHasStack() && getSlot(0).isItemValid(newStack)) {
				if(!mergeItemStack(newStack, 0, 1, true))
					return null;
			} else {
				return null;
			}

			if(stackInSlot.stackSize == 0)
				slotObject.putStack(null);
			else
				slotObject.onSlotChanged();

			return stack;
		}
		return null;
	}

}