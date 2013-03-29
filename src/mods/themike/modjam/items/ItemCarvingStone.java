package mods.themike.modjam.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;

public class ItemCarvingStone extends ItemBlock {
	
	public ItemCarvingStone(int par1) {
		super(par1);
	}
	
	@Override
	public Icon getIconFromDamage(int metadata) {
		return this.iconIndex;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister reg) {
		this.iconIndex = reg.registerIcon("mikejam:carvingStone");
	}

}
