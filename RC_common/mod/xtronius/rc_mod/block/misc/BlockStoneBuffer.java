package mod.xtronius.rc_mod.block.misc;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStoneBuffer extends BlockGlass{

	public BlockStoneBuffer(int par1) {
		super(Material.glass, false);
		this.setStepSound(soundTypeMetal);
		this.setTickRandomly(true);
		this.setResistance(6000000.0F);
		this.setBlockUnbreakable();
	}
	
	public int tickRate(World par1World)
    {
        return 45;
    }
	
	public void updateTick(World world, int x, int y, int z, Random par5Random)
	  {
		
		int meta = world.getBlockMetadata(x, y, z);
		System.out.println("Meta: " + meta);
		
		switch(meta) {
		case 0:world.setBlock(x, y, z, Block.getBlockFromName("coal_ore"));break;
		case 1:world.setBlock(x, y, z, Block.getBlockFromName("iron_ore"));break;
		case 2:world.setBlock(x, y, z, Block.getBlockFromName("gold_ore"));break;
		case 3:world.setBlock(x, y, z, Block.getBlockFromName("diamond_ore"));break;
		case 4:world.setBlock(x, y, z, Block.getBlockFromName("emerald_ore"));break;
		case 5:world.setBlock(x, y, z, Block.getBlockFromName("lapis_ore"));break;
		case 6:world.setBlock(x, y, z, Block.getBlockFromName("quartz_ore"));break;
		}
		//world.setBlock(x, y, z, Block.wood.blockID, meta, 2);
	  }  
	@Override
	@SideOnly(Side.CLIENT)

	public void registerBlockIcons(IIconRegister iconRegister){
	    blockIcon = iconRegister.registerIcon("rc_mod:" + "Buffer");
		}
 }
