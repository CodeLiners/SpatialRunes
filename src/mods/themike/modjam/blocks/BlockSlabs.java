package mods.themike.modjam.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.themike.modjam.ModJam;
import mods.themike.modjam.utils.MultiBlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockSlabs extends BlockHalfSlab {
	
	private static Icon[] subIcons = new Icon[MultiBlockUtils.getArray().length];

	public BlockSlabs(int par1) {
		super(par1, false, Material.rock);
		this.setCreativeTab(ModJam.tab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("mikejam:magebrick");
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName() {
		return "slab.magebrick";
	}

	@Override
	public String getFullSlabName(int i) {
		return MultiBlockUtils.getArray()[i];
	}

}
