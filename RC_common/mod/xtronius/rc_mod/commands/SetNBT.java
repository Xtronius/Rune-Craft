package mod.xtronius.rc_mod.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.Location;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class SetNBT extends RCBaseCommand implements IRCBaseCommand{

	@Override
	public String getCommandName()
	{
		return "setNBT";
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "Sets the NBT value of a tag, string, integer, float, double, byte, name, short, ect.";
	}
	
	public int getRequiredPermissionLevel()
    {
        return 2;
    }
	
	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (icommandsender instanceof EntityPlayer) {
			ProcessPlayer((EntityPlayer) icommandsender, astring);
		} else if (icommandsender instanceof TileEntityCommandBlock) {
			ProcessCommandBlock((TileEntityCommandBlock) icommandsender, astring);
		} else {
			ProcessServerConsole(icommandsender, astring);
		}
	}

	@Override
	public void ProcessPlayer(EntityPlayer player, String[] params) { 
		String LvlName;
		World world = player.worldObj;
	
		System.out.println(params.length);
		if (params.length > 3) {
			if (params[0].equalsIgnoreCase("Me") && params.length == 4) {
				if (!params[0].equals(null) && !params[1].equals(null) && !params[2].equals(null) && !params[3].equals(null)) {
					if (params[1].equalsIgnoreCase("Int") || params[1].equalsIgnoreCase("Integer") || params[1].equalsIgnoreCase("Float") || params[1].equalsIgnoreCase("Double") || params[1].equalsIgnoreCase("Byte") || params[1].equalsIgnoreCase("String") || params[1].equalsIgnoreCase("Boolean") || params[1].equalsIgnoreCase("Short") || params[1].equalsIgnoreCase("Name") || params[1].equals("Long"))
						if (player.getEntityData().hasKey(params[2])) {
							setNBT(player, null, params[2], params[3], params[1], 0);
							return;
						} else {throwWrongUsage(player); return;}
				} else {throwWrongUsage(player); return;}
			}
		if (params[0].equalsIgnoreCase("Player") && params.length == 5) {
				if (!params[0].equals(null) && !params[1].equals(null) && !params[2].equals(null) && !params[3].equals(null) && !params[4].equals(null)) {
						EntityPlayerMP entityPlayer = (EntityPlayerMP) player.worldObj.getPlayerEntityByName(params[4]);

			if (params[1].equalsIgnoreCase("Int") || params[1].equalsIgnoreCase("Integer") || params[1].equalsIgnoreCase("Float") || params[1].equalsIgnoreCase("Double") || params[1].equalsIgnoreCase("Byte") || params[1].equalsIgnoreCase("String") || params[1].equalsIgnoreCase("Boolean") || params[1].equalsIgnoreCase("Short") || params[1].equalsIgnoreCase("Name") || params[1].equals("Long"))
				if (entityPlayer != null) {
					if(entityPlayer.getEntityData().hasKey(params[2])) {
					setNBT(player, entityPlayer, params[2], params[3], params[1], 1);
					return;
					} else {throwKeyDoesNotExist(player); return;}
				}  else {throwPlayerDoesNotExist(player); return;}
			} else {throwWrongUsage(player); return;}
		}
		if (params[0].equalsIgnoreCase("Entity")) {
			
			System.out.println(getEntity(world, player));
			if (!params[0].equals(null) && !params[1].equals(null) && !params[2].equals(null) && !params[3].equals(null) && !params[4].equals(null)) {
				return;
			} else {throwWrongUsage(player); return;}
		} else {throwWrongUsage(player); return;}
		} else {throwWrongUsage(player); return;}
	}

	@Override
	public void ProcessCommandBlock(TileEntityCommandBlock commandBlock, String[] params) {
		
	}

	@Override
	public void ProcessServerConsole(ICommandSender console, String[] params) {
		
	}
	
	public void setNBT(EntityPlayer player, EntityPlayerMP playerMP, String nbtName, String value, String type, int mode) {
		if(mode == 0) {
			if(type.equalsIgnoreCase("Int") || type.equalsIgnoreCase("Integer")) {
				player.getEntityData().setInteger(  nbtName, Integer.valueOf(value));
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Float")) {
				player.getEntityData().setFloat(  nbtName, Float.valueOf(value));
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Double")) {
				player.getEntityData().setDouble(  nbtName, Double.valueOf(value));
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Byte")) {
				player.getEntityData().setByte(  nbtName, Byte.valueOf(value));
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("String")) {
				player.getEntityData().setString(  nbtName, value);
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Boolean")) {
				player.getEntityData().setBoolean(  nbtName, Boolean.valueOf(value));
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Short")) {
				player.getEntityData().setBoolean(  nbtName, Boolean.valueOf(value));
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Name")) {
				player.getEntityData().setBoolean(  nbtName, Boolean.valueOf(value));
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Long")) {
				player.getEntityData().setBoolean(  nbtName, Boolean.valueOf(value));
				player.addChatMessage(new ChatComponentText(nbtName + "(" + type +")" + " has been set to " + value));
			}
		} else if( mode == 1) {
			
			if(type.equalsIgnoreCase("Int") || type.equalsIgnoreCase("Integer")) {
				playerMP.getEntityData().setInteger(  nbtName, Integer.valueOf(value));
				player.addChatMessage(new ChatComponentText("Your " + nbtName + "(" + type +")" + " has been set to " + value));
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Float")) {
				playerMP.getEntityData().setFloat(  nbtName, Float.valueOf(value));
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Double")) {
				playerMP.getEntityData().setDouble(  nbtName, Double.valueOf(value));
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Byte")) {
				playerMP.getEntityData().setByte(  nbtName, Byte.valueOf(value));
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("String")) {
				playerMP.getEntityData().setString(  nbtName, value);
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Boolean")) {
				playerMP.getEntityData().setBoolean(  nbtName, Boolean.valueOf(value));
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Short")) {
				playerMP.getEntityData().setBoolean(  nbtName, Boolean.valueOf(value));
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Name")) {
				playerMP.getEntityData().setBoolean(  nbtName, Boolean.valueOf(value));
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
			else if(type.equalsIgnoreCase("Long")) {
				playerMP.getEntityData().setBoolean(  nbtName, Boolean.valueOf(value));
				player.addChatMessage(new ChatComponentText(playerMP.getDisplayName() + "'s " + nbtName + "(" + type +")" + " has been set to " + value));
			}
		}
	}
	
	public void throwWrongUsage(EntityPlayer player) {
		
		player.addChatMessage(new ChatComponentText("\u00a74[Rune-Craft] Command Template: /setNBT <Target Type> <Variable Type> <NBT Variable Name> <Variable Value> <Target>"));
		player.addChatMessage(new ChatComponentText("\u00a74[Rune-Craft] Usage 1: /setNBT <Me> <Variable Type> <NBT Variable Name> <Variable Value> <Target>"));
		player.addChatMessage(new ChatComponentText("\u00a74[Rune-Craft] Usage 2: /setNBT <Player> <Variable Type> <NBT Variable Name> <Variable Value> <Target Player>"));
		player.addChatMessage(new ChatComponentText("\u00a74[Rune-Craft] Usage3 : /setNBT <Entity> <Variable Type> <NBT Variable Name> <Variable Value> <Target Entity>"));
	}
	
	public void throwKeyDoesNotExist(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a74[Rune-Craft] That Key Does Not Exist"));
	}
	
	public void throwPlayerDoesNotExist(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a74[Rune-Craft] That Player Does Not Exist"));
	}
	
	private Entity getEntity(World world, EntityPlayer player) {
		List<Entity> found = new ArrayList<Entity>();

		for (Entity entity : getTotalEntities(world)) {
			if (isInBorder(player.posX, player.posY, player.posZ, entity.posX, entity.posY, entity.posZ, 1, 1, 1) && !(entity instanceof EntityPlayerMP)) {
	
				found.add(entity);
				System.out.println("true");
				return entity;
			}
		}
		return null;
	}
	
	public List<Entity> getTotalEntities(World world) {
		return world.loadedEntityList;
	}
	
	public static boolean isInBorder(double playerX, double playerY, double playerZ, double entityX, double entityY, double entityZ, int rangeX, int rangeY, int rangeZ) {
			if((Math.max(Math.abs(playerX), Math.abs(entityX))) - Math.min(Math.abs(playerX), Math.abs(entityX)) <= rangeX) {
				if((Math.max(Math.abs(playerY), Math.abs(entityY))) - Math.min(Math.abs(playerY), Math.abs(entityY)) <= rangeY) {
					if((Math.max(Math.abs(playerZ), Math.abs(entityZ))) - Math.min(Math.abs(playerZ), Math.abs(entityZ)) <= rangeZ) {
						return true;
					} else return false;
				} else return false;
			} 
			return false;
	}
}
