package mod.xtronius.rc_mod.block.misc;

import java.util.Random;

import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.Misc.IDs.MiscIDs;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.creativetab.CreativeTab;
import mod.xtronius.rc_mod.handlers.LevelManager;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.lib.LogInfo;
import mod.xtronius.rc_mod.packetHandling.main.ChannelHandler;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketLogFire;
import mod.xtronius.rc_mod.tileEntity.TileEntityFurnace1;
import mod.xtronius.rc_mod.tileEntity.TileEntityLogFire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;


public class BlockLogFire extends BlockContainer
{
	private boolean isActive;
	private boolean hasIntitRender = false;
	private boolean renderLogFire = false;
	
	private LogInfo logInfo = new LogInfo();
	
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
    public BlockLogFire(boolean isActive, int id)
    {
        super(Material.wood);
        this.setLightOpacity(0);
        this.isActive = isActive;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public int getRenderType()
    {
    	if(!hasIntitRender) {
	        if(rc_mod.playerSettings.settings.getPlayerSettingsValues("RenderRCFire", "boolean").equals(true)) {
	        	this.hasIntitRender = true;
	        	this.renderLogFire = true;
	        } else 
	        this.hasIntitRender = true;
	       } 
	        
        if(this.renderLogFire == true) {
        	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
        	return -1;
        } else {
        	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        	return 0;
        }
    }
   
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.iconArray = new IIcon[] {par1IconRegister.registerIcon(this.getTextureName() + "_layer_0"), par1IconRegister.registerIcon(this.getTextureName() + "_layer_1")};
    }

    @SideOnly(Side.CLIENT)
    public IIcon getFireIcon(int par1)
    {
        return this.iconArray[par1];
    }

    @SideOnly(Side.CLIENT)

    public IIcon getIcon(int par1, int par2)
    {
        return this.iconArray[0];
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    
    public TileEntity createNewTileEntity(World world, int var1)
    {
        return new TileEntityLogFire();
    }
    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4);
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	
    	if(!this.isActive) {
    		ExtendedPlayer props = ExtendedPlayer.get(player);
	    	if(props != null && player.inventory != null && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() != null && logInfo.logLvlReq.get(world.getBlockMetadata(x, y, z)) != null && this.logInfo.logExp.get(world.getBlockMetadata(x, y, z)) != null) {
	    		if(player.inventory.getCurrentItem().getItem().equals(Item.getItemById(259)) && props.getLvl("FireMaking") >= logInfo.logLvlReq.get(world.getBlockMetadata(x, y, z))) {
	    			world.setBlock(x, y, z, Blocks.LogFireActive, world.getBlockMetadata(x, y, z), 2);
	    			LevelManager.addFireMaking(player, this.logInfo.logExp.get(world.getBlockMetadata(x, y, z)));
				    return true;
	    		}
	    	}
    	}
    	return false;
    }
    
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
    	if(world.isRemote) {
	    	if(world.getTileEntity(x, y, z) != null) {
	    		TileEntityLogFire entity = (TileEntityLogFire)world.getTileEntity(x, y, z);
	    		if(this.isActive) {
	    			for (int i = 0; i < 20; i++) {
	    		    	
			        	float f = 0;
			        	float f1 = 0;
			        	float f2 = 0;
			        	
				        f = (float)x + 0.5F + rand.nextFloat() * 1F / 16.0F;
				        f1 = (float)y + 0.175F;
				        f2 = (float)z + 0.5F + rand.nextFloat() * 1F / 16.0F;
				        
			            world.spawnParticle("smoke", (double)(f), (double)f1, (double)(f2), 0.0D, 0.D, 0.0D);
			            
	    			}
	    		}
	    	}
	    }
    }
 }

