package mods.themike.modjam.blocks;

import java.util.Random;

import themike.core.block.BlockBase;
import mods.themike.modjam.ModJam;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockMagebrickLamp extends BlockBase {

	public BlockMagebrickLamp(int par1) {
		super(par1, Material.rock, "mikejam", "magebrickLamp");
		this.setLightValue(15);
		this.setCreativeTab(ModJam.tab);
	}

}
