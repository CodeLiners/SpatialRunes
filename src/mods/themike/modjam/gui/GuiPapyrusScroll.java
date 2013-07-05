package mods.themike.modjam.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import themike.core.gui.GuiBase;
import themike.core.render.RenderHelper;
import themike.core.util.CraftingHelper;

import mods.themike.modjam.ModJam;
import mods.themike.modjam.api.pages.IPage;
import mods.themike.modjam.api.pages.PageRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;

public class GuiPapyrusScroll extends GuiBase {
	
	int currentPage = 0;
	EntityPlayer player;

	public GuiPapyrusScroll(Container par1Container, EntityPlayer par2) {
		super(par1Container);
		player = par2;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		RenderHelper.bindTexture("spatialrunes", "/textures/gui/parchment.png");
		int x = (this.width - 187) / 2;
		int y = (this.height - 200) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, 187, 177);
	}
	
	@Override
	protected void mouseClicked(int x, int y, int par3) {
		if((x - this.guiLeft) > 144 && (x - this.guiLeft) < 162 && (y - this.guiTop) > 110 && (y - this.guiTop) < 124) {
			player.playSound("random.click", 1.0F, 1.0F);
			if(currentPage + 1 < PageRegistry.getPages().size()) {
				currentPage++;
			}
		}
		if((x - this.guiLeft) > 14 && (x - this.guiLeft) < 38 && (y - this.guiTop) > 110 && (y - this.guiTop) < 124) { 
			player.playSound("random.click", 1.0F, 1.0F);
			Integer newPage = currentPage - 1;
			if(newPage >= 0) {
				currentPage--;
			}
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		IPage page = PageRegistry.getPages().get(currentPage);
		if(currentPage == 1) {
			this.fontRenderer.drawString("\247l" + page.getHeader(), (xSize - fontRenderer.getStringWidth(page.getHeader())) / 2, 12, 0000000, false);
		} else {
			this.fontRenderer.drawString("\247l" + page.getHeader(), (xSize - fontRenderer.getStringWidth(page.getHeader())) / 2, 12, 0000000, false);			
		}
		int count = 0;
		if(currentPage == 1) {
			List<IPage> pages = PageRegistry.getPages();
			int newCount = 0;
			for(IPage newPage: pages) {
				if(newCount > 1) {
					this.fontRenderer.drawString(String.valueOf(newCount) + ": " + newPage.getHeader(), 7, 28 + ((fontRenderer.FONT_HEIGHT + 2) * (newCount - 2)), 0000000, false);
				}
				newCount++;
			}
		} else {
			for(String content : page.getContents()) {
				if(currentPage == 0) {
					this.fontRenderer.drawString(content, (xSize - fontRenderer.getStringWidth(content)) / 2, 21 + ((fontRenderer.FONT_HEIGHT + 2) * count), 0000000, false);
				} else {
					if(content.startsWith("RECIPE")) {
						// Needs added eventually.
					} else {
						this.fontRenderer.drawString(content, 7, 28 + ((fontRenderer.FONT_HEIGHT + 2) * count), 0000000, false);
					}
				}
				count++;
			}
		}
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		RenderHelper.bindTexture("spatialrunes", "/textures/gui/parts.png");
		if((x - this.guiLeft) > 144 && (x - this.guiLeft) < 162 && (y - this.guiTop) > 110 && (y - this.guiTop) < 124) 
			this.drawTexturedModalRect(144, 110, 23, 0, 22, 14);
		else {
			this.drawTexturedModalRect(144, 110, 0, 0, 22, 14);
		}
		if((x - this.guiLeft) > 14 && (x - this.guiLeft) < 38 && (y - this.guiTop) > 110 && (y - this.guiTop) < 124) 
			this.drawTexturedModalRect(14, 110, 23, 14, 22, 14);
		else {
			this.drawTexturedModalRect(14, 110, 0, 14, 22, 14);
		}
			
		GL11.glPopMatrix();
	}

}
