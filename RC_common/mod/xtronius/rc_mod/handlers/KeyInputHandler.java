package mod.xtronius.rc_mod.handlers;

import net.minecraft.client.Minecraft;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketSwitchCombatStyle;
import mod.xtronius.rc_mod.util.KeyBindings;
import mod.xtronius.rc_mod.util.enumClasses.MeleCombatStyles;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;

public class KeyInputHandler {
	
	Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
    	
    	ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
    	
    	/** switchCombatStyle */
        if(KeyBindings.keyBindingList.get(0).isPressed()) {
        	this.cycleCombatStyles(props);
        	props.setMeleCombatStyleGuiCoolDown(200);
            System.out.println("Combat Style Switched!!! " + "New Combat Style is " + props.getMeleCombatStyle().toString());
        }
    }
    
    private void cycleCombatStyles(ExtendedPlayer props) {
    	if(props.getMeleCombatStyle() == MeleCombatStyles.ATTACK) {
    		props.setMeleCombatStyle(MeleCombatStyles.STRENGTH);
    		rc_mod.SwitchCombatStylePacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
            rc_mod.SwitchCombatStylePacket.get(Side.CLIENT).writeOutbound(new PacketSwitchCombatStyle(1));
    	}
    	else if(props.getMeleCombatStyle() == MeleCombatStyles.STRENGTH) {
    		props.setMeleCombatStyle(MeleCombatStyles.DEFENSE);
    		rc_mod.SwitchCombatStylePacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
            rc_mod.SwitchCombatStylePacket.get(Side.CLIENT).writeOutbound(new PacketSwitchCombatStyle(2));
    	}
    	else if(props.getMeleCombatStyle() == MeleCombatStyles.DEFENSE) {
    		props.setMeleCombatStyle(MeleCombatStyles.SHARED);
    		rc_mod.SwitchCombatStylePacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
            rc_mod.SwitchCombatStylePacket.get(Side.CLIENT).writeOutbound(new PacketSwitchCombatStyle(3));
    	}
    	else if(props.getMeleCombatStyle() == MeleCombatStyles.SHARED) {
    		props.setMeleCombatStyle(MeleCombatStyles.ATTACK);
    		rc_mod.SwitchCombatStylePacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
            rc_mod.SwitchCombatStylePacket.get(Side.CLIENT).writeOutbound(new PacketSwitchCombatStyle(0));
    	}
    }

}
