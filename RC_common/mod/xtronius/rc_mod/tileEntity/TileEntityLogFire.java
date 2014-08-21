package mod.xtronius.rc_mod.tileEntity;

import java.util.Random;

import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketLogFire;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityLogFire extends TileEntity{
	
	private Random rand = new Random();
	
	private Block block;
	
	private int ticksActivated = 0;
	private float alpha = 1;
	private float fireScaleX = 1.0F;
	private float fireScaleY = 1.0F;
	private float fireScaleZ = 1.0F;
	
	public int burnTicks = 1200;
	
	public TileEntityLogFire() {
		super();
	}
	
	public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.setTicksActivated(compound.getInteger("ticksActivated"));
    }

    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("ticksActivated", this.getTicksActivated());
    }
	
	public void updateEntity()
    {
		if(this.getBlockType().equals(Blocks.LogFireActive)) {
			if(this.burnTicks == 1200 && this.getBlockMetadata() == 7)
				this.burnTicks = 6600;
			if((this.getTicksActivated() < burnTicks)) {
				this.setTicksActivated(ticksActivated + 1);
			} else {
				this.setTicksActivated(0);
				if(!this.getWorldObj().isRemote) {
					getWorldObj().setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
					
					ItemStack stack = new ItemStack(Item.getItemById(289), 1);
					
					EntityItem item = new EntityItem(getWorldObj(), (this.xCoord)+0.5, (this.yCoord)+0.4, (this.zCoord)+0.5, stack);
					
					item.motionX = 0;
					item.motionY = 0;
					item.motionZ = 0;
					
					getWorldObj().spawnEntityInWorld(item);
				}
				if(this.getWorldObj().isRemote) {
					for (int i = 0; i < 30; i++) {
	    		    	
			        	float f = 0;
			        	float f1 = 0;
			        	float f2 = 0;
			        	
				        f = (float)this.xCoord + 0.5F + rand.nextFloat() * 1F / 16.0F;
				        f1 = (float)this.yCoord + 0.175F;
				        f2 = (float)this.zCoord + 0.5F + rand.nextFloat() * 1F / 16.0F;
				        
				        getWorldObj().spawnParticle("smoke", (double)(f), (double)f1, (double)(f2), 0.0D, 0.D, 0.0D);
			            
	    			}
				}
			}
		}
    }
	
	public float getAlphaValue() { return alpha; }
	
	public void setAlphaValue(float alpha) { this.alpha = alpha; }
	
	public int getTicksActivated() { return ticksActivated; }
	
	public void setTicksActivated(int ticksActivated) { this.ticksActivated = ticksActivated; }
	
	public float getFireScaleX() { return fireScaleX; }

	public void setFireScaleX(float fireScaleX) { this.fireScaleX = fireScaleX; }

	public float getFireScaleY() { return fireScaleY; }

	public void setFireScaleY(float fireScaleY) { this.fireScaleY = fireScaleY; }

	public float getFireScaleZ() { return fireScaleZ; }

	public void setFireScaleZ(float fireScaleZ) { this.fireScaleZ = fireScaleZ; }
}
