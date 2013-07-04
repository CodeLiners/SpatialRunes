package mods.themike.modjam.render;

import org.lwjgl.opengl.GL11;

import themike.core.render.RenderHelper;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderMagebrickLamp extends TileEntitySpecialRenderer {

	ModelCarvingStone stone = new ModelCarvingStone();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		RenderHelper.bindTexture("spatialrunes", "/textures/models/stone.png")
		GL11.glPushMatrix()
		GL11.glTranslatef((float) d0 + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F)
		GL11.glScalef(1.0F, -1F, -1F)
		GL11.glRotatef(0F, 0F, 1F, 0F)
		stone.render(0.0625F, 0F, 0F, 0F)
		GL11.glPopMatrix()
	}

}
