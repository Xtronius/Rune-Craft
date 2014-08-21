package mod.xtronius.rc_mod.lib;

import java.util.HashMap;

import mod.xtronius.rc_mod.positions.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class BlockBreakActionInfo {

	private static HashMap<EntityPlayer, BlockBreakActionInfo> info = new HashMap<EntityPlayer, BlockBreakActionInfo>();
	
	public EntityPlayer player;
	
	private static int Lvl;
	private static float toolSpeed;
	private static Item tool;
	private static float breakSpeed;
	private static float blockHardness;
	private static int toolLvl;

	public BlockBreakActionInfo(EntityPlayer player) {
		BlockBreakActionInfo.reg(player, this);
		this.player = player;
	}
	
	public static BlockBreakActionInfo get(EntityPlayer player) {
		return BlockBreakActionInfo.info.get(player);
	}
	public static void reg(EntityPlayer player, BlockBreakActionInfo info) {
		BlockBreakActionInfo.info.put(player, info);
	}
	
	public static int getLvl() {
		return Lvl;
	}

	public static void setLvl(int lvl) {
		Lvl = lvl;
	}

	public static float getToolSpeed() {
		return toolSpeed;
	}

	public static void setToolSpeed(float toolSpeed) {
		BlockBreakActionInfo.toolSpeed = toolSpeed;
	}

	public static Item getTool() {
		return tool;
	}
	
	public static int getToolLvl() {
		return toolLvl;
	}

	public static void setTool(Item tool) {
		BlockBreakActionInfo.tool = tool;
	}

	public static float getBreakSpeed() {
		return breakSpeed;
	}

	public static void setBreakSpeed(float breakSpeed) {
		BlockBreakActionInfo.breakSpeed = breakSpeed;
	}

	public static float getBlockHardness() {
		return blockHardness;
	}

	public static void setBlockHardness(float blockHardness) {
		BlockBreakActionInfo.blockHardness = blockHardness;
	}
	
	public static void setToolLvl(int toolLvl) {
		BlockBreakActionInfo.toolLvl = toolLvl;
	}
}
