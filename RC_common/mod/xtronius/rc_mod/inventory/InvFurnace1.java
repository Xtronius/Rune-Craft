package mod.xtronius.rc_mod.inventory;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.container.Furnace1Container;
import mod.xtronius.rc_mod.furnaceRecipies.RCCastFurnace1Recipes;
import mod.xtronius.rc_mod.furnaceRecipies.RCIngotFurnace1Recipes;
import mod.xtronius.rc_mod.handlers.RCTickHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class InvFurnace1 implements IExtendedEntityProperties ,  IInventory
{
   
   private Furnace1Container eventHandler;
   private World worldObj;
   private EntityPlayer player;
   private String type = "SERVER";
      
   private static final int[] slots_side_left= new int[] {0};
    private static final int[] slots_mid = new int[] {1};
    private static final int[] slots_side_right = new int[] {2};
    
    private RCTickHandler tick = RCTickHandler.intance;
    
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    
   public InvFurnace1(Container container, World world, EntityPlayer player, int x, int y, int z) {
      this.worldObj = world;
	   
	   if(world.isRemote)
		   tick.furnace1ContainerMapCLIENT.put(player, (Furnace1Container) container);
	   else if(!world.isRemote)
		   tick.furnace1ContainerMapSERVER.put(player, (Furnace1Container) container);
      this.eventHandler = (Furnace1Container) container;
   }
   
   /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return par1 >= this.getSizeInventory() ? null : this.furnaceItemStacks[par1];
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.furnace";
    }

    /**
     * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
     * language. Otherwise it will be used directly.
     */
    public boolean isInvNameLocalized()
    {
        return false;
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack itemstack = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            
            	if(this.worldObj.isRemote) {
            		this.eventHandler.update(player, "CLIENT");
            	} else if(!this.worldObj.isRemote) {
            		this.eventHandler.update(player, "SERVER");
            	}
            return itemstack;
        }
        else
        {
            	if(this.worldObj.isRemote) {
            		this.eventHandler.update(player, "CLIENT");
            	} else if(!this.worldObj.isRemote) {
            		this.eventHandler.update(player, "SERVER");
            	}
            return null;
        }
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
    	if(this.worldObj.isRemote) {
    		type = "CLIENT";
    	}
    	
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.furnaceItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.furnaceItemStacks[par1];
                this.furnaceItemStacks[par1] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                this.eventHandler.update(player, type);
                return itemstack;
            }
            else
            {
                itemstack = this.furnaceItemStacks[par1].splitStack(par2);

                if (this.furnaceItemStacks[par1].stackSize == 0)
                {
                    this.furnaceItemStacks[par1] = null;
                }

                this.eventHandler.onCraftMatrixChanged(this);
                this.eventHandler.update(player, type);
                return itemstack;
            }
        }
        else
        {
        	this.eventHandler.update(player, type);
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.furnaceItemStacks[par1] = par2ItemStack;
        this.eventHandler.onCraftMatrixChanged(this);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 1;
    }

    /**
     * Called when an the contents of an Inventory change, usually
     */
    public void onInventoryChanged() {}

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return true;
    }

   @Override
   public void saveNBTData(NBTTagCompound compound) {
   
   }

   @Override
   public void loadNBTData(NBTTagCompound compound) {

   }

   @Override
   public void init(Entity entity, World world) {
   
   }

@Override
public String getInventoryName() {
	// TODO Auto-generated method stub
	return this.getInvName();
}

@Override
public boolean hasCustomInventoryName() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void markDirty() {
	// TODO Auto-generated method stub
	
}

@Override
public void openInventory() {
	// TODO Auto-generated method stub
	
}

@Override
public void closeInventory() {
	// TODO Auto-generated method stub
	
}
}