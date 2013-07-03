package mods.themike.modjam.blocks;

import mods.themike.modjam.ModJam;
import net.minecraft.block.material.Material;
import themike.core.block.SlabBase;

public class SlabDecoration extends SlabBase {

    public SlabDecoration(int par1) {
        super(par1, false, Material.rock, "spatialrunes", "magebrick");
        this.setCreativeTab(ModJam.tab);
    }

}
