package mods.themike.modjam.rune;

import mods.themike.modjam.api.runes.IRune;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class RunePower implements IRune {
	
	@Override
	public void onUse(EntityPlayer player) {
		player.addPotionEffect((new PotionEffect(Potion.damageBoost.getId(), 200, 2)));
	}

	@Override
	public String getName() {
		return "power";
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
