package mods.themike.modjam.rune;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class RuneProtection implements IRune {
	
	@Override
	public void onUse(EntityPlayer player) {
		player.addPotionEffect((new PotionEffect(Potion.resistance.getId(), 150, 20)));
	}

	@Override
	public String getName() {
		return "protection";
	}

	@Override
	public int getLevel() {
		return 15;
	}

	@Override
	public int getUses() {
		return 3;
	}

	@Override
	public Object getSacrifice() {
		return Item.ingotIron;
	}

}
