package mods.themike.modjam.rune;

import com.google.common.collect.ObjectArrays;

public class RuneRegistry {
	
	private static IRune[] runes = new IRune[]{
		new RuneBlank(), 
		new RuneRegeneration(),
		new RuneFire(),
		new RuneProtection(),
		new RunePower()
	};
	
	public static void appendRune(IRune rune) {
		runes = ObjectArrays.concat(rune, runes);
	}
	
	public static IRune[] getrunes() {
		return runes;
	}

}
