package mod.xtronius.rc_mod.proxy;

import java.util.HashMap;

import mod.xtronius.rc_mod.util.KeyBindings;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	
	private static final HashMap<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void registerRenderInformation() {}

	public void initSounds() {}
	
	public void initKeyBindings() {}
	
	public static void storeEntityData(String name, NBTTagCompound compound) { extendedEntityData.put(name, compound); }

	public static NBTTagCompound getEntityData(String name) { return extendedEntityData.remove(name); }
}
