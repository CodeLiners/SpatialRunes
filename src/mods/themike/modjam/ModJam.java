package mods.themike.modjam;

import mods.themike.modjam.handler.MobDropHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

// Use the Force, Luke.
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "ModJamMagic!", name = "ModJam - With Magic!", version = "1")
public class ModJam {

	@Instance("ModJamMagic!")
	public ModJam instance;
	
	public static Item item;
	public static Item runes;
	
	public static CreativeTabs tab = new ModJamTab();

	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new MobDropHandler());
		LanguageRegistry.instance().loadLocalization("/mods/mikejam/lang/en_US.xml", "en_US", true);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		ModJamConfiguration.init(config);		
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		ModJamRecipies.init();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
