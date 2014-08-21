package mod.xtronius.rc_mod.tileEntity.slot;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.inventory.InvBank;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketBankScroll;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class SlotBank extends Slot {
    private final int slotIndex;
    public final IInventory inventory;
    public final InvBank invBank;
    public int slotNumber;
    public int xDisplayPosition;
    public int yDisplayPosition;
    private static final String __OBFID = "CL_00001762";

    protected IIcon backgroundIcon = null;

    @SideOnly(Side.CLIENT)
    protected ResourceLocation texture;

    public SlotBank(IInventory inv, int slotIndex, int x, int y)
    {
    	super(inv, slotIndex, x, y);
        this.inventory = inv;
        this.invBank = (InvBank) inv;
        this.slotIndex = slotIndex;
        this.xDisplayPosition = x;
        this.yDisplayPosition = y;
    }

    public void onSlotChange(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        if (par1ItemStack != null && par2ItemStack != null)
        {
            if (par1ItemStack.getItem() == par2ItemStack.getItem())
            {
                int i = par2ItemStack.stackSize - par1ItemStack.stackSize;

                if (i > 0)
                {
                    this.onCrafting(par1ItemStack, i);
                }
            }
        }
    }

    protected void onCrafting(ItemStack par1ItemStack, int par2) {}

    protected void onCrafting(ItemStack par1ItemStack) {}

    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
    {
        this.onSlotChanged();
    }

    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return true;
    }

    public ItemStack getStack()
    {
        return this.inventory.getStackInSlot(this.slotIndex);
    }

    public boolean getHasStack()
    {
        return this.getStack() != null;
    }

    public void putStack(ItemStack par1ItemStack)
    {
        this.inventory.setInventorySlotContents(this.slotIndex, par1ItemStack);
        this.onSlotChanged();
    }

    public void onSlotChanged()
    {
        this.inventory.markDirty();
        switch (FMLCommonHandler.instance().getEffectiveSide()) {
        	case CLIENT: 
        		rc_mod.bankScrollPacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
        		rc_mod.bankScrollPacket.get(Side.CLIENT).writeOutbound(new PacketBankScroll(this.invBank.getCurrentTopRow()));
        	break;
        	case SERVER:  ;break;
        }
    }

    public int getSlotStackLimit()
    {
        return this.inventory.getInventoryStackLimit();
    }

    public ItemStack decrStackSize(int par1)
    {
        return this.inventory.decrStackSize(this.slotIndex, par1);
    }

    public boolean isSlotInInventory(IInventory par1IInventory, int par2)
    {
        return par1IInventory == this.inventory && par2 == this.slotIndex;
    }

    public boolean canTakeStack(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getBackgroundIconIndex()
    {
        return backgroundIcon;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_111238_b()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public ResourceLocation getBackgroundIconTexture()
    {
        return (texture == null ? TextureMap.locationItemsTexture : texture);
    }

    public void setBackgroundIcon(IIcon icon)
    {
        backgroundIcon = icon;
    }


    @SideOnly(Side.CLIENT)
    public void setBackgroundIconTexture(ResourceLocation texture)
    {
        this.texture = texture;
    }
    
    public int getSlotIndex()
    {
        return slotIndex;
    }
}