package mods.themike.modjam.rune;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

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
		return 3;
	}

	@Override
	public Object getSacrifice() {
		return Item.rottenFlesh;
	}

}
