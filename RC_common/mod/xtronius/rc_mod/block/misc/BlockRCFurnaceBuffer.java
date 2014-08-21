package mod.xtronius.rc_mod.block.misc;

import java.util.List;
import java.util.Random;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.Misc.IDs.MiscIDs;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.creativetab.CreativeTab;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.PacketWoodCuttingLvl;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRCFurnaceBuffer extends BlockGlass
{
	private int furnaceXCoord;
	private int furnaceYCoord;
	private int furnaceZCoord;
	
    public BlockRCFurnaceBuffer(int id)
    {
        super(Material.rock, false);
        
        this.setLightOpacity(0);
    }
    
    public int getFurnaceXCoord() {
    	return this.furnaceXCoord;
    }
    public int getFurnaceYCoord() {
    	return this.furnaceYCoord;
    }
    public int getFurnaceZCoord() {
    	return this.furnaceZCoord;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
    	int x1;
    	int y1;
    	int z1;
    	
    	if(this.findFurnace(world, x, y, z) == Blocks.RCFurnace) {
    		x1 = this.furnaceXCoord;
    		y1 = this.furnaceYCoord;
    		z1 = this.furnaceZCoord;
    		
    		world.setBlock(x1, y1+1, z1, Block.getBlockById(0));
        	world.setBlock(x1, y1+2, z1, Block.getBlockById(0));
        	world.setBlock(x1, y1+3, z1, Block.getBlockById(0));
    //-----------------------------------------------------------------------------
        	
        	world.setBlock(x1, y1, z1+1, Block.getBlockById(0));
        	world.setBlock(x1, y1, z1-1, Block.getBlockById(0));

        	world.setBlock(x1+1, y1, z1, Block.getBlockById(0));
        	world.setBlock(x1-1, y1, z1, Block.getBlockById(0));

        	world.setBlock(x1-1, y1, z1-1, Block.getBlockById(0));
        	world.setBlock(x1+1, y1, z1+1, Block.getBlockById(0));
        	
        	world.setBlock(x1-1, y1, z1+1, Block.getBlockById(0));
        	world.setBlock(x1+1, y1, z1-1, Block.getBlockById(0));
    //-----------------------------------------------------------------------------	
        	world.setBlock(x1, y1+1, z1+1, Block.getBlockById(0));
        	world.setBlock(x1, y1+1, z1-1, Block.getBlockById(0));

        	world.setBlock(x1+1, y1+1, z1, Block.getBlockById(0));
        	world.setBlock(x1-1, y1+1, z1, Block.getBlockById(0));

        	world.setBlock(x1-1, y1+1, z1-1, Block.getBlockById(0));
        	world.setBlock(x1+1, y1+1, z1+1, Block.getBlockById(0));
        	
        	world.setBlock(x1-1, y1+1, z1+1, Block.getBlockById(0));
        	world.setBlock(x1+1, y1+1, z1-1, Block.getBlockById(0));
    //-----------------------------------------------------------------------------
        	world.setBlock(x1, y1+2, z1+1, Block.getBlockById(0));
        	world.setBlock(x1, y1+2, z1-1, Block.getBlockById(0));

        	world.setBlock(x1+1, y1+2, z1, Block.getBlockById(0));
        	world.setBlock(x1-1, y1+2, z1, Block.getBlockById(0));

        	world.setBlock(x1-1, y1+2, z1-1, Block.getBlockById(0));
        	world.setBlock(x1+1, y1+2, z1+1, Block.getBlockById(0));
        	
        	world.setBlock(x1-1, y1+2, z1+1, Block.getBlockById(0));
        	world.setBlock(x1+1, y1+2, z1-1, Block.getBlockById(0));
    //-----------------------------------------------------------------------------
        	world.setBlock(x1, y1+3, z1+1, Block.getBlockById(0));
        	world.setBlock(x1, y1+3, z1-1, Block.getBlockById(0));

        	world.setBlock(x1+1, y1+3, z1, Block.getBlockById(0));
        	world.setBlock(x1-1, y1+3, z1, Block.getBlockById(0));

        	world.setBlock(x1-1, y1+3, z1-1, Block.getBlockById(0));
        	world.setBlock(x1+1, y1+3, z1+1, Block.getBlockById(0));
        	
        	world.setBlock(x1-1, y1+3, z1+1, Block.getBlockById(0));
        	world.setBlock(x1+1, y1+3, z1-1, Block.getBlockById(0));
        	
        	world.setBlock(x1,  y1,  z1, Block.getBlockById(0));
    	}
    }
    
    private Block findFurnace(World world, int x, int y, int z) {
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 4; j++) {
    			for(int k = 0; k < 3; k++) {
    				if(world.getBlock(x+i, y-j, z+k) == Blocks.RCFurnace) {
    					this.furnaceXCoord = x+i;
    					this.furnaceYCoord = y-j;
    					this.furnaceZCoord = z+k;
    					return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    				} else if(world.getBlock(x-i, y-j, z-k) == Blocks.RCFurnace) {
    					this.furnaceXCoord = x-i;
    					this.furnaceYCoord = y-j;
    					this.furnaceZCoord = z-k;
    					return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    				} else if(world.getBlock(x+i, y-j, z-k) == Blocks.RCFurnace) {
    					this.furnaceXCoord = x+i;
    					this.furnaceYCoord = y-j;
    					this.furnaceZCoord = z-k;
    					return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    				} else if(world.getBlock(x-i, y-j, z+k) == Blocks.RCFurnace) {
    					this.furnaceXCoord = x-i;
    					this.furnaceYCoord = y-j;
    					this.furnaceZCoord = z+k;
    					return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    				} else if(world.getBlock(x+i, y+j, z+k) == Blocks.RCFurnace) {
    					this.furnaceXCoord = x+i;
    					this.furnaceYCoord = y-j;
    					this.furnaceZCoord = z+k;
    					return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    				} else if(world.getBlock(x-i, y+j, z-k) == Blocks.RCFurnace) {
    					this.furnaceXCoord = x-i;
    					this.furnaceYCoord = y-j;
    					this.furnaceZCoord = z-k;
    					return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    				} else if(world.getBlock(x+i, y+j, z-k) == Blocks.RCFurnace) {
    					this.furnaceXCoord = x+i;
    					this.furnaceYCoord = y-j;
    					this.furnaceZCoord = z-k;
    					return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    				} else if(world.getBlock(x-i, y+j, z+k) == Blocks.RCFurnace) {
    					this.furnaceXCoord = x-i;
    					this.furnaceYCoord = y-j;
    					this.furnaceZCoord = z+k;
    					return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    				}
    			}
    		}
    	}
    	if(world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord) == Blocks.RCFurnace) {
    		return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    	} else {
    		return world.getBlock(this.furnaceXCoord, this.furnaceYCoord, this.furnaceZCoord);
    	}
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
    	
    	Block block = world.getBlock(x, y, z);
    	int meta = world.getBlockMetadata(x, y, z);
    	
    	if(block == Blocks.RCFurnaceShellBase) {
    		switch(meta) {
    		case 1: this.setBlockBounds(-1, 0, -2, 2, 3.4F, 1); break;
    		case 2: this.setBlockBounds(-1, 0, 0, 2, 3.4F, 3); break;
    		case 3: this.setBlockBounds(-2, 0, -1, 1, 3.4F, 2); break;
    		case 4: this.setBlockBounds(0, 0, -1, 3, 3.4F, 2); break;
    		case 5: this.setBlockBounds(0, 0, 0, 3, 3.4F, 3); break;
    		case 6: this.setBlockBounds(-2, 0, -2, 1, 3.4F, 1); break;
    		case 7: this.setBlockBounds(0, 0, -2, 3, 3.4F, 1); break;
    		case 8: this.setBlockBounds(-2, 0, 0, 1, 3.4F, 3); break;
    		}
    	} else
    		
    	if(block == Blocks.RCFurnaceShellMid) {
    	    switch(meta) {
    	    case 1: this.setBlockBounds(-1, -1, -2, 2, 2.4F, 1); break;
    		case 2: this.setBlockBounds(-1, -1, 0, 2, 2.4F, 3); break;
    		case 3: this.setBlockBounds(-2, -1, -1, 1, 2.4F, 2); break;
    		case 4: this.setBlockBounds(0, -1, -1, 3, 2.4F, 2); break;
    		case 5: this.setBlockBounds(0, -1, 0, 3, 2.4F, 3); break;
    		case 6: this.setBlockBounds(-2, -1, -2, 1, 2.4F, 1); break;
    		case 7: this.setBlockBounds(0, -1, -2, 3, 2.4F, 1); break;
    		case 8: this.setBlockBounds(-2, -1, 0, 1, 2.4F, 3); break;
    		}
    	} else
    		
    	if(block == Blocks.RCFurnaceShellRoofLower) {
    		switch(meta) {
    		case 2: this.setBlockBounds(-1, -2, -2, 2, 1.4F, 1); break;
    		case 3: this.setBlockBounds(-1, -2, 0, 2, 1.4F, 3); break;
    		case 4: this.setBlockBounds(-2, -2, -1, 1, 1.4F, 2); break;
    		case 5: this.setBlockBounds(0, -2, -1, 3, 1.4F, 2); break;
    		case 6: this.setBlockBounds(0, -2, 0, 3, 1.4F, 3); break;
    		case 7: this.setBlockBounds(-2, -2, -2, 1, 1.4F, 1); break;
    		case 8: this.setBlockBounds(0, -2, -2, 3, 1.4F, 1); break;
    		case 9: this.setBlockBounds(-2, -2, 0, 1, 1.4F, 3); break;
    		}
    	} else
    		
    	if(block == Blocks.RCFurnaceShellRoofUpper) {
    		switch(meta) {
    		case 1: this.setBlockBounds(-1, -3, -1, 2, 0.4F, 2); break;
    		case 2: this.setBlockBounds(-1, -3, -2, 2, 0.4F, 1); break;
    		case 3: this.setBlockBounds(-1, -3, 0, 2, 0.4F, 3); break;
    		case 4: this.setBlockBounds(-2, -3, -1, 1, 0.4F, 2); break;
    		case 5: this.setBlockBounds(0, -3, -1, 3, 0.4F, 2); break;
    		case 6: this.setBlockBounds(0, -3, 0, 3, 0.4F, 3); break;
    		case 7: this.setBlockBounds(-2, -3, -2, 1, 0.4F, 1); break;
    		case 8: this.setBlockBounds(0, -3, -2, 3, 0.4F, 1); break;
    		case 9: this.setBlockBounds(-2, -3, 0, 1, 0.4F, 3); break;
    		}
    	} else
    	
    	this.setBlockBounds(0, 0, 0, 1, 1, 1);
    }
    
    public int getRenderType()
    {
        return -1;
    }
   
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    

    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {}
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	if(world.isRemote)
	    	return true;
	    else {
	    	
	    	
	    	if(player.isSneaking()) {
    	    	return true;
    	    } else {
		    	FMLNetworkHandler.openGui(player, rc_mod.instance, MiscIDs.BankGuiID, world, x, y, z);
		    	return true;
    	    }
	    }  
    }
    
    private boolean isValidBlock(Block block) { if(block == Blocks.RCFurnace || block == Blocks.RCFurnaceShellBase || block == Blocks.RCFurnaceShellMid || block == Blocks.RCFurnaceShellItemRender || block == Blocks.RCFurnaceShellRoofLower || block == Blocks.RCFurnaceShellRoofUpper || block == Blocks.RCFurnaceShellMisc) { return true; } return false; }
    
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
    	for (int i = 0; i < 20; i++) {
	    	if(this.equals(Blocks.RCFurnaceShellRoofUpper)) {
		    	int l = world.getBlockMetadata(x, y, z);
		    	
		        if (l == 1)
		        {
		        	int rand1 = rand.nextInt(4);
		        	float f = 0;
		        	float f1 = 0;
		        	float f2 = 0;
		        	
		        	if(rand1 == 0) {
		        		
			            f = (float)x + 0.5F + rand.nextFloat() * 10F / 16.0F;
			            f1 = (float)y + 0.4F;
			            f2 = (float)z + 0.5F + rand.nextFloat() * 10F / 16.0F;
		        	} else if(rand1 == 1){
		        		
		        		f = (float)x + 0.5F - rand.nextFloat() * 10F / 16.0F;
			            f1 = (float)y + 0.4F;
			            f2 = (float)z + 0.5F - rand.nextFloat() * 10F / 16.0F; 
		        	} else if(rand1 == 2){
		        		
		        		f = (float)x + 0.5F + rand.nextFloat() * 10F / 16.0F;
			            f1 = (float)y + 0.4F;
			            f2 = (float)z + 0.5F - rand.nextFloat() * 10F / 16.0F; 
		        	} else if(rand1 == 3){
		        		
		        		f = (float)x + 0.5F - rand.nextFloat() * 10F / 16.0F;
			            f1 = (float)y + 0.4F;
			            f2 = (float)z + 0.5F + rand.nextFloat() * 10F / 16.0F; 
		        	}
		
		            world.spawnParticle("smoke", (double)(f), (double)f1, (double)(f2), 0.0D, 0.D, 0.0D);
		            //world.spawnParticle("flame", (double)(f), (double)f1, (double)(f2), 0.0D, 0.0D, 0.0D);
	
		        }
		    }
    	}
    }
}
