package mods.themike.modjam.blocks

import static net.minecraftforge.common.ForgeDirection.*
import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly

import mods.themike.modjam.*
import mods.themike.modjam.proxy.ClientProxy;
import mods.themike.modjam.tile.BlankTileEntity

import themike.core.block.BlockBase
import themike.core.block.TileBase

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.common.ForgeDirection

class BlockMagebrickLamp extends TileBase {

	BlockMagebrickLamp(int id) {
		super(id, Material.glass, "spatialrunes", "magebrickLamp")
		setHardness(0.3F)
		setStepSound(Block.soundGlassFootstep)
		this.setCreativeTab(ModJam.tab)
	}
	
	@Override
    public int onBlockPlaced(World world, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        int newMeta = par9;
		        
		if(par5.is(1)) {
			newMeta = 1
		} else if(par5.is(2)) {
			newMeta = 4
		} else if(par5.is(3)) {
			newMeta = 3
		} else if(par5.is(4)) {
			newMeta = 2
		} else if(par5.is(5)) {
			newMeta = 5
		} else if(par5.is(0)) {
			newMeta = 0
		}

        return newMeta
    }
	
    @Override
    boolean canProvidePower() {
        return true
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	int getRenderType() {
		return ClientProxy.ID
	}
	
	@Override
	boolean isOpaqueCube() {
		return false
	}
	
	@Override
	boolean renderAsNormalBlock() {
		return false
	}
    
    @Override
    boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {
        return false
    }
    
	@Override
    int getLightValue(IBlockAccess world, int x, int y, int z) {
		return 15
	}
	
	@Override
	TileEntity createNewTileEntity(World world) {
		return new BlankTileEntity()
	}

}
