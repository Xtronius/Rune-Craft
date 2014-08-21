package mod.xtronius.rc_mod.commands;

import java.util.Timer;
import java.util.TimerTask;

import mod.xtronius.rc_mod.positions.BlockPos;
import mod.xtronius.rc_mod.positions.PlayerPos;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntityCommandBlock;

public class Tutorial extends RCBaseCommand implements IRCBaseCommand{

	public static boolean isOn =  false;
	public static boolean isOn2 =  false;
	
	@Override
	public String getCommandName() {
		return "tutorial";
	}
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "Tutorial";
	}
	
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (icommandsender instanceof EntityPlayer) {
			ProcessPlayer(getCommandSenderAsPlayer(icommandsender), astring);
		} else if (icommandsender instanceof TileEntityCommandBlock) {
			ProcessCommandBlock((TileEntityCommandBlock) icommandsender, astring);
		} else {
			ProcessServerConsole(icommandsender, astring);
		}
	}
	
	public void ProcessPlayer(EntityPlayerMP player, String[] params) {
		 Timer timer = new Timer("Temp");
		 MyTask t = new MyTask();
		 timer.schedule(t, 0, 250);
			//this.setPositionAndRotationAndUpdate(player, player.posX, player.posY, player.posZ, (player.rotationYaw + i), (player.rotationPitch + i));
		}

	@Override
	public void ProcessCommandBlock(TileEntityCommandBlock commandBlock, String[] params) {
	}

	@Override
	public void ProcessServerConsole(ICommandSender console, String[] params) {	
	}

	public void setPositionAndRotationAndUpdate(EntityPlayerMP player, double x, double y, double z, float yaw, float pitch)
    {
		player.playerNetServerHandler.setPlayerLocation(x, y, z, yaw, pitch);
    }
	public void update(EntityPlayerMP player) {
			this.setPositionAndRotationAndUpdate(player, player.posX + player.motionX, player.posY + 0.25F, player.posZ + player.motionZ, (player.rotationYaw + 0.01F), (player.rotationPitch + 0.01F));
	}
	
}

class MyTask extends TimerTask {
	
    private int times = 0;
    private Tutorial tutorial;
 
    public void run() {
        times++;
        if (times <= 30) {
            System.out.println("I'm alive...");
            tutorial.isOn = true;
        } else {
            System.out.println("Timer stops now...");
            tutorial.isOn = false;
            this.cancel();
        }
    }
}
