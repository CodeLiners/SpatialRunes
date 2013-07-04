package mods.themike.modjam.items;

import java.util.List;
import java.util.Random;

import themike.core.packet.PacketParticle;
import themike.core.packet.PacketSound;
import themike.core.render.RenderHelper;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.themike.modjam.ModJam;
import mods.themike.modjam.api.runes.IRune;
import mods.themike.modjam.api.runes.RuneRegistry;
import mods.themike.modjam.packet.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemStaff extends ItemMulti {

	
	protected static String[] subNames = new String[]{"apprentice", "mage"};
	private static Icon[] subIcons = new Icon[subNames.length];
	
	public ItemStaff(int par1) {
		super(par1);
		this.hasSubtypes = true;
		this.setUnlocalizedName("itemStaff");
		this.setCreativeTab(ModJam.tab);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5);
		if(stack.hasTagCompound() && !stack.getTagCompound().hasKey("timestamp") && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if(ItemStack.areItemStacksEqual(stack, player.inventory.getCurrentItem())) {
				ItemStack newStack = stack.copy();
				newStack.getTagCompound().setLong("timestamp", Minecraft.getSystemTime());
				player.inventory.setInventorySlotContents(player.inventory.currentItem, newStack);	
			}
		}
	}
	
	@Override
	public Icon getIconFromDamage(int metadata) {
		return subIcons[metadata];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		for(int par1 = 0; par1 < subNames.length; par1++) {
			subIcons[par1] = reg.registerIcon("spatialrunes:staff" + subNames[par1]);
		}
	}
	
	@Override
	public void getSubItems(int ID, CreativeTabs tabs, List list) {
		for(int par1 = 0; par1 < subNames.length; par1++) {
			ItemStack stack = new ItemStack(ID, 1, par1);
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setLong("timestamp", Minecraft.getSystemTime());
			list.add(stack);
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() >= 0 && stack.getItemDamage() < subNames.length) {
			return "staff." + subNames[stack.getItemDamage()];
		}
		return null;
	}
	
	@Override 
	public boolean hasEffect(ItemStack stack) {
		if(stack.getItemDamage() == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if(stack.getItemDamage() == 0) {
			list.add("Can bind up to Level 25.");
		} else {
			list.add("Can bind all levels.");
		}
		if(stack.getTagCompound().getTag("item") != null) {
			ItemStack runeStack = ItemStack.loadItemStackFromNBT((NBTTagCompound) stack.getTagCompound().getTag("item"));
			if(stack.getTagCompound().getTag("item") != null && runeStack != null) {
				list.add(RenderHelper.applyColor(14) + LanguageRegistry.instance().getStringLocalization("rune." + RuneRegistry.getrunes().get(runeStack.getItemDamage()).getName() + ".name") + ".");
			}
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		super.onItemRightClick(stack, world, player);
		ItemStack newStack = stack.copy();
		
		if(!world.isRemote && !player.isSneaking() && stack.getTagCompound().getTag("item") == null) {
				player.addChatMessage(RenderHelper.applyColor(12) + "No Rune selected!");
		}
		if(!world.isRemote && !player.isSneaking() && stack.getTagCompound().getTag("item") != null) {
			ItemStack runeStack = ItemStack.loadItemStackFromNBT((NBTTagCompound) stack.getTagCompound().getTag("item"));
			if(runeStack != null && player.experienceLevel  >= RuneRegistry.getrunes().get(runeStack.getItemDamage()).getLevel()) {
				IRune rune = RuneRegistry.getrunes().get(runeStack.getItemDamage());
				player.addExperienceLevel(- RuneRegistry.getrunes().get(runeStack.getItemDamage()).getLevel());
				rune.onUse(player);
				int uses = runeStack.getTagCompound().getInteger("uses");
				if(uses == 1) {
					NBTTagCompound tag = new NBTTagCompound();
					newStack.getTagCompound().setTag("item", tag);
				} else {
					runeStack.getTagCompound().setInteger("uses", uses - 1);
					NBTTagCompound tag = new NBTTagCompound();
					runeStack.writeToNBT(tag);
					newStack.getTagCompound().setTag("item", tag);
				}
				this.sparkle("reddust", player, world, (int) player.posX, (int) player.posY + 1, (int) player.posZ, world.rand);
			} else if(runeStack != null) {
				player.addChatMessage(RenderHelper.applyColor(14) + "Not enough XP to use this rune!");
			} 
		}
		if(world.isRemote && !player.isSneaking() && stack.getTagCompound().getTag("item") == null) {
			PacketSound sound = new PacketSound("assets.spatialrunes.sounds.failure", 1.0F, 1.0F);
			PacketHandler.sound.sendToAllPlayersAround(sound, (int) player.posX, (int) player.posY + 1, (int) player.posZ, 10, player.dimension);
		}
		if(world.isRemote && !player.isSneaking() && stack.getTagCompound() != null) {
			if(stack.getTagCompound().getTag("item") != null) {
				ItemStack runeStack = ItemStack.loadItemStackFromNBT((NBTTagCompound) stack.getTagCompound().getTag("item"));
				if(runeStack != null && player.experienceLevel  >= RuneRegistry.getrunes().get(runeStack.getItemDamage()).getLevel()) {
					PacketSound sound = new PacketSound("runes_success", 1.0F, 1.0F);
					PacketHandler.sound.sendToAllPlayersAround(sound, (int) player.posX, (int) player.posY + 1, (int) player.posZ, 10, player.dimension);
				} else if(runeStack != null) {
					PacketSound sound = new PacketSound("runes_failure", 1.0F, 1.0F);
					PacketHandler.sound.sendToAllPlayersAround(sound, (int) player.posX, (int) player.posY + 1, (int) player.posZ, 10, player.dimension);
				}
			}
		}
		if(player.isSneaking()) {
			player.openGui(ModJam.instance, 1, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
		return newStack;
	}
	
	public void sparkle(String type, EntityPlayer player, World world, int x, int y, int z, Random rand) {
        double riser = 0.01D;
        
        for(int var1 = 0; var1 != 6; var1++) {
            double x2 = x,
                    y2 = y + rand.nextDouble(),
                    z2 = z;
            
            if(rand.nextInt(1) == 0) {
            	x2 = x - rand.nextDouble();
            	y2 = y + rand.nextDouble();
            } else {
            	x2 = x + rand.nextDouble();
            	y2 = y - rand.nextDouble();
            }
            
            PacketParticle part = new PacketParticle(type, x2, y2, z2, rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
            PacketHandler.particle.sendToAllPlayersInDimension(part, player.dimension);
        }
	}

}
