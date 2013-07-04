package mods.themike.modjam;

import mods.themike.modjam.blocks.*;
import mods.themike.modjam.items.ItemCrystal;
import mods.themike.modjam.items.ItemMulti;
import mods.themike.modjam.items.ItemPapyrus;
import mods.themike.modjam.items.ItemRune;
import mods.themike.modjam.items.ItemStaff;
import mods.themike.modjam.items.ToolReaper;
import net.minecraftforge.common.Configuration;

public class ModJamConfiguration {

	public static void init(Configuration config) {
		
		ModJam.carvingStone = new BlockCarvingStone(config.getBlock("Carving Stone", 1100).getInt(1100));
		ModJam.decoration = new BlockDecoration(config.getBlock("Decorative Blocks", 1101).getInt(1101));
		ModJam.mageSlab = new SlabDecoration(config.getBlock("Decorative Slabs", 1102).getInt(1102));
		
		// ModJam.lamp = new BlockMagebrickLamp(config.getBlock("Magebrick Lamp", 1104).getInt(1104));
		
		ModJam.item = new ItemMulti(config.getItem("Main Items", 5500).getInt(5500));
		ModJam.runes = new ItemRune(config.getItem("Runes", 5501).getInt(5501));
		ModJam.scroll = new ItemPapyrus(config.getItem("Papyrus Scroll", 5502).getInt(5502));
		ModJam.staff = new ItemStaff(config.getItem("Staffs", 5503).getInt(5503));
		ModJam.reaper = new ToolReaper(config.getItem("Reaper", 5504).getInt(5504));
		ModJam.essence = new ItemCrystal(config.getItem("Crystalline Essence", 5505).getInt(5505));
		
		config.save();
		
	}
	
}
