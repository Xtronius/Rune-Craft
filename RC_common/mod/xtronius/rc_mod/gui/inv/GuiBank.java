package mod.xtronius.rc_mod.gui.inv;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.container.BankContainer;
import mod.xtronius.rc_mod.handlers.RCTickHandler;
import mod.xtronius.rc_mod.inventory.InvBank;
import mod.xtronius.rc_mod.lib.Reference;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketBankScroll;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketBankTab;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBank extends GuiContainer
{
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(Reference.MOD_Gui, "textures/gui/container/GuiBank3.png");
    private static BankContainer container;
    private InvBank invBank;
    public EntityPlayer player;
    private int scrollButtonY = 10;
    public static float currentScroll;
    
    private RightArrowButton bankRightArrowButton;
    private LeftArrowButton bankLeftArrowButton;
    private BankScrollButton bankScrollButton;
    
    private BankTabButton bankTabButton0;
    private BankTabButton bankTabButton1;
    private BankTabButton bankTabButton2;
    private BankTabButton bankTabButton3;
    private BankTabButton bankTabButton4;
    private BankTabButton bankTabButton5;
    private BankTabButton bankTabButton6;
    private BankTabButton bankTabButton7;
    private BankTabButton bankTabButton8;
    private boolean buttonsNotDrawn;
    
    private boolean isScrolling = false;
    
    public static int minY;
    public static int maxY;
    
    private float xSizeFloat;
   
    private float ySizeFloat;
    
    private int currentTopRow = 0;
    
    private int currentScrollingProg = 0;
    private int prevScrollingProg = 0;
    
    private RCTickHandler tickHandler = RCTickHandler.intance;
    
    public GuiBank(InventoryPlayer playerInv, World world, int x, int y, int z) {
    	super(container = new BankContainer(playerInv, world, x, y, z));
        this.invBank = container.getInv();
        tickHandler.BankContainerMapCLIENT.put(playerInv.player, container);
        this.player = playerInv.player;
        this.xSize = 256;
        this.ySize = 219;
    }
    
    public void initGui() {
        super.initGui();
        minY = this.guiTop + 12;
        maxY = this.guiTop + 104;
        
        rc_mod.bankScrollPacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
    	rc_mod.bankScrollPacket.get(Side.CLIENT).writeOutbound(new PacketBankScroll(0));
    	
    	rc_mod.bankScrollPacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
    	rc_mod.bankScrollPacket.get(Side.CLIENT).writeOutbound(new PacketBankTab(0));
    	
    	this.invBank.setCurrentTopRow(0);
    	this.invBank.currentSelectedTab = 0;
    	
        
        this.buttonList.add(this.bankRightArrowButton = new GuiBank.RightArrowButton(-1, this.guiLeft + 246, this.guiTop - 19, 10, 15));
        this.buttonList.add(this.bankLeftArrowButton = new GuiBank.LeftArrowButton(-2, this.guiLeft + 0, this.guiTop - 19, 10, 15));
        
        
        this.buttonList.add(this.bankScrollButton = new GuiBank.BankScrollButton(-12, this.guiLeft + 240, minY, 12, 15));
        
        this.buttonList.add(this.bankTabButton0 = new GuiBank.BankTabButton(-3, 1, this.guiLeft + 15, this.guiTop - 27, 25, 27));
        this.buttonList.add(this.bankTabButton1 = new GuiBank.BankTabButton(-4, 2, this.guiLeft + 40, this.guiTop - 27, 25, 27));
        this.buttonList.add(this.bankTabButton2 = new GuiBank.BankTabButton(-5, 3, this.guiLeft + 65, this.guiTop - 27, 25, 27));
        this.buttonList.add(this.bankTabButton3 = new GuiBank.BankTabButton(-6, 4, this.guiLeft + 90, this.guiTop - 27, 25, 27));
        this.buttonList.add(this.bankTabButton4 = new GuiBank.BankTabButton(-7, 5, this.guiLeft + 115, this.guiTop - 27, 25, 27));
        this.buttonList.add(this.bankTabButton5 = new GuiBank.BankTabButton(-8, 6, this.guiLeft + 140, this.guiTop - 27, 25, 27));
        this.buttonList.add(this.bankTabButton6 = new GuiBank.BankTabButton(-9, 7, this.guiLeft + 165, this.guiTop - 27, 25, 27));
        this.buttonList.add(this.bankTabButton7 = new GuiBank.BankTabButton(-10, 8, this.guiLeft + 190, this.guiTop - 27, 25, 27));
        this.buttonList.add(this.bankTabButton8 = new GuiBank.BankTabButton(-11, 7, this.guiLeft + 215, this.guiTop - 27, 25, 27));
        this.buttonsNotDrawn = true;
        
        this.setActiveTab(this.getTab(this.invBank.currentSelectedTab), 0, true);
    }
    
    public void updateScreen() {
        super.updateScreen();
        
        for(int i = 0; i < 8; i++) 
        	this.invBank.eventHandler.ItemDisplay[i] = this.invBank.getIndexedStackArray(i+1)[0];
        
        if(this.invBank.currentSelectedTab == 0)
        	this.bankLeftArrowButton.enabled = false;
        else
        	this.bankLeftArrowButton.enabled = true;
        if(this.invBank.currentSelectedTab == 8)
        	this.bankRightArrowButton.enabled = false;
        else
        	this.bankRightArrowButton.enabled = true;
        
        if(this.isScrolling && Mouse.isButtonDown(0)) {
        	this.bankScrollButton.yPosition = this.bankScrollButton.mouseY - (this.bankScrollButton.width/2);        	
        	if(this.bankScrollButton.yPosition < this.minY)
        		this.bankScrollButton.yPosition = this.minY;
        	if(this.bankScrollButton.yPosition > this.maxY)
        		this.bankScrollButton.yPosition = this.maxY;
        	
        	float scrollTranslationSize = (this.maxY - this.minY);
        	
        	float percentBarScrolled = (this.bankScrollButton.yPosition-this.minY)/scrollTranslationSize;
        	currentTopRow = (int) (percentBarScrolled * 30);
        	
            this.invBank.setCurrentTopRow(currentTopRow);
        	
        	this.currentScrollingProg = currentTopRow;
        	updateTabIndex(this.invBank.currentSelectedTab);
       } 
       if(this.isScrolling && !Mouse.isButtonDown(0)) {
    	   updateTabIndex(this.invBank.currentSelectedTab);
        	this.isScrolling = false;
       }
    }
    
    private GuiBank.BankTabButton getTab(int i) {
    	switch(i) {
	    	case 0: return this.bankTabButton0;
	    	case 1: return this.bankTabButton1;
	    	case 2: return this.bankTabButton2;
	    	case 3: return this.bankTabButton3;
	    	case 4: return this.bankTabButton4;
	    	case 5: return this.bankTabButton5;
	    	case 6: return this.bankTabButton6;
	    	case 7: return this.bankTabButton7;
	    	case 8: return this.bankTabButton8;
    	}
    	return null;
    }
    
    protected void actionPerformed(GuiButton button) {
        if (button.id == -2 && this.invBank.currentSelectedTab >= 0) {
            this.invBank.setCurrentSelectedTab(this.invBank.currentSelectedTab-1);
            
            for(int i = 0; i < 9; i++){
     		   if(i == this.invBank.currentSelectedTab) {
     			   this.setActiveTab(this.getTab(this.invBank.currentSelectedTab), i, true);
     			   updateTabIndex(this.invBank.currentSelectedTab);
     		   }
     		   else 
     			   this.setActiveTab(this.getTab(i), i, false);
     	   }
        }
        else if (button.id == -1 && this.invBank.currentSelectedTab <= 8) {
        	this.invBank.setCurrentSelectedTab(this.invBank.currentSelectedTab+1);
        	
        	for(int i = 0; i < 9; i++){
    		   if(i == (this.invBank.currentSelectedTab)) {
    			   this.setActiveTab(this.getTab(this.invBank.currentSelectedTab), i, true);
    			   updateTabIndex(this.invBank.currentSelectedTab);
    		   }
    		   else 
    			   this.setActiveTab(this.getTab(i), i, false);
    	   }
        }
        else if (button.id == -3) {
           if(button instanceof GuiBank.BankTabButton) { 
        	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
        	   this.invBank.setCurrentSelectedTab(0);
        	   updateTabIndex(this.invBank.currentSelectedTab);
        	   
        	   for(int i = 0; i < 9; i++){
        		   if(i == 0) {
        			   this.setActiveTab(guiTabButton, 0, true); 
        		   }
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
           }
        }
        else if (button.id == -4) {
            if(button instanceof GuiBank.BankTabButton) { 
         	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
         	  this.invBank.setCurrentSelectedTab(1);
         	   updateTabIndex(this.invBank.currentSelectedTab);
        	   for(int i = 0; i < 9; i++){
        		   if(i == 1)
        			   this.setActiveTab(guiTabButton, 1, true);
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
            }
         }
        
        else if (button.id == -5) {
            if(button instanceof GuiBank.BankTabButton) { 
         	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
         	  this.invBank.setCurrentSelectedTab(2);
         	   updateTabIndex(this.invBank.currentSelectedTab);
        	   for(int i = 0; i < 9; i++){
        		   if(i == 2)
        			   this.setActiveTab(guiTabButton, 2, true);
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
            }
         }
        
        else if (button.id == -6) {
            if(button instanceof GuiBank.BankTabButton) { 
         	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
         	  this.invBank.setCurrentSelectedTab(3);
         	   updateTabIndex(this.invBank.currentSelectedTab);
        	   for(int i = 0; i < 9; i++){
        		   if(i == 3)
        			   this.setActiveTab(guiTabButton, 3, true);
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
            }
         }
        
        else if (button.id == -7) {
            if(button instanceof GuiBank.BankTabButton) { 
         	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
         	  this.invBank.setCurrentSelectedTab(4);
         	   updateTabIndex(this.invBank.currentSelectedTab);
        	   for(int i = 0; i < 9; i++){
        		   if(i == 4)
        			   this.setActiveTab(guiTabButton, 4, true);
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
            }
         }
        
        else if (button.id == -8) {
            if(button instanceof GuiBank.BankTabButton) { 
         	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
         	  this.invBank.setCurrentSelectedTab(5);
         	   updateTabIndex(this.invBank.currentSelectedTab);
        	   for(int i = 0; i < 9; i++){
        		   if(i == 5)
        			   this.setActiveTab(guiTabButton, 5, true);
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
            }
         }
        else if (button.id == -9) {
            if(button instanceof GuiBank.BankTabButton) { 
         	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
         	  this.invBank.setCurrentSelectedTab(6);
         	   updateTabIndex(this.invBank.currentSelectedTab);
        	   for(int i = 0; i < 9; i++){
        		   if(i == 6)
        			   this.setActiveTab(guiTabButton, 6, true);
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
            }
         }
        else if (button.id == -10) {
            if(button instanceof GuiBank.BankTabButton) { 
         	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
         	  this.invBank.setCurrentSelectedTab(7);
         	   updateTabIndex(this.invBank.currentSelectedTab);
        	   for(int i = 0; i < 9; i++){
        		   if(i == 7)
        			   this.setActiveTab(guiTabButton, 7, true);
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
            }
         }
        else if (button.id == -11) {
            if(button instanceof GuiBank.BankTabButton) { 
         	   GuiBank.BankTabButton guiTabButton = (BankTabButton) button;
         	  this.invBank.setCurrentSelectedTab(8);
         	   updateTabIndex(this.invBank.currentSelectedTab);
        	   for(int i = 0; i < 9; i++){
        		   if(i == 8)
        			   this.setActiveTab(guiTabButton, 8, true);
        		   else 
        			   this.setActiveTab(this.getTab(i), i, false);
        	   }
            }
         }
        else if(button.id == -12) {
        	if(button instanceof GuiBank.BankScrollButton) {
        		GuiBank.BankScrollButton scrollButton = (BankScrollButton) button;
        		this.isScrolling =  true;
        	}
        }
    }
    
    public void handleMouseInput() {
    	super.handleMouseInput();
    	int yD = Mouse.getEventY();
    	this.currentScroll = yD;
    }
    
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        // String s = invFurnace.isInvNameLocalized() ? invFurnace.getInvName() : I18n.getString(invFurnace.getInvName());
//    	String s = "Bank";
//        this.fontRendererObj.drawString(s, ((this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2) + 1), 6, 8355711);
        //this.fontRendererObj.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96, 8355711);
        this.fontRendererObj.drawString("inventory", 8, this.ySize - 96, 8355711);
//       this.buttonList.add(this.bankTabButton1 = new GuiBank.BankTabButton(-4, 2, this.guiLeft + 40, this.guiTop - 27, 25, 27));
        
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.ItemDisplay[0], 45, -20);
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.ItemDisplay[1], 70, -20);
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.ItemDisplay[2], 95, -20);
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.ItemDisplay[3], 120, -20);
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.ItemDisplay[4], 145, -20);
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.ItemDisplay[5], 170, -20);
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.ItemDisplay[6], 195, -20);
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.ItemDisplay[7], 220, -20);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float x, int y, int z) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        int startingXPos = this.guiLeft;
        int startingYPos = this.guiTop;
        
        this.renderPlayerArmorModel(startingXPos + 187 + 21, startingYPos + 126 + 66, 30, (float)(startingXPos + 187 + 28) - this.xSizeFloat, (float)(startingYPos + 126 + 23 - 50) - this.ySizeFloat, this.mc.thePlayer);
    }
    
    private void renderPlayerArmorModel(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_) {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_147046_0_, (float)p_147046_1_, 50.0F);
        GL11.glScalef((float)(-p_147046_2_), (float)p_147046_2_, (float)p_147046_2_);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = p_147046_5_.renderYawOffset;
        float f3 = p_147046_5_.rotationYaw;
        float f4 = p_147046_5_.rotationPitch;
        float f5 = p_147046_5_.prevRotationYawHead;
        float f6 = p_147046_5_.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        p_147046_5_.renderYawOffset = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 20.0F;
        p_147046_5_.rotationYaw = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 40.0F;
        p_147046_5_.rotationPitch = -((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F;
        p_147046_5_.rotationYawHead = p_147046_5_.rotationYaw;
        p_147046_5_.prevRotationYawHead = p_147046_5_.rotationYaw;
        GL11.glTranslatef(0.0F, p_147046_5_.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(p_147046_5_, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        p_147046_5_.renderYawOffset = f2;
        p_147046_5_.rotationYaw = f3;
        p_147046_5_.rotationPitch = f4;
        p_147046_5_.prevRotationYawHead = f5;
        p_147046_5_.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    private void setActiveTab(GuiBank.BankTabButton button, int i, boolean var1) {
    	button.isActive = var1;
    }
    
    
    private void updateTabIndex(int i) {
    	
    	rc_mod.bankScrollPacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
    	rc_mod.bankScrollPacket.get(Side.CLIENT).writeOutbound(new PacketBankScroll(this.invBank.getCurrentTopRow()));
    	
    	rc_mod.bankTabPacket.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
    	rc_mod.bankTabPacket.get(Side.CLIENT).writeOutbound(new PacketBankTab(i));
    	container.invBank.currentSelectedTab = i;
    }
    
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
        this.xSizeFloat = (float)par1;
        this.ySizeFloat = (float)par2;
    }
    
    @SideOnly(Side.CLIENT)
    static class Button extends GuiButton {
            private final ResourceLocation field_146145_o;
            public int mouseX = 0;
            public int mouseY = 0;
            public final int width;
            public final int height;
            private boolean field_146142_r;
            public boolean isHighlighted =  false;
            public boolean isActive = false;
            private static final String __OBFID = "CL_00000743";

            protected Button(int id, int x, int y, ResourceLocation texture, int width, int height) {
                super(id, x, y, width, height, "");
                this.field_146145_o = texture;
                this.width = width;
                this.height = height;
            }

            /**
             * Draws this button to the screen.
             */
            public void drawButton(Minecraft mc, int x, int y) {
                if (this.visible) {
                	mc.getTextureManager().bindTexture(GuiBank.furnaceGuiTextures);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    this.field_146123_n = x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height;
                    this.isHighlighted = field_146123_n;
                    this.mouseX = x;
                    this.mouseY = y;
                    short v = 0;
                    int u = 0;
                    
                    if(this.id == -1) {
                    	v = 219;
                    	if(this.field_146123_n) {
                    		u = 146;
                    	} else {
                    		u = 136;
                    	}
                    } else if(this.id == -2){
                    	v = 234;
                    	if(this.field_146123_n) {
                    		u = 146;
                    	} else {
                    		u = 136;
                    	}
                    } else if(this instanceof GuiBank.BankTabButton) {
                    	v = 219;
                    	if(isActive) {
                    		u = 181;
                    	} else if(this.field_146123_n) {
                    		u = 181;
                    	} else {
                    		u = 156;
                    	}
                    } else if(this instanceof GuiBank.BankScrollButton) {
	                	v = 219;
//	                	if(this.field_146123_n) {
//	                		u = 112;
//	                	} else {
	                		u = 124;
//	                	}
	                }

                    this.drawTexturedModalRect(this.xPosition, this.yPosition, u, v, this.width, this.height);

                    if (!GuiBank.furnaceGuiTextures.equals(this.field_146145_o)) {
                    	mc.getTextureManager().bindTexture(this.field_146145_o);
                    }

                    this.drawTexturedModalRect(this.xPosition, this.yPosition, u, v, this.width, this.height);
                }
            }

            public boolean func_146141_c() {
                return this.field_146142_r;
            }

            public void func_146140_b(boolean p_146140_1_) {
                this.field_146142_r = p_146140_1_;
            }
        }

    @SideOnly(Side.CLIENT)
    class RightArrowButton extends GuiBank.Button {
        public RightArrowButton(int id, int x, int y, int width, int height)
        {
            super(id, x, y, GuiBank.furnaceGuiTextures, width, height);
        }

        public void func_146111_b(int p_146111_1_, int p_146111_2_)
        {
            GuiBank.this.drawCreativeTabHoveringText(I18n.format("gui.rightArrow", new Object[0]), p_146111_1_, p_146111_2_);
        }
    }

    @SideOnly(Side.CLIENT)
    class LeftArrowButton extends GuiBank.Button {
        public LeftArrowButton(int id, int x, int y, int width, int height)
        {
            super(id, x, y, GuiBank.furnaceGuiTextures, width, height);
        }

        public void func_146111_b(int p_146111_1_, int p_146111_2_)
        {
            GuiBank.this.drawCreativeTabHoveringText(I18n.format("gui.leftArrow", new Object[0]), p_146111_1_, p_146111_2_);
        }
    }
    
    @SideOnly(Side.CLIENT)
    class BankTabButton extends GuiBank.Button {
    	int tabNum = 0;
        public BankTabButton(int id, int tabNum, int x, int y, int width, int height)
        {
            super(id, x, y, GuiBank.furnaceGuiTextures, width, height);
            this.tabNum = tabNum;
        }

        public void func_146111_b(int p_146111_1_, int p_146111_2_)
        {
            GuiBank.this.drawCreativeTabHoveringText(I18n.format("gui.tab" + tabNum, new Object[0]), p_146111_1_, p_146111_2_);
        }
    }
    
    @SideOnly(Side.CLIENT)
    class BankScrollButton extends GuiBank.Button {
        public BankScrollButton(int id, int x, int y, int width, int height) {
            super(id, x, y, GuiBank.furnaceGuiTextures, width, height);
        }
    }
}
