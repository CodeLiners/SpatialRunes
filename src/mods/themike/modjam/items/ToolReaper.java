package mods.themike.modjam.items;

import java.util.Random;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.themike.modjam.ModJam;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ToolReaper extends ItemSword {

	public ToolReaper(int par1) {
		super(par1, EnumToolMaterial.GOLD);
		this.setUnlocalizedName("reaper");
		this.setCreativeTab(ModJam.tab);
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        this.itemIcon = register.registerIcon("spatialrunes:reaper");
    }
    
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase player) {
    	super.hitEntity(stack, target, player);
    	if(target.func_110143_aJ() == 0){
    		
    		Random rand = new Random();
    		if(target instanceof EntitySkeleton) {
    			EntitySkeleton skeleton = (EntitySkeleton) target;
    			if(skeleton.getSkeletonType() == 0) {
    				int chance = rand.nextInt(3);
    				if(chance == 2)
    					skeleton.entityDropItem(new ItemStack(Item.skull, 1, 0), 0.0F);
    			}
    		}else if(target instanceof EntityZombie) {
    			int chance = rand.nextInt(3);
    			if(chance == 2)
    				target.entityDropItem(new ItemStack(Item.skull, 1, 2), 0.0F);
    		}else if(target instanceof EntityCreeper) {
    			int chance = rand.nextInt(3);
    			if(chance == 2)
    				target.entityDropItem(new ItemStack(Item.skull, 1, 4), 0.0F);
    		}
    	}
    	return true;
		
    }

}
