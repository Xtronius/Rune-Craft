package mod.xtronius.rc_mod.handlers;

import cpw.mods.fml.common.FMLCommonHandler;
import mod.xtronius.rc_mod.gui.overlay.GuiBuffBar;
import mod.xtronius.rc_mod.gui.overlay.GuiLevelBar;
import mod.xtronius.rc_mod.gui.overlay.GuiSwitchMeleCombatStyle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class RCEventInitializer {
	
	public RCEventInitializer(){
		FMLCommonHandler.instance().bus().register(new RCTickHandler());
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		
		
		MinecraftForge.EVENT_BUS.register(new RCPlayerHandler());
		MinecraftForge.EVENT_BUS.register(new BlockBreakHandler());
		MinecraftForge.EVENT_BUS.register(new MobInteractionHandler());
		MinecraftForge.EVENT_BUS.register(new RCPlayerHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerMouseListener());
		MinecraftForge.EVENT_BUS.register(new GuiBuffBar(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiLevelBar(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiSwitchMeleCombatStyle(Minecraft.getMinecraft()));
	}
}
