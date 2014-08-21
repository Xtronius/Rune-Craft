//package mod.xtronius.rc_mod.commands;
//
//import mod.xtronius.rc_mod.lib.PlayerXPValue;
//import net.minecraft.command.CommandBase;
//import net.minecraft.command.ICommandSender;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.tileentity.TileEntityCommandBlock;
//
//public class SetLvl extends RCBaseCommand implements IRCBaseCommand{
//
//	@Override
//	public String getCommandName()
//	{
//	return "setLvl";
//	}
//	
//	@Override
//	public String getCommandUsage(ICommandSender icommandsender)
//	{
//	return "Resets The Player's Lvl NBT to 1";
//	}
//	
//	@Override
//	public void processCommand(ICommandSender icommandsender, String[] astring)
//	{
//		if (icommandsender instanceof EntityPlayer) {
//			ProcessPlayer((EntityPlayer) icommandsender, astring);
//		} else if (icommandsender instanceof TileEntityCommandBlock) {
//			processCommand((TileEntityCommandBlock) icommandsender, astring);
//		} else {
//			ProcessServerConsole(icommandsender, astring);
//		}
//	}
//
//	@Override
//	public void ProcessPlayer(EntityPlayer player, String[] params) { String LvlName;
//	System.out.println(params.length);
//		if (params.length > 0) {
//			for (int j = 0; j < PlayerXPValue.SkillsNoSpaceStr.length; j++) {
//				if (params[0].equals(PlayerXPValue.SkillsNoSpaceStr[j])) {
//					if (Integer.valueOf(params[1]) >= 1 && Integer.valueOf(params[1]) <= 99) {
//						player.getEntityData().setInteger( PlayerXPValue.SkillsStr[j] + "Lvl", Integer.valueOf(params[1]));
//						player.addChatMessage(PlayerXPValue.SkillsStr[j] + " has been set to " + Integer.valueOf(params[1]));
//						break;
//					}
//				}
//			}
//		}
//	}
//
//	@Override
//	public void ProcessCommandBlock(TileEntityCommandBlock commandBlock,
//			String[] params) {
//
//	}
//
//	@Override
//	public void ProcessServerConsole(ICommandSender console, String[] params) {
//
//	}
//}
