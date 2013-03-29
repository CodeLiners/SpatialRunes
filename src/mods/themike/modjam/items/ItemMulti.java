package mods.themike.modjam.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMulti extends Item {
	
	private static final String[] subNames = new String[]{"dustSpacial"};

	public ItemMulti(int par1) {
		super(par1);
		this.hasSubtypes = true;
		this.setUnlocalizedName("miscItems");
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() >= 0 && stack.getItemDamage() < subNames.length) {
			return this.getUnlocalizedName() + subNames[stack.getItemDamage()];
		}
		return null;
	}

}
