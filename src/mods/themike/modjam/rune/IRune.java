package mods.themike.modjam.rune;

import net.minecraft.entity.player.EntityPlayer;

public interface IRune {
	
	public void onUse(EntityPlayer player);
	
	public String getName();
	
	public int getLevel();
	
}
