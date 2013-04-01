package mods.themike.modjam.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.themike.modjam.ModJam;
import mods.themike.modjam.proxy.ClientProxy;
import mods.themike.modjam.tile.TileEntityCarvingStone;
import mods.themike.modjam.utils.MultiBlockUtils;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCarvingStone extends BlockContainer {

	public BlockCarvingStone(int par1) {
		super(par1, Material.rock);
		this.setHardness(1.0F);
		this.setCreativeTab(ModJam.tab);
		this.setResistance(2.0F);
		this.setUnlocalizedName("carvingStone");
		this.setBlockBounds(0.065F, 0F, 0.065F, 0.935F, 0.875F, 0.935F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCarvingStone();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("stone");
	}
	
	@Override
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
