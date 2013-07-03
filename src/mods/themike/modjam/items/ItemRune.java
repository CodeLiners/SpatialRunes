package mods.themike.modjam.items;

import java.util.List;

import themike.core.render.RenderHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.themike.modjam.ModJam;
import mods.themike.modjam.rune.IRune;
import mods.themike.modjam.rune.RuneRegistry;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;

public class ItemRune extends Item {
	
	public Icon[] icons = new Icon[100];
	
	public ItemRune(int par1) {
		super(par1);
		this.hasSubtypes = true;
		this.setUnlocalizedName("itemRune");
		this.setCreativeTab(ModJam.tab);
		this.setMaxStackSize(12);
	}
	
	@Override
	public Icon getIconFromDamage(int metadata) {
		return icons[metadata];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		for(int par1 = 0; par1 != RuneRegistry.getrunes().length; par1++) {
			IRune rune = RuneRegistry.getrunes()[par1];
			if(rune != null) {
				icons[par1] = reg.registerIcon("spatialrunes:rune" + rune.getName());
			}
		}
	}
	
	@Override
	public void getSubItems(int ID, CreativeTabs tabs, List list) {
		for(int par1 = 0; par1 < RuneRegistry.getrunes().length; par1++) {
			if(RuneRegistry.getrunes()[par1] != null) {
				if(par1 == 0) {
					list.add(new ItemStack(ID, 1, par1));
				} else {
					NBTTagCompound tag = new NBTTagCompound();
					tag.setInteger("uses", RuneRegistry.getrunes()[par1].getUses());
					ItemStack stack = new ItemStack(ID, 1, par1);
					stack.setTagCompound(tag);
					list.add(stack);
				}
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() >= 0 && stack.getItemDamage() < RuneRegistry.getrunes().length) {
			return "rune." + RuneRegistry.getrunes()[stack.getItemDamage()].getName();
		}
		return null;
	}
	
	@Override 
	public boolean hasEffect(ItemStack stack) {
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if(stack.getTagCompound() != null && stack.getItemDamage() != 0 && RuneRegistry.getrunes()[stack.getItemDamage()] != null) {
			list.add(RenderHelper.applyColor(9) + "Level " + String.valueOf(RuneRegistry.getrunes()[stack.getItemDamage()].getLevel()) + " Rune.");
			int uses = stack.getTagCompound().getInteger("uses");
			list.add(RenderHelper.applyColor(14) + String.valueOf(uses) + " uses left.");
		}
	}

}
