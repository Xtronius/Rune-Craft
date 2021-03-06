package mod.xtronius.rc_mod.packetHandling.packets.lvlInfo;

import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;

public class PacketWoodCuttingLvl  implements IPacket{
	
    int i;
    
    public PacketWoodCuttingLvl(){}
    
    public PacketWoodCuttingLvl(int i) {
        this.i = i;
    }

    public void readBytes(ByteBuf bytes) {
        i = bytes.readInt();
    }

    public void writeBytes(ByteBuf bytes){
        bytes.writeInt(i);
    }

	@Override
	public void executeClient(EntityPlayer player) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		if(props != null)
			ExtendedPlayer.get(player).setLvl("WoodCutting", i);
	}

	@Override
	public void executeServer(EntityPlayer player) {
		
	}
}
