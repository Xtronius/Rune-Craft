package mod.xtronius.rc_mod.broken;
//package mod.xtronius.rc_mod.handlers;
//
//import java.util.HashMap;
//
//import net.minecraft.entity.player.EntityPlayer;
//import cpw.mods.fml.common.IPlayerTracker;
//import mod.xtronius.rc_mod.rc_mod;
//import mod.xtronius.rc_mod.lib.ExtendedPlayer;
//
//
//public class PlayerTrackerHandler implements IPlayerTracker{
//
//	public static PlayerTrackerHandler instance = new PlayerTrackerHandler();
//	private PacketHandler packetHandler = rc_mod.proxy.getPacketHandler();
//         
//        @Override
//        public void onPlayerLogin(EntityPlayer player) {
//        	 for(int i = 0; i < ExtendedPlayer.SkillsNoSpaceStr.length; i++) {
//        		 this.packetHandler.sendGenericLvlPacket(player, ExtendedPlayer.SkillsNoSpaceStr[i]);
//        		 this.packetHandler.sendGenericExpPacket(player, ExtendedPlayer.SkillsNoSpaceStr[i]);
//        		 this.packetHandler.sendGenericExpUntilNextLvlPacket(player, ExtendedPlayer.SkillsNoSpaceStr[i]);
//        	 }
//        }
//        
//        @Override
//        public void onPlayerLogout(EntityPlayer player) {}
//
//        @Override
//        public void onPlayerChangedDimension(EntityPlayer player) {}
//
//        @Override
//        public void onPlayerRespawn(EntityPlayer player) {}
//}
//
// 