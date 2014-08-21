package mod.xtronius.rc_mod.packetHandling.packets.generalPackets;

import mod.xtronius.rc_mod.handlers.BlockBreakHandler;
import mod.xtronius.rc_mod.handlers.RCTickHandler;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import mod.xtronius.rc_mod.util.enumClasses.MeleCombatStyles;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;

public class PacketBankTab  implements IPacket{
	
	int tabIndex;
    
    public PacketBankTab(){}
    
    public PacketBankTab(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public void readBytes(ByteBuf bytes) {
    	tabIndex = bytes.readInt();
    	System.out.println(tabIndex);
    }

    public void writeBytes(ByteBuf bytes){
        bytes.writeInt(tabIndex);
    }

	@Override
	public void executeClient(EntityPlayer player) {}

	@Override
	public void executeServer(EntityPlayer player) {
		RCTickHandler tickHandler = RCTickHandler.intance;
		if(tickHandler.BankContainerMapSERVER.get(player) != null) {
			tickHandler.BankContainerMapSERVER.get(player).invBank.currentSelectedTab = this.tabIndex;
		}
	}
}
