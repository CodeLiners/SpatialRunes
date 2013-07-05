package mods.themike.modjam.container;

import themike.core.gui.slot.SlotClosed;
import themike.core.gui.slot.SlotSpecific;
import mods.themike.modjam.ModJam;
import mods.themike.modjam.tile.TileEntityCarvingStone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerCarvingStone extends Container {
	
	private static TileEntityCarvingStone inventory;
	private static EntityPlayer player;

	public ContainerCarvingStone(EntityPlayer par1, IInventory par2) {
		
		player = par1;
		inventory = (TileEntityCarvingStone) par2;
		
		this.addSlotToContainer(new Slot(inventory, 0, 80, 15));
        this.addSlotToContainer(new SlotSpecific(new ItemStack(ModJam.runes, 0, 0), inventory, 1, 69, 39));
        this.addSlotToContainer(new SlotSpecific(new ItemStack(Item.dyePowder, 1, 4), inventory, 2, 91, 39));
		this.addSlotToContainer(new SlotClosed(inventory, 3, 124, 15));
		this.addSlotToContainer(new SlotClosed(inventory, 4, 141, 15));
		this.addSlotToContainer(new SlotClosed(inventory, 5, 36, 15));
		this.addSlotToContainer(new SlotClosed(inventory, 6, 19, 15));
		
		int var3;
		
		for(var3 = 0; var3 < 3; ++var3) {
			for(int var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(player.inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18 - 17));
			}
		}
		
		for(var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(player.inventory, var3, 8 + var3 * 18, 125));
		}
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            ItemStack stack = null;
            Slot slotObject = getSlot(slot);

            if (slotObject != null && slotObject.getHasStack()) {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();

                    if (slot < 3) {
                        if (!this.mergeItemStack(stackInSlot, 7, inventorySlots.size(), true)) {
                            return null;
                        }
                    } else if(slot > 6) {
                    	if(this.getSlot(2).isItemValid(stackInSlot) && !this.mergeItemStack(stackInSlot, 2, 3, true)) {
                    		return null;
                    	}
                    	if(this.getSlot(1).isItemValid(stackInSlot) && !this.mergeItemStack(stackInSlot, 1, 2, true)) {
                    		return null;
                    	}
                    	if(!this.mergeItemStack(stackInSlot, 0, 1, true)) {
                    		return null;
                    	}
                    }

        			if(stackInSlot.stackSize == 0)
        				slotObject.putStack(null);
        			else
        				slotObject.onSlotChanged();

                    if (stackInSlot.stackSize == stack.stackSize) {
                    	return null;
                    }
            }
            return stack;
    }

}
