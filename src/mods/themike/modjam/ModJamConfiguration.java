package mods.themike.modjam;

import mods.themike.modjam.blocks.BlockCarvingStone;
import mods.themike.modjam.blocks.BlockDecoration;
import mods.themike.modjam.blocks.BlockSlabs;
import mods.themike.modjam.items.ItemMulti;
import mods.themike.modjam.items.ItemPapyrus;
import mods.themike.modjam.items.ItemRune;
import net.minecraftforge.common.Configuration;

public class ModJamConfiguration {

	public static void init(Configuration config) {
		
		ModJam.carvingStone = new BlockCarvingStone(config.getBlock("Carving Stone", 1100).getInt(1100));
		ModJam.decoration = new BlockDecoration(config.getBlock("Decorative Blocks", 1101).getInt(1101));
		ModJam.slabs = new BlockSlabs(config.getBlock("Decorative Slabs", 1102).getInt(1102));
		
		ModJam.item = new ItemMulti(config.getItem("Main Items", 5500).getInt(5500));
		ModJam.runes = new ItemRune(config.getItem("Runes", 5501).getInt(5501));
		ModJam.scroll = new ItemPapyrus(config.getItem("Papyrus Scroll", 5502).getInt(5502));
		
	}
	
}
