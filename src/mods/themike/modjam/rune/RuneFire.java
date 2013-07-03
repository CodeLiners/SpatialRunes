package mods.themike.modjam.rune;

import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;

public class RuneFire implements IRune {

	@Override
	public void onUse(EntityPlayer player) {
		List<EntityLivingBase> entityList = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX - 5, player.posY - 5, player.posZ - 5, player.posX + 5, player.posY + 5, player.posZ + 5));
		for(EntityLivingBase living : entityList) {
			boolean isThePlayer = false;
			if(living instanceof EntityPlayer && (EntityPlayer) living == player) {
				isThePlayer = true;
			}
			if(!isThePlayer) {
				living.setFire(20);
			}
		}
	}

	@Override
	public String getName() {
		return "fire";
	}

	@Override
	public int getLevel() {
		return 15;
	}

	@Override
	public int getUses() {
		return 2;
	}

	@Override
	public Object getSacrifice() {
		return Item.flint;
	}

}
