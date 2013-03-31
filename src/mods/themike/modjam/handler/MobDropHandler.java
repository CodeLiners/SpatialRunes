package mods.themike.modjam.handler;

import java.util.Random;

import mods.themike.modjam.ModJam;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MobDropHandler {
	
	@ForgeSubscribe
	public void modDrop(LivingDropsEvent event) {
		Random rand = new Random();
		if(event.entityLiving instanceof IMob && rand.nextInt(5) == 2) {
			event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY + 0.5, event.entity.posZ, new ItemStack(ModJam.item, 1, 0)));
		}
	}

}
