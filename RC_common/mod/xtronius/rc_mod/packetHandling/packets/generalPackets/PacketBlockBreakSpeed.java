package mod.xtronius.rc_mod.packetHandling.packets.generalPackets;

import mod.xtronius.rc_mod.handlers.BlockBreakHandler;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;

public class PacketBlockBreakSpeed  implements IPacket{
	
    float breakSpeed;
    
    public PacketBlockBreakSpeed(){}
    
    public PacketBlockBreakSpeed(float breakSpeed) {
        this.breakSpeed = breakSpeed;
    }

    public void readBytes(ByteBuf bytes) {
    	breakSpeed = bytes.readFloat();
    }

    public void writeBytes(ByteBuf bytes){
        bytes.writeFloat(breakSpeed);
    }

	@Override
	public void executeClient(EntityPlayer player) {
		BlockBreakHandler.breakSpeedMap.put(player, this.breakSpeed);
	}

	@Override
	public void executeServer(EntityPlayer player) {
		
	}
}
