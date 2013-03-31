package mods.themike.modjam.gui;

import mods.themike.modjam.container.ContainerStaff;
import mods.themike.modjam.inventory.InventoryStaff;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GuiStaff extends GuiContainer {

	private EntityPlayer player;
	private IInventory inventory;
	
	public GuiStaff(EntityPlayer par1, IInventory par2) {
		super(new ContainerStaff(par1, par2));
		player = par1;
		inventory = par2;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		
		System.out.println("Hello Runes, SlotStaff!");

		ItemStack staff = player.getHeldItem();
		if(staff != null && player.worldObj.isRemote) {
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
