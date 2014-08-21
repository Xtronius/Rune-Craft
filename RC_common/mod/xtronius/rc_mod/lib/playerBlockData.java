package mod.xtronius.rc_mod.lib;

public class playerBlockData {

	private int lvl;
	private float toolSpeed;
	private float blockHardness;

	public playerBlockData(int lvl, float toolSpeed, float blockHardness) {
		this.setLvl(lvl);
		this.setToolSpeed(toolSpeed);
		this.setBlockHardness(blockHardness);
	}
	
	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public float getToolSpeed() {
		return toolSpeed;
	}

	public void setToolSpeed(float toolSpeed) {
		this.toolSpeed = toolSpeed;
	}

	public float getBlockHardness() {
		return blockHardness;
	}

	public void setBlockHardness(float blockHardness) {
		this.blockHardness = blockHardness;
	}
}
