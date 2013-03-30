package mods.themike.modjam.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.themike.modjam.ModJam;
import mods.themike.modjam.rune.IRune;
import mods.themike.modjam.rune.RuneBlank;
import mods.themike.modjam.rune.RuneRegistry;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemRune extends Item {
	
	public Icon[] icons = new Icon[100];
	
	public ItemRune(int par1) {
		super(par1);
		this.hasSubtypes = true;
		this.setUnlocalizedName("itemRune");
		this.setCreativeTab(ModJam.tab);
		
		RuneRegistry.appendRune(new RuneBlank());
	}
	
	@Override
	public Icon getIconFromDamage(int metadata) {
		return icons[metadata];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister reg) {
		for(int par1 = 0; par1 != 101; par1++) {
			IRune rune = RuneRegistry.getrunes()[par1];
			if(rune != null) {
				icons[par1] = reg.registerIcon("mikejam:rune" + rune.getName());
			}
		}
	}
	
	@Override
	public void getSubItems(int ID, CreativeTabs tabs, List list) {
		for(int par1 = 0; par1 < 101; par1++) {
			if(RuneRegistry.getrunes()[par1] != null) {
				list.add(new ItemStack(ID, 1, par1));
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() >= 0 && stack.getItemDamage() < 101) {
			return "rune." + RuneRegistry.getrunes()[stack.getItemDamage()].getName();
		}
		return null;
	}
	
	@Override 
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

}
