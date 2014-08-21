package mod.xtronius.rc_mod.positions;

public class EntityPos {

	private static double x;
	private static double y;
	private static double z;
	
	public EntityPos() {}
	
	public EntityPos(double x, double y, double z) {
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
