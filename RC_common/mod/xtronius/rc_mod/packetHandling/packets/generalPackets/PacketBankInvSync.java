package mod.xtronius.rc_mod.packetHandling.packets.generalPackets;

import mod.xtronius.rc_mod.container.BankContainer;
import mod.xtronius.rc_mod.handlers.BlockBreakHandler;
import mod.xtronius.rc_mod.handlers.RCTickHandler;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.main.IPacket;
import mod.xtronius.rc_mod.util.enumClasses.MeleCombatStyles;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import io.netty.buffer.ByteBuf;

public class PacketBankInvSync  implements IPacket{
	
	int slotIndex;
	int objID;
	int stackSize;
	int meta;
	boolean isBlock;
    
    public PacketBankInvSync(){}
    
    public PacketBankInvSync(int slotIndex, int objID, int stackSize, int meta, boolean isBlock) {
        this.slotIndex = slotIndex;
        this.objID = objID;
        this.stackSize = stackSize;
        this.meta = meta;
        this.isBlock = isBlock;
    }

    public void readBytes(ByteBuf bytes) {
    	slotIndex = bytes.readInt();
    	objID = bytes.readInt();
    	stackSize = bytes.readInt();
    	meta = (int) bytes.readByte();
    	isBlock = bytes.readBoolean();
    }

    public void writeBytes(ByteBuf bytes){
        bytes.writeInt(slotIndex);
        bytes.writeInt(objID);
        bytes.writeInt(stackSize);
        bytes.writeByte((byte) meta);
        bytes.writeBoolean(isBlock);
    }

	@Override
	public void executeClient(EntityPlayer player) {
		RCTickHandler tickHandler = RCTickHandler.intance;
		BankContainer bank = tickHandler.BankContainerMapCLIENT.get(player);
		if(bank != null) {
			ItemStack stack;
			if(this.isBlock) {
				stack = new ItemStack(Block.getBlockById(this.objID), this.stackSize, this.meta);
			} else {
				stack = new ItemStack(Item.getItemById(this.objID), this.stackSize, this.meta);
			}
			bank.invBank.setInventorySlotContents(bank.invBank.currentSelectedTab, this.slotIndex, stack);
			bank.invBank.onInventoryChanged();
		} else {
			System.out.println("null");
		}
	}

	@Override
	public void executeServer(EntityPlayer player) {}
}
