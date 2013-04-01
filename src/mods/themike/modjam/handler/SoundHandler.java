package mods.themike.modjam.handler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundHandler {
	
	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void onSoundLoad(SoundLoadEvent event) {
		try {
			event.manager.soundPoolSounds.addSound("mods/mikejam/sounds/sucess.ogg", 
					this.getClass().getResource("/mods/mikejam/sounds/sucess.ogg"));
			event.manager.soundPoolSounds.addSound("mods/mikejam/sounds/failure.ogg", 
					this.getClass().getResource("/mods/mikejam/sounds/failure.ogg"));
			System.out.println("[Spatial Runes] Loaded sounds!");
		} catch(Exception e) {
			System.out.println("[Spatial Runes] Failed to load sounds!");
		}
	}

}
