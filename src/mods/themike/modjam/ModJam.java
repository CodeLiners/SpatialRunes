package mods.themike.modjam;

import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "ModJamMagic!", name = "ModJam - With Magic!", version = "1")
public class ModJam {

	@Instance("ModJamMagic!")
	public ModJam instance;
	
	public static final Item itemDust = null;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		
		
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
