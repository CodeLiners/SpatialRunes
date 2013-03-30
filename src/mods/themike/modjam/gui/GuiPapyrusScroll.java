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
		this.drawTexturedModalRect((this.xSize + 82) / 2, (this.ySize - 110) / 2, 0, 0, 187, 177);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		this.drawCenteredString(this.mc.fontRenderer, "Papyrus Scroll", (xSize - fontRenderer.getStringWidth("Papyrus Scroll") / 2), 6, ColorUtils.applyColor(9));
	}

}
