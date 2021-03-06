package mod.xtronius.rc_mod.tileEntity.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLogFire extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
  
  public ModelLogFire()
  {
    textureWidth = 512;
    textureHeight = 512;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(-2F, -2F, 0F, 4, 4, 10);
      Shape1.setRotationPoint(7F, 22F, -7F);
      Shape1.setTextureSize(512, 512);
      Shape1.mirror = true;
      setRotation(Shape1, 0.1396263F, -0.7853982F, 0F);
      Shape2 = new ModelRenderer(this, 50, 0);
      Shape2.addBox(-2F, -2F, 0F, 4, 4, 8);
      Shape2.setRotationPoint(-7F, 22F, -7F);
      Shape2.setTextureSize(512, 512);
      Shape2.mirror = true;
      setRotation(Shape2, 0.0698132F, 0.7853982F, 0F);
      Shape3 = new ModelRenderer(this, 100, 0);
      Shape3.addBox(-2F, -2F, -10F, 4, 4, 10);
      Shape3.setRotationPoint(-7F, 22F, 7F);
      Shape3.setTextureSize(512, 512);
      Shape3.mirror = true;
      setRotation(Shape3, -0.1396263F, -0.7853982F, 0F);
      Shape4 = new ModelRenderer(this, 150, 0);
      Shape4.addBox(-2F, -2F, -8F, 4, 4, 8);
      Shape4.setRotationPoint(7F, 22F, 7F);
      Shape4.setTextureSize(512, 512);
      Shape4.mirror = true;
      setRotation(Shape4, -0.0698132F, 0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
  }
  
  public void renderModel(float f) {
	  Shape1.render(f);
	  Shape2.render(f);
	  Shape3.render(f);
	  Shape4.render(f);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
