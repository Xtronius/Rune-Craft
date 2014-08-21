package mod.xtronius.rc_mod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityCommandBlock;

public class RCBaseCommand extends CommandBase implements IRCBaseCommand {
	
	@Override
	public String getCommandName() {
		return null;
	}
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return null;
	}
	
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (icommandsender instanceof EntityPlayer) {
			ProcessPlayer((EntityPlayer) icommandsender, astring);
		} else if (icommandsender instanceof TileEntityCommandBlock) {
			ProcessCommandBlock((TileEntityCommandBlock) icommandsender, astring);
		} else {
			ProcessServerConsole(icommandsender, astring);
		}
	}
	public void ProcessPlayer(EntityPlayer player, String[] params) {
		
	}
	public void ProcessCommandBlock(TileEntityCommandBlock commandBlock, String[] params) {
		
	}
	public void ProcessServerConsole(ICommandSender console, String[] params) {
		
	}
}
