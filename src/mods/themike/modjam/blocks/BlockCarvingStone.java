package mods.themike.modjam.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import themike.core.block.TileBase;
import mods.themike.modjam.ModJam;
import mods.themike.modjam.proxy.ClientProxy;
import mods.themike.modjam.tile.TileEntityCarvingStone;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCarvingStone extends TileBase {

	public BlockCarvingStone(int par1) {
		super(par1, Material.rock, "spatialrunes", "carvingStone");
		this.setHardness(1.0F);
		this.setCreativeTab(ModJam.tab);
		this.setResistance(2.0F);
		this.setBlockBounds(0.065F, 0F, 0.065F, 0.935F, 0.875F, 0.935F);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int meta, int something) {
		TileEntityCarvingStone tileEntity = (TileEntityCarvingStone) world.getBlockTileEntity(x, y, z);
		if(!world.isRemote) {
			for(int count = 0; count != 3; count++) {
				ItemStack stack = tileEntity.getStackInSlot(count);
				if(stack != null) {
					EntityItem entity = new EntityItem(world, x, y + 0.5, z, stack);
					entity.motionX = world.rand.nextGaussian() * 0.05F; 
					entity.motionY = world.rand.nextGaussian() * 0.05F; 
					entity.motionZ = world.rand.nextGaussian() * 0.05F; 
					world.spawnEntityInWorld(entity);
				}
			}
		}
		
        super.breakBlock(world, x, y, z, meta, something);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCarvingStone();
	}
	
    @Override
    public Icon getIcon(int side, int meta) {
    	return Block.stone.getIcon(side, meta);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.ID;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par4, float par5, float par6, float par7) {
		if(!player.isSneaking()) {
			player.openGui(ModJam.instance, 2, world, x, y, z);
			return true;
		}
		return false;
	}

}
