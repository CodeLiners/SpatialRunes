package mods.themike.modjam.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import themike.core.block.BlockBase;

public class BlockGhostBlock extends BlockBase {

	public BlockGhostBlock(int par1) {
		super(par1, Material.air.setReplaceable(), "mikejam", "invisibleblock");
		this.setCreativeTab(null);
		this.setLightValue(15);
	}
    
    @Override
    public boolean isCollidable() {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        return 0;
    }

    @Override
    public boolean isAirBlock(World world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
        return false;
    }

}
