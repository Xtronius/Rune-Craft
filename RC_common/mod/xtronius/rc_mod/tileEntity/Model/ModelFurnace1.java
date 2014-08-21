package mod.xtronius.rc_mod.tileEntity.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFurnace1 extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer LeftWall;
    ModelRenderer RightWall;
    ModelRenderer BackWall;
    ModelRenderer IronBar1;
    ModelRenderer IronBar2;
    ModelRenderer IronBar3;
    ModelRenderer IronBarTop;
    ModelRenderer IronBarBottom;
    ModelRenderer SmeltingPlate;
    ModelRenderer TopWall;
    ModelRenderer Plaque;
    ModelRenderer Roof;
    ModelRenderer RoofFrontLeft;
    ModelRenderer RoofFrontRight;
    ModelRenderer Roof2;
    ModelRenderer VentLeftWall;
    ModelRenderer VentRightWall;
    ModelRenderer VentBackWall;
    ModelRenderer VentFrontWall;
    ModelRenderer VentBar1;
    ModelRenderer VentBar2;
    ModelRenderer HammerHandel;
    ModelRenderer HammerMetal;
  
  public ModelFurnace1()
  {
    textureWidth = 512;
    textureHeight = 512;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 48, 4, 48);
      Base.setRotationPoint(-24F, 20F, -24F);
      Base.setTextureSize(64, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      LeftWall = new ModelRenderer(this, 200, 0);
      LeftWall.addBox(0F, 0F, 0F, 10, 26, 38);
      LeftWall.setRotationPoint(-24F, -6F, -24F);
      LeftWall.setTextureSize(64, 32);
      LeftWall.mirror = true;
      setRotation(LeftWall, 0F, 0F, 0F);
      RightWall = new ModelRenderer(this, 298, 200);
      RightWall.addBox(0F, 0F, 0F, 10, 26, 38);
      RightWall.setRotationPoint(14F, -6F, -24F);
      RightWall.setTextureSize(64, 32);
      RightWall.mirror = true;
      setRotation(RightWall, 0F, 0F, 0F);
      BackWall = new ModelRenderer(this, 310, 0);
      BackWall.addBox(0F, 0F, 0F, 48, 26, 10);
      BackWall.setRotationPoint(-24F, -6F, 14F);
      BackWall.setTextureSize(64, 32);
      BackWall.mirror = true;
      setRotation(BackWall, 0F, 0F, 0F);
      IronBar1 = new ModelRenderer(this, 450, 0);
      IronBar1.addBox(0F, 0F, 0F, 1, 12, 1);
      IronBar1.setRotationPoint(-7F, 8F, -24F);
      IronBar1.setTextureSize(64, 32);
      IronBar1.mirror = true;
      setRotation(IronBar1, 0F, 0F, 0F);
      IronBar2 = new ModelRenderer(this, 450, 0);
      IronBar2.addBox(0F, 0F, 0F, 1, 12, 1);
      IronBar2.setRotationPoint(0F, 8F, -24F);
      IronBar2.setTextureSize(64, 32);
      IronBar2.mirror = true;
      setRotation(IronBar2, 0F, 0F, 0F);
      IronBar3 = new ModelRenderer(this, 450, 0);
      IronBar3.addBox(0F, 0F, 0F, 1, 12, 1);
      IronBar3.setRotationPoint(7F, 8F, -24F);
      IronBar3.setTextureSize(64, 32);
      IronBar3.mirror = true;
      setRotation(IronBar3, 0F, 0F, 0F);
      IronBarTop = new ModelRenderer(this, 0, 70);
      IronBarTop.addBox(0F, 0F, 0F, 28, 3, 1);
      IronBarTop.setRotationPoint(-14F, 8F, -24F);
      IronBarTop.setTextureSize(64, 32);
      IronBarTop.mirror = true;
      setRotation(IronBarTop, 0F, 0F, 0F);
      IronBarBottom = new ModelRenderer(this, 67, 70);
      IronBarBottom.addBox(0F, 0F, 0F, 28, 2, 1);
      IronBarBottom.setRotationPoint(-14F, 18F, -24F);
      IronBarBottom.setTextureSize(64, 32);
      IronBarBottom.mirror = true;
      setRotation(IronBarBottom, 0F, 0F, 0F);
      SmeltingPlate = new ModelRenderer(this, 138, 68);
      SmeltingPlate.addBox(0F, 0F, 0F, 26, 2, 35);
      SmeltingPlate.setRotationPoint(-13F, 18F, -22F);
      SmeltingPlate.setTextureSize(64, 32);
      SmeltingPlate.mirror = true;
      setRotation(SmeltingPlate, 0F, 0F, 0F);
      TopWall = new ModelRenderer(this, 277, 70);
      TopWall.addBox(0F, 0F, 0F, 48, 8, 48);
      TopWall.setRotationPoint(-24F, -14F, -24F);
      TopWall.setTextureSize(64, 32);
      TopWall.mirror = true;
      setRotation(TopWall, 0F, 0F, 0F);
      Plaque = new ModelRenderer(this, 475, 85);
      Plaque.addBox(0F, 0F, 0F, 14, 14, 2);
      Plaque.setRotationPoint(-7F, -20F, -26F);
      Plaque.setTextureSize(64, 32);
      Plaque.mirror = true;
      setRotation(Plaque, 0F, 0F, 0F);
      Roof = new ModelRenderer(this, 0, 130);
      Roof.addBox(0F, 0F, 0F, 56, 6, 52);
      Roof.setRotationPoint(-28F, -20F, -24F);
      Roof.setTextureSize(64, 32);
      Roof.mirror = true;
      setRotation(Roof, 0F, 0F, 0F);
      RoofFrontLeft = new ModelRenderer(this, 225, 130);
      RoofFrontLeft.addBox(0F, 0F, 0F, 21, 6, 4);
      RoofFrontLeft.setRotationPoint(-28F, -20F, -28F);
      RoofFrontLeft.setTextureSize(64, 32);
      RoofFrontLeft.mirror = true;
      setRotation(RoofFrontLeft, 0F, 0F, 0F);
      RoofFrontRight = new ModelRenderer(this, 225, 130);
      RoofFrontRight.addBox(0F, 0F, 0F, 21, 6, 4);
      RoofFrontRight.setRotationPoint(7F, -20F, -28F);
      RoofFrontRight.setTextureSize(64, 32);
      RoofFrontRight.mirror = true;
      setRotation(RoofFrontRight, 0F, 0F, 0F);
      Roof2 = new ModelRenderer(this, 291, 130);
      Roof2.addBox(0F, 0F, 0F, 48, 6, 56);
      Roof2.setRotationPoint(-24F, -26F, -28F);
      Roof2.setTextureSize(64, 32);
      Roof2.mirror = true;
      setRotation(Roof2, 0F, 0F, 0F);
      VentLeftWall = new ModelRenderer(this, 0, 200);
      VentLeftWall.addBox(0F, 0F, 0F, 6, 4, 37);
      VentLeftWall.setRotationPoint(-18F, -30F, -18F);
      VentLeftWall.setTextureSize(64, 32);
      VentLeftWall.mirror = true;
      setRotation(VentLeftWall, 0F, 0F, 0F);
      VentRightWall = new ModelRenderer(this, 0, 200);
      VentRightWall.addBox(0F, 0F, 0F, 6, 4, 37);
      VentRightWall.setRotationPoint(12F, -30F, -18F);
      VentRightWall.setTextureSize(64, 32);
      VentRightWall.mirror = true;
      setRotation(VentRightWall, 0F, 0F, 0F);
      VentBackWall = new ModelRenderer(this, 95, 200);
      VentBackWall.addBox(0F, 0F, 0F, 24, 4, 6);
      VentBackWall.setRotationPoint(-12F, -30F, 13F);
      VentBackWall.setTextureSize(64, 32);
      VentBackWall.mirror = true;
      setRotation(VentBackWall, 0F, 0F, 0F);
      VentFrontWall = new ModelRenderer(this, 95, 200);
      VentFrontWall.addBox(0F, 0F, 0F, 24, 4, 6);
      VentFrontWall.setRotationPoint(-12F, -30F, -18F);
      VentFrontWall.setTextureSize(64, 32);
      VentFrontWall.mirror = true;
      setRotation(VentFrontWall, 0F, 0F, 0F);
      VentBar1 = new ModelRenderer(this, 165, 200);
      VentBar1.addBox(0F, 0F, 0F, 24, 2, 2);
      VentBar1.setRotationPoint(-12F, -29F, 4F);
      VentBar1.setTextureSize(64, 32);
      VentBar1.mirror = true;
      setRotation(VentBar1, 0F, 0F, 0F);
      VentBar2 = new ModelRenderer(this, 165, 200);
      VentBar2.addBox(0F, 0F, 0F, 24, 2, 2);
      VentBar2.setRotationPoint(-12F, -29F, -5F);
      VentBar2.setTextureSize(64, 32);
      VentBar2.mirror = true;
      setRotation(VentBar2, 0F, 0F, 0F);
      HammerHandel = new ModelRenderer(this, 235, 200);
      HammerHandel.addBox(0F, -5F, 0F, 1, 10, 1);
      HammerHandel.setRotationPoint(-2F, -11.5F, -27F);
      HammerHandel.setTextureSize(64, 32);
      HammerHandel.mirror = true;
      setRotation(HammerHandel, 0F, 0F, 0.7853982F);
      HammerMetal = new ModelRenderer(this, 258, 200);
      HammerMetal.addBox(0F, 0F, 0F, 6, 4, 1);
      HammerMetal.setRotationPoint(2F, -19F, -27F);
      HammerMetal.setTextureSize(64, 32);
      HammerMetal.mirror = true;
      setRotation(HammerMetal, 0F, 0F, 0.837758F);
  }
  
  public void renderModel(float f)
  {
    Base.render(f);
    LeftWall.render(f);
    RightWall.render(f);
    BackWall.render(f);
    IronBar1.render(f);
    IronBar2.render(f);
    IronBar3.render(f);
    IronBarTop.render(f);
    IronBarBottom.render(f);
    SmeltingPlate.render(f);
    TopWall.render(f);
    Plaque.render(f);
    Roof.render(f);
    RoofFrontLeft.render(f);
    RoofFrontRight.render(f);
    Roof2.render(f);
    VentLeftWall.render(f);
    VentRightWall.render(f);
    VentBackWall.render(f);
    VentFrontWall.render(f);
    VentBar1.render(f);
    VentBar2.render(f);
    HammerHandel.render(f);
    HammerMetal.render(f);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    LeftWall.render(f5);
    RightWall.render(f5);
    BackWall.render(f5);
    IronBar1.render(f5);
    IronBar2.render(f5);
    IronBar3.render(f5);
    IronBarTop.render(f5);
    IronBarBottom.render(f5);
    SmeltingPlate.render(f5);
    TopWall.render(f5);
    Plaque.render(f5);
    Roof.render(f5);
    RoofFrontLeft.render(f5);
    RoofFrontRight.render(f5);
    Roof2.render(f5);
    VentLeftWall.render(f5);
    VentRightWall.render(f5);
    VentBackWall.render(f5);
    VentFrontWall.render(f5);
    VentBar1.render(f5);
    VentBar2.render(f5);
    HammerHandel.render(f5);
    HammerMetal.render(f5);
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
