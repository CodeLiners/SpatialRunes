package mods.themike.modjam.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.themike.modjam.ModJam;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

}
