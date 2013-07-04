package mods.themike.modjam.rune;

import mods.themike.modjam.api.runes.IRune;
import net.minecraft.entity.player.EntityPlayer;

public class RuneBlank implements IRune {

	@Override
	public void onUse(EntityPlayer player) {}

	@Override
	public String getName() {
		return "blank";
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public int getUses() {
		return 0;
	}

	@Override
	public Object getSacrifice() {
		return null;
	}

}
