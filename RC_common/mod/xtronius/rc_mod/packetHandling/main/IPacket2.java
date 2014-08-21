package mod.xtronius.rc_mod.packetHandling.main;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

public interface IPacket2 {
    public void readBytes(PacketBuffer bytes) throws IOException;
    public void writeBytes(PacketBuffer bytes) throws IOException;
    public void executeClient(EntityPlayer player);
    public void executeServer(EntityPlayer player);
}