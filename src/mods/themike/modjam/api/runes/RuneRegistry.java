package mods.themike.modjam.api.runes;

import java.util.ArrayList;
import java.util.List;

import mods.themike.modjam.api.runes.IRune;

public class RuneRegistry {
	
	private static List<IRune> runes = new ArrayList<IRune>();
	
	public static void appendRune(IRune rune) {
		runes.add(rune);
	}
	
	public static List<IRune> getrunes() {
		return runes;
	}

}
