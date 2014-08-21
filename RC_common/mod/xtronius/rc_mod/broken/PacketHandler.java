package mod.xtronius.rc_mod.broken;
//package mod.xtronius.rc_mod.handlers;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//
//import mod.xtronius.rc_mod.rc_mod;
//import mod.xtronius.rc_mod.lib.ExtendedPlayer;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.network.INetworkManager;
//import net.minecraft.network.packet.Packet250CustomPayload;
//import net.minecraft.world.World;
//import cpw.mods.fml.common.FMLCommonHandler;
//import cpw.mods.fml.common.network.IPacketHandler;
//import cpw.mods.fml.common.network.PacketDispatcher;
//import cpw.mods.fml.common.network.Player;
//
//public class PacketHandler implements IPacketHandler {
//	
////	private PlayerManager playerManager;
//	public static float breakSpeed;
//
//	@Override
//	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
//       
//		ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) player);
//		
//		 if (packet.channel.equals("RCBreakSpeed")) {
//			 handleBreakSpeedPacket(packet, (EntityPlayer) player);
//		 } else if(props != null) {	
//			 
//			if (packet.channel.equals("WoodCutLvl")) {
//	        	handleGenericLvlPacket("WoodCutting", packet, (EntityPlayer) player, props);
//	        }else if (packet.channel.equals("MiningLvl")) {
//	        	handleGenericLvlPacket("Mining", packet, (EntityPlayer) player, props);
//	        }else if (packet.channel.equals("AttackLvl")) {
//		    	handleGenericLvlPacket("Attack", packet, (EntityPlayer) player, props);
//		    }else if (packet.channel.equals("WoodCutExp")) {
//	        	handleGenericExpPacket("WoodCutting", packet, (EntityPlayer) player, props);
//	        }else if (packet.channel.equals("MiningExp")) {
//	        	handleGenericExpPacket("Mining", packet, (EntityPlayer) player, props);
//	        }else if (packet.channel.equals("AttackExp")) {
//		    	handleGenericExpPacket("Attack", packet, (EntityPlayer) player, props);
//		    }else if (packet.channel.equals("WoodCutExpUNL")) {
//		    	handleGenericExpUntilNextLvlPacket("WoodCutting", packet, (EntityPlayer) player, props);
//	        }else if (packet.channel.equals("MiningExpUNL")) {
//	        	handleGenericExpUntilNextLvlPacket("Mining", packet, (EntityPlayer) player, props);
//	        }else if (packet.channel.equals("AttackExpUNL")) {
//		    	handleGenericExpUntilNextLvlPacket("Attack", packet, (EntityPlayer) player, props);
//		    }   
//		}
//	}
//	
//	private void handleBreakSpeedPacket(Packet250CustomPayload packet, EntityPlayer player) {
//		
//        DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
//        float breakSpeed;
//        try { breakSpeed = inputStream.readFloat();
//        } catch (IOException e) { e.printStackTrace(); return; }
//        this.breakSpeed = breakSpeed;
//	}
//	
//	private void handleGenericLvlPacket(String type, Packet250CustomPayload packet, EntityPlayer player, ExtendedPlayer props) {
//		
//        DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
//        float Lvl;
//        try { Lvl = inputStream.readFloat();
//        } catch (IOException e) { e.printStackTrace(); return; }
//        props.setLvl(type, (int) Lvl);
//	}
//	
//	private void handleGenericExpPacket(String type, Packet250CustomPayload packet, EntityPlayer player, ExtendedPlayer props) {
//        DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
//        float Exp;
//        try { Exp = inputStream.readFloat();
//        } catch (IOException e) { e.printStackTrace(); return; }
//        props.setExp(type, Exp);
//	}
//	
//	private void handleGenericExpUntilNextLvlPacket(String type, Packet250CustomPayload packet, EntityPlayer player, ExtendedPlayer props) {
//        DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
//        float ExpUntilNextLvl;
//        try { ExpUntilNextLvl = inputStream.readFloat();
//        } catch (IOException e) { e.printStackTrace(); return; }
//        props.setExpUntilNextLvl(type, ExpUntilNextLvl);
//	}
//	    
//    public void sendGenericLvlPacket(EntityPlayer player, String Name) {
//    	
//    	String channel = "RCGenericLvl";
//		float genericLvl = 0;
//		if(Name == "WoodCutting") { channel = "WoodCutLvl"; }
//		else { channel = Name + "Lvl"; }
//		
//		ExtendedPlayer props = ExtendedPlayer.get(player);
//		if(props != null) { genericLvl = props.getLvl(Name); }
//        ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//        DataOutputStream outputStream = new DataOutputStream(bos);
//        try { outputStream.writeFloat(genericLvl);
//        } catch (Exception ex) { ex.printStackTrace(); }
//        
//        Packet250CustomPayload packet = new Packet250CustomPayload();
//        packet.channel = channel;
//        packet.data = bos.toByteArray();
//        packet.length = bos.size();
//    
//        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//    }
//    
//    public void sendGenericExpPacket(EntityPlayer player, String Name) {
//    	
//    	String channel = "RCGenericExp";
//		float genericExp = 0;
//		if(Name == "WoodCutting") { channel = "WoodCutExp"; }
//		else { channel = Name + "Exp"; }
//		
//		ExtendedPlayer props = ExtendedPlayer.get(player);
//		if(props != null) { genericExp = (float) props.getExp(Name); }
//        ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//        DataOutputStream outputStream = new DataOutputStream(bos);
//        try { outputStream.writeFloat(genericExp);
//        } catch (Exception ex) { ex.printStackTrace(); }
//        
//        Packet250CustomPayload packet = new Packet250CustomPayload();
//        packet.channel = channel;
//        packet.data = bos.toByteArray();
//        packet.length = bos.size();
//    
//        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//    }
//    
//    public void sendGenericExpUntilNextLvlPacket(EntityPlayer player, String Name) {
//    	
//    	String channel = "RCGenericExpUNL";
//		float genericExpUNL = 0;
//		if(Name == "WoodCutting") { channel = "WoodCutExpUNL"; }
//		else { channel = Name + "ExpUNL"; }
//		
//		ExtendedPlayer props = ExtendedPlayer.get(player);
//		if(props != null) { genericExpUNL = (float) props.getExpUntilNextLvl(Name); }
//        ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//        DataOutputStream outputStream = new DataOutputStream(bos);
//        try {
//        	outputStream.writeFloat(genericExpUNL);
//        } catch (Exception ex) {
//            ex.printStackTrace(); }
//        
//        Packet250CustomPayload packet = new Packet250CustomPayload();
//        packet.channel = channel;
//        packet.data = bos.toByteArray();
//        packet.length = bos.size();
//    
//        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//    }
//}