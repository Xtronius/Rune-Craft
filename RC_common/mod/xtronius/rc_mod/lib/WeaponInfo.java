package mod.xtronius.rc_mod.lib;

import java.util.HashMap;

import mod.xtronius.rc_mod.handlers.LevelManager;
import mod.xtronius.rc_mod.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class WeaponInfo {
	
	public static HashMap<Item, Integer> weaponLvl = new HashMap<Item, Integer>();
	public static HashMap<Item, Float> weaponDamage = new HashMap<Item, Float>();
	
	public WeaponInfo() {
		
		weaponLvl.put(Items.BronzeSword, 1);
		weaponLvl.put(Items.IronSword, 1);
		weaponLvl.put(Items.BlackSword, 6);
		weaponLvl.put(Items.SteelSword, 6);
		weaponLvl.put(Items.MithrilSword, 21);
		weaponLvl.put(Items.AdamantSword, 31);
		weaponLvl.put(Items.RuneSword, 41);
		weaponLvl.put(Items.DragonSword, 61);
		
		weaponDamage.put(Items.BronzeSword, 61F);
		weaponDamage.put(Items.IronSword, 122F);
		weaponDamage.put(Items.BlackSword, 306F);
		weaponDamage.put(Items.SteelSword, 245F);
		weaponDamage.put(Items.MithrilSword, 367F);
		weaponDamage.put(Items.AdamantSword, 490F);
		weaponDamage.put(Items.RuneSword, 612F);
		weaponDamage.put(Items.DragonSword, 735F);
		
	}
}

