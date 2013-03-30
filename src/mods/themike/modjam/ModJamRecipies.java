package mods.themike.modjam;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModJamRecipies {
	
	public static void init() {
		GameRegistry.addRecipe(new ItemStack(ModJam.item, 1, 1), new Object[]{"XXX", "XIX", "XXX", 'X', new ItemStack(ModJam.item, 1, 0), 'I', Item.ingotGold});
		GameRegistry.addRecipe(new ItemStack(ModJam.item, 1, 2), new Object[]{"X", "X", 'X', Block.whiteStone});

		GameRegistry.addRecipe(new ItemStack(ModJam.runes, 4, 0), new Object[]{"XX ", "XXX", " XX", 'X', Block.stone});
		
		GameRegistry.addRecipe(new ItemStack(ModJam.carvingStone, 1, 0), new Object[]{"XXX", "XIX", "XIX", 'X', Block.stone, 'I', new ItemStack(ModJam.item, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModJam.decoration, 12, 0), new Object[]{"X", "I", "X", 'X', Block.netherBrick, 'I', Item.blazePowder});
		GameRegistry.addRecipe(new ItemStack(ModJam.slabs, 6), new Object[]{"XXX", 'X', new ItemStack(ModJam.decoration, 1, 0)});
	}

}
