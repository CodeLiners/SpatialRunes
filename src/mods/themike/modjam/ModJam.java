package mods.themike.modjam;

import mods.themike.modjam.handler.GUIHandler;
import mods.themike.modjam.handler.MobDropHandler;
import mods.themike.modjam.handler.SoundHandler;
import mods.themike.modjam.items.ItemBlockDecoration;
import mods.themike.modjam.proxy.IProxy;
import mods.themike.modjam.tile.TileEntityCarvingStone;
import mods.themike.modjam.utils.ColorUtils;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

// Use the Force, Luke.
// Thee shall now be dubbed, Spatial Runes!
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "ModJamMagic!", name = "Spatial Runes", version = "1.0.0")
public class ModJam {

	@Instance("ModJamMagic!")
	public static ModJam instance;
	
	public static Item item;
	public static Item runes;
	public static Item staff;
	public static Item scroll;
	
	public static Block carvingStone;
	public static Block decoration;
	public static Block slabs;
	
	public static CreativeTabs tab = new ModJamTab();

	@SidedProxy(clientSide = "mods.themike.modjam.proxy.ClientProxy", serverSide = "mods.themike.modjam.proxy.CommonProxy")
	public static IProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new MobDropHandler());
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		
		LanguageRegistry.instance().loadLocalization("/mods/mikejam/lang/en_US.xml", "en_US", true);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		ModJamConfiguration.init(config);		
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		ModJamRecipies.init();
		proxy.init();
		NetworkRegistry.instance().registerGuiHandler(this, new GUIHandler());
		GameRegistry.registerBlock(carvingStone, "Carving Stone");
		GameRegistry.registerBlock(decoration, ItemBlockDecoration.class, "Decoration");
		GameRegistry.registerBlock(slabs, "Slabs");
		GameRegistry.registerTileEntity(TileEntityCarvingStone.class, "Carving Stone");
		LanguageRegistry.instance().addStringLocalization("itemsub.dustSpatial.name", ColorUtils.applyColor(9) + "Spatial Dust");
		LanguageRegistry.instance().addStringLocalization("itemsub.essence.name", ColorUtils.applyColor(9) + "Crystalline Essence");
		LanguageRegistry.instance().addStringLocalization("staff.apprentice.name", ColorUtils.applyColor(9) + "Staff of the Apprentice");
		LanguageRegistry.instance().addStringLocalization("item.papyrusScroll.name", ColorUtils.applyColor(14) + "Papyrus Scroll (For a later release)");
		LanguageRegistry.instance().addStringLocalization("itemsub.magegem.name", ColorUtils.applyColor(14) + "Mage Gem");
		LanguageRegistry.instance().addStringLocalization("staff.mage.name", ColorUtils.applyColor(14) + "Staff of the Mage");
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
