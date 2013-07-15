package mods.themike.modjam.tile;


import com.google.common.collect.ObjectArrays;

import mods.themike.modjam.ModJam;
import mods.themike.modjam.api.runes.IRune;
import mods.themike.modjam.api.runes.RuneRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
		ItemStack stack;
		if(i >= 3) {
			if(inventory[0] != null && inventory[1] != null && inventory[2] != null) {
				remove(i);				
			} else {
				return null;
			}
		}
		if(inventory[i] != null) {
			if(inventory[i].stackSize - j > 0) {
				stack = inventory[i].splitStack(j);
				if(inventory[i].stackSize == 0) {
					inventory[i] = null;
				}
				update();
				return stack;
			} else {
				stack = inventory[i];
				inventory[i] = null;
				update();
				return stack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return inventory[i];
	}
	
	public void update() {
		if(inventory[0] != null && inventory[1] != null && inventory[2] != null) {
			Integer[] runes = new Integer[]{};
			for(int var1 = 1; var1 != RuneRegistry.getrunes().size(); var1++) {
				if(RuneRegistry.getrunes().get(var1).getSacrifice() == inventory[0].getItem()) {
					runes = ObjectArrays.concat(var1, runes);
				}
			}
			if(runes.length >= 1) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("uses", RuneRegistry.getrunes().get(runes[0]).getUses());
				ItemStack stack = new ItemStack(ModJam.runes, 1, runes[0]);
				stack.setTagCompound(tag);
				inventory[6] = stack;
			}
			if(runes.length >= 2) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("uses", RuneRegistry.getrunes().get(runes[1]).getUses());
				ItemStack stack = new ItemStack(ModJam.runes, 1, runes[1]);
				stack.setTagCompound(tag);
				inventory[5] = stack;
			}
			if(runes.length >= 3) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("uses", RuneRegistry.getrunes().get(runes[2]).getUses());
				ItemStack stack = new ItemStack(ModJam.runes, 1, runes[2]);
				stack.setTagCompound(tag);
				inventory[3] = stack;
			}
			if(runes.length >= 4) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("uses", RuneRegistry.getrunes().get(runes[3]).getUses());
				ItemStack stack = new ItemStack(ModJam.runes, 1, runes[3]);
				stack.setTagCompound(tag);
				inventory[4] = stack;
			}
		} else {
			inventory[3] = null;
			inventory[4] = null;
			inventory[5] = null;
			inventory[6] = null;
		}
	}
	
	public void remove(int i) {
		if(inventory[0] != null && inventory[1] != null && inventory[2] != null) {
			inventory[0].splitStack(1);
			if(inventory[0].stackSize == 0) {
				inventory[0] = null;
			}
			inventory[1].splitStack(1);
			if(inventory[1].stackSize == 0) {
				inventory[1] = null;
			}
			inventory[2].splitStack(1);
			if(inventory[2].stackSize == 0) {
				inventory[2] = null;
			}
			if(i != 3) {
				inventory[3] = null;
			}
			if(i != 4) {
				inventory[4] = null;
			}
			if(i != 5) {
				inventory[5] = null;
			}
			if(i != 6) {
				inventory[6] = null;
			}
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
		this.update();
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
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		for(int par1 = 0; par1 != inventory.length; par1++) {
			if(tag.getTag(String.valueOf(par1)) != null) {
				inventory[par1] = ItemStack.loadItemStackFromNBT((NBTTagCompound) tag.getTag(String.valueOf(par1)));
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		for(int par1 = 0; par1 != inventory.length; par1++) {
			NBTTagCompound com = new NBTTagCompound();
			if(inventory[par1] != null) {
				inventory[par1].writeToNBT(com);
				tag.setTag(String.valueOf(par1), com);
			}
		}
	}

}
