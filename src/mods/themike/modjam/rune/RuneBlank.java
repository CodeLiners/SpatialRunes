package mods.themike.modjam.rune;

import net.minecraft.entity.player.EntityPlayer;

public class RuneBlank implements IRune {

	@Override
	public void onUse(EntityPlayer player) {}

	@Override
	public String getName() {
		return "blank";
	}

	@Override
	public String getIconPath() {
		return null;
	}

	@Override
	public int getLevel() {
		return 0;
	}

}
