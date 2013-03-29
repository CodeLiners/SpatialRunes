package mods.themike.modjam;

import mods.themike.modjam.items.ItemMulti;
import net.minecraftforge.common.Configuration;

public class ModJamConfiguration {

	public static void init(Configuration config) {
		
		ModJam.item = new ItemMulti(config.getItem("Main Items", 5500).getInt(5500));
		
	}
	
}
