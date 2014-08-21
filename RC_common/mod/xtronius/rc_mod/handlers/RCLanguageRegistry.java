package mod.xtronius.rc_mod.handlers;

import net.minecraft.item.ItemStack;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.items.Items;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RCLanguageRegistry {
	
	public static void LanguageReg()
	{
	
		LanguageRegistry.addName(Items.BronzeHatchet, "Bronze Hatchet");
		LanguageRegistry.addName(Items.IronHatchet, "Iron Hatchet");
		LanguageRegistry.addName(Items.SteelHatchet, "Steel Hatchet");
		LanguageRegistry.addName(Items.BlackHatchet, "Black Hatchet");
		LanguageRegistry.addName(Items.MithrilHatchet, "Mithril Hatchet");
		LanguageRegistry.addName(Items.AdamantHatchet, "Adamant Hatchet");
		LanguageRegistry.addName(Items.RuneHatchet, "Rune Hatchet");
		LanguageRegistry.addName(Items.DragonHatchet, "Dragon Hatchet");
		LanguageRegistry.addName(Items.InfernoAdze, "Inferno Adze");
		
		LanguageRegistry.addName(Items.BronzePickaxe, "Bronze Pickaxe");
		LanguageRegistry.addName(Items.IronPickaxe, "Iron Pickaxe");
		LanguageRegistry.addName(Items.SteelPickaxe, "Steel Pickaxe");
		LanguageRegistry.addName(Items.MithrilPickaxe, "Mithril Pickaxe");
		LanguageRegistry.addName(Items.AdamantPickaxe, "Adamant Pickaxe");
		LanguageRegistry.addName(Items.AdamantPickaxe, "Adamant Pickaxe");
		LanguageRegistry.addName(Items.RunePickaxe, "Rune Pickaxe");
		LanguageRegistry.addName(Items.DragonPickaxe, "Dragon Pickaxe");
		
//	LanguageRegistry.addName(Metals.blockTungstenCarbide, "Block of Tungsten Carbide");
//  LanguageRegistry.instance().addStringLocalization("itemGroup.bc_mod.metals", "en_US", "BC_Mod Metals");
//  LanguageRegistry.instance().addStringLocalization("container.BCfurnace", "Battle Craft Furnace 1");
//  LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 0), "White Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 1), "Orange Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 2), "Magenta Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 3), "Light Blue Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 4), "Yellow Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 5), "Lime Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 6), "Pink Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 7), "Gray Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 8), "Light Gray Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 9), "Cyan Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 10), "Purple Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 11), "Blue Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 12), "Brown Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 13), "Green Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 14), "Red Metal Post");
//	LanguageRegistry.addName(new ItemStack(Misc.FenceIron, 1, 15), "Black Metal Post");
		
		LanguageRegistry.addName(new ItemStack(Blocks.Wood2, 1, 0), "Willow Log");
		LanguageRegistry.addName(new ItemStack(Blocks.Wood2, 1, 1), "Maple Log");
		LanguageRegistry.addName(new ItemStack(Blocks.Wood2, 1, 2), "Mahogany Log");
		LanguageRegistry.addName(new ItemStack(Blocks.Wood2, 1, 3), "Magic Log");
	}
}
