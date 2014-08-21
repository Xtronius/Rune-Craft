package mod.xtronius.rc_mod;


import java.util.EnumMap;
import java.util.HashMap;

import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.broken.EnumRCToolMaterial;
import mod.xtronius.rc_mod.commands.*;
import mod.xtronius.rc_mod.handlers.*;
import mod.xtronius.rc_mod.lib.Reference;
import mod.xtronius.rc_mod.packetHandling.main.ChannelHandler;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.*;
import mod.xtronius.rc_mod.proxy.CommonProxy;
import mod.xtronius.rc_mod.util.RCPlayer;
import mod.xtronius.rc_mod.util.enumClasses.EnumLvlInfo;
import mod.xtronius.rc_mod.world.EventManager;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * rc_mod
 * 
 * rc_mod
 * 
 * @author xtronius
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
//channels={"WoodCutLvl", "MiningLvl", "AttackLvl", "WoodCutExp", "MiningExp", "AttackExp","WoodCutExpUNL", "MiningExpUNL", "AttackExpUNL", "RCGenericLvl", "RCBreakSpeed"}, packetHandler = PacketHandler.class)
//TODO Re-Implement Channels 


public class rc_mod {
	
	@Instance(Reference.MOD_ID)
	public static rc_mod instance;
	
	private static EnumMap<Side, FMLEmbeddedChannel> woodCuttingLvlPacket = NetworkRegistry.INSTANCE.newChannel("WoodCutLvl", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> MiningLvlPacket = NetworkRegistry.INSTANCE.newChannel("MiningLvl", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> AttackLvlPacket = NetworkRegistry.INSTANCE.newChannel("AttackLvl", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> StrengthLvlPacket = NetworkRegistry.INSTANCE.newChannel("StrengthLvl", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> DefenseLvlPacket = NetworkRegistry.INSTANCE.newChannel("DefenseLvl", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> FireMakingLvlPacket = NetworkRegistry.INSTANCE.newChannel("FireMakingLvl", new ChannelHandler());
	
	private static EnumMap<Side, FMLEmbeddedChannel> woodCuttingExpPacket = NetworkRegistry.INSTANCE.newChannel("WoodCutExp", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> MiningExpPacket = NetworkRegistry.INSTANCE.newChannel("MiningExp", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> AttackExpPacket = NetworkRegistry.INSTANCE.newChannel("AttackExp", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> StrengthExpPacket = NetworkRegistry.INSTANCE.newChannel("StrengthExp", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> DefenseExpPacket = NetworkRegistry.INSTANCE.newChannel("DefenseExp", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> FireMakingExpPacket = NetworkRegistry.INSTANCE.newChannel("FireMakingExp", new ChannelHandler());
	
	private static EnumMap<Side, FMLEmbeddedChannel> woodCuttingExpUNLPacket = NetworkRegistry.INSTANCE.newChannel("WoodCutExpUNL", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> MiningLvlUNLPacket = NetworkRegistry.INSTANCE.newChannel("MiningExpUNL", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> AttackLvlUNLPacket = NetworkRegistry.INSTANCE.newChannel("AttackExpUNL", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> StrengthLvlUNLPacket = NetworkRegistry.INSTANCE.newChannel("StrengthExpUNL", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> DefenseLvlUNLPacket = NetworkRegistry.INSTANCE.newChannel("DefenseExpUNL", new ChannelHandler());
	private static EnumMap<Side, FMLEmbeddedChannel> FireMakingLvlUNLPacket = NetworkRegistry.INSTANCE.newChannel("FireMakingExpUNL", new ChannelHandler());

	public static EnumMap<Side, FMLEmbeddedChannel> blockBreakSpeedPacket = NetworkRegistry.INSTANCE.newChannel("RCBreakSpeed", new ChannelHandler());
	public static EnumMap<Side, FMLEmbeddedChannel> LogFirePacket = NetworkRegistry.INSTANCE.newChannel("LogFire", new ChannelHandler());
	public static EnumMap<Side, FMLEmbeddedChannel> SwitchCombatStylePacket = NetworkRegistry.INSTANCE.newChannel("SwitchCombatStyle", new ChannelHandler());
	public static EnumMap<Side, FMLEmbeddedChannel> initCombatStylePacket = NetworkRegistry.INSTANCE.newChannel("initCombatStyle", new ChannelHandler());
	public static EnumMap<Side, FMLEmbeddedChannel> bankTabPacket = NetworkRegistry.INSTANCE.newChannel("bankTab", new ChannelHandler());
	public static EnumMap<Side, FMLEmbeddedChannel> bankScrollPacket = NetworkRegistry.INSTANCE.newChannel("bankScroll", new ChannelHandler());
	public static EnumMap<Side, FMLEmbeddedChannel> bankInvSyncPacket = NetworkRegistry.INSTANCE.newChannel("bankInvSync", new ChannelHandler());
	
	public static HashMap<TileEntity, Boolean> isLit =  new HashMap<TileEntity, Boolean>();
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	
	public static CommonProxy proxy;
	private static RCBlockInitializer rcblockinitializer;
	public static RCBlockRegistry BlockReg;
	public static RCItemRegistry ItemReg;
	public static RCLanguageRegistry LanguageReg;
	private RCObjectRemover rcObjectRemover;
	public static PlayerSettingsHandler playerSettings = new PlayerSettingsHandler();
	public static RCPlayer rcPlayer =  new RCPlayer();
	
	EventManager eventmanager = new EventManager();
	
	
    /***
     * This is code that is executed prior to your mod being initialized into of Minecraft
     * Examples of code that could be run here;
     * 
     * Initializing your items/blocks (you must do this here)
     * Setting up your own custom logger for writing log data to
     * Loading your language translations for your mod (if your mod has translations for other languages)
     * Registering your mod's key bindings and sounds
     * 
     * @param event The Forge ModLoader pre-initialization event
     */
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		
		RCIDHandler.RegConfigIDs(event);
		playerSettings.RegConfigs(event);
		new EnumRCToolMaterial();
		new RCBlockInitializer();
		new RCItemInitializer();	
		new RCEventInitializer();
		new RCObjectRemover();
    }   
    /***
     * This is code that is executed when your mod is being initialized in Minecraft
     * Examples of code that could be run here;
     * 
     * Registering your GUI Handler
     * Registering your different event listeners
     * Registering your different tile entities
     * Adding in any recipes you have 
     * 
     * @param event The Forge ModLoader initialization event
     */
	@EventHandler
	public void init(FMLInitializationEvent event) {

		RCBlockRegistry.BlockReg();
		RCItemRegistry.ItemReg();
		RCLanguageRegistry.LanguageReg();
		GameRegistry.registerWorldGenerator(eventmanager, 0);
//		GameRegistry..registerPlayerTracker(PlayerTrackerHandler.instance);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		//new RCCreativeTabsInitializer();
	}
    	
    /***
     * This is code that is executed after all mods are initialized in Minecraft
     * This is a good place to execute code that interacts with other mods (ie, loads an addon module
     * of your mod if you find a particular mod).
     * 
     * @param event The Forge ModLoader post-initialization event
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.registerRenderInformation();
    	proxy.initSounds();
    	proxy.initKeyBindings();
    }
    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
    	 MinecraftServer server = MinecraftServer.getServer();
    	 ICommandManager command = server.getCommandManager();
    	 ServerCommandManager manager = (ServerCommandManager) command;
//    	 manager.registerCommand(new ResetLvlNBT());
//    	 manager.registerCommand(new SetLvl());
    	 manager.registerCommand(new Tutorial());
    	 manager.registerCommand(new SetNBT());
    }
    
    public rc_mod() {}
    
    public static EnumMap<Side, FMLEmbeddedChannel> getChannel(String name) {
    	EnumLvlInfo lvls = Enum.valueOf(EnumLvlInfo.class, name);
		switch(lvls) {
			case WoodCuttingLvl: return woodCuttingLvlPacket;
			case WoodCuttingExp: return woodCuttingExpPacket;
			case WoodCuttingExpUNL: return woodCuttingExpUNLPacket;
			
			case MiningLvl: return MiningLvlPacket;
			case MiningExp: return MiningExpPacket;
			case MiningExpUNL: return MiningLvlUNLPacket;
			
			case AttackLvl: return AttackLvlPacket;
			case AttackExp: return AttackExpPacket;
			case AttackExpUNL: return AttackLvlUNLPacket;
			
			case StrengthLvl: return StrengthLvlPacket;
			case StrengthExp: return StrengthExpPacket;
			case StrengthExpUNL: return StrengthLvlUNLPacket;
			
			case DefenseLvl: return DefenseLvlPacket;
			case DefenseExp: return DefenseExpPacket;
			case DefenseExpUNL: return DefenseLvlUNLPacket;
			
			case FireMakingLvl: return FireMakingLvlPacket;
			case FireMakingExp: return FireMakingExpPacket;
			case FireMakingExpUNL: return FireMakingLvlUNLPacket;

			default: return null;
		}
    }
    
    public static IPacket getPacketType(String lvlName, String type, float value) {
    	EnumLvlInfo lvls = Enum.valueOf(EnumLvlInfo.class, lvlName);
		if(type.equals("Lvl")) {
			switch(lvls) {
			case WoodCutting: return new PacketWoodCuttingLvl((int)value); 
			case Mining: return new PacketMiningLvl((int)value); 
			case Attack: return new PacketAttackLvl((int)value); 
			case Strength: return new PacketStrengthLvl((int)value); 
			case Defense: return new PacketDefenseLvl((int)value); 
			case FireMaking: return new PacketFireMakingLvl((int)value);
			}
		}
		else if(type.equals("Exp")) {
			switch(lvls) {
			case WoodCutting: return new PacketWoodCuttingExp(value); 
			case Mining: return new PacketMiningExp(value); 
			case Attack: return new PacketAttackExp(value);
			case Strength: return new PacketStrengthExp(value);
			case Defense: return new PacketDefenseExp(value);
			case FireMaking: return new PacketFireMakingExp(value);
			}
		}
		else if(type.equals("ExpUNL")) {
			switch(lvls) {
			case WoodCutting: return new PacketWoodCuttingExpUNL(value); 
			case Mining: return new PacketMiningExpUNL(value); 
			case Attack: return new PacketAttackExpUNL(value); 
			case Strength: return new PacketStrengthExpUNL(value); 
			case Defense: return new PacketDefenseExpUNL(value);
			case FireMaking: return new PacketFireMakingExpUNL(value); 
			}
		}
		return null;
	}
}

