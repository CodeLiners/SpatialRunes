package mods.themike.modjam.container;

import mods.themike.modjam.ModJam;
import mods.themike.modjam.slot.SlotHelper;
import mods.themike.modjam.slot.SlotReject;
import mods.themike.modjam.slot.SlotRune;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerCarvingStone extends Container {
	
	private static IInventory inventory;
	private static EntityPlayer player;

	public ContainerCarvingStone(EntityPlayer par1, IInventory par2) {
		
		player = par1;
		inventory = par2;
		
		this.addSlotToContainer(new Slot(inventory, 0, 80, 15));
        this.addSlotToContainer(new SlotRune(new ItemStack(ModJam.runes, 0, 0), inventory, 1, 69, 39));
        this.addSlotToContainer(new SlotHelper(new ItemStack(Item.dyePowder, 1, 4), inventory, 2, 91, 39));
		this.addSlotToContainer(new SlotReject(inventory, 3, 124, 15));
		this.addSlotToContainer(new SlotReject(inventory, 4, 141, 15));
		this.addSlotToContainer(new SlotReject(inventory, 5, 36, 15));
		this.addSlotToContainer(new SlotReject(inventory, 6, 19, 15));
		
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
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        Slot slotObject = (Slot) inventorySlots.get(slot);
        if(slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            ItemStack stack = stackInSlot.copy();
            if(slot <= 6) {
                if(!mergeItemStack(stackInSlot, 7, inventorySlots.size(), true))
                    return null;
            } else if(slot > 6) {
                if(stack.itemID == ModJam.runes.itemID && stack.getItemDamage() == 0) {
                    if(getSlot(1).getHasStack()) {
                        ItemStack newStack = getSlot(1).getStack().copy();
                        if(getSlot(1).getStack().stackSize + stack.stackSize <= getSlot(1).getStack().getMaxStackSize()) {
                            newStack.stackSize = newStack.stackSize + stack.copy().stackSize;
                            getSlot(1).putStack(newStack);

                            return null;
                        } else {
                            ItemStack returnStack = stack.copy();
                            newStack.stackSize = newStack.getMaxStackSize();
                            returnStack.stackSize = returnStack.stackSize - (newStack.getMaxStackSize() - newStack.stackSize);
                            return returnStack;
                        }
                    } else {
                        getSlot(1).putStack(stack);
                        return null;
                    }
                } else if(stack.itemID == Item.dyePowder.itemID && stack.getItemDamage() == 4 && !getSlot(2).getHasStack()) {
                    if(getSlot(2).getHasStack()) {
                        ItemStack newStack = getSlot(2).getStack().copy();
                        if(getSlot(2).getStack().stackSize + stack.stackSize <= getSlot(2).getStack().getMaxStackSize()) {
                            newStack.stackSize = newStack.stackSize + stack.copy().stackSize;
                            getSlot(2).putStack(newStack);

                            return null;
                        } else {
                            ItemStack returnStack = stack.copy();
                            newStack.stackSize = newStack.getMaxStackSize();
                            returnStack.stackSize = returnStack.stackSize - (newStack.getMaxStackSize() - newStack.stackSize);
                            return returnStack;
                        }
                    } else {
                        getSlot(2).putStack(stack);
                        return null;
                    }
                } else {
                    if(getSlot(0).getHasStack()) {
                        if(getSlot(0).getStack().itemID == stack.itemID && getSlot(0).getStack().getItemDamage() == stack.getItemDamage()) {
                            ItemStack newStack = getSlot(0).getStack().copy();
                            if(getSlot(0).getStack().stackSize + stack.stackSize <= getSlot(0).getStack().getMaxStackSize()) {
                                newStack.stackSize = newStack.stackSize + stack.copy().stackSize;
                                getSlot(0).putStack(newStack);

                                return null;
                            } else {
                                ItemStack returnStack = stack.copy();
                                newStack.stackSize = newStack.getMaxStackSize();
                                returnStack.stackSize = returnStack.stackSize - (newStack.getMaxStackSize() - newStack.stackSize);
                                return returnStack;
                            }
                        }
                        return stack;
                    } else {
                        getSlot(0).putStack(stack);
                        return null;
                    }
                }
                ItemStack copy = slotObject.decrStackSize(1);
                getSlot(0).putStack(copy);
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
