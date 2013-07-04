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
		if(i > 2 && i <= 6) {
			if(this.getStackInSlot(1) != null && this.getStackInSlot(2) != null && this.getStackInSlot(1).getItem() == ModJam.runes && this.getStackInSlot(2).getItem() == Item.dyePowder) {
				switch(i) {
				case 3:
					inventory[4] = null;
					inventory[5] = null;
					inventory[6] = null;
					break;
				case 4:
					inventory[3] = null;
					inventory[5] = null;
					inventory[6] = null;
					break;
				case 5:
					inventory[4] = null;
					inventory[3] = null;
					inventory[6] = null;
					break;
				case 6:
					inventory[4] = null;
					inventory[5] = null;
					inventory[3] = null;
					break;
				}
				
				this.decrStackSize(0, 1);
				this.decrStackSize(1, 1);
				this.decrStackSize(2, 1);
				
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
				
			}
		} else if(inventory[i] != null) {
			if(inventory[i].stackSize <= j) {
				if(i == 0 ) {
					inventory[3] = null;
					inventory[4] = null;
					inventory[5] = null;
					inventory[6] = null;
				}
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
		this.update();
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return inventory[i];
	}
	
	public void update() {
		if(inventory[0] != null) {
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
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
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
