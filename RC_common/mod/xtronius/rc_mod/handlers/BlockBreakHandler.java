package mod.xtronius.rc_mod.handlers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.items.Items;
import mod.xtronius.rc_mod.lib.BlockBreakActionInfo;
import mod.xtronius.rc_mod.lib.BlockInfo;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketBlockBreakSpeed;
import mod.xtronius.rc_mod.positions.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class BlockBreakHandler {
	
	private BlockInfo blockInfo = new BlockInfo();
	
	public static HashMap<EntityPlayer, Float> breakSpeedMap  = new HashMap<EntityPlayer, Float>();
	
	@SubscribeEvent
	public void breakSpeedEvent(BreakSpeed event) {
		
		if(isBreakableBlock(event.block) && this.canObtainMoreItems(event.entityPlayer)) {
			BlockBreakActionInfo info = new BlockBreakActionInfo(event.entityPlayer);
		
			if(!event.entityPlayer.worldObj.isRemote) {
				if(blockInfo != null && info != null) {
					info.setBlockHardness(0);
					info.setBreakSpeed(0);
					info.setLvl(0);
					info.setTool(null);
					info.setToolLvl(0);
					info.setToolSpeed(0);
				
					getInfo(event.entityPlayer, event.block, info, event.metadata);
					
//					System.out.println("Lvl: " + info.getLvl() + " Tool Speed: " + info.getToolSpeed() + " Block Hardness: " + info.getBlockHardness() + " Break Speed: " + calculateBreakingSpeed(info.getLvl(), info.getToolSpeed(), info.getBlockHardness()));
				
					float breakSpeed = calculateBreakingSpeed(info.getLvl(), info.getToolSpeed(), info.getBlockHardness());
					
					event.newSpeed = breakSpeed;
					sendBreakSpeedPacket(event.entityPlayer, breakSpeed);
				}
			} else {}
			if(this.breakSpeedMap.get(event.entityPlayer) != null)
				event.newSpeed = this.breakSpeedMap.get(event.entityPlayer);
				this.breakSpeedMap.put(event.entityPlayer, 0F);
		} else {
			event.newSpeed = 0;
			event.setCanceled(true);
		}
	}
	
	public void getInfo(EntityPlayer player, Block block, BlockBreakActionInfo info, int meta) {
		
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
			if(props != null) {
				if(player.inventory.getCurrentItem() != null) 
					info.setTool(player.inventory.getCurrentItem().getItem());
				
				if(info.getTool() != null) {
					
					if(block == Block.getBlockFromName("log")) {
						info.setLvl(props.getLvl("WoodCutting"));
						if(blockInfo.toolHatchetLvlRatingHash.get(info.getTool()) != null)
							info.setToolLvl(blockInfo.toolHatchetLvlRatingHash.get(info.getTool()));
						if(blockInfo.toolHatchetSpeedHash.get(info.getTool()) != null && blockInfo.toolHatchetLvlHash.get(info.getTool()) != null && info.getLvl() >= blockInfo.toolHatchetLvlHash.get(info.getTool()))
							info.setToolSpeed(blockInfo.toolHatchetSpeedHash.get(info.getTool()));
						if(info.getLvl() >= blockInfo.blockMetaWoodLvlHash.get(meta))
							//TODO Add Values For Block Tool Values And Then Check For >= For Them
							if(info.getToolLvl() >= 0) { 
								info.setBlockHardness(blockInfo.blockMetaWoodHardnessHash.get(meta));
							}
					}
					else if(block == Blocks.Wood2) {
						info.setLvl(props.getLvl("WoodCutting"));
						if(blockInfo.toolHatchetLvlRatingHash.get(info.getTool()) != null)
							info.setToolLvl(blockInfo.toolHatchetLvlRatingHash.get(info.getTool()));
						if(blockInfo.toolHatchetSpeedHash.get(info.getTool()) != null && blockInfo.toolHatchetLvlHash.get(info.getTool()) != null && info.getLvl() >= blockInfo.toolHatchetLvlHash.get(info.getTool()))
							info.setToolSpeed(blockInfo.toolHatchetSpeedHash.get(info.getTool()));
						if(info.getLvl() >= blockInfo.blockMetaWood2LvlHash.get(meta))
							//TODO Add Values For Block Tool Values And Then Check For >= For Them
							if(info.getToolLvl() >= 0) {
								info.setBlockHardness(blockInfo.blockMetaWood2HardnessHash.get(meta));
							}
					} 
					else if(this.isOre(block)){
						info.setLvl(props.getLvl("Mining"));
						if(blockInfo.toolPickaxeLvlRatingHash.get(info.getTool()) != null)
							info.setToolSpeed(blockInfo.toolPickaxeLvlRatingHash.get(info.getTool()));
						if(blockInfo.toolPickaxeSpeedHash.get(info.getTool()) != null && blockInfo.toolPickaxeLvlHash.get(info.getTool()) != null && info.getLvl() >= blockInfo.toolPickaxeLvlHash.get(info.getTool()))
							info.setToolLvl(blockInfo.toolPickaxeLvlRatingHash.get(info.getTool()));
						
						if(info.getLvl() >= blockInfo.blockLvlHash.get(block))
							//TODO Add Values For Block Tool Values And Then Check For >= For Them
							if(info.getToolLvl() >= 0) {
								info.setBlockHardness(blockInfo.blockHardnessHash.get(block));
							}
					}
				}
			}
		}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.HarvestDropsEvent event) {
		event.dropChance = 0;
		
		if(isBreakableBlock(event.block) && event.harvester != null) {
			
			int meta = event.blockMetadata;
			Item itemReturn = BlockInfo.blockReturnItemHash.get(event.block);
			int x = event.x;
			int y = event.y;
			int z = event.z;
			
				
			if(event.block.equals(Block.getBlockFromName("log"))) {
				setBufferBlock(event.world, event.block, meta, x, y, z);
				Item itemReturnMeta = BlockInfo.blockReturnItemMetaHash.get(meta);
				if(canObtainMoreItems(event.harvester))
					event.harvester.inventory.setInventorySlotContents(event.harvester.inventory.getFirstEmptyStack(), new ItemStack(itemReturnMeta, 1));
					LevelManager.addWoodCuttingHarvest(event.harvester, blockInfo.xpPerLogHash.get(meta));
			} 
			else if(event.block.equals(Blocks.Wood2)) {
				setBufferBlock(event.world, event.block, meta, x, y, z);
				Item itemReturnMeta2 = BlockInfo.blockReturnItemMeta2Hash.get(meta);
				if(canObtainMoreItems(event.harvester))
					event.harvester.inventory.setInventorySlotContents(event.harvester.inventory.getFirstEmptyStack(), new ItemStack(itemReturnMeta2, 1));
					LevelManager.addWoodCuttingHarvest(event.harvester, blockInfo.xpPerLog2Hash.get(meta));
			}
			else if(isOre(event.block)) {
				setBufferBlock(event.world, event.block, BlockInfo.blockReturnHarvestMetaIDHash.get(event.block), x, y, z);
				if(canObtainMoreItems(event.harvester))
					event.harvester.inventory.setInventorySlotContents(event.harvester.inventory.getFirstEmptyStack(), new ItemStack(itemReturn, 1));
					LevelManager.addMiningHarvest(event.harvester, blockInfo.xpPerBlockHash.get(event.block));
			}
		}
	}
	public void sendBreakSpeedPacket(EntityPlayer player, float breakSpeed) {
		rc_mod.blockBreakSpeedPacket.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		rc_mod.blockBreakSpeedPacket.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
		rc_mod.blockBreakSpeedPacket.get(Side.SERVER).writeOutbound(new PacketBlockBreakSpeed(breakSpeed));
    }
	
	public float calculateBreakingSpeed(float Lvl, float toolSpeed, float blockHardness) {
		if(toolSpeed > 0 && blockHardness > 0 && Lvl > 0)
			return ((blockHardness * toolSpeed) + (Lvl/50F));
			return 0;
	}
	public void setBufferBlock(World world ,Block block, int meta, int x, int y, int z) {
		if(block.equals(Block.getBlockFromName("log"))) {
			world.setBlock(x, y, z ,Blocks.BlockWoodBuffer, meta, 2);
			return;
		}
		else if(block.equals(Blocks.Wood2)) {
			world.setBlock(x, y, z ,Blocks.BlockWood2Buffer, meta, 2);
			return;
		}
		else if(isOre(block))  {
			world.setBlock(x, y, z ,Blocks.BlockStoneBuffer, meta, 2);
			return;
		}
	}
	public boolean canObtainMoreItems(EntityPlayer player) {
		if(player.inventory.getFirstEmptyStack() < 0) 
			return false;
		return true;
	}
	public boolean isBreakableBlock(Block block) { if(block.equals(Block.getBlockFromName("log")) || block.equals(Blocks.Wood2) || block.equals(Block.getBlockFromName("coal_ore")) || block.equals(Block.getBlockFromName("iron_ore")) || block.equals(Block.getBlockFromName("gold_ore")) || block.equals(Block.getBlockFromName("diamond_ore")) || block.equals(Block.getBlockFromName("emerald_ore")) || block.equals(Block.getBlockFromName("lapis_ore")) || block.equals(Block.getBlockFromName("quartz_ore"))) {return true;} return false;}
	public boolean isWood(Block block) { if(block.equals(Block.getBlockFromName("log")) || block.equals(Blocks.Wood2)) { return true;} return false;}
	public boolean isOre(Block block) { if(block.equals(Block.getBlockFromName("coal_ore")) || block.equals(Block.getBlockFromName("iron_ore")) || block.equals(Block.getBlockFromName("gold_ore")) || block.equals(Block.getBlockFromName("diamond_ore")) || block.equals(Block.getBlockFromName("emerald_ore")) || block.equals(Block.getBlockFromName("lapis_ore")) || block.equals(Block.getBlockFromName("quartz_ore"))) {return true;} return false;}
//	public boolean isHatchet(Item item) { if(item.equals(Items.BronzeHatchet) || item.equals(Items.IronHatchet) || item.equals(Items.SteelHatchet) || item.equals(Items.BlackHatchet) || item.equals(Items.MithrilHatchet) || item.equals(Items.AdamantHatchet) || item.equals(Items.RuneHatchet) || item.equals(Items.DragonHatchet) || item.equals(Items.InfernoAdze)) {return true;} return false;}
//	public boolean isPickaxe(Item item) { if(item.equals(Items.BronzePickaxe) || item.equals(Items.IronPickaxe) || item.equals(Items.SteelPickaxe) || item.equals(Items.MithrilPickaxe) || item.equals(Items.AdamantHatchet) || item.equals(Items.RunePickaxe) || item.equals(Items.DragonPickaxe) || item.equals(Items.InfernoAdze)) {return true;} return false;}
}
