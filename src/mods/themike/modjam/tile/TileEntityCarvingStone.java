package mods.themike.modjam.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCarvingStone extends TileEntity implements IInventory {

	private ItemStack[] inventory = new ItemStack[7];
	
	public TileEntityCarvingStone() {
		
	}
	
	@Override
	public int getSizeInventory() {
		return 7;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(inventory[i] != null) {
			if(inventory[i].stackSize <= j) {
				ItemStack newStack = inventory[i].copy();
				inventory[i] = null;
				return newStack;
			} else {
				ItemStack newStack = inventory[i].splitStack(j);
				if(inventory[i].stackSize == 0) {
					inventory[i] = null;
				}
				return newStack;
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
	}

	@Override
	public String getInvName() {
		return "Carving Stone";
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
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
