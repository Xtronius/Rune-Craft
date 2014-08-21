package mod.xtronius.rc_mod.packetHandling.packets.lvlInfo;

import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;

public class PacketStrengthLvl  implements IPacket{
	
    int i;
    
    public PacketStrengthLvl(){}
    
    public PacketStrengthLvl(int i) {
        this.i = i;
    }

    public void readBytes(ByteBuf bytes) {
        i = bytes.readInt();

//        System.out.println("Recieved packet with the int i = " + i);
    }

    public void writeBytes(ByteBuf bytes){
        bytes.writeInt(i);
    }

	@Override
	public void executeClient(EntityPlayer player) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		if(props != null)
			ExtendedPlayer.get(player).setLvl("Strength", i);
	}

	@Override
	public void executeServer(EntityPlayer player) {
		
	}
}
