package mod.xtronius.rc_mod.broken;
//package mod.xtronius.rc_mod.handlers;
//
//import java.util.EnumSet;
//import java.util.HashMap;
//
//import mod.xtronius.rc_mod.rc_mod;
//import mod.xtronius.rc_mod.commands.Tutorial;
//import mod.xtronius.rc_mod.container.Furnace1Container;
//import mod.xtronius.rc_mod.gui.inv.GuiFurnace1;
//import mod.xtronius.rc_mod.lib.ExtendedPlayer;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.item.ItemStack;
//
//public class RCTickHandler{
//	
//	public static HashMap<EntityPlayer, Furnace1Container> furnace1ContainerMapSERVER = new HashMap<EntityPlayer, Furnace1Container>();
//	public static HashMap<EntityPlayer, Furnace1Container> furnace1ContainerMapCLIENT = new HashMap<EntityPlayer, Furnace1Container>();
//	
//	public static HashMap<EntityPlayer, GuiFurnace1> furnace1GuiMapSERVER = new HashMap<EntityPlayer, GuiFurnace1>();
//	public static HashMap<EntityPlayer, GuiFurnace1> furnace1GuiMapCLIENT = new HashMap<EntityPlayer, GuiFurnace1>();
//	
//	private static HashMap<ExtendedPlayer, Short> tickCounter = new HashMap<ExtendedPlayer, Short>();
//	
//	private int lvlUpdateCounter = 0;
//	
//	private Tutorial tutorial =  new Tutorial();
//	int CD = 0;
//
////	@Override
////	public void tickStart(EnumSet<TickType> type, Object... tickData) {
////		
////		if (type.equals(EnumSet.of(TickType.PLAYER))) {
////			onEntityPlayerTick((EntityPlayer) tickData[0]);
////			onEntityPlayerMPTick((EntityPlayerMP) tickData[0]);
////		}
////	}
////
////	@Override
////	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
////	}
////
////	@Override
////	public EnumSet<TickType> ticks() {
////		
////		return EnumSet.of(TickType.PLAYER, TickType.SERVER, TickType.CLIENT);
////	}
////
////	@Override
////	public String getLabel() {
////		return null;
////	}
////	
////	private void onEntityPlayerTick(EntityPlayer player) {
////		
////		managePlayerXP(player);
////	}
////	
////	private void onEntityPlayerMPTick(EntityPlayer player) {
////		
////		tickFurnace1SERVER(player);
////		updateLvls(player);
//////		if(tutorial.isOn == true) {
//////			tutorial.update(player);
//////		}
////	}
////	
////	private void updateLvls(EntityPlayer player) {
////		 
////		if(lvlUpdateCounter <= 60)
////			 lvlUpdateCounter++;
////		
////		 if(lvlUpdateCounter == 60) {
////			 for(int i = 0; i < ExtendedPlayer.SkillsNoSpaceStr.length; i++) {
////			 	this.packetHandler.sendGenericLvlPacket(player, ExtendedPlayer.SkillsNoSpaceStr[i]);
////			 	this.packetHandler.sendGenericExpPacket(player, ExtendedPlayer.SkillsNoSpaceStr[i]);
////			 	this.packetHandler.sendGenericExpUntilNextLvlPacket(player, ExtendedPlayer.SkillsNoSpaceStr[i]);
////			 }
////		 } 
////		 
////		 if(lvlUpdateCounter > 60) 
////			 lvlUpdateCounter = 0;
////	}
////	
////	
////	private void tickFurnace1SERVER(EntityPlayer player) {
////
////		if(!player.worldObj.isRemote) {
////			if(furnace1ContainerMapSERVER.get(player) != null) {
////				Furnace1Container container = furnace1ContainerMapSERVER.get(player);
////				if(container.hasValidStackInSlots() && !container.isClosed) {
////					container.update(player, "SERVER");
////				}
////				
////				if(container.isClosed && container.hasStackInSlots()) {
////					if(container.counter < 200)
////						container.counter++;
////					else {
////						for (int i = 0; i < 3; ++i) {
////							ItemStack itemstack = container.invFurnace.getStackInSlotOnClosing(i);
////				                if (itemstack != null)
////				                {
////				                	container.invFurnace.setInventorySlotContents(i, null);
////				                	player.addChatMessage("\u00a74The item(s) you have left in the furnace have been left in there too long, the item(s) have been destroyed!");
////				                }
////				            }
////						container.counter = 0;
////						container.isClosed = false;
////					}
////				}
////			}
////		}
////	}
////	
////	private void tickFurnace1CLIENT(EntityPlayer player) {
////
////		if(player.worldObj.isRemote) {
////			if(furnace1ContainerMapCLIENT.get(player) != null) {
////				Furnace1Container container = furnace1ContainerMapCLIENT.get(player);
////				if(container.hasValidStackInSlots() || container.hasBeenUpdated == false) {
////					container.update(player, "CLIENT");
////				}
////			}
////		}
////	}
////	
////	private void managePlayerXP(EntityPlayer player) {
////		
////		for(int xpT = player.experienceTotal; xpT <= 0; xpT--)
////			player.experienceTotal = xpT;
////			player.experienceLevel = 0;
////	}
//}
//
