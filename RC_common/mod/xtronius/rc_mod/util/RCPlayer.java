package mod.xtronius.rc_mod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;


public class RCPlayer {
	
	public static void messagePlayer(EntityPlayer player, String message) {
	    ChatComponentText msg = new ChatComponentText(message);
	    player.addChatMessage(msg);
	}
}
