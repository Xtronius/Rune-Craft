package mod.xtronius.rc_mod.handlers;

import java.util.EnumMap;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketInitCombatStyle;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketLogFire;
import mod.xtronius.rc_mod.proxy.CommonProxy;
import mod.xtronius.rc_mod.tileEntity.TileEntityLogFire;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class RCPlayerHandler {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) { registerPlayer(event.entity); }
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		saveAndStoreData(event.entity);
		sendDataPackets(event.entity);
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		loadData(event.entity);
		sendDataPackets(event.entity);
	}

	private void registerPlayer(Entity entity) {
		if (entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) entity) == null)
			ExtendedPlayer.register((EntityPlayer) entity);
	}
	
	private void saveAndStoreData(Entity entity) {
		if (!entity.worldObj.isRemote && entity instanceof EntityPlayer) {
			NBTTagCompound playerData = new NBTTagCompound();
			((ExtendedPlayer)(entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).saveNBTData(playerData);
			CommonProxy.storeEntityData(((EntityPlayer) entity).getDisplayName(), playerData);
			ExtendedPlayer.saveProxyData((EntityPlayer) entity);
		}
	}
	
	private void loadData(Entity entity) {
		if (!entity.worldObj.isRemote && entity instanceof EntityPlayer) {
			NBTTagCompound playerData = CommonProxy.getEntityData(((EntityPlayer) entity).getDisplayName());
			if (playerData != null) {
				((ExtendedPlayer)(entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).loadNBTData(playerData);
			}
		}
	}
	
	private void sendDataPackets(Entity entity) {
		if (!entity.worldObj.isRemote && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			
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
						
						rc_mod.initCombatStylePacket.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
						rc_mod.initCombatStylePacket.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
						rc_mod.initCombatStylePacket.get(Side.SERVER).writeOutbound(new PacketInitCombatStyle(props.getMeleCombatStyleInt()));
					}
				}
			}
			
		}
	}
}
