package mod.xtronius.rc_mod.gui.overlay;

import java.util.Collection;
import java.util.Iterator;

import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.util.enumClasses.MeleCombatStyles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;





import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

//
// GuiBuffBar implements a simple status bar at the top of the screen which 
// shows the current buffs/debuffs applied to the character.
//
public class GuiSwitchMeleCombatStyle extends Gui
{
  private Minecraft mc;

  public GuiSwitchMeleCombatStyle(Minecraft mc)
  {
    super();
    // We need this to invoke the render engine.
    this.mc = mc;
  }

  private  static final ResourceLocation texture = new ResourceLocation("rc_mod", "textures/gui/GuiSwitchMeleCombatStyle4.png");
  private int prevHighlightPos = -1;
  private int currentHighlightPos = -1;
  
  private int hightlightXPos = 6;
  
  private int prevhightlightXPos = 6;
  
  private float alpha = 0;
  
  //
  // This event is called by GuiIngameForge during each frame by
  // GuiIngameForge.pre() and GuiIngameForce.post().
  //
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
    int xPos = 2;
    int yPos = 2;
    
    ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
    
    if (props != null && props.getMeleCombatStyleGuiCoolDown() > 0) {
    	if(this.currentHighlightPos == -1 && this.prevHighlightPos == -1) {
    		this.currentHighlightPos = props.getMeleCombatStyleInt();
    		this.prevHighlightPos = props.getMeleCombatStyleInt();
    	}
    	
	      GL11.glDisable(GL11.GL_LIGHTING);   
	      GL11.glEnable(GL11.GL_BLEND);
	      this.mc.renderEngine.bindTexture(texture);
	      
	      if(props.getMeleCombatStyleGuiCoolDown() >= 175) {
	    	  alpha += 0.04F;
	      } else if(props.getMeleCombatStyleGuiCoolDown() <= 25) {
	    	  alpha -= 0.04F;
	      }
	      
	      if(alpha > 1F) {
	    	  alpha = 1F;
	      } else if(alpha < 0F) {
	    	  alpha = 0F;
	      }
	      
	      GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
	      
	      this.drawTexturedModalRect(xPos, yPos,  0, 0, 136, 40); 
	      
	      this.currentHighlightPos = props.getMeleCombatStyleInt();
	      
	      if(this.prevHighlightPos == this.currentHighlightPos) {
	    	  if(this.currentHighlightPos == 0) {//6,4
	        	  this.hightlightXPos = 6;
	    	  	  this.prevhightlightXPos = 6;
	    	  }
	          if(this.currentHighlightPos == 1) {//68,6
	        	  this.hightlightXPos = 38;
	        	  this.prevhightlightXPos = 68;
	          }
	          if(this.currentHighlightPos == 2) {//70,6
	        	  this.hightlightXPos = 70;
	        	  this.prevhightlightXPos = 70;
	          }
	          if(this.currentHighlightPos == 3) {//102,6
	        	  this.hightlightXPos = 102;
	        	  this.prevhightlightXPos = 102;
	          }
	          
	          this.drawTexturedModalRect(this.hightlightXPos, 6,  0, 40, 32, 32);
	          
	      } else {
	    	  if(props.getMeleCombatStyleGuiCoolDown() < 175) {
		    	  if(this.hightlightXPos >= 6 && this.currentHighlightPos == 0) {
		        	  this.hightlightXPos -= 4;
		    	  } 
		    	  else if(this.hightlightXPos <= 6 && this.currentHighlightPos == 0) {
		    		  this.hightlightXPos = 6;
		    	  }
		    	  else if(this.hightlightXPos <= 102 && this.currentHighlightPos != 0){
		    		  this.hightlightXPos += 1;
		    	  } 
	    	  	  else if(this.hightlightXPos >= 102 && this.currentHighlightPos != 0) {
		    		  this.hightlightXPos = 102;
		    	  }
		    	  
		    	  if(this.currentHighlightPos == 0) {
		        	 if(this.hightlightXPos == 6)
		        		 this.prevHighlightPos = this.currentHighlightPos;
		    	  }
		          if(this.currentHighlightPos == 1) {
		        	  if(this.hightlightXPos == 38)
		         		 this.prevHighlightPos = this.currentHighlightPos;
		          }
		          if(this.currentHighlightPos == 2) {
		        	  if(this.hightlightXPos == 70)
		         		 this.prevHighlightPos = this.currentHighlightPos;
		          }
		          if(this.currentHighlightPos == 3) {
		        	  if(this.hightlightXPos == 102)
		         		 this.prevHighlightPos = this.currentHighlightPos;
		          }
	    	  }
	          this.drawTexturedModalRect(this.hightlightXPos, 6,  0, 40, 32, 32);
	      }
	      
	      GL11.glDisable(GL11.GL_BLEND);
	      
	      props.setMeleCombatStyleGuiCoolDown(props.getMeleCombatStyleGuiCoolDown()-1);
    }
  }
}