package mod.xtronius.rc_mod.block.guiBlocks;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.Misc.IDs.MiscIDs;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.creativetab.CreativeTab;
import mod.xtronius.rc_mod.inventory.InvFurnace1;
import mod.xtronius.rc_mod.tileEntity.TileEntityFurnace1;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Furnace1 extends BlockContainer
{
    public Furnace1(int par1)
    {
        super(Material.rock);
        
        this.setCreativeTab(CreativeTab.tabsRC_ModBlocks);
        this.setLightOpacity(0);
    }
    
    public int getRenderType()
    {
        return -1;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
   
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
    	if( Block.getIdFromBlock(world.getBlock(x, y+1, z)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x, y+2, z)) == 0 && 	
	    	Block.getIdFromBlock(world.getBlock(x, y, z+1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x, y, z-1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y, z)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x-1, y, z)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x-1, y, z-1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y, z+1)) == 0 &&    	
	    	Block.getIdFromBlock(world.getBlock(x-1, y, z+1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y, z-1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x, y+1, z+1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x, y+1, z-1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y+1, z)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x-1, y+1, z)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x-1, y+1, z-1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y+1, z+1)) == 0 &&   	    	
	    	Block.getIdFromBlock(world.getBlock(x-1, y+1, z+1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y+1, z-1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x, y+2, z+1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x, y+2, z-1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y+2, z)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x-1, y+2, z)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x-1, y+2, z-1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y+2, z+1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x-1, y+2, z+1)) == 0 &&
	    	Block.getIdFromBlock(world.getBlock(x+1, y+2, z-1)) == 0) {
    		
    		world.setBlock(x, y+1, z, Blocks.RCFurnaceShellItemRender);
        	world.setBlock(x, y+2, z, Blocks.RCFurnaceShellRoofLower, 1, 2);
        	world.setBlock(x, y+3, z, Blocks.RCFurnaceShellRoofUpper, 1, 2);
    //-----------------------------------------------------------------------------
        	
        	world.setBlock(x, y, z+1, Blocks.RCFurnaceShellBase, 1, 2);
        	world.setBlock(x, y, z-1, Blocks.RCFurnaceShellBase, 2, 2);

        	world.setBlock(x+1, y, z, Blocks.RCFurnaceShellBase, 3, 2);
        	world.setBlock(x-1, y, z, Blocks.RCFurnaceShellBase, 4, 2);

        	world.setBlock(x-1, y, z-1, Blocks.RCFurnaceShellBase, 5, 2);
        	world.setBlock(x+1, y, z+1, Blocks.RCFurnaceShellBase, 6, 2);
        	
        	world.setBlock(x-1, y, z+1, Blocks.RCFurnaceShellBase, 7, 2);
        	world.setBlock(x+1, y, z-1, Blocks.RCFurnaceShellBase, 8, 2);
    //-----------------------------------------------------------------------------	
        	world.setBlock(x, y+1, z+1, Blocks.RCFurnaceShellMid, 1, 2);
        	world.setBlock(x, y+1, z-1, Blocks.RCFurnaceShellMid, 2 , 2);

        	world.setBlock(x+1, y+1, z, Blocks.RCFurnaceShellMid, 3, 2);
        	world.setBlock(x-1, y+1, z, Blocks.RCFurnaceShellMid, 4, 2);

        	world.setBlock(x-1, y+1, z-1, Blocks.RCFurnaceShellMid, 5, 2);
        	world.setBlock(x+1, y+1, z+1, Blocks.RCFurnaceShellMid, 6, 2);
        	
        	world.setBlock(x-1, y+1, z+1, Blocks.RCFurnaceShellMid, 7, 2);
        	world.setBlock(x+1, y+1, z-1, Blocks.RCFurnaceShellMid, 8, 2);
    //-----------------------------------------------------------------------------
        	world.setBlock(x, y+2, z+1, Blocks.RCFurnaceShellRoofLower, 2, 2);
        	world.setBlock(x, y+2, z-1, Blocks.RCFurnaceShellRoofLower, 3, 2);

        	world.setBlock(x+1, y+2, z, Blocks.RCFurnaceShellRoofLower, 4, 2);
        	world.setBlock(x-1, y+2, z, Blocks.RCFurnaceShellRoofLower, 5, 2);

        	world.setBlock(x-1, y+2, z-1, Blocks.RCFurnaceShellRoofLower, 6, 2);
        	world.setBlock(x+1, y+2, z+1, Blocks.RCFurnaceShellRoofLower, 7, 2);
        	
        	world.setBlock(x-1, y+2, z+1, Blocks.RCFurnaceShellRoofLower, 8, 2);
        	world.setBlock(x+1, y+2, z-1, Blocks.RCFurnaceShellRoofLower, 9, 2);
    //-----------------------------------------------------------------------------
        	world.setBlock(x, y+3, z+1, Blocks.RCFurnaceShellRoofUpper, 2, 2);
        	world.setBlock(x, y+3, z-1, Blocks.RCFurnaceShellRoofUpper, 3, 2);

        	world.setBlock(x+1, y+3, z, Blocks.RCFurnaceShellRoofUpper, 4, 2);
        	world.setBlock(x-1, y+3, z, Blocks.RCFurnaceShellRoofUpper, 5, 2);

        	world.setBlock(x-1, y+3, z-1, Blocks.RCFurnaceShellRoofUpper, 6, 2);
        	world.setBlock(x+1, y+3, z+1, Blocks.RCFurnaceShellRoofUpper, 7, 2);
        	
        	world.setBlock(x-1, y+3, z+1, Blocks.RCFurnaceShellRoofUpper, 8, 2);
        	world.setBlock(x+1, y+3, z-1, Blocks.RCFurnaceShellRoofUpper, 9, 2);
    	} else
    		world.setBlockToAir(x, y, z);
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) {
    	func_149930_e(world, x, y, z);
	}
    
    private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
    {
        if (!p_149930_1_.isRemote)
        {
            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
        }
    }

	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
		int rotation = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360F) + 0.5D) & 3;
	
		if(rotation == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
	
		if(rotation == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
	
		if(rotation == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
	
		if(rotation == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    public TileEntity createNewTileEntity(World par1World, int var2)
    {
        return new TileEntityFurnace1();
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
    	
        blockIcon = iconRegister.registerIcon("furnace_front_on");
    }
}
