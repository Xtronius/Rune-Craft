package mod.xtronius.rc_mod.container;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.furnaceRecipies.RCCastFurnace1Recipes;
import mod.xtronius.rc_mod.furnaceRecipies.RCIngotFurnace1Recipes;
import mod.xtronius.rc_mod.inventory.InvFurnace1;
import mod.xtronius.rc_mod.tileEntity.slot.SlotFurnace1;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Furnace1Container extends Container
{
	public InvFurnace1 invFurnace;
   	public int furnaceCookTime;
   	private int itemTotalCookTime = 0;
    private int lastCookTime;
    private World worldObj;
    private ICrafting crafter;
    private int xPos;
    private int yPos;
    private int zPos;
    
    private Item itemToBeSmelted;
    private boolean hasItemBeenSmelted = false;
    public boolean hasBeenUpdated = true;
    
    public boolean isClosed = true;
    public int counter = 0;
    
    public static final int SMELT_INGOT = 0;
    public static final int SMELT_CAST = 1;
    public static int  SMELT_TYPE;

    public Furnace1Container(InventoryPlayer playerInv, World world, int x, int y, int z)
    {
       this.invFurnace = new InvFurnace1(this, world, playerInv.player, x, y, z);
       
       this.worldObj = world;
       this.xPos = x;
       this.yPos = y;
       this.xPos = z;
       
        this.addSlotToContainer(new Slot(this.invFurnace, 0, 60, 110));
        this.addSlotToContainer(new Slot(this.invFurnace, 1, 88, 110));
        this.addSlotToContainer(new SlotFurnace1(playerInv.player, this.invFurnace, 2, 156, 110));
        
        byte b0 = 36;
        short short1 = 137;
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, b0 + j * 18, short1 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(playerInv, i, b0 + i * 18, 58 + short1));
        }
    }
    public Item getItemToBeSmelted() {
      if(this.itemToBeSmelted != null)
         return itemToBeSmelted;
      else return Item.getItemById(262);
   }
   
   public void setItemToBeSmelted(Item item) {
      if(item != null)
      this.itemToBeSmelted = item;
   }
    public InvFurnace1 getInv() {
       return this.invFurnace;
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
    	this.crafter = par1ICrafting;
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.furnaceCookTime);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.furnaceCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnaceCookTime);
            }
        }

        this.lastCookTime = this.furnaceCookTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.furnaceCookTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.invFurnace.isUseableByPlayer(par1EntityPlayer);
    }
    
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        this.removeCraftingFromCrafters(crafter);
        this.isClosed = true;
