package mod.xtronius.rc_mod.packetHandling.packets.generalPackets;

import mod.xtronius.rc_mod.handlers.BlockBreakHandler;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import mod.xtronius.rc_mod.util.enumClasses.MeleCombatStyles;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;

public class PacketInitCombatStyle  implements IPacket{
	
	int style;
    
    public PacketInitCombatStyle(){}
    
    public PacketInitCombatStyle(int style) {
        this.style = style;
    }

    public void readBytes(ByteBuf bytes) {
    	style = bytes.readInt();
    }

    public void writeBytes(ByteBuf bytes){
        bytes.writeInt(style);
    }

	@Override
	public void executeClient(EntityPlayer player) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		if(style == 0) props.setMeleCombatStyle(MeleCombatStyles.ATTACK);
		else if(style == 1) props.setMeleCombatStyle(MeleCombatStyles.STRENGTH);
		else if(style == 2) props.setMeleCombatStyle(MeleCombatStyles.DEFENSE);
		else if(style == 3) props.setMeleCombatStyle(MeleCombatStyles.SHARED);
//		System.out.println("Name: " + player.getDisplayName() + " Style: " + style);
	}

	@Override
	public void executeServer(EntityPlayer player) {}
}
