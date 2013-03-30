package mods.themike.modjam.rune;

import net.minecraft.entity.player.EntityPlayer;

public class RuneRegeneration implements IRune {

	@Override
	public void onUse(EntityPlayer player) {
		player.heal(100);
	}

	@Override
	public String getName() {
		return "regeneration";
	}

	@Override
	public int getLevel() {
		return 10;
	}

	@Override
	public int getUses() {
		return 2;
	}

}
