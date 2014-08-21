package mod.xtronius.rc_mod.positions;

public class PlayerPos {

	private static double x;
	private static double y;
	private static double z;
	
	public PlayerPos() {}
	
	public PlayerPos(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
}
