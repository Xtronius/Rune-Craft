package mod.xtronius.rc_mod.handlers;

import java.util.List;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.block.ids.BlockIDs;
import mod.xtronius.rc_mod.items.ids.ItemIDs;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.config.Configuration;

public class RCIDHandler {

//	public static List<Block> getAllRCBlock() {
//		return Blocks.blocks;
//	}
	 
	public static void RegConfigIDs(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        int idI = 20000;
        int idB = 2750;
        int idGui = 1;
        
		  BlockIDs.BlockWoodBufferID = config.get("BlockIDs", "BlockWoodBufferID", idB++).getInt();
		  BlockIDs.BlockWood2BufferID = config.get("BlockIDs", "BlockWood2BufferID", idB++).getInt();
		  BlockIDs.BlockStoneBufferID = config.get("BlockIDs", "BlockStoneBufferID", idB++).getInt();
		  BlockIDs.BlockWood2ID = config.get("BlockIDs", "BlockWood2ID", idB++).getInt();
		  
		  BlockIDs.BlockRCFurnaceID = config.get("BlockIDs", "BlockRCFurnaceID", idB++).getInt();
		  BlockIDs.BlockRCFurnaceShellBaseID = config.get("BlockIDs", "BlockRCFurnaceShellBaseID", idB++).getInt();
		  BlockIDs.BlockRCFurnaceShellMidID = config.get("BlockIDs", "BlockRCFurnaceShellMidID", idB++).getInt();
		  BlockIDs.BlockRCFurnaceShellItemRenderID = config.get("BlockIDs", "BlockRCFurnaceShellItemRenderID", idB++).getInt();
		  BlockIDs.BlockRCFurnaceShellRoofLowerID = config.get("BlockIDs", "BlockRCFurnaceShellRoofLowerID", idB++).getInt();
		  BlockIDs.BlockRCFurnaceShellRoofUpperID = config.get("BlockIDs", "BlockRCFurnaceShellRoofUpperID", idB++).getInt();
		  BlockIDs.BlockRCFurnaceShellMiscID = config.get("BlockIDs", "BlockRCFurnaceShellMiscID", idB++).getInt();
		  
		  BlockIDs.LogFireIdleID = config.get("BlockIDs", "LogFireIdelID", idB++).getInt();
		  BlockIDs.LogFireActiveID = config.get("BlockIDs", "LogFireActiveID", idB++).getInt();
		  
		  ItemIDs.BronzeHatchetID = config.get("ItemIDs", "BronzeHatchetID", idI++).getInt();
		  ItemIDs.IronHatchetID = config.get("ItemIDs", "IronHatchetID", idI++).getInt();
		  ItemIDs.SteelHatchetID = config.get("ItemIDs", "SteelHatchetID", idI++).getInt();
		  ItemIDs.BlackHatchetID = config.get("ItemIDs", "BlackHatchetID", idI++).getInt();
		  ItemIDs.MithrilHatchetID = config.get("ItemIDs", "MithrilHatchetID", idI++).getInt();
		  ItemIDs.AdamantHatchetID = config.get("ItemIDs", "AdamantHatchetID", idI++).getInt();
		  ItemIDs.RuneHatchetID = config.get("ItemIDs", "RuneHatchetID", idI++).getInt();
		  ItemIDs.DragonHatchetID = config.get("ItemIDs", "DragonHatchetID", idI++).getInt();
		  ItemIDs.InfernoAdzeID = config.get("ItemIDs", "InfernoAdzeID", idI++).getInt();
		  
		  ItemIDs.BronzePickaxeID = config.get("ItemIDs", "BronzePickaxeID", idI++).getInt();
		  ItemIDs.IronPickaxeID = config.get("ItemIDs", "IronPickaxeID", idI++).getInt();
		  ItemIDs.SteelPickaxeID = config.get("ItemIDs", "SteelPickaxeID", idI++).getInt();
		  ItemIDs.MithrilPickaxeID = config.get("ItemIDs", "MithrilPickaxeID", idI++).getInt();
		  ItemIDs.AdamantPickaxeID = config.get("ItemIDs", "AdamantPickaxeID", idI++).getInt();
		  ItemIDs.RunePickaxeID = config.get("ItemIDs", "RunePickaxeID", idI++).getInt();
		  ItemIDs.DragonPickaxeID = config.get("ItemIDs", "DragonPickaxeID", idI++).getInt();
		  
		  ItemIDs.LogsID = config.get("ItemIDs", "LogsID", idI++).getInt();
		  ItemIDs.YewLogsID = config.get("ItemIDs", "YewLogsID", idI++).getInt();
		  ItemIDs.OakLogsID = config.get("ItemIDs", "OakLogsID", idI++).getInt();
		  ItemIDs.TeakLogsID = config.get("ItemIDs", "TeakLogsID", idI++).getInt();
		  ItemIDs.WillowLogsID = config.get("ItemIDs", "WillowLogsID", idI++).getInt();
		  ItemIDs.MapleLogsID = config.get("ItemIDs", "MapleLogsID", idI++).getInt();
		  ItemIDs.MahoganyLogsID = config.get("ItemIDs", "MahoganyLogsID", idI++).getInt();
		  ItemIDs.MagicLogsID = config.get("ItemIDs", "MagicLogsID", idI++).getInt();
		  
		  ItemIDs.BronzeSwordID = config.get("ItemIDs", "BronzeSwordID", idI++).getInt();
		  ItemIDs.IronSwordID = config.get("ItemIDs", "IronSwordID", idI++).getInt();
		  ItemIDs.SteelSwordID = config.get("ItemIDs", "SteelSwordID", idI++).getInt();
		  ItemIDs.BlackSwordID = config.get("ItemIDs", "BlackSwordID", idI++).getInt();
		  ItemIDs.MithrilSwordID = config.get("ItemIDs", "MithrilSwordID", idI++).getInt();
		  ItemIDs.AdamantSwordID = config.get("ItemIDs", "AdamantSwordID", idI++).getInt();
		  ItemIDs.RuneSwordID = config.get("ItemIDs", "RuneSwordID", idI++).getInt();
		  ItemIDs.DragonSwordID = config.get("ItemIDs", "DragonSwordID", idI++).getInt();
		  
		  config.save();
	}
}
