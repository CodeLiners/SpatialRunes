package mods.themike.modjam.items;

import mods.themike.modjam.utils.MultiBlockUtils;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDecoration extends ItemBlock {

	public ItemBlockDecoration(int par1) {
		super(par1);
		this.hasSubtypes = true;
		this.setUnlocalizedName("blockDecor");
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() >= 0 && stack.getItemDamage() < MultiBlockUtils.getArray().length) {
			return "blocksub." + MultiBlockUtils.getArray()[stack.getItemDamage()];
		}
		return null;
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}

}