//
//        if (!player.worldObj.isRemote)
//        {
//            for (int i = 0; i < 3; ++i)
//            {
//                ItemStack itemstack = this.invFurnace.getStackInSlotOnClosing(i);
//
//                if (itemstack != null)
//                {
//                    player.dropPlayerItem(itemstack);
//                }
//            }
//            this.tickHandler.furnace1ContainerMapSERVER.remove(player);
//        } else
//        	this.tickHandler.furnace1ContainerMapCLIENT.remove(player);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot == null && !slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            return null;
        }
        return null;
    }
    
    public boolean hasValidStackInSlots() {
      
      for (int i = 0; i < 3; i++) {
         if(this.invFurnace.getStackInSlot(i) != null) {
        	 ItemStack itemstack = RCIngotFurnace1Recipes.smelting().getSmeltingResult(this.invFurnace.getStackInSlot(0));
        	 ItemStack itemstack2 = RCIngotFurnace1Recipes.smelting().getSmeltingResult(this.invFurnace.getStackInSlot(1));
        	 if(itemstack != null || itemstack2 != null)
        		 return true;
        	 else
        		 return false;
         }
      }
      return false;
   }
    public boolean hasStackInSlots() {
        
        for (int i = 0; i < 3; i++) {
           if(this.invFurnace.getStackInSlot(i) != null) 
          		 return true;
        }
        return false;
     }
    
    
    public int getCookProgressScaled(int par1)
    {
        return this.furnaceCookTime * par1 / 200;
    }
    
    public ItemStack getSmeltResult() {
    	ItemStack itemstack = RCIngotFurnace1Recipes.smelting().getSmeltingResult(this.invFurnace.getStackInSlot(0));
    	return canSmelt() ? itemstack : null;
    }
    
    private boolean canSmelt()
    {   
        if (this.invFurnace.getStackInSlot(0) == null)
        {
            return false;
        }
        else
        {
           ItemStack itemstack = RCIngotFurnace1Recipes.smelting().getSmeltingResult(this.invFurnace.getStackInSlot(0));
          ItemStack itemstack2 = RCCastFurnace1Recipes.smelting().getSmeltingResult(this.invFurnace.getStackInSlot(1));
           
           if (this.invFurnace.getStackInSlot(0) != null && this.invFurnace.getStackInSlot(1) == null) {
              SMELT_TYPE = SMELT_INGOT;
           }
           
           if (this.invFurnace.getStackInSlot(0) != null && this.invFurnace.getStackInSlot(1) != null) {
              SMELT_TYPE = SMELT_CAST;
           }

           if (SMELT_TYPE == SMELT_INGOT) {
              if (itemstack != null) {
                   if (this.invFurnace.getStackInSlot(2) != null && this.invFurnace.getStackInSlot(2).isItemEqual(itemstack)) {
                      int result = this.invFurnace.getStackInSlot(2).stackSize + itemstack.stackSize;
                      return (result <= this.invFurnace.getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
                   } else if(this.invFurnace.getStackInSlot(2) == null){
                      return true;
                   }
              }
           }
           else if (SMELT_TYPE == SMELT_CAST) {
              
              if(itemstack != null && itemstack2 != null) {
                 
                 if(itemstack == itemstack2) {
                    if (this.invFurnace.getStackInSlot(2) == null) return true;
                       if (!this.invFurnace.getStackInSlot(2).isItemEqual(itemstack)) return false;
                       int result = this.invFurnace.getStackInSlot(2).stackSize + itemstack.stackSize;
                       return (result <= this.invFurnace.getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
                  }
                  else if(itemstack != itemstack){
                     if (this.invFurnace.getStackInSlot(2) == null) return true;
                        if (!this.invFurnace.getStackInSlot(2).isItemEqual(itemstack)) return false;
                        int result = this.invFurnace.getStackInSlot(20).stackSize + itemstack.stackSize;
                        return (result <= this.invFurnace.getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
                  }
              }
           }
        }
      return false;
    }

    public void smeltItem(EntityPlayer player, String type)
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.invFurnace.getStackInSlotOnClosing(0));

            this.setItemToBeSmelted(itemstack.getItem());
            
//            if (this.furnaceItemStacks[2] == null)
//            {
//                this.furnaceItemStacks[2] = itemstack.copy();
//            }
//            else if (this.furnaceItemStacks[2].isItemEqual(itemstack))
//            {
//                furnaceItemStacks[2].stackSize += itemstack.stackSize;
//            }
            
            if(!(player.inventory.getFirstEmptyStack() < 0)) {
               if(player != null && player.inventory != null && player.inventory.getStackInSlot(player.inventory.getFirstEmptyStack()) == null) {
                      player.inventory.addItemStackToInventory(itemstack.copy());
                      this.invFurnace.setInventorySlotContents(0, null);
                      this.onCraftMatrixChanged(this.invFurnace);
                      this.update(player, type);
               } 
               else {
                  this.invFurnace.setInventorySlotContents(2, itemstack.copy());
                  this.onCraftMatrixChanged(this.invFurnace);
                  this.update(player, type);
               }
            }
            else if (player.inventory.getFirstEmptyStack() < 0) {
               if(this.invFurnace.getStackInSlot(2) == null) {
                  this.invFurnace.setInventorySlotContents(2, itemstack.copy());
                  this.onCraftMatrixChanged(this.invFurnace);
                  this.update(player, type);
               }
            }
        }
    }
    
    public void update(EntityPlayer player, String type) {
    	
    	if(type == "SERVER") {
    	
	       if(this.invFurnace.getStackInSlot(2) != null && !(player.inventory.getFirstEmptyStack() < 0)) {
	          if(player != null && player.inventory != null && player.inventory.getStackInSlot(player.inventory.getFirstEmptyStack()) == null) {
	                player.inventory.addItemStackToInventory(this.invFurnace.getStackInSlot(2).copy());
	                 this.invFurnace.setInventorySlotContents(2, null);
	          }
	       }
	        boolean flag = false;
	
	            if (this.canSmelt() && !(player.inventory.getFirstEmptyStack() < 0))
	            {
	                ++this.furnaceCookTime;
	
	                if (this.furnaceCookTime == 100)
	                {
	                    this.furnaceCookTime = 0;
	                    this.smeltItem(player, type);
	                    flag = true;
	                }
	            }
	            else
	                this.furnaceCookTime = 0;
	            
	            if(flag)
	               this.hasItemBeenSmelted = true;
	            this.hasBeenUpdated = false;
	    }
    	else if(type == "CLIENT") {
    		
    	}
    }
}