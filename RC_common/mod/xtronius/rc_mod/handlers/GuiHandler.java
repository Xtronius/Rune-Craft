package mod.xtronius.rc_mod.handlers;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.Misc.IDs.MiscIDs;
import mod.xtronius.rc_mod.container.BankContainer;
import mod.xtronius.rc_mod.container.Furnace1Container;
import mod.xtronius.rc_mod.gui.inv.GuiBank;
import mod.xtronius.rc_mod.gui.inv.GuiFurnace1;
import mod.xtronius.rc_mod.inventory.InvFurnace1;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	private RCTickHandler tickHandler = RCTickHandler.intance;
	
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
	
		switch(id) {
			case MiscIDs.Furnace1GuiID:
				if(player != null){
					if(player instanceof EntityPlayer){
						if(tickHandler.furnace1ContainerMapSERVER.get(player) != null) {
							tickHandler.furnace1ContainerMapSERVER.get(player).isClosed = false;
							tickHandler.furnace1ContainerMapSERVER.get(player).counter = 0;
							return tickHandler.furnace1ContainerMapSERVER.get(player);
						} else {
							Furnace1Container container = new Furnace1Container(player.inventory, world, x, y, z);
							tickHandler.furnace1ContainerMapSERVER.put(player, container);
							return container;
						}
					}
				}; break;
			case MiscIDs.BankGuiID:
				if(player != null){
					if(player instanceof EntityPlayer){
						if(tickHandler.BankContainerMapSERVER.get(player) != null) {
							return tickHandler.BankContainerMapSERVER.get(player);
						} else {
							BankContainer container = new BankContainer(player.inventory, world, x, y, z);
							tickHandler.BankContainerMapSERVER.put(player, container);
							return container;
						}
					}
				}; break;
		}
		return null;
	}
	
	
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
	
		switch(id) {
			case MiscIDs.Furnace1GuiID:
				if(player != null){
					if(player instanceof EntityPlayer){
						if(tickHandler.furnace1GuiMapCLIENT.get(player) != null) {
							return tickHandler.furnace1GuiMapCLIENT.get(player);
						} else {
							GuiFurnace1 gui = new GuiFurnace1(player.inventory, world, x, y, z);
							tickHandler.furnace1GuiMapCLIENT.put(player, gui);
							return gui;
						}
					}
				}; break;
			case MiscIDs.BankGuiID:
				if(player != null){
					if(player instanceof EntityPlayer){
						if(tickHandler.BankGuiMapCLIENT.get(player) != null) {
							return tickHandler.BankGuiMapCLIENT.get(player);
						} else {
							GuiBank gui = new GuiBank(player.inventory, world, x, y, z);
							tickHandler.BankGuiMapCLIENT.put(player, gui);
							return gui;
						}
					}
				}
		}
		return null;
	}
}