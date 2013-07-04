package mods.themike.modjam.gui;

import themike.core.render.RenderHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.themike.modjam.container.ContainerStaff;
import mods.themike.modjam.inventory.InventoryStaff;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GuiStaff extends GuiContainer {

	private EntityPlayer player;
	private IInventory inventory;
	private ItemStack staff;
	
	public GuiStaff(EntityPlayer par1, IInventory par2) {
		super(new ContainerStaff(par1, par2));
		player = par1;
		inventory = par2;
		staff = player.getHeldItem();
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = LanguageRegistry.instance().getStringLocalization(staff.getItem().getUnlocalizedName(staff) + ".name");
		fontRenderer.drawString(name, (xSize - fontRenderer.getStringWidth(name)) / 2, -30, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		RenderHelper.bindTexture("spatialrunes", "/textures/gui/staff.png");
		int x = (this.width - 176) / 2;
		int y = (this.height - 200) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, 256, 256);
	}

}
