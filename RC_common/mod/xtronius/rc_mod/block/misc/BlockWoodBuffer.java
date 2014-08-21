package mod.xtronius.rc_mod.block.misc;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.xtronius.rc_mod.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWoodBuffer extends BlockGlass{

	public BlockWoodBuffer(int par1) {
		super( Material.glass, false);
		this.setStepSound(soundTypeWood);
		this.setTickRandomly(true);
		this.setResistance(6000000.0F);
		this.setBlockUnbreakable();
	}
	
	public int tickRate(World par1World)
    {
        return 50;
    }
	
	public void updateTick(World world, int x, int y, int z, Random par5Random) {
		int meta = world.getBlockMetadata(x, y, z);
		
		if(this.equals(Blocks.BlockWoodBuffer))
			world.setBlock(x, y, z, Block.getBlockFromName("log"), meta, 2);
		else if(this.equals(Blocks.BlockWood2Buffer))
			world.setBlock(x, y, z, Blocks.Wood2, meta, 2);
	  }  
	@Override
	@SideOnly(Side.CLIENT)

	public void registerBlockIcons(IIconRegister iconRegister){
	    blockIcon = iconRegister.registerIcon("rc_mod:" + "Buffer");
		}
 }
