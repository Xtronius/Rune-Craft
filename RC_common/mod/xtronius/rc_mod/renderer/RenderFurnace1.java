package mod.xtronius.rc_mod.renderer;

import mod.xtronius.rc_mod.lib.Reference;
import mod.xtronius.rc_mod.tileEntity.Model.ModelFurnace1;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

public class RenderFurnace1 extends TileEntitySpecialRenderer{
	
	
	private ModelFurnace1 model;
	private Minecraft mc = Minecraft.getMinecraft();
	private float i = 0;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_Gui, "textures/modelTextureMaps/ModelFurnace1TextureMap2.png");
	
	public RenderFurnace1(){
		this.model = new ModelFurnace1();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180F, 0F, 0F, 1F);
		
		int i = tileentity.getBlockMetadata();
		
		short short1 = 0;

		if (i == 2)
        {
            short1 = 360;
        }

        if (i == 3)
        {
            short1 = 180;
        }

        if (i == 4)
        {
            short1 = -90;
        }

        if (i == 5)
        {
            short1 = 90;
        }
        GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
        
		//GL11.glScalef(0.2F, 0.2F, 0.2F);
		this.bindTexture(texture);
		this.model.renderModel(0.0625F);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

		float rotation = 0;
		int direction = 0;
		
		double xOffset1 = 0.5;
		double yOffset1 = 0.43;
		double zOffset1 = 0.5;
		
		double xOffset2 = 0.5;
		double yOffset2 = 0.43;
		double zOffset2 = 0.5;
		
		double xOffset3 = 0.5;
		double yOffset3 = 0.43;
		double zOffset3 = 0.5;
		
		double xOffset4 = 0.5;
		double yOffset4 = 0.43;
		double zOffset4 = 0.5;
		
		double xOffset5 = 0.5;
		double yOffset5 = 0.43;
		double zOffset5 = 0.5;
		
		if(tileentity.getBlockMetadata() == 2) {//South
			rotation = -270F;
			
			xOffset1 = 0.6;//0.5
			xOffset2 = 0.1;//0
			xOffset3 = 1.1;//1
			xOffset4 = 0.35;//.25
			xOffset5 = 0.85;
		
			yOffset1 = 0.63;
		
			zOffset4 = 0.25;
			zOffset5 = 0.25;
			
		}else
		if(tileentity.getBlockMetadata() == 3) {//North
			rotation = -90F;
			
			xOffset1 = 0.4;//0.5
			xOffset2 = 0.9;//1
			xOffset3 = -0.1;//0
			xOffset4 = 0.14;//0.25
			xOffset5 = 0.65;//0.75
			
			yOffset1 = 0.63;
			
			zOffset4 = 0.75;
			zOffset5 = 0.75;
			
		}else
		if(tileentity.getBlockMetadata() == 4) {//East
			rotation = 180F;
			
			zOffset1 = 0.6;//0.5
			zOffset2 = 0.1;//0
			zOffset3 = 1.1;//1
			zOffset4 = 0.35;//.25
			zOffset5 = 0.85;
		
			yOffset1 = 0.63;
		
			xOffset4 = 0.25;
			xOffset5 = 0.25;
		}else
		if(tileentity.getBlockMetadata() == 5) {//West
			
			zOffset1 = 0.4;//0.5
			zOffset2 = 0.9;//1
			zOffset3 = -0.1;//0
			zOffset4 = 0.14;//0.25
			zOffset5 = 0.65;//0.75
			
			yOffset1 = 0.63;
			
			xOffset4 = 0.75;
			xOffset5 = 0.75;
		}	
	
		GL11.glPushMatrix();
		ItemStack stack = new ItemStack(Block.getBlockFromName("fire"), 1000, 0);
		EntityItem entItem = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
		//Without the below line, the item will spazz out
		entItem.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		//Add the below line (without //'s) to make the item lie flat on the block

		GL11.glTranslated(x+xOffset1, y+yOffset1, z+zOffset1);
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glRotatef(rotation, 0, 1, 0);
		
		//Change the 0D's to different values to move it around
		RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		ItemStack stack2 = new ItemStack(Block.getBlockFromName("fire"), 1000, 0);
		EntityItem entItem2 = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
		//Without the below line, the item will spazz out
		entItem2.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		//Add the below line (without //'s) to make the item lie flat on the block

		GL11.glTranslated(x+xOffset2, y+yOffset2, z+zOffset2);
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glRotatef(rotation, 0, 1, 0);
		
		//Change the 0D's to different values to move it around
		RenderManager.instance.renderEntityWithPosYaw(entItem2, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		ItemStack stack3 = new ItemStack(Block.getBlockFromName("fire"), 1000, 0);
		EntityItem entItem3 = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
		//Without the below line, the item will spazz out
		entItem3.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		//Add the below line (without //'s) to make the item lie flat on the block

		GL11.glTranslated(x+xOffset3, y+yOffset3, z+zOffset3);
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glRotatef(rotation, 0, 1, 0);
		
		//Change the 0D's to different values to move it around
		RenderManager.instance.renderEntityWithPosYaw(entItem3, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();
		
		
		GL11.glPushMatrix();
		ItemStack stack4 = new ItemStack(Block.getBlockFromName("fire"), 1000, 0);
		EntityItem entItem4 = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
		//Without the below line, the item will spazz out
		entItem4.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		//Add the below line (without //'s) to make the item lie flat on the block

		GL11.glTranslated(x+xOffset4, y+yOffset4, z+zOffset4);
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glRotatef(rotation, 0, 1, 0);
		
		//Change the 0D's to different values to move it around
		RenderManager.instance.renderEntityWithPosYaw(entItem4, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		ItemStack stack5 = new ItemStack(Block.getBlockFromName("fire"), 1000, 0);
		EntityItem entItem5 = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
		//Without the below line, the item will spazz out
		entItem5.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		//Add the below line (without //'s) to make the item lie flat on the block

		GL11.glTranslated(x+xOffset5, y+yOffset5, z+zOffset5);
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glRotatef(rotation, 0, 1, 0);
		
		//Change the 0D's to different values to move it around
		RenderManager.instance.renderEntityWithPosYaw(entItem5, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();
		
//		GL11.glPushMatrix();
//		ItemStack currentSmeltingItem = new ItemStack(Block.getBlockFromName("fire"), 1000, 0);
//		EntityItem entItem = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), x, y, z, stack);
//		//Without the below line, the item will spazz out
//		entItem.hoverStart = 0.0F;
//		RenderItem.renderInFrame = true;
//		//Add the below line (without //'s) to make the item lie flat on the block
//
//		GL11.glTranslated(x+xOffset1, y+yOffset1, z+zOffset1);
//		GL11.glRotatef(90, 0, 1, 0);
//		GL11.glRotatef(rotation, 0, 1, 0);
//		
//		//Change the 0D's to different values to move it around
//		RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
//		RenderItem.renderInFrame = false;
//		GL11.glPopMatrix();
	}
	

	public static String getPlayerDirection(EntityPlayer player) {
        double rot = (player.rotationYaw - 90) % 360;
        if (rot < 0) {
            rot += 360.0;
        }
        return getDirection(rot);
    }
	
	private static String getDirection(double rot) {
        if (0 <= rot && rot < 22.5) {
            return "North";
        } else if (22.5 <= rot && rot < 45) {
            return "Northeastnorth";
        }else if (45 <= rot && rot < 67.5) {
            return "Northeasteast";
        } else if (67.5 <= rot && rot < 112.5) {
            return "East";
        } else if (112.5 <= rot && rot < 135) {
            return "Southeasteast";
        } else if (135 <= rot && rot < 157.5) {
            return "Southeastsouth";
        } else if (157.5 <= rot && rot < 202.5) {
            return "South";
        } else if (202.5 <= rot && rot < 225) {
            return "Southwestsouth";
        } else if (225 <= rot && rot < 247.5) {
            return "Southwestwest";
        } else if (247.5 <= rot && rot < 292.5) {
            return "West";
        } else if (292.5 <= rot && rot < 315) {
            return "Northwestwest";
        } else if (315 <= rot && rot < 337.5) {
            return "Northwestnorth";
        } else if (337.5 <= rot && rot < 360.0) {
            return "North";
        } else {
            return null;
        }
    }
}

