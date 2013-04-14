package mods.themike.modjam.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class GuiPapyrusScroll extends GuiContainer {

	public GuiPapyrusScroll(Container par1Container) {
		super(par1Container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		this.mc.renderEngine.bindTexture("/mods/mikejam/textures/gui/parchment.png");
		int x = (this.width - 187) / 2;
		int y = (this.height - 200) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, 187, 177);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		this.fontRenderer.drawString("Papyrus Scroll", (xSize - fontRenderer.getStringWidth("Papyrus Scroll")) / 2, 12, 0000000, false);
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/mikejam/textures/gui/parts.png");
		if(x > 150 && x < 172 && y > 110 && y < 114) 
			this.drawTexturedModalRect(150, 110, 0, 14, 22, 14);
		else {
			this.drawTexturedModalRect(150, 110, 0, 0, 22, 14);
		}
			
		this.drawTexturedModalRect(14, 110, 0, 14, 22, 14);
		GL11.glPopMatrix();
	}

}
