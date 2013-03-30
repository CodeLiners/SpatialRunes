package mods.themike.modjam.rune;

import com.google.common.collect.ObjectArrays;

public class RuneRegistry {
	
	private static IRune[] runes = new IRune[100];
	
	public static void appendRune(IRune rune) {
		runes = ObjectArrays.concat(rune, runes);
	}
	
	public static IRune[] getrunes() {
		return runes;
	}

}
