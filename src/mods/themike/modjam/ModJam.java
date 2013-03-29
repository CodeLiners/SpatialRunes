package mods.themike.modjam;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

// Use the Force, Luke.
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "ModJamMagic!", name = "ModJam - With Magic!", version = "1")
public class ModJam {

	@Instance("ModJamMagic!")
	public ModJam instance;
	
	public static Item item;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		ModJamConfiguration.init(config);
		
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
