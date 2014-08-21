package mod.xtronius.rc_mod.handlers;

import mod.xtronius.rc_mod.items.Items;
import cpw.mods.fml.common.registry.GameRegistry;

public class RCItemRegistry {
	
	public static void ItemReg() {	
		//GameRegistry.registerBlock(Blocks.BlockWoodBuffer, "BlockWoodBuffer");
		GameRegistry.registerItem(Items.BronzeHatchet, "BronzeHatchet");
		GameRegistry.registerItem(Items.IronHatchet, "IronHatchet");
		GameRegistry.registerItem(Items.BlackHatchet, "BlackHatchet");
		GameRegistry.registerItem(Items.SteelHatchet, "SteelHatchet");
		GameRegistry.registerItem(Items.MithrilHatchet, "MithrilHatchet");
		GameRegistry.registerItem(Items.AdamantHatchet, "AdamantHatchet");
		GameRegistry.registerItem(Items.RuneHatchet, "RuneHatchet");
		GameRegistry.registerItem(Items.DragonHatchet, "DragonHatchet");
		
		GameRegistry.registerItem(Items.BronzePickaxe, "BronzePickaxe");
		GameRegistry.registerItem(Items.IronPickaxe, "IronPickaxe");
		GameRegistry.registerItem(Items.SteelPickaxe, "SteelPickaxe");
		GameRegistry.registerItem(Items.MithrilPickaxe, "MithrilPickaxe");
		GameRegistry.registerItem(Items.AdamantPickaxe, "AdamantPickaxe");
		GameRegistry.registerItem(Items.RunePickaxe, "RunePickaxe");
		GameRegistry.registerItem(Items.DragonPickaxe, "DragonPickaxe");
		
		GameRegistry.registerItem(Items.InfernoAdze, "InfernoAdze");
		
		GameRegistry.registerItem(Items.BronzeSword, "BronzeSword");
		GameRegistry.registerItem(Items.IronSword, "IronSword");
		GameRegistry.registerItem(Items.BlackSword, "BlackSword");
		GameRegistry.registerItem(Items.SteelSword, "SteelSword");
		GameRegistry.registerItem(Items.MithrilSword, "MithrilSword");
		GameRegistry.registerItem(Items.AdamantSword, "AdamantSword");
		GameRegistry.registerItem(Items.RuneSword, "RuneSword");
		GameRegistry.registerItem(Items.DragonSword, "DragonSword");
		
		GameRegistry.registerItem(Items.Logs, "Logs");
		GameRegistry.registerItem(Items.YewLogs, "YewLogs");
		GameRegistry.registerItem(Items.OakLogs, "OakLogs");
		GameRegistry.registerItem(Items.TeakLogs, "TeakLogs");
		GameRegistry.registerItem(Items.WillowLogs, "WillowLogs");
		GameRegistry.registerItem(Items.MapleLogs, "MapleLogs");
		GameRegistry.registerItem(Items.MahoganyLogs, "MahoganyLogs");
		GameRegistry.registerItem(Items.MagicLogs, "MagicLogs");
	}
}
