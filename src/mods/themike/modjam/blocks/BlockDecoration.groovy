package mods.themike.modjam.blocks;

import mods.themike.modjam.ModJam;
import net.minecraft.block.material.Material
import themike.core.block.BlockBase

class BlockDecoration extends BlockBase {

    BlockDecoration(int par1) {
        super(par1, Material.rock, "spatialrunes", "block", ["magebrick", "endbrick", "endchiseled"])
        this.setCreativeTab(ModJam.tab)
        this.setResistance(15.0F)
        this.setHardness(3.0F)
    }

}
