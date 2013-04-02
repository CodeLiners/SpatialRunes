package mods.themike.modjam.proxy;

import mods.themike.modjam.handler.SimpleBlockRenderingHandler;
import mods.themike.modjam.render.RenderCarvingStone;
import mods.themike.modjam.tile.TileEntityCarvingStone;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class ClientProxy implements IProxy {
	
	public static SimpleBlockRenderingHandler handler = new SimpleBlockRenderingHandler();
	public static int ID;
	
	@Override
	public void init() {
		ID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ID, handler);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCarvingStone.class, new RenderCarvingStone());
	}

}
