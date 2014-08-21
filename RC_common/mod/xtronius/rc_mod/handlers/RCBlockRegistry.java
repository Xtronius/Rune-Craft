package mod.xtronius.rc_mod.handlers;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.tileEntity.TileEntityFurnace1;
import mod.xtronius.rc_mod.tileEntity.TileEntityLogFire;
import mod.xtronius.rc_mod.util.RCItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class RCBlockRegistry {

	public static void BlockReg()
	
	{	
		GameRegistry.registerBlock(Blocks.BlockWoodBuffer, "BlockWoodBuffer");
		GameRegistry.registerBlock(Blocks.BlockWood2Buffer, "BlockWood2Buffer");
		GameRegistry.registerBlock(Blocks.BlockStoneBuffer, "BlockStoneBuffer");
		GameRegistry.registerBlock(Blocks.Wood2, RCItemBlock.class, "BlockWood2");
		
	    GameRegistry.registerBlock(Blocks.RCFurnaceShellBase , "RCFurnaceShellBase");
	    GameRegistry.registerBlock(Blocks.RCFurnaceShellMid , "RCFurnaceShellMid");
	    GameRegistry.registerBlock(Blocks.RCFurnaceShellItemRender , "RCFurnaceShellItemRender");
	    GameRegistry.registerBlock(Blocks.RCFurnaceShellRoofLower , "RCFurnaceShellRoofLower");
	    GameRegistry.registerBlock(Blocks.RCFurnaceShellRoofUpper , "RCFurnaceShellRoofUpper");
	    GameRegistry.registerBlock(Blocks.RCFurnaceShellMisc , "RCFurnaceShellMisc");
		
	    GameRegistry.registerBlock(Blocks.RCFurnace, RCItemBlock.class , "RCFurnace1");
	    GameRegistry.registerTileEntity(TileEntityFurnace1.class, "RCFurnace1");
	    
	    GameRegistry.registerBlock(Blocks.LogFireIdle, RCItemBlock.class , "BlockLogFireIdle");
	    
	    GameRegistry.registerBlock(Blocks.LogFireActive, RCItemBlock.class , "BlockLogFireActive");
	    GameRegistry.registerTileEntity(TileEntityLogFire.class, "BlockLogFireActive");
	}
}
