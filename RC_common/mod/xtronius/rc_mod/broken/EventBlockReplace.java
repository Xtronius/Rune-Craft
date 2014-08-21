package mod.xtronius.rc_mod.broken;
//package mod.xtronius.rc_mod.util.event;
//
//import mod.xtronius.rc_mod.block.Blocks;
//import mod.xtronius.rc_mod.handlers.LevelManager;
//import mod.xtronius.rc_mod.handlers.PacketHandler;
//import mod.xtronius.rc_mod.items.RCItem;
//import mod.xtronius.rc_mod.util.RCPlayer;
//import net.minecraft.block.Block;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.world.World;
//import net.minecraftforge.event.ForgeSubscribe;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent;
//import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
//
//public class EventBlockReplace
//{
//	private float UnbreakableSpeed;
//	private float WoodSpeed;
//	private int prevMeta;
//	private int meta;
//	private int x;
//	private int y;
//	private int z;
////	private int temp = 0;
//	public static boolean chatToggleLvl;
//	public static boolean overChatToggleLvl;
//	public static boolean chatToggleAxe;
//	public static boolean overChatToggleAxe;
//	public static boolean overChatToggleMain;
//	
//	@ForgeSubscribe
//	public void getCurrentBlockBeingBroken(PlayerInteractEvent event) {
//		if(event.action == event.action.LEFT_CLICK_BLOCK) {
//		setX(event.x);
//		setY(event.y);
//		setZ(event.z);
//		}
//	}
//	
//	@ForgeSubscribe
//	public void breakSpeedAdjustment(PlayerEvent.BreakSpeed event) {
//		
//		
//		
//		
//		int x = this.getX();
//		int y = this.getY();
//		int z = this.getZ();
//		
//		if(isBreakableBlock(event.block) != true) {
//			event.newSpeed = 0;
//		}
//		else if(isBreakableBlock(event.block) && isWood(event.block)) {
//			event.newSpeed = actionWood.woodBreakSpeed(event.entityPlayer.worldObj, event.entityPlayer, xpValue, event.block, x, y, z);
//		}
//		else if(isBreakableBlock(event.block) && isOre(event.block)) {
//			event.newSpeed = actionOre.oreBreakSpeed(event.entityPlayer.worldObj, event.entityPlayer, xpValue, event.block, x, y, z);
//		}
//	}
//	
//	@ForgeSubscribe
//	public void onWoodBreakVanilla(HarvestDropsEvent event) {
//		
//		if (isWood(event.block)) {
//			
//			int returnMeta;
//			double xpPerLog;
//			switch(event.blockMetadata) {
//			case 0:
//				returnMeta = 0;
//				xpPerLog = 25;
//				break;
//			case 1:
//				returnMeta = 1;
//				xpPerLog = 350;
//				break;
//			case 2:
//				returnMeta = 2;
//				xpPerLog = 37.5;
//				break;
//			case 3:
//				returnMeta = 3;
//				xpPerLog = 85;
//				break;
//			case 4:
//				returnMeta = 0;
//				xpPerLog = 25;
//				break;
//			case 5:
//				returnMeta = 1;
//				xpPerLog = 350;
//				break;
//			case 6:
//				returnMeta = 2;
//				xpPerLog = 37.5;
//				break;
//			case 7:
//				returnMeta = 3;
//				xpPerLog = 85;
//				break;
//			case 8:
//				returnMeta = 0;
//				xpPerLog = 25;
//				break;
//			case 9:
//				returnMeta = 1;
//				xpPerLog = 350;
//				break;
//			case 10:
//				returnMeta = 2;
//				xpPerLog = 37.5;
//				break;
//			case 11:
//				returnMeta = 3;
//				xpPerLog = 85;
//				break;
//			default:
//				returnMeta = 13;
//				xpPerLog = 0;
//			}
//			
//			prevMeta = event.blockMetadata;
//			setMeta(prevMeta);
//			event.dropChance = 0;
//			int x = event.x;
//			int y = event.y;
//			int z = event.z;
//			
//			setBuffer(event.world,Block.wood.blockID, x, y, z);
//			event.harvester.inventory.addItemStackToInventory(new ItemStack(Block.wood, 1, returnMeta));
//			LevelManager lvlManager = new LevelManager();
//			
//			lvlManager.addWoodCuttingHarvest(event.harvester, event.harvester.getEntityData().getInteger("WoodCuttingLvl"), event.harvester.getEntityData().getDouble("WoodCuttingExp"), xpPerLog, event.harvester.getEntityData().getDouble("WoodCuttingExpUntilNextLvl"));
//		}
//	}
//	
//	@ForgeSubscribe
//	public void onOreBreakVanilla(HarvestDropsEvent event) {
//		
//		if (isOre(event.block)) {
//			
//			int returnMeta;
//			double xpPerOre;
//			
//			switch(event.block.blockID) {
//			case 16:
//				returnMeta = 1;
//				xpPerOre = 25;
//				break;
//			case 15:
//				returnMeta = 2;
//				xpPerOre = 350;
//				break;
//			case 14:
//				returnMeta = 3;
//				xpPerOre = 37.5;
//				break;
//			case 56:
//				returnMeta = 4;
//				xpPerOre = 85;
//				break;
//			case 129:
//				returnMeta = 5;
//				xpPerOre = 25;
//				break;
//			case 21:
//				returnMeta = 6;
//				xpPerOre = 350;
//				break;
//			case 74:
//				returnMeta = 7;
//				xpPerOre = 37.5;
//				break;
//			case 73:
//				returnMeta = 8;
//				xpPerOre = 85;
//				break;
//			case 153:
//				returnMeta = 9;
//				xpPerOre = 85;
//				break;
//			default:
//				returnMeta = 0;
//				xpPerOre = 0;
//			}
//			prevMeta = event.blockMetadata;
//			setMeta(prevMeta);
//			event.dropChance = 0;
//			int x = event.x;
//			int y = event.y;
//			int z = event.z;
//			
//			setBuffer(event.world, returnMeta, x, y, z);
//			event.harvester.inventory.addItemStackToInventory(new ItemStack(event.block, 1, returnMeta));
//			LevelManager lvlManager = new LevelManager();
//			
//			lvlManager.addMiningHarvest(event.harvester, event.harvester.getEntityData().getInteger("MiningLvl"), event.harvester.getEntityData().getDouble("MiningExp"), xpPerOre, event.harvester.getEntityData().getDouble("MiningExpUntilNextLvl"));
//		}
//	}
//
//	public Item getTool(EntityPlayer player) { if(player != null){ if(player.inventory != null) { if(player.inventory.getCurrentItem() != null) { if(player.inventory.getCurrentItem().getItem() != null) { Item currentItem = player.inventory.getCurrentItem().getItem(); return currentItem;}}}}return null;}
//	
//	public float getWoodToolSpeed(EntityPlayer player) {
//
//		if (getTool(player) != RCItem.BronzeHatchet && getTool(player) != RCItem.IronHatchet && getTool(player) != RCItem.SteelHatchet && getTool(player) != RCItem.BlackHatchet && getTool(player) != RCItem.MithrilHatchet && getTool(player) != RCItem.AdamantHatchet && getTool(player) != RCItem.RuneHatchet && getTool(player) != RCItem.DragonHatchet && getTool(player) != RCItem.InfernoAdze) {
//			RCPlayer.messagePlayer(player, "[Rune-Craft]\u00a74You need a hatchet to chop down a tree!", new Object[0]);
//			return 0;
//		} else if (getTool(player) == RCItem.BronzeHatchet && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 1) {
//			return 0.2F;
//		} else if (getTool(player) == RCItem.IronHatchet && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 1) {
//			return 0.25F;
//		} else if (getTool(player) == RCItem.SteelHatchet && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 6) {
//			return 0.3F;
//		} else if (getTool(player) == RCItem.BlackHatchet && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 6) {
//			return 0.3F;
//		} else if (getTool(player) == RCItem.MithrilHatchet && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 21) {
//			return 0.4F;
//		} else if (getTool(player) == RCItem.AdamantHatchet && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 31) {
//			return 0.5F;
//		} else if (getTool(player) == RCItem.RuneHatchet && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 41) {
//			return 0.6F;
//		} else if (getTool(player) == RCItem.DragonHatchet && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 61) {
//			return 0.6F;	
//		} else if (getTool(player) == RCItem.InfernoAdze && PacketHandler.playerLvl.get("WoodCuttingLvl") >= 61) {
//			return 100F;
//		} else if(getTool(player) == null) {
//			RCPlayer.messagePlayer(player, "[Rune-Craft]\u00a74You need a hatchet to chop down a tree!", new Object[0]);
//			return 0;
//		}
//		else {
//			if(overChatToggleMain == false) {
//				if(overChatToggleLvl == false) {
//				chatToggleLvl = true;
//				}
//			}
//			return 0;
//			}
//	}
//	
//	public int getWoodToolLevel(EntityPlayer player) {
//
//		Item tool = getTool(player);
//		
//		if(tool == RCItem.BronzeHatchet) {
//			return 1;
//		}
//		else if(tool == RCItem.IronHatchet) {
//			return 1;
//		}
//		else if(tool == RCItem.SteelHatchet) {
//			return 2;
//		}
//		else if(tool == RCItem.BlackHatchet) {
//			return 2;
//		}
//		else if(tool == RCItem.MithrilHatchet) {
//			return 3;
//		}
//		else if(tool == RCItem.AdamantHatchet) {
//			return 4;
//		}
//		else if(tool == RCItem.RuneHatchet) {
//			return 5;
//		}
//		else if(tool == RCItem.DragonHatchet) {
//			return 6;
//		}
//		else if(tool == RCItem.InfernoAdze) {
//			return 6;
//		}else
//			return 0;
//	}
//	
//	public float getOreToolSpeed(EntityPlayer player) {
//
//		if (getTool(player) != RCItem.BronzePickaxe && getTool(player) != RCItem.IronPickaxe && getTool(player) != RCItem.SteelPickaxe && getTool(player) != RCItem.MithrilPickaxe && getTool(player) != RCItem.AdamantPickaxe && getTool(player) != RCItem.RunePickaxe && getTool(player) != RCItem.DragonPickaxe) {
//			RCPlayer.messagePlayer(player, "[Rune-Craft]\u00a74You need a hatchet to chop down a tree!", new Object[0]);
//			return 0;
//		} else if (getTool(player) == RCItem.BronzePickaxe && PacketHandler.playerLvl.get("miningLvl") >= 0) {	
//			return 0.2F;
//		} else if (getTool(player) == RCItem.IronPickaxe && PacketHandler.playerLvl.get("miningLvl") >= 0) {
//			return 0.25F;
//		} else if (getTool(player) == RCItem.SteelPickaxe && PacketHandler.playerLvl.get("miningLvl") >= 6) {
//			return 0.3F;
//		} else if (getTool(player) == RCItem.MithrilPickaxe && PacketHandler.playerLvl.get("miningLvl") >= 21) {
//			return 0.3F;
//		} else if (getTool(player) == RCItem.AdamantPickaxe && PacketHandler.playerLvl.get("miningLvl") >= 31) {
//			return 0.4F;
//		} else if (getTool(player) == RCItem.RunePickaxe && PacketHandler.playerLvl.get("miningLvl") >= 41) {
//			return 0.55F;
//		} else if (getTool(player) == RCItem.DragonPickaxe && PacketHandler.playerLvl.get("miningLvl") >= 61) {
//			return 0.65F;
//		} else if(getTool(player) == null) {
//			RCPlayer.messagePlayer(player, "[Rune-Craft]\u00a74 You need a pickaxe to mine ore!", new Object[0]);
//			return 0;
//		}
//		else {
//			return 0;
//			}
//	}
//	
//	public int getOreToolLevel(EntityPlayer player) {
//
//		Item tool = getTool(player);
//		
//		if(tool == RCItem.BronzePickaxe) {
//			return 1;
//		}
//		else if(tool == RCItem.IronPickaxe) {
//			return 1;
//		}
//		else if(tool == RCItem.SteelPickaxe) {
//			return 2;
//		}
//		else if(tool == RCItem.MithrilPickaxe) {
//			return 3;
//		}
//		else if(tool == RCItem.AdamantPickaxe) {
//			return 4;
//		}
//		else if(tool == RCItem.RunePickaxe) {
//			return 5;
//		}
//		else if(tool == RCItem.DragonPickaxe) {
//			return 6;
//		}
//		else
//			return 0;
//	}
//	
//	public boolean isBreakableBlock(Block block) { if(block.equals(Block.wood) || block.equals(Block.oreCoal) || block.equals(Block.oreIron) || block.equals(Block.oreGold) || block.equals(Block.oreDiamond) || block.equals(Block.oreEmerald) || block.equals(Block.oreLapis) || block.equals(Block.oreRedstone) || block.equals(Block.oreRedstoneGlowing) || block.equals(Block.oreNetherQuartz)) {return true;} return false;}
//	public boolean isWood(Block block) { if(block.equals(Block.wood)) { return true;} return false;}
//	public boolean isOre(Block block) { if(block.equals(Block.oreCoal) || block.equals(Block.oreIron) || block.equals(Block.oreGold) || block.equals(Block.oreDiamond) || block.equals(Block.oreEmerald) || block.equals(Block.blockLapis) || block.equals(Block.oreRedstone) || block.equals(Block.oreRedstoneGlowing) || block.equals(Block.oreNetherQuartz)) {return true;} return false;}
//	
//	public int getX() {return x;}
//	public void setX(int x) {this.x = x;}
//	public int getY() {return y;}
//	public void setY(int y) {this.y = y;}
//	public int getZ() {return z;}
//	public void setZ(int z) {this.z = z;}
//	public int getMeta() {return meta;}
//	public void setMeta(int meta) {this.meta = meta;}
//	public float getWoodSpeed() {return WoodSpeed;}
//	public void setWoodSpeed(float woodSpeed) {WoodSpeed = woodSpeed;}
//	public float getUnbreakableSpeed() {return UnbreakableSpeed;}
//	public void setBuffer(World world ,int block, int x, int y, int z) {
//		int meta;
//		if(block == Block.wood.blockID) {
//			world.setBlock(x, y, z ,Blocks.BlockWoodBuffer.blockID, this.getMeta(), 2);	
//		} 
//		else if(block == 1 || block == 2 || block == 3 || block == 4 || block == 5 || block == 6 || block == 7 || block == 8) {
//			world.setBlock(x, y, z, Blocks.BlockStoneBuffer.blockID, block, 2);
//		}
//	}
//}
//	