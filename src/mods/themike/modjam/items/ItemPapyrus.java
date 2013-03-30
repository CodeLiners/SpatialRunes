package mods.themike.modjam.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.themike.modjam.ModJam;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPapyrus extends Item {

	public ItemPapyrus(int par1) {
		super(par1);
		this.setUnlocalizedName("papyrusScroll");
		this.setCreativeTab(ModJam.tab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister reg) {
		this.iconIndex = reg.registerIcon("mikejam:papyrusScroll");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		super.onItemRightClick(stack, world, player);
		if(player.isSneaking()) {
			player.openGui(ModJam.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
		return stack;
	}

}
