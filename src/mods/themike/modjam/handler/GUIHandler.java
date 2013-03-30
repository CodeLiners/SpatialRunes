package mods.themike.modjam.handler;

import mods.themike.modjam.container.ContainerPapyrusScroll;
import mods.themike.modjam.gui.GuiPapyrusScroll;
import mods.themike.modjam.items.ItemPapyrus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(player.getHeldItem().getItem() instanceof ItemPapyrus) {
			return new ContainerPapyrusScroll();
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(player.getHeldItem().getItem() instanceof ItemPapyrus) {
			return new GuiPapyrusScroll(new ContainerPapyrusScroll());
		}
		return null;
	}

}
