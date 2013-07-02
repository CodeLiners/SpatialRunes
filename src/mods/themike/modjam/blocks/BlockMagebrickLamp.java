package mods.themike.modjam.blocks;

import themike.core.block.BlockBase;
import mods.themike.modjam.ModJam;
import net.minecraft.block.material.Material;

public class BlockMagebrickLamp extends BlockBase {

	public BlockMagebrickLamp(int par1) {
		super(par1, Material.rock, "mikejam", "magebrickLamp");
		this.setLightValue(15);
		this.setCreativeTab(ModJam.tab);
	}

}
