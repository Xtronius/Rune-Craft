package mod.xtronius.rc_mod.packetHandling.packets.generalPackets;

import mod.xtronius.rc_mod.container.BankContainer;
import mod.xtronius.rc_mod.handlers.BlockBreakHandler;
import mod.xtronius.rc_mod.handlers.RCTickHandler;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import mod.xtronius.rc_mod.util.enumClasses.MeleCombatStyles;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;

public class PacketBankScroll  implements IPacket{
	
	int scrollIndex;
    
    public PacketBankScroll(){}
    
    public PacketBankScroll(int scrollIndex) {
        this.scrollIndex = scrollIndex;
    }

    public void readBytes(ByteBuf bytes) {
    	scrollIndex = bytes.readInt();
    }

    public void writeBytes(ByteBuf bytes){
        bytes.writeInt(scrollIndex);
    }

	@Override
	public void executeClient(EntityPlayer player) {}

	@Override
	public void executeServer(EntityPlayer player) {
		RCTickHandler tickHandler = RCTickHandler.intance;
		BankContainer bank = tickHandler.BankContainerMapSERVER.get(player);
		if(bank != null) {
			bank.invBank.setCurrentTopRow(scrollIndex);
			bank.invBank.onInventoryChanged();
//			System.out.println("Recieved Packet For Gui Bank Scroll with the following digits beigh transfered: " + scrollIndex);
		} else {
			System.out.println("null");
		}
	}
}
