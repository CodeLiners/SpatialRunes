package mods.themike.modjam.items;

import themike.core.item.ItemBase;
import mods.themike.modjam.ModJam;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPapyrus extends ItemBase {

	public ItemPapyrus(int par1) {
		super(par1, "spatialrunes", "papyrusScroll");
		this.setUnlocalizedName("papyrusScroll");
		this.setCreativeTab(ModJam.tab);
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
