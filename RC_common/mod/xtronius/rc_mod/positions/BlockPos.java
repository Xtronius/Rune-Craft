package mod.xtronius.rc_mod.positions;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;

public class BlockPos {
	
	private static HashMap<EntityPlayer, BlockPos> blockPos = new HashMap<EntityPlayer, BlockPos>();

	private static int x;
	private static int y;
	private static int z;
	
	public BlockPos() {}
	
	public BlockPos(EntityPlayer player, int x, int y, int z) {
		
		BlockPos.reg(player, this);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
	
	public static BlockPos get(EntityPlayer player) {
		return BlockPos.blockPos.get(player);
	}
	public static void reg(EntityPlayer player, BlockPos blockPos) {
		BlockPos.blockPos.put(player, blockPos);
	}
}
