package mod.xtronius.rc_mod.broken;
//package mod.xtronius.rc_mod.util.event.action;
//
//import java.io.ByteArrayOutputStream;
//import java.io.DataOutputStream;
//
//import mod.xtronius.rc_mod.handlers.LevelManager;
//import mod.xtronius.rc_mod.handlers.PacketHandler;
//import mod.xtronius.rc_mod.lib.PlayerXPValue;
//import mod.xtronius.rc_mod.util.event.EventBlockReplace;
//import net.minecraft.block.Block;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.item.Item;
//import net.minecraft.network.packet.Packet250CustomPayload;
//import net.minecraft.world.World;
//import cpw.mods.fml.common.network.PacketDispatcher;
//import cpw.mods.fml.common.network.Player;
//
//public class ActionWood {
//
//	public ActionWood() {
//	}
//	
//	private EventBlockReplace eventBlockReplace = new EventBlockReplace();
//	private static LevelManager lvlManager = new LevelManager();
//	private PacketHandler pkHandler = new PacketHandler();
//	private float woodBreakSpeed;
//	
//	private final float Wood = 4.5F;
//	private final float Yew = 4.5F;
//	private final float Oak = 4.5F;
//	private final float Teak = 4.5F;
//	
//	public float woodBreakSpeed(World world, EntityPlayer player, PlayerXPValue xpValue, Block block, int x, int y, int z) {
//		
//		Item tool = eventBlockReplace.getTool(player);
//		int toolLvl = eventBlockReplace.getWoodToolLevel(player);
//		int meta = block.getDamageValue(world, x, y, z);
//		float toolSpeed = eventBlockReplace.getWoodToolSpeed(player);
//		
//		float Lvl = 0;
//		
//		if(!world.isRemote) {
//			Lvl = lvlManager.getLvl(player, "WoodCuttingLvl");
//		}
//		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+PacketHandler.playerLvl.get("WoodCuttingLvl"));
//		
//		System.out.println(meta + " " + toolLvl);
//		
//		if(meta == 0 && toolLvl >= 1) 
//			calculateSpeed(world, player, toolSpeed);
//		else if(meta == 1 && toolLvl >= 5) 
//			calculateSpeed(world, player, toolSpeed);
//		else if(meta == 2 && toolLvl >= 5) 
//			calculateSpeed(world, player, toolSpeed);
//		else if(meta == 3 && toolLvl >= 4) 
//			calculateSpeed(world, player, toolSpeed);
//		 
//		System.out.println("[Rune-Craft] Error - WoodBreakSpeed Method");
//		return 0;
//	}
//	
//	private float calculateSpeed(World world, EntityPlayer player, float toolSpeed) {
//		this.sendPacket(world, player);
//		System.out.println("ffffffffffffffffffffffffffffffffffuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu"+PacketHandler.playerLvl.get("WoodCuttingLvl"));
//		if(toolSpeed > 0) 
//			return ((Wood*toolSpeed) + (PacketHandler.playerLvl.get("WoodCuttingLvl")/50));
//		return 0;
//	}
//	
//	public static void sendPacket(World world, EntityPlayer player) {
//		
//		if(!world.isRemote){
//			
//			float Lvl = 0;
//			Lvl = lvlManager.getLvl(player, "WoodCuttingLvl");
//            float WoodCuttingLvl = Lvl;
//            ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//            DataOutputStream outputStream = new DataOutputStream(bos);
//            
//            try {
//                    outputStream.writeFloat(WoodCuttingLvl);
//            } catch (Exception ex) {
//                    ex.printStackTrace();
//            }
//            
//            Packet250CustomPayload packet = new Packet250CustomPayload();
//            packet.channel = "RCWoodCutLvl";
//            packet.data = bos.toByteArray();
//            packet.length = bos.size();
//            
//            EntityPlayerMP playerObj = (EntityPlayerMP) player;
//            PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//		}
//	}
//}
