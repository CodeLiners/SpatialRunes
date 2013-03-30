package mods.themike.modjam.gui;

import mods.themike.modjam.utils.ColorUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class GuiPapyrusScroll extends GuiContainer {

	public GuiPapyrusScroll(Container par1Container) {
		super(par1Container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		this.mc.renderEngine.bindTexture("/mods/mikejam/textures/gui/parchment.png");
		this.drawTexturedModalRect((this.xSize + 75) / 2, (this.ySize - 125) / 2, 0, 0, 187, 177);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		this.drawString(fontRenderer, "Papyrus Scroll", (xSize - fontRenderer.getStringWidth("Papyrus Scroll")) / 2, 12, 4210752);
	}

}
