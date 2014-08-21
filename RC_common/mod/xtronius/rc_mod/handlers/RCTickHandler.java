package mod.xtronius.rc_mod.handlers;

import java.util.EnumMap;
import java.util.HashMap;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.commands.Tutorial;
import mod.xtronius.rc_mod.container.BankContainer;
import mod.xtronius.rc_mod.container.Furnace1Container;
import mod.xtronius.rc_mod.gui.inv.GuiBank;
import mod.xtronius.rc_mod.gui.inv.GuiFurnace1;
import mod.xtronius.rc_mod.gui.overlay.GuiBuffBar;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketAttackExp;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketAttackExpUNL;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketAttackLvl;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketMiningExp;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketMiningExpUNL;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketMiningLvl;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketWoodCuttingExp;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketWoodCuttingExpUNL;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketWoodCuttingLvl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;

public class RCTickHandler {
	
	public static RCTickHandler intance  =  new RCTickHandler();
	
	public static HashMap<EntityPlayer, Furnace1Container> furnace1ContainerMapSERVER = new HashMap<EntityPlayer, Furnace1Container>();
	public static HashMap<EntityPlayer, Furnace1Container> furnace1ContainerMapCLIENT = new HashMap<EntityPlayer, Furnace1Container>();
	
	public static HashMap<EntityPlayer, GuiFurnace1> furnace1GuiMapSERVER = new HashMap<EntityPlayer, GuiFurnace1>();
	public static HashMap<EntityPlayer, GuiFurnace1> furnace1GuiMapCLIENT = new HashMap<EntityPlayer, GuiFurnace1>();
	
	public static HashMap<EntityPlayer, BankContainer> BankContainerMapSERVER = new HashMap<EntityPlayer, BankContainer>();
	public static HashMap<EntityPlayer, BankContainer> BankContainerMapCLIENT = new HashMap<EntityPlayer, BankContainer>();
	
	public static HashMap<EntityPlayer, GuiBank> BankGuiMapSERVER = new HashMap<EntityPlayer, GuiBank>();
	public static HashMap<EntityPlayer, GuiBank> BankGuiMapCLIENT = new HashMap<EntityPlayer, GuiBank>();
	
	private static HashMap<ExtendedPlayer, Short> tickCounter = new HashMap<ExtendedPlayer, Short>();
	
	private int lvlUpdateCounter = 0;
	
	//private Tutorial tutorial =  new Tutorial();
	int CD = 0;
	
	@SubscribeEvent
	public void PlayerTickEvent(TickEvent.PlayerTickEvent event) {
		
		if(event.side.equals(event.side.CLIENT))
			TickPlayerClient(event.player);
		else if(event.side.equals(event.side.SERVER))
			TickPlayerServer(event.player);
	}
	
	private void TickPlayerServer(EntityPlayer player) {
		tickFurnace1SERVER(player);	
		tickBankSERVER(player);	
		updateLvls(player);
		managePlayerAttackCoolDown(player);
	}

	private void TickPlayerClient(EntityPlayer player) {
		managePlayerXP(player);
	}
	
	private void managePlayerAttackCoolDown(EntityPlayer player) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		if(props != null && props.attackCoolDown > 0) {
			props.attackCoolDown--;
		}
	}
	
	private void managePlayerXP(EntityPlayer player) {
		for(int xpT = player.experienceTotal; xpT <= 0; xpT--)
			player.experienceTotal = xpT;
			player.experienceLevel = 0;
			player.experience = 0F;
	}
	
	final int var1 = 1000;
	
	private void updateLvls(EntityPlayer player) {
		
		
	
		if(lvlUpdateCounter <= var1)
			lvlUpdateCounter++;
	
		if(lvlUpdateCounter == var1 && player != null) {
			ExtendedPlayer props = ExtendedPlayer.get(player);
			if(props != null) {
				for(int i = 0; i < ExtendedPlayer.SkillsNoSpaceStr.length; i++) {
					EnumMap<Side, FMLEmbeddedChannel> lvlChannel = rc_mod.getChannel(ExtendedPlayer.SkillsNoSpaceStr[i] + "Lvl");
					EnumMap<Side, FMLEmbeddedChannel> expChannel = rc_mod.getChannel(ExtendedPlayer.SkillsNoSpaceStr[i] + "Exp");
					EnumMap<Side, FMLEmbeddedChannel> expUNLChannel = rc_mod.getChannel(ExtendedPlayer.SkillsNoSpaceStr[i] + "ExpUNL");
					
					if(lvlChannel != null || expChannel != null || expUNLChannel != null) {
//						System.out.println("Currently Sending " + ExtendedPlayer.SkillsNoSpaceStr[i] + " Data!");
						lvlChannel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
						lvlChannel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
						expChannel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
						expChannel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
						expUNLChannel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
						expUNLChannel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
						lvlChannel.get(Side.SERVER).writeOutbound(rc_mod.getPacketType(ExtendedPlayer.SkillsNoSpaceStr[i], "Lvl",  props.getLvl(ExtendedPlayer.SkillsNoSpaceStr[i])));
						expChannel.get(Side.SERVER).writeOutbound(rc_mod.getPacketType(ExtendedPlayer.SkillsNoSpaceStr[i], "Exp",  (float) props.getExp(ExtendedPlayer.SkillsNoSpaceStr[i])));
						expUNLChannel.get(Side.SERVER).writeOutbound(rc_mod.getPacketType(ExtendedPlayer.SkillsNoSpaceStr[i], "ExpUNL",  (float) props.getExpUntilNextLvl(ExtendedPlayer.SkillsNoSpaceStr[i])));
					}
				}
			}
		} 
		
		if(lvlUpdateCounter > var1) 
			lvlUpdateCounter = 0;
	}
	
	private void tickFurnace1SERVER(EntityPlayer player) {
	
		if(!player.worldObj.isRemote) {
			if(furnace1ContainerMapSERVER.get(player) != null) {
				Furnace1Container container = furnace1ContainerMapSERVER.get(player);
				if(container.hasValidStackInSlots() && !container.isClosed) {
					container.update(player, "SERVER");
				}
			
				if(container.isClosed && container.hasStackInSlots()) {
					if(container.counter < 200)
						container.counter++;
					else {
						for (int i = 0; i < 3; ++i) {
							ItemStack itemstack = container.invFurnace.getStackInSlotOnClosing(i);
				                if (itemstack != null)
				                {
				                	container.invFurnace.setInventorySlotContents(i, null);
				                	//player.addChatMessage("\u00a74The item(s) you have left in the furnace have been left in there too long, the item(s) have been destroyed!");
				                }
				            }
						container.counter = 0;
						container.isClosed = false;
					}
				}
			}
		}
	}
	
	private void tickBankSERVER(EntityPlayer player) {
		
//		if(!player.worldObj.isRemote) {
//			if(BankContainerMapSERVER.get(player) != null) {
//				BankContainer container = BankContainerMapSERVER.get(player);
//				if(!container.isClosed) {
//					container.update(player, "SERVER");
//				}
//			}
//		}
	}
}
