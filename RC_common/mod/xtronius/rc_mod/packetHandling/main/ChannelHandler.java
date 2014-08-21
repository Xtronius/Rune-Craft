package mod.xtronius.rc_mod.packetHandling.main;

import java.io.IOException;
import java.util.HashMap;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.*;
import mod.xtronius.rc_mod.packetHandling.packets.lvlInfo.*;
import mod.xtronius.rc_mod.tileEntity.TileEntityLogFire;
import net.minecraft.client.Minecraft;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ChannelHandler extends FMLIndexedMessageToMessageCodec<IPacket> {
	
	//public static HashMap<TileEntityLogFire, Vec3> logMap =  new HashMap<TileEntityLogFire, Vec3>();
	
    public ChannelHandler() {
    	addDiscriminator(0, PacketWoodCuttingLvl.class);
    	addDiscriminator(1, PacketMiningLvl.class);
    	addDiscriminator(2, PacketAttackLvl.class);
    	addDiscriminator(3, PacketStrengthLvl.class);
    	addDiscriminator(4, PacketDefenseLvl.class);
    	addDiscriminator(5, PacketFireMakingLvl.class);
    	
    	addDiscriminator(6, PacketWoodCuttingExp.class);
    	addDiscriminator(7, PacketMiningExp.class);
    	addDiscriminator(8, PacketAttackExp.class);
    	addDiscriminator(9, PacketStrengthExp.class);
    	addDiscriminator(10, PacketDefenseExp.class);
    	addDiscriminator(11, PacketFireMakingExp.class);
    	
    	addDiscriminator(12, PacketWoodCuttingExpUNL.class);
    	addDiscriminator(13, PacketMiningExpUNL.class);
    	addDiscriminator(14, PacketAttackExpUNL.class);
    	addDiscriminator(15, PacketStrengthExpUNL.class);
    	addDiscriminator(16, PacketDefenseExpUNL.class);
    	addDiscriminator(17, PacketFireMakingExpUNL.class);
    	
    	addDiscriminator(18, PacketBlockBreakSpeed.class);
    	addDiscriminator(19, PacketLogFire.class);
    	addDiscriminator(20, PacketSwitchCombatStyle.class);
    	addDiscriminator(21, PacketInitCombatStyle.class);
    	addDiscriminator(22, PacketBankTab.class);
    	addDiscriminator(23, PacketBankScroll.class);
    	addDiscriminator(24, PacketBankInvSync.class);
    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, IPacket packet, ByteBuf data) throws Exception {
        packet.writeBytes(data);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf data, IPacket packet) {
        try {
			packet.readBytes(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
        switch (FMLCommonHandler.instance().getEffectiveSide()) {
            case CLIENT:
                packet.executeClient(Minecraft.getMinecraft().thePlayer);
                break;
            case SERVER:
                INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
                packet.executeServer(((NetHandlerPlayServer) netHandler).playerEntity);
                break;
        }
    }
}

/*
Sending packets

Since how networking is changed sending the packet would be changed also, now if you were sending a packet from the client to the server you would: 
channels.get(Side.CLIENT).attr(FML_MESSAGETARGET).set(TOSERVER);
channels.get(Side.CLIENT).writeOutbound(new ExamplePacket(10));

And to send to a client from the server we would: 
channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
channels.get(Side.SERVER).writeOutbound(new ExamplePacket(10));

Sending to all clients is as simple as: 
channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
channels.get(Side.SERVER).writeOutbound(new ExamplePacket(10));
*/