package mods.themike.modjam.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerStaff extends Container {
	
	private static IInventory inventory;
	private static EntityPlayer player;
	
	public ContainerStaff(EntityPlayer par1, IInventory par2) {		
		player = par1;
		inventory = par2;
		
		this.addSlotToContainer(new Slot(inventory, 0, 80, 37));
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

}
