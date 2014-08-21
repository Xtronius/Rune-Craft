package mod.xtronius.rc_mod.handlers;

import net.minecraftforge.common.config.Configuration;
import mod.xtronius.rc_mod.lib.PlayerSettings;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class PlayerSettingsHandler {
	
	public PlayerSettings settings = new PlayerSettings();
	 
	public void RegConfigs(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		settings.setPlayerSettingsValues("RenderRCFire", "boolean", config.get("Render_Options", "Should Render RCFire", "true").getString());
		
		config.save();
	}
}
