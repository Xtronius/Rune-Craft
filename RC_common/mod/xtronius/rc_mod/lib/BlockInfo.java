package mod.xtronius.rc_mod.lib;

import java.util.HashMap;

import mod.xtronius.rc_mod.handlers.LevelManager;
import mod.xtronius.rc_mod.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BlockInfo {
	
	public static HashMap<Item, Float> toolHatchetSpeedHash = new HashMap<Item, Float>();
	public static HashMap<Item, Integer> toolHatchetLvlHash = new HashMap<Item, Integer>();
	public static HashMap<Item, Integer> toolHatchetLvlRatingHash = new HashMap<Item, Integer>();
	public static HashMap<Item, Float> toolPickaxeSpeedHash = new HashMap<Item, Float>();
	public static HashMap<Item, Integer> toolPickaxeLvlHash = new HashMap<Item, Integer>();
	public static HashMap<Item, Integer> toolPickaxeLvlRatingHash = new HashMap<Item, Integer>();
	public static HashMap<Block, Float> blockHardnessHash = new HashMap<Block, Float>();
	public static HashMap<Integer, Float> blockMetaWoodHardnessHash = new HashMap<Integer, Float>();
	public static HashMap<Integer, Float> blockMetaWood2HardnessHash = new HashMap<Integer, Float>();
	public static HashMap<Block, Integer> blockLvlHash = new HashMap<Block, Integer>();
	public static HashMap<Integer, Integer> blockMetaWoodLvlHash = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer> blockMetaWood2LvlHash = new HashMap<Integer, Integer>();
	public static HashMap<Block, Float> xpPerBlockHash = new HashMap<Block, Float>();
	public static HashMap<Integer, Float> xpPerLogHash = new HashMap<Integer, Float>();
	public static HashMap<Integer, Float> xpPerLog2Hash = new HashMap<Integer, Float>();
	public static HashMap<Block, Integer> blockReturnHarvestMetaIDHash = new HashMap<Block, Integer>();
	public static HashMap<Block, Item> blockReturnItemHash = new HashMap<Block, Item>();
	public static HashMap<Integer, Item> blockReturnItemMetaHash = new HashMap<Integer, Item>();
	public static HashMap<Integer, Item> blockReturnItemMeta2Hash = new HashMap<Integer, Item>();
	public static HashMap<Integer, Item> blockToolLvlReq = new HashMap<Integer, Item>();
	public static HashMap<Integer, Item> blockMetaToolLvlReq = new HashMap<Integer, Item>();
	public static HashMap<Integer, Item> blockMeta2ToolLvlReq = new HashMap<Integer, Item>();
	
	public BlockInfo() {
		
		
		
		toolHatchetLvlRatingHash.put(Items.BronzeHatchet, 1);
		toolHatchetLvlRatingHash.put(Items.IronHatchet, 1);
		toolHatchetLvlRatingHash.put(Items.BlackHatchet, 2);
		toolHatchetLvlRatingHash.put(Items.SteelHatchet, 2);
		toolHatchetLvlRatingHash.put(Items.MithrilHatchet, 3);
		toolHatchetLvlRatingHash.put(Items.AdamantHatchet, 4);
		toolHatchetLvlRatingHash.put(Items.RuneHatchet, 5);
		toolHatchetLvlRatingHash.put(Items.DragonHatchet, 6);
		toolHatchetLvlRatingHash.put(Items.InfernoAdze, 6);
		
		toolPickaxeLvlRatingHash.put(Items.BronzePickaxe, 1);
		toolPickaxeLvlRatingHash.put(Items.IronPickaxe, 1);
		toolPickaxeLvlRatingHash.put(Items.SteelPickaxe, 2);
		toolPickaxeLvlRatingHash.put(Items.MithrilPickaxe, 3);
		toolPickaxeLvlRatingHash.put(Items.AdamantPickaxe, 4);
		toolPickaxeLvlRatingHash.put(Items.RunePickaxe, 5);
		toolPickaxeLvlRatingHash.put(Items.DragonPickaxe, 6);
		toolPickaxeLvlRatingHash.put(Items.InfernoAdze, 6);
		
		toolHatchetSpeedHash.put(Items.BronzeHatchet, 0.2F);
		toolHatchetSpeedHash.put(Items.IronHatchet, 0.25F);
		toolHatchetSpeedHash.put(Items.BlackHatchet, 0.3F);
		toolHatchetSpeedHash.put(Items.SteelHatchet, 0.35F);
		toolHatchetSpeedHash.put(Items.MithrilHatchet, 0.4F);
		toolHatchetSpeedHash.put(Items.AdamantHatchet, 0.5F);
		toolHatchetSpeedHash.put(Items.RuneHatchet, 0.6F);
		toolHatchetSpeedHash.put(Items.DragonHatchet, 0.7F);
		toolHatchetSpeedHash.put(Items.InfernoAdze, 100F);
		
		toolPickaxeSpeedHash.put(Items.BronzePickaxe, 0.2F);
		toolPickaxeSpeedHash.put(Items.IronPickaxe, 0.25F);
		toolPickaxeSpeedHash.put(Items.SteelPickaxe, 0.35F);
		toolPickaxeSpeedHash.put(Items.MithrilPickaxe, 0.4F);
		toolPickaxeSpeedHash.put(Items.AdamantPickaxe, 0.5F);
		toolPickaxeSpeedHash.put(Items.RunePickaxe, 0.6F);
		toolPickaxeSpeedHash.put(Items.DragonPickaxe, 0.7F);
		toolPickaxeSpeedHash.put(Items.InfernoAdze, 100F);
		
		toolHatchetLvlHash.put(Items.BronzeHatchet, 1);
		toolHatchetLvlHash.put(Items.IronHatchet, 1);
		toolHatchetLvlHash.put(Items.BlackHatchet, 6);
		toolHatchetLvlHash.put(Items.SteelHatchet, 6);
		toolHatchetLvlHash.put(Items.MithrilHatchet, 21);
		toolHatchetLvlHash.put(Items.AdamantHatchet, 31);
		toolHatchetLvlHash.put(Items.RuneHatchet, 41);
		toolHatchetLvlHash.put(Items.DragonHatchet, 61);
		toolHatchetLvlHash.put(Items.InfernoAdze, 81);
		
		toolPickaxeLvlHash.put(Items.BronzePickaxe, 1);
		toolPickaxeLvlHash.put(Items.IronPickaxe, 1);
		toolPickaxeLvlHash.put(Items.SteelPickaxe, 6);
		toolPickaxeLvlHash.put(Items.MithrilPickaxe, 21);
		toolPickaxeLvlHash.put(Items.AdamantPickaxe, 31);
		toolPickaxeLvlHash.put(Items.RunePickaxe, 41);
		toolPickaxeLvlHash.put(Items.DragonPickaxe, 61);
		toolPickaxeLvlHash.put(Items.InfernoAdze, 81);
		
		blockHardnessHash.put(Block.getBlockFromName("coal_ore"), 3F);
		blockHardnessHash.put(Block.getBlockFromName("iron_ore"), 3F);
		blockHardnessHash.put(Block.getBlockFromName("gold_ore"), 0.95F);
		blockHardnessHash.put(Block.getBlockFromName("diamond_ore"), 0.75F); //Rune
		blockHardnessHash.put(Block.getBlockFromName("emerald_ore"), 9F); //Copper
		blockHardnessHash.put(Block.getBlockFromName("lapis_ore"), 9F); // Tin
		blockHardnessHash.put(Block.getBlockFromName("quartz_ore"), 1.25F); //Gold
		
		blockMetaWoodHardnessHash.put(0, 4.5F); //Wood
		blockMetaWoodHardnessHash.put(1, 0.75F); //Yew
		blockMetaWoodHardnessHash.put(2, 2.5F); //Oak
		blockMetaWoodHardnessHash.put(3, 1.5F); //Teak
		blockMetaWoodHardnessHash.put(4, 4.5F);
		blockMetaWoodHardnessHash.put(5, 0.75F);
		blockMetaWoodHardnessHash.put(6, 2.5F);
		blockMetaWoodHardnessHash.put(7, 1.5F);
		blockMetaWoodHardnessHash.put(8, 4.5F);
		blockMetaWoodHardnessHash.put(9, 0.75F);
		blockMetaWoodHardnessHash.put(10, 2.5F);
		blockMetaWoodHardnessHash.put(11, 1.5F);
		
		blockMetaWood2HardnessHash.put(0, 4.5F); //Willow
		blockMetaWood2HardnessHash.put(1, 0.75F); //Maple
		blockMetaWood2HardnessHash.put(2, 2.5F); //Mahogany
		blockMetaWood2HardnessHash.put(3, 1.5F); //Magic
		blockMetaWood2HardnessHash.put(4, 4.5F);
		blockMetaWood2HardnessHash.put(5, 0.75F);
		blockMetaWood2HardnessHash.put(6, 2.5F);
		blockMetaWood2HardnessHash.put(7, 1.5F);
		blockMetaWood2HardnessHash.put(8, 4.5F);
		blockMetaWood2HardnessHash.put(9, 0.75F);
		blockMetaWood2HardnessHash.put(10, 2.5F);
		blockMetaWood2HardnessHash.put(11, 1.5F);
		
		blockLvlHash.put(Block.getBlockFromName("coal_ore"), 30);
		blockLvlHash.put(Block.getBlockFromName("iron_ore"), 15);
		blockLvlHash.put(Block.getBlockFromName("gold_ore"), 70);
		blockLvlHash.put(Block.getBlockFromName("diamond_ore"), 85); //Rune
		blockLvlHash.put(Block.getBlockFromName("emerald_ore"), 1); //Copper
		blockLvlHash.put(Block.getBlockFromName("lapis_ore"), 1); // Tin
		blockLvlHash.put(Block.getBlockFromName("quartz_ore"), 40); //Gold
		
		blockMetaWood2LvlHash.put(0, 30); //Willow
		blockMetaWood2LvlHash.put(1, 60); //Maple
		blockMetaWood2LvlHash.put(2, 15); //Mahogany
		blockMetaWood2LvlHash.put(3, 35); //Magic
		blockMetaWood2LvlHash.put(4, 1);
		blockMetaWood2LvlHash.put(5, 60);
		blockMetaWood2LvlHash.put(6, 15);
		blockMetaWood2LvlHash.put(7, 35);
		blockMetaWood2LvlHash.put(8, 1);
		blockMetaWood2LvlHash.put(9, 60);
		blockMetaWood2LvlHash.put(10, 15);
		blockMetaWood2LvlHash.put(11, 35);
		
		blockMetaWoodLvlHash.put(0, 1); //Wood
		blockMetaWoodLvlHash.put(1, 60); //Yew
		blockMetaWoodLvlHash.put(2, 15); //Oak
		blockMetaWoodLvlHash.put(3, 35); //Teak
		blockMetaWoodLvlHash.put(4, 1);
		blockMetaWoodLvlHash.put(5, 60);
		blockMetaWoodLvlHash.put(6, 15);
		blockMetaWoodLvlHash.put(7, 35);
		blockMetaWoodLvlHash.put(8, 1);
		blockMetaWoodLvlHash.put(9, 60);
		blockMetaWoodLvlHash.put(10, 15);
		blockMetaWoodLvlHash.put(11, 35);
		
		xpPerLogHash.put(0, 25F);
		xpPerLogHash.put(1, 175F);
		xpPerLogHash.put(2, 37.5F);
		xpPerLogHash.put(3, 85F);
		xpPerLogHash.put(4, 25F);
		xpPerLogHash.put(5, 175F);
		xpPerLogHash.put(6, 37.5F);
		xpPerLogHash.put(7, 85F);
		xpPerLogHash.put(8, 25F);
		xpPerLogHash.put(9, 175F);
		xpPerLogHash.put(10, 37.5F);
		xpPerLogHash.put(11, 85F);
		
		xpPerLog2Hash.put(0, 67.5F);
		xpPerLog2Hash.put(1, 100F);
		xpPerLog2Hash.put(2, 125F);
		xpPerLog2Hash.put(3, 250F);
		xpPerLog2Hash.put(4, 67.5F);
		xpPerLog2Hash.put(5, 100F);
		xpPerLog2Hash.put(6, 125F);
		xpPerLog2Hash.put(7, 250F);
		xpPerLog2Hash.put(8, 67.5F);
		xpPerLog2Hash.put(9, 100F);
		xpPerLog2Hash.put(10, 125F);
		xpPerLog2Hash.put(11, 250F);
		
		xpPerBlockHash.put(Block.getBlockFromName("coal_ore"), 50F);
		xpPerBlockHash.put(Block.getBlockFromName("iron_ore"), 35F);
		xpPerBlockHash.put(Block.getBlockFromName("gold_ore"), 92F);//Adamant
		xpPerBlockHash.put(Block.getBlockFromName("diamond_ore"), 125F); //Rune
		xpPerBlockHash.put(Block.getBlockFromName("emerald_ore"), 17.2F); //Copper
		xpPerBlockHash.put(Block.getBlockFromName("lapis_ore"), 17.5F); // Tin
		xpPerBlockHash.put(Block.getBlockFromName("quartz_ore"), 65F); //Gold
		
		blockReturnHarvestMetaIDHash.put(Block.getBlockFromName("coal_ore"), 0);
		blockReturnHarvestMetaIDHash.put(Block.getBlockFromName("iron_ore"), 1);
		blockReturnHarvestMetaIDHash.put(Block.getBlockFromName("gold_ore"), 2);
		blockReturnHarvestMetaIDHash.put(Block.getBlockFromName("diamond_ore"), 3);
		blockReturnHarvestMetaIDHash.put(Block.getBlockFromName("emerald_ore"), 4);
		blockReturnHarvestMetaIDHash.put(Block.getBlockFromName("lapis_ore"), 5);
		blockReturnHarvestMetaIDHash.put(Block.getBlockFromName("quartz_ore"), 6);
		
		blockReturnItemHash.put(Block.getBlockFromName("coal_ore"), Item.getItemById(263));
		blockReturnItemHash.put(Block.getBlockFromName("iron_ore"), Item.getItemById(265));
		blockReturnItemHash.put(Block.getBlockFromName("gold_ore"), Item.getItemById(266));
		blockReturnItemHash.put(Block.getBlockFromName("diamond_ore"), Item.getItemById(264));
		blockReturnItemHash.put(Block.getBlockFromName("emerald_ore"), Item.getItemById(388));
		blockReturnItemHash.put(Block.getBlockFromName("lapis_ore"), Item.getItemById(351));
		blockReturnItemHash.put(Block.getBlockFromName("quartz_ore"), Item.getItemById(406));
		
		blockReturnItemMetaHash.put(0, Items.Logs);
		blockReturnItemMetaHash.put(1, Items.YewLogs);
		blockReturnItemMetaHash.put(2, Items.OakLogs);
		blockReturnItemMetaHash.put(3, Items.TeakLogs);
		blockReturnItemMetaHash.put(4, Items.Logs);
		blockReturnItemMetaHash.put(5, Items.YewLogs);
		blockReturnItemMetaHash.put(6, Items.OakLogs);
		blockReturnItemMetaHash.put(7, Items.TeakLogs);
		blockReturnItemMetaHash.put(8, Items.Logs);
		blockReturnItemMetaHash.put(9, Items.YewLogs);
		blockReturnItemMetaHash.put(10, Items.OakLogs);
		blockReturnItemMetaHash.put(11, Items.TeakLogs);
		
		blockReturnItemMeta2Hash.put(0, Items.WillowLogs);
		blockReturnItemMeta2Hash.put(1, Items.MapleLogs);
		blockReturnItemMeta2Hash.put(2, Items.MahoganyLogs);
		blockReturnItemMeta2Hash.put(3, Items.MagicLogs);
		blockReturnItemMeta2Hash.put(4, Items.WillowLogs);
		blockReturnItemMeta2Hash.put(5, Items.MapleLogs);
		blockReturnItemMeta2Hash.put(6, Items.MahoganyLogs);
		blockReturnItemMeta2Hash.put(7, Items.MagicLogs);
		blockReturnItemMeta2Hash.put(8, Items.WillowLogs);
		blockReturnItemMeta2Hash.put(9, Items.MapleLogs);
		blockReturnItemMeta2Hash.put(10, Items.MahoganyLogs);
		blockReturnItemMeta2Hash.put(11, Items.MagicLogs);
		
		System.out.println("[RC_Mod]Initializing Block-Break Variables");
	}
}