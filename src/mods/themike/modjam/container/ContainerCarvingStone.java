package mods.themike.modjam.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerCarvingStone extends Container {
	
	private static IInventory inventory;
	private static EntityPlayer player;

	public ContainerCarvingStone(EntityPlayer par1, IInventory par2) {
		player = par1;
		inventory = par2;
		
		this.addSlotToContainer(new Slot(inventory, 0, 80, 15));
		this.addSlotToContainer(new Slot(inventory, 1, 124, 15));
		this.addSlotToContainer(new Slot(inventory, 2, 141, 15));
		this.addSlotToContainer(new Slot(inventory, 3, 36, 15));
		this.addSlotToContainer(new Slot(inventory, 4, 19, 15));
		this.addSlotToContainer(new Slot(inventory, 5, 90, 45));
		this.addSlotToContainer(new Slot(inventory, 6, 70, 45));

		
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

}
