package mod.xtronius.rc_mod.packetHandling.main;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public interface IPacket {
    public void readBytes(ByteBuf bytes) throws IOException;
    public void writeBytes(ByteBuf bytes) throws IOException;
    public void executeClient(EntityPlayer player);
    public void executeServer(EntityPlayer player);
}