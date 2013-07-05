package mods.themike.modjam.handler;

import mods.themike.modjam.ModJam;
import mods.themike.modjam.container.ContainerCarvingStone;
import mods.themike.modjam.container.ContainerPapyrusScroll;
import mods.themike.modjam.container.ContainerStaff;
import mods.themike.modjam.gui.GuiCarvingStone;
import mods.themike.modjam.gui.GuiPapyrusScroll;
import mods.themike.modjam.gui.GuiStaff;
import mods.themike.modjam.inventory.InventoryStaff;
import mods.themike.modjam.items.ItemPapyrus;
import mods.themike.modjam.items.ItemStaff;
import mods.themike.modjam.tile.TileEntityCarvingStone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {
		
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 2) {
			return new ContainerCarvingStone(player, (TileEntityCarvingStone) world.getBlockTileEntity(x, y, z));
		}
		if(player.getHeldItem() != null && player.getHeldItem().itemID == ModJam.scroll.itemID) {
			return new ContainerPapyrusScroll();
		}
		if(player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemStaff) {
			return new ContainerStaff(player, new InventoryStaff(player));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 2) {
			return new GuiCarvingStone(player, (TileEntityCarvingStone) world.getBlockTileEntity(x, y, z));
		}
		if(player.getHeldItem() != null && player.getHeldItem().itemID == ModJam.scroll.itemID) {
			return new GuiPapyrusScroll(new ContainerPapyrusScroll(), player);
		}
		if(player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemStaff) {
			return new GuiStaff(player, new InventoryStaff(player));
		}
		return null;
	}

}
