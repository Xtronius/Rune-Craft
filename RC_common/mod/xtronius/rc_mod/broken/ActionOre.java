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
//public class ActionOre {
//
//	public ActionOre() {
//	}
//	
//	private EventBlockReplace eventBlockReplace = new EventBlockReplace();
//	private static LevelManager lvlManager = new LevelManager();
//	private PacketHandler pkHandler = new PacketHandler();
//	private float woodBreakSpeed;
//	
//	public float oreBreakSpeed(World world, EntityPlayer player, PlayerXPValue xpValue, Block block, int x, int y, int z) {
//		
//		Item tool = eventBlockReplace.getTool(player);
//		int toolLvl = eventBlockReplace.getOreToolLevel(player);
//		float toolSpeed = eventBlockReplace.getOreToolSpeed(player);
//		
//		float Coal = 1F;
//		float Iron = 2F;
//		float Gold = 4F;
//		float Diamond = 6F;//rune
//		float Emerald = 5F;//adamant
//		float Lapis = 1F;//tin
//		float RedStoneOn = 3F;//mithrill
//		float redStoneOff = 3F;//mithrill'
//		float quartz = 3F;//copper
//		float Lvl = 0;
//		
//		if(!world.isRemote) {
//			Lvl = lvlManager.getLvl(player, "MiningLvl");
//			}
//		
//		
//		if(block == Block.oreCoal) {
//			if(toolLvl >= 4) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				if(toolSpeed > 0 && PacketHandler.playerLvl.get("miningLvl") >= 30) {
//					System.out.println(((Coal*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50)));
//					return ((Coal*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		} else if(block == Block.oreIron) {
//			if(toolLvl >= 3) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				
//				if(toolSpeed > 0 && PacketHandler.playerLvl.get("miningLvl") >= 15) {
//					return ((Iron*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		} else if(block == Block.oreGold) {
//			if(toolLvl >= 5) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				
//				if(toolSpeed > 0 && PacketHandler.playerLvl.get("miningLvl") >= 40) {
//					return ((Gold*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		} else if(block == Block.oreDiamond) {
//			if(toolLvl >= 6) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				
//				if(toolSpeed > 0 && PacketHandler.playerLvl.get("miningLvl") >= 85) {
//					return ((Diamond*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		} else if(block == Block.oreEmerald) {
//			if(toolLvl >= 1) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				
//				if(toolSpeed > 0) {
//					return ((Emerald*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		} else if(block == Block.oreLapis) {
//			if(toolLvl >= 1) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				
//				if(toolSpeed > 0) {
//					return ((Lapis*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		} else if(block == Block.oreRedstone) {
//			if(toolLvl >= 1) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				
//				if(toolSpeed > 0) {
//					return ((Coal*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		} else if(block == Block.oreRedstoneGlowing) {
//			if(toolLvl >= 1) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				
//				if(toolSpeed > 0) {
//					return ((Coal*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		} else if(block == Block.oreNetherQuartz) {
//			if(toolLvl >= 1) {
//				if(!world.isRemote){
//	                float MiningLvl = Lvl;
//	                ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//	                DataOutputStream outputStream = new DataOutputStream(bos);
//	                try {
//	                        outputStream.writeFloat(MiningLvl);
//	                } catch (Exception ex) {
//	                        ex.printStackTrace();
//	                }
//	                
//	                Packet250CustomPayload packet = new Packet250CustomPayload();
//	                packet.channel = "RCMiningLvl";
//	                packet.data = bos.toByteArray();
//	                packet.length = bos.size();
//	                
//	                if (!world.isRemote) {
//	                        EntityPlayerMP playerObj = (EntityPlayerMP) player;
//	                        PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//	                } else if (world.isRemote) {
//	                } else {
//	                }
//				}
//				
//				if(toolSpeed > 0) {
//					return ((Coal*toolSpeed) + (PacketHandler.playerLvl.get("miningLvl")/50));
//				} else {
//					return 0;
//				}
//			}
//		}else 
//			System.out.println("[Rune-Craft] Error - WoodBreakSpeed Method");
//			return 0;
//	}
//	
//	public static void sendStartUpPacket(World world, EntityPlayer player) {
//		float Lvl = 0;
//		if(!world.isRemote){
//			Lvl = lvlManager.getLvl(player, "MiningLvl");
//		float MiningLvl = Lvl;
//        ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
//        DataOutputStream outputStream = new DataOutputStream(bos);
//        try {
//                outputStream.writeFloat(MiningLvl);
//        } catch (Exception ex) {
//                ex.printStackTrace();
//        }
//        
//        Packet250CustomPayload packet = new Packet250CustomPayload();
//        packet.channel = "RCMiningLvl";
//        packet.data = bos.toByteArray();
//        packet.length = bos.size();
//        
//        if (!world.isRemote) {
//                EntityPlayerMP playerObj = (EntityPlayerMP) player;
//                PacketDispatcher.sendPacketToPlayer(packet, (Player)playerObj);
//        }
//	}
//}
//		
//}
