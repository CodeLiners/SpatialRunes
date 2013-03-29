package mods.themike.modjam.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.themike.modjam.ModJam;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemRune extends ItemMulti {

	protected static String[] subNames = new String[]{"blank"};
	private static Icon[] subIcons = new Icon[subNames.length];
	
	public ItemRune(int par1) {
		super(par1);
		this.hasSubtypes = true;
		this.setUnlocalizedName("itemRune");
		this.setCreativeTab(ModJam.tab);
	}
	
	@Override
	public Icon getIconFromDamage(int metadata) {
		return subIcons[metadata];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister reg) {
		for(int par1 = 0; par1 < subNames.length; par1++) {
			subIcons[par1] = reg.registerIcon("mikejam:" + subNames[par1]);
		}
	}
	
	@Override
	public void getSubItems(int ID, CreativeTabs tabs, List list) {
		for(int par1 = 0; par1 < subNames.length; par1++) {
			list.add(new ItemStack(ID, 1, par1));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() >= 0 && stack.getItemDamage() < subNames.length) {
			return "rune." + subNames[stack.getItemDamage()];
		}
		return null;
	}
	
	@Override 
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

}
