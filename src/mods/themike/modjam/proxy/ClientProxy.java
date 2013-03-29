package mods.themike.modjam.proxy;

import mods.themike.modjam.handler.SimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy {
	
	public static SimpleBlockRenderingHandler handler = new SimpleBlockRenderingHandler();

	@Override
	public void init() {
		RenderingRegistry.registerBlockHandler(handler);
	}

}
