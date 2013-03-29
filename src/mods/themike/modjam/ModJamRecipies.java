package mods.themike.modjam;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModJamRecipies {
	
	public static void init() {
		GameRegistry.addRecipe(new ItemStack(ModJam.item, 1, 1), new Object[]{"XXX", "XIX", "XXX", 'X', new ItemStack(ModJam.item, 1, 0), 'I', Item.ingotGold});
		GameRegistry.addRecipe(new ItemStack(ModJam.runes, 4, 0), new Object[]{"XX ", "XXX", " XX", 'X', Block.stone});
		GameRegistry.addRecipe(new ItemStack(ModJam.carvingStone, 1, 0), new Object[]{"XX ", "XIX", " XIX", 'X', Block.stone, 'I', new ItemStack(ModJam.item, 1, 0)});
	}

}
