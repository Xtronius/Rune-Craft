//package mod.xtronius.rc_mod.commands;
//
//import mod.xtronius.rc_mod.lib.PlayerXPValue;
//import net.minecraft.command.CommandBase;
//import net.minecraft.command.ICommandSender;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.tileentity.TileEntityCommandBlock;
//
//public class ResetLvlNBT extends RCBaseCommand{
//
//	@Override
//	public String getCommandName()
//	{
//		return "resetLvlNBT";
//	}
//	
//	@Override
//	public String getCommandUsage(ICommandSender icommandsender)
//	{
//		return "Resets The Player's Lvl NBT to 1";
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
//	public void ProcessPlayer(EntityPlayer player, String[] params) {
//		player.addChatMessage("Level NBT Has Been Reset");
//		for(int i = 0; i < PlayerXPValue.SkillsStr.length; i++) {
//			player.getEntityData().setInteger(PlayerXPValue.SkillsStr[i] + "Lvl", 1);
//			player.getEntityData().setDouble(PlayerXPValue.SkillsStr[i] + "Exp", 0);
//			player.getEntityData().setDouble(PlayerXPValue.SkillsStr[i] + "ExpUntilNextLvl", 83);
//		}
//	}
//	
//	@Override
//	public void ProcessCommandBlock(TileEntityCommandBlock commandBlock, String[] params) {
//		
//	}
//	
//	@Override
//	public void ProcessServerConsole(ICommandSender console, String[] params) {
//		
//	}
//}