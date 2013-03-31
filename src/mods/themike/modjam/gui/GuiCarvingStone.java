package mods.themike.modjam.gui;

import org.lwjgl.opengl.GL11;

import mods.themike.modjam.ModJam;
import mods.themike.modjam.container.ContainerCarvingStone;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GuiCarvingStone extends GuiContainer {
	
	private static IInventory inventory;
	private static EntityPlayer player;
	
	public GuiCarvingStone(EntityPlayer par1, IInventory par2) {
		super(new ContainerCarvingStone(par1, par2));
		player = par1;
		inventory = par2;
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int x, int y) {
		fontRenderer.drawString("Carving Stone", (xSize - fontRenderer.getStringWidth("Carving Stone")) / 2, -10, 4210752);
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.4F);
		this.drawTexturedModelRectFromIcon(68, 38, ModJam.runes.getIconFromDamage(0), 16, 16);
		GL11.glPopMatrix();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		this.mc.renderEngine.bindTexture("/mods/mikejam/textures/gui/carving.png");
		int x = (this.width - 176) / 2;
		int y = (this.height - 200) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, 256, 256);
	}

}
