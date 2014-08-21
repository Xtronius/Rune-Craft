package mod.xtronius.rc_mod.inventory;

import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.container.BankContainer;
import mod.xtronius.rc_mod.container.Furnace1Container;
import mod.xtronius.rc_mod.furnaceRecipies.RCCastFurnace1Recipes;
import mod.xtronius.rc_mod.furnaceRecipies.RCIngotFurnace1Recipes;
import mod.xtronius.rc_mod.handlers.RCTickHandler;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketBankTab;
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

public class InvBank implements IExtendedEntityProperties ,  IInventory {
   
	public BankContainer eventHandler;
    
    private ItemStack[] bankTab0ItemStacks = new ItemStack[468];
    private ItemStack[] bankTab1ItemStacks = new ItemStack[468];
    private ItemStack[] bankTab2ItemStacks = new ItemStack[468];
    private ItemStack[] bankTab3ItemStacks = new ItemStack[468];
    private ItemStack[] bankTab4ItemStacks = new ItemStack[468];
    private ItemStack[] bankTab5ItemStacks = new ItemStack[468];
    private ItemStack[] bankTab6ItemStacks = new ItemStack[468];
    private ItemStack[] bankTab7ItemStacks = new ItemStack[468];
    private ItemStack[] bankTab8ItemStacks = new ItemStack[468];
    
    public int currentSelectedTab = 0;
    private int currentTopRow = 0;

    public InvBank(Container container) { 
    	this.eventHandler = (BankContainer) container; 
    }
   
    public ItemStack[] getIndexedStackArray(int id) {
	   switch(id) {
		   case 0: return bankTab0ItemStacks;
		   case 1: return bankTab1ItemStacks;
		   case 2: return bankTab2ItemStacks;
		   case 3: return bankTab3ItemStacks;
		   case 4: return bankTab4ItemStacks;
		   case 5: return bankTab5ItemStacks;
		   case 6: return bankTab6ItemStacks;
		   case 7: return bankTab7ItemStacks;
		   case 8: return bankTab8ItemStacks;
	   default: System.out.println("[Rune-Craft][Mod-Error] MethodName: getStacksWithInt Error: variable id is null"); return bankTab0ItemStacks;
	   }
    }

    public int getSizeInventory() { return 468; }

    public ItemStack getStackInSlot(int slotIndex) { return this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex]; }
    
    public ItemStack getStackInSlot(int arrayIndex, int slotIndex) { return this.getIndexedStackArray(arrayIndex)[slotIndex]; }

    public String getInvName() { return "container.bank"; }

    public boolean isInvNameLocalized() { return false; }

    public ItemStack getStackInSlotOnClosing(int slotIndex) {
        if (this.getIndexedStackArray(this.currentSelectedTab) != null) return this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex]; return null; }
    
    public ItemStack decrStackSize(int slotIndex, int par2) {
        if (this.getIndexedStackArray(this.currentSelectedTab) != null) {
            ItemStack itemstack;

            if (this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex].stackSize <= par2) {
                itemstack = this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex];
                this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                return itemstack;
            }
            else {
                itemstack = this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex].splitStack(par2);

                if (this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex].stackSize == 0) {
                	this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex] = null;
                }

                this.eventHandler.onCraftMatrixChanged(this);
                return itemstack;
            }
        }
		return null;
    }
    
    public boolean hasInvSpace() {
    	
    	int result = 0;
	
		for(int i = 0; i < this.bankTab0ItemStacks.length; i++) 
    		if(this.bankTab0ItemStacks[i] != null) result ++;
    	
    	for(int i = 0; i < this.bankTab1ItemStacks.length; i++) 
    		if(this.bankTab1ItemStacks[i] != null) result ++;
    	
    	for(int i = 0; i < this.bankTab2ItemStacks.length; i++) 
    		if(this.bankTab2ItemStacks[i] != null) result ++;
    	
    	for(int i = 0; i < this.bankTab3ItemStacks.length; i++) 
    		if(this.bankTab3ItemStacks[i] != null) result ++;
    	
    	for(int i = 0; i < this.bankTab4ItemStacks.length; i++) 
    		if(this.bankTab4ItemStacks[i] != null) result ++;
    	
    	for(int i = 0; i < this.bankTab5ItemStacks.length; i++) 
    		if(this.bankTab5ItemStacks[i] != null) result ++;
    	
    	for(int i = 0; i < this.bankTab6ItemStacks.length; i++) 
    		if(this.bankTab6ItemStacks[i] != null) result ++;
    	
    	for(int i = 0; i < this.bankTab7ItemStacks.length; i++) 
    		if(this.bankTab7ItemStacks[i] != null) result ++;
    	
    	for(int i = 0; i < this.bankTab8ItemStacks.length; i++) 
    		if(this.bankTab8ItemStacks[i] != null) result ++;
    	
		if(result < 468) return true;
		
		return false;
    }

    public void setInventorySlotContents(int slotIndex, ItemStack stack) {
    	if(hasInvSpace()) this.getIndexedStackArray(this.currentSelectedTab)[(this.getCurrentTopRow() * 13) + slotIndex] = stack;
    }
    
    public void setInventorySlotContents(int bankItemStackIndex, int slotIndex, ItemStack stack) {
    	this.getIndexedStackArray(bankItemStackIndex)[slotIndex] = stack;
    }

    public int getInventoryStackLimit() { return 127; }

    public void onInventoryChanged() {}

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) { return true; }

    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) { return true; }

   @Override
   public void saveNBTData(NBTTagCompound compound) {
	   for(int i = 0; i < 100; i++) {
		   System.out.println("Saving");
	   }
   }

   @Override
   public void loadNBTData(NBTTagCompound compound) {
	   for(int i = 0; i < 100; i++) {
		   System.out.println("Saving");
	   }
   }

   @Override
   public void init(Entity entity, World world) {
   
   }

	@Override
	public String getInventoryName() { return this.getInvName(); }
	
	@Override
	public boolean hasCustomInventoryName() { return false; }
	
	@Override
	public void markDirty() {}
	
	@Override
	public void openInventory() {}
	
	@Override
	public void closeInventory() {}
	
	public int getCurrentTopRow() { return currentTopRow; }

	public void setCurrentTopRow(int currentTopRow) { this.currentTopRow = currentTopRow; }
	
	public int getCurrentSelectedTab() { return this.currentSelectedTab; }

	public void setCurrentSelectedTab(int currentSelectedTab) { this.currentSelectedTab = currentSelectedTab; }
}