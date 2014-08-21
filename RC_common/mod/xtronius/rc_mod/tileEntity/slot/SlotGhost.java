package mod.xtronius.rc_mod.tileEntity.slot;

import mod.xtronius.rc_mod.inventory.InvBank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGhost extends Slot{

    private EntityPlayer thePlayer;
    private int slotIndex;
    private int x, y, z;
    private InvBank bankInv;

    public SlotGhost(EntityPlayer player, IInventory bankInv, int slotIndex, int x, int y)
    {
        super(bankInv, slotIndex, x, y);
        this.thePlayer = player;
        this.slotIndex = slotIndex;
        this.bankInv = (InvBank) bankInv;
        this.x = x;
        this.y = y;
    }
}
