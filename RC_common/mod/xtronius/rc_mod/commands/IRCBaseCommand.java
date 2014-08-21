package mod.xtronius.rc_mod.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityCommandBlock;

public interface IRCBaseCommand {
	
	public void ProcessPlayer(EntityPlayer player, String[] params);
	public void ProcessCommandBlock(TileEntityCommandBlock commandBlock, String[] params);
	public void ProcessServerConsole(ICommandSender console, String[] params);

}
