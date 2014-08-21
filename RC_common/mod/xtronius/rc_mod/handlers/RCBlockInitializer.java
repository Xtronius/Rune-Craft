package mod.xtronius.rc_mod.handlers;

import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.block.guiBlocks.Furnace1;
import mod.xtronius.rc_mod.block.ids.BlockIDs;
import mod.xtronius.rc_mod.block.misc.BlockLogFire;
import mod.xtronius.rc_mod.block.misc.BlockRCFurnaceBuffer;
import mod.xtronius.rc_mod.block.misc.BlockRCWood;
import mod.xtronius.rc_mod.block.misc.BlockStoneBuffer;
import mod.xtronius.rc_mod.block.misc.BlockWoodBuffer;
import mod.xtronius.rc_mod.creativetab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;

public class RCBlockInitializer {

	public RCBlockInitializer()
	{
		//blockRegistry.addObject(0, "air", (new BlockAir()).setBlockName("air"));
  	  	Blocks.BlockWoodBuffer = new BlockWoodBuffer(BlockIDs.BlockWoodBufferID).setBlockName("BlockWoodBuffer").setBlockTextureName("Buffer");
  	  	Blocks.BlockWood2Buffer = new BlockWoodBuffer(BlockIDs.BlockWood2BufferID).setBlockName("BlockWood2Buffer").setBlockTextureName("Buffer");
		Blocks.BlockStoneBuffer = new BlockStoneBuffer(BlockIDs.BlockStoneBufferID).setBlockName("BlockStoneBuffer").setBlockTextureName("Buffer");
		Blocks.Wood2 = new BlockRCWood().setBlockName("BlockWood2").setBlockTextureName("log").setCreativeTab(CreativeTab.tabsRC_ModBlocks);
		
		Blocks.RCFurnace = new Furnace1(BlockIDs.BlockRCFurnaceID).setBlockName("RCFurnace1").setCreativeTab(CreativeTab.tabsRC_ModBlocks);
		Blocks.RCFurnaceShellBase = new BlockRCFurnaceBuffer(BlockIDs.BlockRCFurnaceShellBaseID).setBlockName("RCFurnace1ShellBase");
		Blocks.RCFurnaceShellMid = new BlockRCFurnaceBuffer(BlockIDs.BlockRCFurnaceShellMidID).setBlockName("RCFurnace1ShellMid");
		Blocks.RCFurnaceShellItemRender = new BlockRCFurnaceBuffer(BlockIDs.BlockRCFurnaceShellItemRenderID).setBlockName("RCFurnace1ShellItemRender");
		Blocks.RCFurnaceShellRoofLower = new BlockRCFurnaceBuffer(BlockIDs.BlockRCFurnaceShellRoofLowerID).setBlockName("RCFurnace1BufferShelRoofLower");
		Blocks.RCFurnaceShellRoofUpper = new BlockRCFurnaceBuffer(BlockIDs.BlockRCFurnaceShellRoofUpperID).setBlockName("RCFurnace1ShellRoofUpper");
		Blocks.RCFurnaceShellMisc = new BlockRCFurnaceBuffer(BlockIDs.BlockRCFurnaceShellMiscID).setBlockName("RCFurnace1ShellMisc");
		
		Blocks.LogFireIdle = new BlockLogFire(false, BlockIDs.LogFireIdleID).setBlockName("BlockLogFire").setCreativeTab(CreativeTab.tabsRC_ModBlocks);
		
		Blocks.LogFireActive = new BlockLogFire(true, BlockIDs.LogFireActiveID).setBlockName("BlockLogFire").setCreativeTab(CreativeTab.tabsRC_ModBlocks);
		
//		Block.blockRegistry.addObject(BlockIDs.BlockWood2ID, "BlockWood2", Blocks.Wood2);
		
		setVanillaBlockToRCCreativeTab();
	}
	
	private void setVanillaBlockToRCCreativeTab() {
		Block.getBlockFromName("log").setCreativeTab(CreativeTab.tabsRC_ModBlocks);
	}
}