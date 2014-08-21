package mod.xtronius.rc_mod.handlers;

import net.minecraft.item.Item;
import mod.xtronius.rc_mod.items.ItemHatchetBase;
import mod.xtronius.rc_mod.items.ItemLogs;
import mod.xtronius.rc_mod.items.ItemPickaxeBase;
import mod.xtronius.rc_mod.items.ItemSwordBase;
import mod.xtronius.rc_mod.items.Items;
import mod.xtronius.rc_mod.items.ids.ItemIDs;

public class RCItemInitializer {

	public RCItemInitializer() {
		Items.BronzeHatchet = new ItemHatchetBase(ItemIDs.BronzeHatchetID, "bronze_axe", 0).setUnlocalizedName("BronzeHatchet");
		Items.IronHatchet = new ItemHatchetBase(ItemIDs.IronHatchetID, "iron_axe", 1).setUnlocalizedName("IronHatchet");
		Items.SteelHatchet = new ItemHatchetBase(ItemIDs.SteelHatchetID, "steel_axe", 2).setUnlocalizedName("SteelHatchet");
		Items.BlackHatchet = new ItemHatchetBase(ItemIDs.BlackHatchetID, "black_axe", 3).setUnlocalizedName("BlackHatchet");
		Items.MithrilHatchet = new ItemHatchetBase(ItemIDs.MithrilHatchetID, "mithrill_axe", 4).setUnlocalizedName("MithrilHatchet");
		Items.AdamantHatchet = new ItemHatchetBase(ItemIDs.AdamantHatchetID, "adamant_axe", 5).setUnlocalizedName("AdamantHatchet");
		Items.RuneHatchet = new ItemHatchetBase(ItemIDs.RuneHatchetID, "rune_axe", 6).setUnlocalizedName("RuneHatchet");
		Items.DragonHatchet = new ItemHatchetBase(ItemIDs.DragonHatchetID, "dragon_axe", 7).setUnlocalizedName("DragonHatchet");
		Items.InfernoAdze = new ItemHatchetBase(ItemIDs.InfernoAdzeID, "InfernoAdze", 7).setUnlocalizedName("InfernoAdze");
		
		Items.BronzePickaxe = new ItemPickaxeBase(ItemIDs.BronzePickaxeID, "bronze_pickaxe", 0).setUnlocalizedName("BronzePickaxe");
		Items.IronPickaxe = new ItemPickaxeBase(ItemIDs.IronPickaxeID, "iron_pickaxe", 1).setUnlocalizedName("IronPickaxe");
		Items.SteelPickaxe = new ItemPickaxeBase(ItemIDs.SteelPickaxeID, "steel_pickaxe", 2).setUnlocalizedName("SteelPickaxe");
		Items.MithrilPickaxe = new ItemPickaxeBase(ItemIDs.MithrilPickaxeID, "mithrill_pickaxe", 4).setUnlocalizedName("MithrilPickaxe");
		Items.AdamantPickaxe = new ItemPickaxeBase(ItemIDs.AdamantPickaxeID, "adamant_pickaxe", 5).setUnlocalizedName("AdamantPickaxe");
		Items.RunePickaxe = new ItemPickaxeBase(ItemIDs.RunePickaxeID, "rune_pickaxe", 6).setUnlocalizedName("RunePickaxe");
		Items.DragonPickaxe = new ItemPickaxeBase(ItemIDs.DragonPickaxeID, "dragon_pickaxe", 7).setUnlocalizedName("DragonPickaxe");
		
		Items.Logs =  new ItemLogs(ItemIDs.LogsID, "Logs").setUnlocalizedName("Logs");
		Items.YewLogs =  new ItemLogs(ItemIDs.YewLogsID, "Yew_logs").setUnlocalizedName("YewLogs");
		Items.OakLogs =  new ItemLogs(ItemIDs.OakLogsID, "Oak_logs").setUnlocalizedName("OakLogs");
		Items.TeakLogs =  new ItemLogs(ItemIDs.TeakLogsID, "Teak_logs").setUnlocalizedName("TeakLogs");
		Items.WillowLogs =  new ItemLogs(ItemIDs.WillowLogsID, "Willow_logs").setUnlocalizedName("WillowLogs");
		Items.MapleLogs =  new ItemLogs(ItemIDs.MapleLogsID, "Maple_logs").setUnlocalizedName("MapleLogs");
		Items.MahoganyLogs =  new ItemLogs(ItemIDs.MahoganyLogsID, "Mahogany_logs").setUnlocalizedName("MahoganyLogs");
		Items.MagicLogs =  new ItemLogs(ItemIDs.MagicLogsID, "Magic_logs").setUnlocalizedName("MagicLogs");
		
		
		
//		RCItem.BronzeDagger = new ItemDaggerBase(ItemIDs.BronzeDaggerID, "bronze_axe", 0).setUnlocalizedName("BronzeDagger");
//		RCItem.IronDagger = new ItemDaggerBase(ItemIDs.IronDaggerID, "iron_axe", 1).setUnlocalizedName("IronDagger");
//		RCItem.SteelDagger = new ItemDaggerBase(ItemIDs.SteelDaggerID, "steel_axe", 2).setUnlocalizedName("SteelDagger");
//		RCItem.BlackDagger = new ItemDaggerBase(ItemIDs.BlackDaggerID, "black_axe", 3).setUnlocalizedName("BlackDagger");
//		RCItem.MithrilDagger = new ItemDaggerBase(ItemIDs.MithrilDaggerID, "mithrill_axe", 4).setUnlocalizedName("MithrilDagger");
//		RCItem.AdamantDagger = new ItemDaggerBase(ItemIDs.AdamantDaggerID, "adamant_axe", 5).setUnlocalizedName("AdamantDagger");
//		RCItem.RuneDagger = new ItemDaggerBase(ItemIDs.RuneDaggerID, "rune_axe", 6).setUnlocalizedName("RuneDagger");
//		RCItem.DragonDagger = new ItemDaggerBase(ItemIDs.DragonDaggerID, "dragon_axe", 7).setUnlocalizedName("DragonDagger");
//		
		Items.BronzeSword = new ItemSwordBase(ItemIDs.BronzeSwordID, "bronze_sword", 0).setUnlocalizedName("BronzeSword");
		Items.IronSword = new ItemSwordBase(ItemIDs.IronSwordID, "iron_bronze_sword", 1).setUnlocalizedName("IronSword");
		Items.SteelSword = new ItemSwordBase(ItemIDs.SteelSwordID, "steel_bronze_sword", 2).setUnlocalizedName("SteelSword");
		Items.BlackSword = new ItemSwordBase(ItemIDs.BlackSwordID, "black_bronze_sword", 3).setUnlocalizedName("BlackSword");
		Items.MithrilSword = new ItemSwordBase(ItemIDs.MithrilSwordID, "mithrill_bronze_sword", 4).setUnlocalizedName("MithrilSword");
		Items.AdamantSword = new ItemSwordBase(ItemIDs.AdamantSwordID, "adamant_bronze_sword", 5).setUnlocalizedName("AdamantSword");
		Items.RuneSword = new ItemSwordBase(ItemIDs.RuneSwordID, "rune_bronze_sword", 6).setUnlocalizedName("RuneSword");
		Items.DragonSword = new ItemSwordBase(ItemIDs.DragonSwordID, "dragon_bronze_sword", 7).setUnlocalizedName("DragonSword");
//		
//		RCItem.BronzeMace = new ItemMaceBase(ItemIDs.BronzeMaceID, "bronze_axe", 0).setUnlocalizedName("BronzeMace");
//		RCItem.IronMace = new ItemMaceBase(ItemIDs.IronMaceID, "iron_axe", 1).setUnlocalizedName("IronMace");
//		RCItem.SteelMace = new ItemMaceBase(ItemIDs.SteelMaceID, "steel_axe", 2).setUnlocalizedName("SteelMace");
//		RCItem.BlackMace = new ItemMaceBase(ItemIDs.BlackMaceID, "black_axe", 3).setUnlocalizedName("BlackMace");
//		RCItem.MithrilMace = new ItemMaceBase(ItemIDs.MithrilMaceID, "mithrill_axe", 4).setUnlocalizedName("MithrilMace");
//		RCItem.AdamantMace = new ItemMaceBase(ItemIDs.AdamantMaceID, "adamant_axe", 5).setUnlocalizedName("AdamantMace");
//		RCItem.RuneMace = new ItemMaceBase(ItemIDs.RuneMaceID, "rune_axe", 6).setUnlocalizedName("RuneMace");
//		RCItem.DragonMace = new ItemMaceBase(ItemIDs.DragonMaceID, "dragon_axe", 7).setUnlocalizedName("DragonMace");
//		
//		RCItem.BronzeScimitar = new ItemScimitarBase(ItemIDs.BronzeScimitarID, "bronze_axe", 0).setUnlocalizedName("BronzeScimitar");
//		RCItem.IronScimitar = new ItemScimitarBase(ItemIDs.IronScimitarID, "iron_axe", 1).setUnlocalizedName("IronScimitar");
//		RCItem.SteelScimitar = new ItemScimitarBase(ItemIDs.SteelScimitarID, "steel_axe", 2).setUnlocalizedName("SteelScimitar");
//		RCItem.BlackScimitar = new ItemScimitarBase(ItemIDs.BlackScimitarID, "black_axe", 3).setUnlocalizedName("BlackScimitar");
//		RCItem.MithrilScimitar = new ItemScimitarBase(ItemIDs.MithrilScimitarID, "mithrill_axe", 4).setUnlocalizedName("MithrilScimitar");
//		RCItem.AdamantScimitar = new ItemScimitarBase(ItemIDs.AdamantScimitarID, "adamant_axe", 5).setUnlocalizedName("AdamantScimitar");
//		RCItem.RuneScimitar = new ItemScimitarBase(ItemIDs.RuneScimitarID, "rune_axe", 6).setUnlocalizedName("RuneScimitar");
//		RCItem.DragonScimitar = new ItemScimitarBase(ItemIDs.DragonScimitarID, "dragon_axe", 7).setUnlocalizedName("DragonScimitar");
//		
//		RCItem.BronzeLongSword = new ItemLongSwordBase(ItemIDs.BronzeLongSwordID, "bronze_axe", 0).setUnlocalizedName("BronzeLongSword");
//		RCItem.IronLongSword = new ItemLongSwordBase(ItemIDs.IronLongSwordID, "iron_axe", 1).setUnlocalizedName("IronLongSword");
//		RCItem.SteelLongSword = new ItemLongSwordBase(ItemIDs.SteelLongSwordID, "steel_axe", 2).setUnlocalizedName("SteelLongSword");
//		RCItem.BlackLongSword = new ItemLongSwordBase(ItemIDs.BlackLongSwordID, "black_axe", 3).setUnlocalizedName("BlackLongSword");
//		RCItem.MithrilLongSword = new ItemLongSwordBase(ItemIDs.MithrilLongSwordID, "mithrill_axe", 4).setUnlocalizedName("MithrilLongSword");
//		RCItem.AdamantLongSword = new ItemLongSwordBase(ItemIDs.AdamantLongSwordID, "adamant_axe", 5).setUnlocalizedName("AdamantLongSword");
//		RCItem.RuneLongSword = new ItemLongSwordBase(ItemIDs.RuneLongSwordID, "rune_axe", 6).setUnlocalizedName("RuneLongSword");
//		RCItem.DragonLongSword = new ItemLongSwordBase(ItemIDs.DragonLongSwordID, "dragon_axe", 7).setUnlocalizedName("DragonLongSword");
//		
//		RCItem.BronzeWarHammer = new ItemWarHammerBase(ItemIDs.BronzeWarHammerID, "bronze_axe", 0).setUnlocalizedName("BronzeWarHammer");
//		RCItem.IronWarHammer = new ItemWarHammerBase(ItemIDs.IronWarHammerID, "iron_axe", 1).setUnlocalizedName("IronWarHammer");
//		RCItem.SteelWarHammer = new ItemWarHammerBase(ItemIDs.SteelWarHammerID, "steel_axe", 2).setUnlocalizedName("SteelWarHammer");
//		RCItem.BlackWarHammer = new ItemWarHammerBase(ItemIDs.BlackWarHammerID, "black_axe", 3).setUnlocalizedName("BlackWarHammer");
//		RCItem.MithrilWarHammer = new ItemWarHammerBase(ItemIDs.MithrilWarHammerID, "mithrill_axe", 4).setUnlocalizedName("MithrilWarHammer");
//		RCItem.AdamantWarHammer = new ItemWarHammerBase(ItemIDs.AdamantWarHammerID, "adamant_axe", 5).setUnlocalizedName("AdamantWarHammer");
//		RCItem.RuneWarHammer = new ItemWarHammerBase(ItemIDs.RuneWarHammerID, "rune_axe", 6).setUnlocalizedName("RuneWarHammer");
//		RCItem.DragonWarHammer = new ItemWarHammerBase(ItemIDs.DragonWarHammerID, "dragon_axe", 7).setUnlocalizedName("DragonWarHammer");
//		
//		RCItem.BronzeBattleAxe = new ItemBattleAxeBase(ItemIDs.BronzeBattleAxeID, "bronze_axe", 0).setUnlocalizedName("BronzeBattleAxe");
//		RCItem.IronBattleAxe = new ItemBattleAxeBase(ItemIDs.IronBattleAxeID, "iron_axe", 1).setUnlocalizedName("IronBattleAxe");
//		RCItem.SteelBattleAxe = new ItemBattleAxeBase(ItemIDs.SteelBattleAxeID, "steel_axe", 2).setUnlocalizedName("SteelBattleAxe");
//		RCItem.BlackBattleAxe = new ItemBattleAxeBase(ItemIDs.BlackBattleAxeID, "black_axe", 3).setUnlocalizedName("BlackBattleAxe");
//		RCItem.MithrilBattleAxe = new ItemBattleAxeBase(ItemIDs.MithrilBattleAxeID, "mithrill_axe", 4).setUnlocalizedName("MithrilBattleAxe");
//		RCItem.AdamantBattleAxe = new ItemBattleAxeBase(ItemIDs.AdamantBattleAxeID, "adamant_axe", 5).setUnlocalizedName("AdamantBattleAxe");
//		RCItem.RuneBattleAxe = new ItemBattleAxeBase(ItemIDs.RuneBattleAxeID, "rune_axe", 6).setUnlocalizedName("RuneBattleAxe");
//		RCItem.DragonBattleAxe = new ItemBattleAxeBase(ItemIDs.DragonBattleAxeID, "dragon_axe", 7).setUnlocalizedName("DragonBattleAxe");
//		
//		RCItem.BronzeTwoHandedSword = new ItemTwoHandedSwordBase(ItemIDs.BronzeTwoHandedSwordID, "bronze_axe", 0).setUnlocalizedName("BronzeTwoHandedSword");
//		RCItem.IronTwoHandedSword = new ItemTwoHandedSwordBase(ItemIDs.IronTwoHandedSwordID, "iron_axe", 1).setUnlocalizedName("IronTwoHandedSword");
//		RCItem.SteelTwoHandedSword = new ItemTwoHandedSwordBase(ItemIDs.SteelTwoHandedSwordID, "steel_axe", 2).setUnlocalizedName("SteelTwoHandedSword");
//		RCItem.BlackTwoHandedSword = new ItemTwoHandedSwordBase(ItemIDs.BlackTwoHandedSwordID, "black_axe", 3).setUnlocalizedName("BlackTwoHandedSword");
//		RCItem.MithrilTwoHandedSword = new ItemTwoHandedSwordBase(ItemIDs.MithrilTwoHandedSwordID, "mithrill_axe", 4).setUnlocalizedName("MithrilTwoHandedSword");
//		RCItem.AdamantTwoHandedSword = new ItemTwoHandedSwordBase(ItemIDs.AdamantTwoHandedSwordID, "adamant_axe", 5).setUnlocalizedName("AdamantTwoHandedSword");
//		RCItem.RuneTwoHandedSword = new ItemTwoHandedSwordBase(ItemIDs.RuneTwoHandedSwordID, "rune_axe", 6).setUnlocalizedName("RuneTwoHandedSword");
//		RCItem.DragonTwoHandedSword = new ItemTwoHandedSwordBase(ItemIDs.DragonTwoHandedSwordID, "dragon_axe", 7).setUnlocalizedName("DragonTwoHandedSword");
//		
//		RCItem.BronzeHalberd = new ItemHalberdBase(ItemIDs.BronzeHalberdID, "bronze_axe", 0).setUnlocalizedName("BronzeHalberd");
//		RCItem.IronHalberd = new ItemHalberdBase(ItemIDs.IronHalberdID, "iron_axe", 1).setUnlocalizedName("IronHalberd");
//		RCItem.SteelHalberd = new ItemHalberdBase(ItemIDs.SteelHalberdID, "steel_axe", 2).setUnlocalizedName("SteelHalberd");
//		RCItem.BlackHalberd = new ItemHalberdBase(ItemIDs.BlackHalberdID, "black_axe", 3).setUnlocalizedName("BlackHalberd");
//		RCItem.MithrilHalberd = new ItemHalberdBase(ItemIDs.MithrilHalberdID, "mithrill_axe", 4).setUnlocalizedName("MithrilHalberd");
//		RCItem.AdamantHalberd = new ItemHalberdBase(ItemIDs.AdamantHalberdID, "adamant_axe", 5).setUnlocalizedName("AdamantHalberd");
//		RCItem.RuneHalberd = new ItemHalberdBase(ItemIDs.RuneHalberdID, "rune_axe", 6).setUnlocalizedName("RuneHalberd");
//		RCItem.DragonHalberd = new ItemHalberdBase(ItemIDs.DragonHalberdID, "dragon_axe", 7).setUnlocalizedName("DragonHalberd");
//		
//		RCItem.BronzeSpear = new ItemSpearBase(ItemIDs.BronzeSpearID, "bronze_axe", 0).setUnlocalizedName("BronzeSpear");
//		RCItem.IronSpear = new ItemSpearBase(ItemIDs.IronSpearID, "iron_axe", 1).setUnlocalizedName("IronSpear");
//		RCItem.SteelSpear = new ItemSpearBase(ItemIDs.SteelSpearID, "steel_axe", 2).setUnlocalizedName("SteelSpear");
//		RCItem.BlackSpear = new ItemSpearBase(ItemIDs.BlackSpearID, "black_axe", 3).setUnlocalizedName("BlackSpear");
//		RCItem.MithrilSpear = new ItemSpearBase(ItemIDs.MithrilSpearID, "mithrill_axe", 4).setUnlocalizedName("MithrilSpear");
//		RCItem.AdamantSpear = new ItemSpearBase(ItemIDs.AdamantSpearID, "adamant_axe", 5).setUnlocalizedName("AdamantSpear");
//		RCItem.RuneSpear = new ItemSpearBase(ItemIDs.RuneSpearID, "rune_axe", 6).setUnlocalizedName("RuneSpear");
//		RCItem.DragonSpear = new ItemSpearBase(ItemIDs.DragonSpearID, "dragon_axe", 7).setUnlocalizedName("DragonSpear");
//		
//		RCItem.BronzeMaul = new ItemMaulBase(ItemIDs.BronzeMaulID, "bronze_axe", 0).setUnlocalizedName("BronzeMaul");
//		RCItem.IronMaul = new ItemMaulBase(ItemIDs.IronMaulID, "iron_axe", 1).setUnlocalizedName("IronMaul");
//		RCItem.SteelMaul = new ItemMaulBase(ItemIDs.SteelMaulID, "steel_axe", 2).setUnlocalizedName("SteelMaul");
//		RCItem.BlackMaul = new ItemMaulBase(ItemIDs.BlackMaulID, "black_axe", 3).setUnlocalizedName("BlackMaul");
//		RCItem.MithrilMaul = new ItemMaulBase(ItemIDs.MithrilMaulID, "mithrill_axe", 4).setUnlocalizedName("MithrilMaul");
//		RCItem.AdamantMaul = new ItemMaulBase(ItemIDs.AdamantMaulID, "adamant_axe", 5).setUnlocalizedName("AdamantMaul");
//		RCItem.RuneMaul = new ItemMaulBase(ItemIDs.RuneMaulID, "rune_axe", 6).setUnlocalizedName("RuneMaul");
//		RCItem.DragonMaul = new ItemMaulBase(ItemIDs.DragonMaulID, "dragon_axe", 7).setUnlocalizedName("DragonMaul");
		setVanillaItemToRCCreativeTab();
		setVanillaItemStackSize();
	}
	
	private void setVanillaItemToRCCreativeTab() {
		
	}
	private void setVanillaItemStackSize() {
		for(int id = 1; id < 3000; id++) {
			if(Item.getItemById(id) != null)
			Item.getItemById(id).setMaxStackSize(1);
		}
		
		Item.getItemById(383).setMaxStackSize(127);
	}
}