package mod.xtronius.rc_mod.tileEntity.slot;

import cpw.mods.fml.common.registry.GameRegistry;
import mod.xtronius.rc_mod.furnaceRecipies.RCIngotFurnace1Recipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public class SlotFurnace1 extends Slot
{
    /** The player that is using the GUI where this slot resides. */
    private EntityPlayer thePlayer;
    private int field_75228_b;
    
    private int x, y, z;

    public SlotFurnace1(EntityPlayer player, IInventory playerInv, int x, int y, int z)
    {
        super(playerInv, x, y, z);
        this.thePlayer = player;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack stack)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1)
    {
        if (this.getHasStack())
        {
            this.field_75228_b += Math.min(par1, this.getStack().stackSize);
        }

        return super.decrStackSize(par1);
    }

    public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
    {
        this.onCrafting(stack);
        super.onPickupFromSlot(player, stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void onCrafting(ItemStack stack, int par2)
    {
        this.field_75228_b += par2;
       // this.onCrafting(stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    protected void onCrafting(ItemStack stack)
    {
    	stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);

        //GameRegistry.onItemSmelted(thePlayer, stack);
    }
}
