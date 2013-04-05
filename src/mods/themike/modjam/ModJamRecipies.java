package mods.themike.modjam;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModJamRecipies {
	
	public static void init() {
		GameRegistry.addRecipe(new ItemStack(ModJam.item, 1, 1), new Object[]{"XXX", "XIX", "XXX", 'X', new ItemStack(ModJam.item, 1, 0), 'I', Item.ingotGold});
		GameRegistry.addRecipe(new ItemStack(ModJam.item, 1, 2), new Object[]{"X", "X", 'X', Block.whiteStone});

		GameRegistry.addRecipe(new ItemStack(ModJam.runes, 4, 0), new Object[]{"XX ", "XXX", " XX", 'X', Block.stone});
		
		GameRegistry.addRecipe(new ItemStack(ModJam.reaper, 1, 0), new Object[]{" X ", " X ", "ZIZ", 'Z', new ItemStack(ModJam.item, 1, 2), 'I', new ItemStack(ModJam.item, 1, 1), 'X', Item.field_94584_bZ});
		
		// GameRegistry.addRecipe(new ItemStack(ModJam.scroll, 1), new Object[]{"I", "X", 'X', Item.paper, 'I', new ItemStack(ModJam.item, 1, 1)});

		ItemStack stack = new ItemStack(ModJam.staff, 1, 0);
		stack.setTagCompound(new NBTTagCompound());

		ItemStack stack2 = new ItemStack(ModJam.staff, 1, 1);
		stack.setTagCompound(new NBTTagCompound());

		GameRegistry.addRecipe(stack, new Object[]{"  I", " X ", "X  ", 'X', Item.blazeRod, 'I', new ItemStack(ModJam.item, 1, 1)});
		GameRegistry.addRecipe(stack2, new Object[]{"  I", " X ", "X  ", 'X', new ItemStack(ModJam.item, 1, 2), 'I', new ItemStack(ModJam.item, 1, 3)});
		
		GameRegistry.addRecipe(new ItemStack(ModJam.carvingStone, 1, 0), new Object[]{"XXX", "XIX", "XIX", 'X', Block.stone, 'I', new ItemStack(ModJam.item, 1, 0)});
		
		GameRegistry.addRecipe(new ItemStack(ModJam.decoration, 12, 0), new Object[]{"X", "I", "X", 'X', Block.netherBrick, 'I', Item.blazePowder});
		GameRegistry.addRecipe(new ItemStack(ModJam.decoration, 4, 1), new Object[]{"XX", "XX", 'X', Block.whiteStone});
		GameRegistry.addRecipe(new ItemStack(ModJam.decoration, 4, 2), new Object[]{"XX", "XX", 'X', new ItemStack(ModJam.decoration, 12, 1)});
		
		GameRegistry.addRecipe(new ItemStack(ModJam.slabs, 6), new Object[]{"XXX", 'X', new ItemStack(ModJam.decoration, 1, 0)});
	}

}
