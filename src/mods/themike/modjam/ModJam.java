package mods.themike.modjam;

import themike.core.render.RenderHelper;
import mods.themike.modjam.handler.GUIHandler;
import mods.themike.modjam.handler.MobDropHandler;
import mods.themike.modjam.handler.SoundHandler;
import mods.themike.modjam.packet.PacketHandler;
import mods.themike.modjam.proxy.IProxy;
import mods.themike.modjam.tile.TileEntityCarvingStone;
import net.minecraft.block.Block;
import net.minecraft.client.resources.ResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;

// Use the Force, Luke.
// Thee shall now be dubbed, Spatial Runes!
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels=("SpatialRunes"), packetHandler = PacketHandler.class)
@Mod(modid = "SpatialRunes", name = "Spatial Runes", version = "1.0.0")
public class ModJam {

	@Instance("SpatialRunes")
	public static ModJam instance;
	
	public static Item item;
	public static Item runes;
	public static Item staff;
	public static Item scroll;
	public static Item reaper;
	
	public static Block carvingStone;

	public static Block decoration;
	public static Block mageSlab;
	public static Block lamp;
	
	public static boolean hasAtum = false;
	
	public static CreativeTabs tab = new ModJamTab();
	
	@SidedProxy(clientSide = "mods.themike.modjam.proxy.ClientProxy", serverSide = "mods.themike.modjam.proxy.CommonProxy")
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new MobDropHandler());
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
				
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		ModJamConfiguration.init(config);		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		ModJamRecipies.init();
		proxy.init();
		NetworkRegistry.instance().registerGuiHandler(this, new GUIHandler());
		GameRegistry.registerBlock(carvingStone, "Carving Stone");
		GameRegistry.registerTileEntity(TileEntityCarvingStone.class, "Carving Stone");
		
		LanguageRegistry.instance().addStringLocalization("itemsub.dustSpatial.name", RenderHelper.applyColor(9) + "Spatial Dust");
		LanguageRegistry.instance().addStringLocalization("itemsub.essence.name", RenderHelper.applyColor(9) + "Crystalline Essence");
		LanguageRegistry.instance().addStringLocalization("staff.apprentice.name", RenderHelper.applyColor(9) + "Staff of the Apprentice");
		LanguageRegistry.instance().addStringLocalization("item.reaper.name", RenderHelper.applyColor(9) + "Reaper Blade");
		LanguageRegistry.instance().addStringLocalization("item.papyrusScroll.name", RenderHelper.applyColor(14) + "Papyrus Scroll (For a later release)");
		LanguageRegistry.instance().addStringLocalization("itemsub.magegem.name", RenderHelper.applyColor(14) + "Mage Gem");
		LanguageRegistry.instance().addStringLocalization("staff.mage.name", RenderHelper.applyColor(14) + "Staff of the Mage");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if(Loader.isModLoaded("Atum")) {
			hasAtum = true;
		}	
	}
	
	
	
}
