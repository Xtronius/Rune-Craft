package mod.xtronius.rc_mod.gui.overlay;

import java.awt.Font;
import java.util.Collection;
import java.util.HashMap;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

//
// GuiBuffBar implements a simple status bar at the top of the screen which 
// shows the current buffs/debuffs applied to the character.
////
public class GuiLevelBar extends Gui
{
  private Minecraft mc;

  public GuiLevelBar(Minecraft mc)
  {
    super();
    this.mc = mc;
  }

  private static final int BUFF_ICON_Width = 115;
  private static final int BUFF_ICON_Height = 150;
  
  private static final int BUFF_ICON_BASE_U_OFFSET = 0; //The x offset of the texture coords
  private static final int BUFF_ICON_BASE_V_OFFSET = 0; //The y offset of the texture coords
  
 
  private  static final ResourceLocation texture = new ResourceLocation(Reference.MOD_Gui, "textures/gui/notifiacationOverlay3.png");
  
  @SubscribeEvent(priority = EventPriority.NORMAL)
  public void onRenderExperienceBar(RenderGameOverlayEvent.Post event)
  {
	  
    // 
    // We draw after the ExperienceBar has drawn.  The event raised by GuiIngameForge.pre()
    // will return true from isCancelable.  If you call event.setCanceled(true) in
    // that case, the portion of rendering which this event represents will be canceled.
    // We want to draw *after* the experience bar is drawn, so we make sure isCancelable() returns
    // false and that the eventType represents the ExperienceBar event.
    if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
    {      
      return;
    }

    // Starting position for the buff bar - 2 pixels from the top left corner.
    int xPos;
    int yPos;
    int x = mc.getMinecraft().displayWidth;
    int y = mc.getMinecraft().displayHeight;
    
    ScaledResolution get = new ScaledResolution(Minecraft.getMinecraft().gameSettings,x,y);
    
    int scale = get.getScaleFactor();
    renderOverlay(0 + 2, 0 + (get.getScaledHeight()/7), ((int)((get.getScaledWidth()/2)/2.5) + 2), get.getScaledHeight()-2);
    
       }
   
  public void renderOverlay(int x, int y, int x1, int y1) {
	  
	  ExtendedPlayer props = ExtendedPlayer.get(this.mc.thePlayer);
	    
	  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	  GL11.glDisable(GL11.GL_LIGHTING);      
	      //this.mc.renderEngine.bindTexture(texture);      
	      //this.drawTexturedModalRect(x, y, BUFF_ICON_BASE_U_OFFSET, BUFF_ICON_BASE_V_OFFSET , BUFF_ICON_Width, BUFF_ICON_Height);
	      
	  this.drawRect(x, y, x1, y1, 1342177280);
	  if(props != null) {
		  this.renderLevels(ExtendedPlayer.SkillsStr[0], String.valueOf(props.getLvl("Attack")), "2", x + 2, y + 2);
		  this.renderLevels(ExtendedPlayer.SkillsStr[1], String.valueOf(props.getLvl("Strength")), "2", x + 2, y + 10);
		  this.renderLevels(ExtendedPlayer.SkillsStr[2], String.valueOf(props.getLvl("Defense")), "2", x + 2, y + 18);
		  this.renderLevels(ExtendedPlayer.SkillsStr[3], String.valueOf(props.getLvl("Range")), "2", x + 2, y + 26);
		  this.renderLevels(ExtendedPlayer.SkillsStr[4], String.valueOf(props.getLvl("Prayer")), "2", x + 2, y + 34);
		  this.renderLevels(ExtendedPlayer.SkillsStr[5], String.valueOf(props.getLvl("Mage")), "2", x + 2, y + 42);
		  this.renderLevels(ExtendedPlayer.SkillsStr[6], String.valueOf(props.getLvl("RuneCrafting")), "2", x + 2, y + 50);
		  this.renderLevels(ExtendedPlayer.SkillsStr[7], String.valueOf(props.getLvl("Construction")), "2", x + 2, y + 58);
		  this.renderLevels(ExtendedPlayer.SkillsStr[8], String.valueOf(props.getLvl("Dungeoneering")), "2", x + 2, y + 66);
		  this.renderLevels(ExtendedPlayer.SkillsStr[9], String.valueOf(props.getLvl("Constitution")), "2", x + 2, y + 74);
		  this.renderLevels(ExtendedPlayer.SkillsStr[10], String.valueOf(props.getLvl("Agility")), "2", x + 2, y + 82);
		  this.renderLevels(ExtendedPlayer.SkillsStr[11], String.valueOf(props.getLvl("Herblore")), "2", x + 2, y + 90);
		  this.renderLevels(ExtendedPlayer.SkillsStr[12], String.valueOf(props.getLvl("Thieving")), "2", x + 2, y + 98);
		  this.renderLevels(ExtendedPlayer.SkillsStr[13], String.valueOf(props.getLvl("Crafting")), "2", x + 2, y + 106);
		  this.renderLevels(ExtendedPlayer.SkillsStr[14], String.valueOf(props.getLvl("Fletching")), "2", x + 2, y + 114);
		  this.renderLevels(ExtendedPlayer.SkillsStr[15], String.valueOf(props.getLvl("Slayer")), "2", x + 2, y + 122);
		  this.renderLevels(ExtendedPlayer.SkillsStr[16], String.valueOf(props.getLvl("Hunting")), "2", x + 2, y + 130);
		  this.renderLevels(ExtendedPlayer.SkillsStr[17], String.valueOf(props.getLvl("Mining")), "2", x + 2, y + 138);
		  this.renderLevels(ExtendedPlayer.SkillsStr[18], String.valueOf(props.getLvl("Smithing")), "2", x + 2, y + 146);
		  this.renderLevels(ExtendedPlayer.SkillsStr[19], String.valueOf(props.getLvl("Fishing")), "2", x + 2, y + 154);
		  this.renderLevels(ExtendedPlayer.SkillsStr[20], String.valueOf(props.getLvl("Cooking")), "2", x + 2, y + 162);
		  this.renderLevels(ExtendedPlayer.SkillsStr[21], String.valueOf(props.getLvl("FireMaking")), "2", x + 2, y + 170);
		  this.renderLevels(ExtendedPlayer.SkillsStr[22], String.valueOf(props.getLvl("WoodCutting")), "2", x + 2, y + 178);
		  this.renderLevels(ExtendedPlayer.SkillsStr[23], String.valueOf(props.getLvl("Farming")), "2", x + 2, y + 186);
		  this.renderLevels(ExtendedPlayer.SkillsStr[24], String.valueOf(props.getLvl("Summoning")), "2", x + 2, y + 194);
	  }
  }

  
  public void renderLevels(String LvlName, String Lvl, String TotalLvl, int x, int y) {
	  
	  GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
      GL11.glDisable(GL11.GL_LIGHTING);
      mc.fontRenderer.drawStringWithShadow(LvlName + ": " + Lvl, x, y, 0xffFFAA00);
  }

}