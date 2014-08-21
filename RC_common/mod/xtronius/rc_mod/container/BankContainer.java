package mod.xtronius.rc_mod.container;

import mod.xtronius.rc_mod.inventory.InvBank;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.tileEntity.slot.SlotBank;
import mod.xtronius.rc_mod.tileEntity.slot.SlotFurnace1;
import mod.xtronius.rc_mod.tileEntity.slot.SlotGhost;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BankContainer extends Container
{
	public InvBank invBank;
	private final EntityPlayer player;
    private ICrafting crafter;
    public ItemStack[] ItemDisplay = new ItemStack[8];

    public BankContainer(InventoryPlayer playerInv, World world, int x, int y, int z) {
    	
       this.invBank = new InvBank(this);
       this.player = playerInv.player;
       
       /* Slot Init **/
       
       int slotIndex = 0;
       byte slotSize = 18;
       short xOffset = 6;
       short xOffset1 = 198;
       short yOffset = 12;
       short yoffset1 = 143;
       
       /* Bank Slots**/
       
       for(int column = 0; column < 13; column++) 
    	   for(int row = 0; row < 6; row++) {
    		   this.addSlotToContainer(new SlotBank(this.getInv(), column + row * 13, slotSize * column + xOffset, slotSize * row + yOffset));
    		   slotIndex++;
    	   }
        
        /* Inv Slots**/
        
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlotToContainer(new Slot(playerInv, column + row * 9 + 9, column * slotSize + xOffset, row * slotSize + yoffset1));
            }
        }
        /* Hot-Bar Slots**/
        
        for (int row  = 0; row < 9; ++row) {
            this.addSlotToContainer(new Slot(playerInv, row, row * slotSize + xOffset, 198));
        }
        /* Armor Slots 1 Column**/
        
        int i = 0;
        for (i = 0; i < 4; ++i) {
            final int k = i;
            int yOS;
            
            if(k == 0) yOS = 126;
            else if(k == 1) yOS = 162;
            else if(k == 2) yOS = 180;
            else yOS = 198;
            
            this.addSlotToContainer(new Slot(playerInv, playerInv.getSizeInventory() - 1 - i, 169, yOS) {
                
                public int getSlotStackLimit() { return 1; }
                public boolean isItemValid(ItemStack par1ItemStack) { if (par1ItemStack == null) return false; return par1ItemStack.getItem().isValidArmor(par1ItemStack, k, player);}
                
                @SideOnly(Side.CLIENT)
                public IIcon getBackgroundIconIndex() { return ItemArmor.func_94602_b(k); }
            });
        }
    }
    
    public InvBank getInv() { return this.getInv(); }

    public void addCraftingToCrafters(ICrafting par1ICrafting) {
    	this.crafter = par1ICrafting;
        super.addCraftingToCrafters(par1ICrafting);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2) {}

    public boolean canInteractWith(EntityPlayer par1EntityPlayer) { return true; }
    
    public void onContainerClosed(EntityPlayer player) {
    	if(!player.worldObj.isRemote)
    		saveInventoryToPlayer(player);
        super.onContainerClosed(player);
        this.removeCraftingFromCrafters(crafter);
    }
    
    private void saveInventoryToPlayer(EntityPlayer player) {
    	
    	ExtendedPlayer props = ExtendedPlayer.get(player);
    	
    	if(props != null) {
	    	for(int i = 0; i < 468; i++) {

//	    		if(this.getInv().bankTab0ItemStacks[i] != null)
	    			props.playerBankStorage[i] = this.getInv().getStackInSlot(0, i);
	    	    	
//	    		if(this.getInv().bankTab1ItemStacks[i] != null)
	    			props.playerBankStorage[i+(468*1)] = this.getInv().getStackInSlot(1, i);
	    	
//	    		if(this.getInv().bankTab2ItemStacks[i] != null)
	    			props.playerBankStorage[i+(468*2)] = this.getInv().getStackInSlot(2, i);
	    	    	
//	    		if(this.getInv().bankTab3ItemStacks[i] != null)
	    			props.playerBankStorage[i+(468*3)] = this.getInv().getStackInSlot(3, i);
	    	    	
//	    		if(this.getInv().bankTab4ItemStacks[i] != null)
	    			props.playerBankStorage[i+(468*4)] = this.getInv().getStackInSlot(4, i);
	     	
//	    		if(this.getInv().bankTab5ItemStacks[i] != null)
	    			props.playerBankStorage[i+(468*5)] = this.getInv().getStackInSlot(5, i);
	    	
//	    		if(this.getInv().bankTab6ItemStacks[i] != null)
	    			props.playerBankStorage[i+(468*6)] = this.getInv().getStackInSlot(6, i);
	    
//	    		if(this.getInv().bankTab7ItemStacks[i] != null)
	    			props.playerBankStorage[i+(468*7)] = this.getInv().getStackInSlot(7, i);
	
//	    		if(this.getInv().bankTab8ItemStacks[i] != null)
	    			props.playerBankStorage[i+(468*8)] = this.getInv().getStackInSlot(8, i);
	    	}
    	}
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot == null && !slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            return itemstack;
        }
        return null;
    }
}