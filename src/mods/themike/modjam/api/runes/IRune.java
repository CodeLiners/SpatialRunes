package mods.themike.modjam.api.runes;

import net.minecraft.entity.player.EntityPlayer;

public interface IRune {
	
	public void onUse(EntityPlayer player);
	
	public String getName();
	
	public int getLevel();
	
	public int getUses();
	
	public Object getSacrifice();
	
}
