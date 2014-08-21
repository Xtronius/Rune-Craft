package mod.xtronius.rc_mod.renderer;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.lib.Reference;
import mod.xtronius.rc_mod.tileEntity.TileEntityLogFire;
import mod.xtronius.rc_mod.tileEntity.Model.ModelLogFire;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderLogFire extends TileEntitySpecialRenderer{
	
	
	private ModelLogFire model;
	private static ResourceLocation texture;
	private Minecraft mc = Minecraft.getMinecraft();
	
	public RenderLogFire(){
		this.model = new ModelLogFire();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.275F, (float)z + 0.5F);
		GL11.glRotatef(180F, 0F, 0F, 1F);
        
        GL11.glScalef(0.85f, 0.85f, 0.85f);
        
        
        int metadata = tileEntity.getBlockMetadata();
        String blockType = "Wood";
        
        if(metadata == 0) {
        	blockType = "Wood";
        }
		if(metadata == 1) {
			blockType = "Yew" ; 	
		}
		if(metadata == 2) {
			blockType = "Oak";
		}
		if(metadata == 3) {
			blockType = "Teak";
		}
		if(metadata == 4) {
			blockType = "Willow";
		}
		if(metadata == 5) {
			blockType = "Maple";
		}
		if(metadata == 6) {
			blockType = "Mahogany";
		}
		if(metadata == 7) {
			blockType = "Magic";
		}
		
		texture = new ResourceLocation(Reference.MOD_Gui, "textures/modelTextureMaps/ModelFire_Texture_Map_"+ blockType + ".png");

		this.bindTexture(texture);
		
		if(tileEntity instanceof TileEntityLogFire) {
			TileEntityLogFire tileEntityLogFire = (TileEntityLogFire) tileEntity;
			if(tileEntityLogFire.getTicksActivated() > tileEntityLogFire.burnTicks) {
				
				tileEntityLogFire.setAlphaValue(tileEntityLogFire.getAlphaValue()-0.0015F);
				
				float alpha = tileEntityLogFire.getAlphaValue();
				
				GL11.glEnable(GL11.GL_BLEND);
				
				GL11.glColor4f(1, 1, 1, alpha);
				
			}
		}
		
		
		this.model.renderModel(0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
	
		GL11.glPopMatrix();
		
		if(tileEntity instanceof TileEntityLogFire && tileEntity.blockType.equals(Blocks.LogFireActive)) {
			TileEntityLogFire tileEntityLogFire = (TileEntityLogFire) tileEntity;
				
			if(tileEntityLogFire.getTicksActivated() < 50 && !(tileEntityLogFire.getFireScaleX() > 1.65F) && !(tileEntityLogFire.getFireScaleY() > 1.5) && !(tileEntityLogFire.getFireScaleY() > 1.65F)) {
				tileEntityLogFire.setFireScaleX(tileEntityLogFire.getFireScaleX() + 0.013F);
				tileEntityLogFire.setFireScaleY(tileEntityLogFire.getFireScaleY() + 0.01F);
				tileEntityLogFire.setFireScaleZ(tileEntityLogFire.getFireScaleZ() + 0.013F);
			}
			
			if(tileEntityLogFire.getTicksActivated() > tileEntityLogFire.burnTicks && !(tileEntityLogFire.getFireScaleX() < 0) && !(tileEntityLogFire.getFireScaleY() < 0) && !(tileEntityLogFire.getFireScaleY() < 0)) {
				tileEntityLogFire.setFireScaleX(tileEntityLogFire.getFireScaleX() - 0.017F);
				tileEntityLogFire.setFireScaleY(tileEntityLogFire.getFireScaleY() - 0.016F);
				tileEntityLogFire.setFireScaleZ(tileEntityLogFire.getFireScaleZ() - 0.017F);
			}
			
			
			GL11.glPushMatrix();
			ItemStack stack = new ItemStack(Block.getBlockFromName("fire"), 1, 0);
			EntityItem entItem = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
			
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
	
			GL11.glTranslated(x+0.5, y+0.3F, z+0.5);
			GL11.glRotatef(45, 0, 1, 0);
			GL11.glScalef(tileEntityLogFire.getFireScaleX(), tileEntityLogFire.getFireScaleY(), tileEntityLogFire.getFireScaleZ());
			
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
			
			GL11.glPushMatrix();
			ItemStack stack2 = new ItemStack(Block.getBlockFromName("fire"), 1, 0);
			EntityItem entItem2 = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
			
			entItem2.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
	
			GL11.glTranslated(x+0.5, y+0.3F, z+0.5);
			GL11.glRotatef(-45, 0, 1, 0);
			GL11.glScalef(tileEntityLogFire.getFireScaleX(), tileEntityLogFire.getFireScaleY(), tileEntityLogFire.getFireScaleZ());    
			
			RenderManager.instance.renderEntityWithPosYaw(entItem2, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
			
			if(!mc.isFancyGraphicsEnabled()) {
				GL11.glPushMatrix();
				ItemStack stack3 = new ItemStack(Block.getBlockFromName("fire"), 1, 0);
				EntityItem entItem3 = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
				
				entItem3.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
		
				GL11.glTranslated(x+0.5, y+0.3F, z+0.5);
				GL11.glRotatef(225, 0, 1, 0);
				GL11.glScalef(tileEntityLogFire.getFireScaleX(), tileEntityLogFire.getFireScaleY(), tileEntityLogFire.getFireScaleZ());
				
				RenderManager.instance.renderEntityWithPosYaw(entItem3, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
				
				GL11.glPushMatrix();
				ItemStack stack4 = new ItemStack(Block.getBlockFromName("fire"), 1, 0);
				EntityItem entItem4 = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
				
				entItem4.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
		
				GL11.glTranslated(x+0.5, y+0.3F, z+0.5);
				GL11.glRotatef(-225, 0, 1, 0);
				GL11.glScalef(tileEntityLogFire.getFireScaleX(), tileEntityLogFire.getFireScaleY(), tileEntityLogFire.getFireScaleZ());    
				
				RenderManager.instance.renderEntityWithPosYaw(entItem4, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
		}
	}
}

