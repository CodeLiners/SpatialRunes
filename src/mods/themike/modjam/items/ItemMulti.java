package mods.themike.modjam.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemMulti extends Item {
	
	private static final String[] subNames = new String[]{"dustSpacial"};
	private static Icon[] subIcons = new Icon[]{};
	
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister reg) {
		for(int par1 = 0; par1 < subNames.length; par1++) {
			subIcons[par1] = reg.registerIcon("mikejam:" + subNames[par1]);
		}
	}
	
}
