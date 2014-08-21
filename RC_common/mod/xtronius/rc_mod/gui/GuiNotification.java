package mod.xtronius.rc_mod.gui;

import java.awt.Font;
import java.util.Collection;
import java.util.HashMap;

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
public class GuiNotification extends Gui
{
  //private final HashMap notifications = new HashMap();
  private final HashMap<String, String> notifications = new HashMap<String, String>();
  private Minecraft mc;

  public GuiNotification(Minecraft mc)
  {
    super();
    // We need this to invoke the render engine.
    this.mc = mc;
    notifications.put("Error", "There is An Error!");
  }

  private static final int BUFF_ICON_Width = 115;
  private static final int BUFF_ICON_Height = 150;
  
  private static final int BUFF_ICON_BASE_U_OFFSET = 0; //The x offset of the texture coords
  private static final int BUFF_ICON_BASE_V_OFFSET = 0; //The y offset of the texture coords
  
 
  private  static final ResourceLocation texture = new ResourceLocation(Reference.MOD_Gui, "textures/gui/notifiacationOverlay3.png");
  
  //
  // This event is called by GuiIngameForge during each frame by
  // GuiIngameForge.pre() and GuiIngameForce.post().
  //
  @SubscribeEvent(priority = EventPriority.NORMAL)
  public void onRenderExperienceBar(RenderGameOverlayEvent event)
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
    
    
     if (scale == 1) {
    	xPos = 2;
    	yPos = 44;
    	renderOverlay(xPos,yPos);
    	renderLevels(xPos + 20, yPos + 3);
    }
    else if (scale == 2) {
    	xPos = 2;
    	yPos = 88;
    	renderOverlay(xPos,yPos);
    	renderLevels(xPos + 20, yPos + 3);
    }
    else if (scale == 3) {
    	xPos = 2;
    	yPos = 141;
    	renderOverlay(xPos,yPos);
    	renderLevels(xPos + 21, yPos + 3);
    }
       }
   
  public void renderOverlay(int x, int y) {
	      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	      GL11.glDisable(GL11.GL_LIGHTING);      
	      this.mc.renderEngine.bindTexture(texture);      
	      this.drawTexturedModalRect(x, y, BUFF_ICON_BASE_U_OFFSET, BUFF_ICON_BASE_V_OFFSET , BUFF_ICON_Width, BUFF_ICON_Height);
	      int X = (x + ((BUFF_ICON_Width/2)/2));
	      int Y = (y + (BUFF_ICON_Height/2));
	      //renderMessage(X, Y, "Hello");
  }

  
  public void renderLevels(int x, int y) {
	  
	  GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
      GL11.glDisable(GL11.GL_LIGHTING);
      mc.fontRenderer.drawStringWithShadow("1", x, y, 0xffFFAA00);
      mc.fontRenderer.drawStringWithShadow("1", (x + 10), (y + 5), 0xffFFAA00);
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  //  public void renderMessage(int x, int y, String message) {
//	  Collection collection = this.getNotifications();
//	  if (!collection.isEmpty())
//	    {
//		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//	      GL11.glDisable(GL11.GL_LIGHTING);
//	      //this.drawString(null, message, x, y, 0);
//	      mc.fontRenderer.drawStringWithShadow(message, x, y, 0xffFFFFFF);
//	    }
//  }
  public Collection getNotifications()
  {
      return this.notifications.values();
  }
}