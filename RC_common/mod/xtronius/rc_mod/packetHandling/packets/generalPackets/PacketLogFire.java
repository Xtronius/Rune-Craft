package mod.xtronius.rc_mod.packetHandling.packets.generalPackets;

import java.io.IOException;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.handlers.BlockBreakHandler;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.ChannelHandler;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import mod.xtronius.rc_mod.packetHandling.main.IPacket2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.ByteBuf;

public class PacketLogFire  implements IPacket{
	
    boolean isLit;
    int x;
    int y;
    int z;
    
    public PacketLogFire(){}
    
    public PacketLogFire(boolean isLit, int x, int y, int z) {
        this.isLit = isLit;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void readBytes(ByteBuf bytes) throws IOException{
    	this.isLit = bytes.readBoolean();
    	this.x = bytes.readInt();
    	this.y = bytes.readInt();
    	this.z = bytes.readInt();
    }

    public void writeBytes(ByteBuf bytes) throws IOException{
        bytes.writeBoolean(isLit);
        bytes.writeInt(x);
        bytes.writeInt(y);
        bytes.writeInt(z);
    }

	@Override
	public void executeClient(EntityPlayer player) {
		rc_mod.isLit.put(player.worldObj.getTileEntity(x, y, z), isLit);
	}

	@Override
	public void executeServer(EntityPlayer player) {
		
	}
}
