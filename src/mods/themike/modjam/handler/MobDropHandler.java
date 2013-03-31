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
	public void onSoundLoad(SoundLoadEvent event) {
		try {
			event.manager.soundPoolSounds.addSound("mods/mikejam/sounds/sucess.ogg", this.getClass().getResource("/mods/mikejam/sounds/sucess.ogg"));
		} catch(Exception e) {
			System.out.println("[Spatial Runes] Failed to load sounds!");
		}
	}

}
