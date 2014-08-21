package mod.xtronius.rc_mod.util;

import java.awt.List;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindings {
    
    public static ArrayList<KeyBinding> keyBindingList = new ArrayList<KeyBinding>();
    
    public static void init() {
    	
    	keyBindingList.add(new KeyBinding("key.ping", Keyboard.KEY_F, "key.gameplay.rc_mod"));

    	for(KeyBinding key : keyBindingList)
    		ClientRegistry.registerKeyBinding(key);
    }

}
