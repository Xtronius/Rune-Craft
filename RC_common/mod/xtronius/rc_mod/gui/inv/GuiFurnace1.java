package mod.xtronius.rc_mod.gui.inv;

import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.container.Furnace1Container;
import mod.xtronius.rc_mod.inventory.InvFurnace1;
import mod.xtronius.rc_mod.lib.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFurnace1 extends GuiContainer
{
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(Reference.MOD_Gui, "textures/gui/container/GuiFurnace1.png");
//    private ServerTickHandler tickHandler = rc_mod.proxy.getServerTickHandler();
    private static Furnace1Container container;
    private InvFurnace1 invFurnace;

    public GuiFurnace1(InventoryPlayer playerInv, World world, int x, int y, int z)
    {
    	super(container = new Furnace1Container(playerInv, world, x, y, z));
//    	tickHandler.furnace1ContainerMapCLIENT.put(playerInv.player, container);
        this.invFurnace = container.getInv();
        this.xSize = 230;
        this.ySize = 219;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        // String s = invFurnace.isInvNameLocalized() ? invFurnace.getInvName() : I18n.getString(invFurnace.getInvName());
    	String s = "Furnace";
        this.fontRendererObj.drawString(s, ((this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2) + 1), 6, 8355711);
        //this.fontRendererObj.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96, 8355711);
        this.fontRendererObj.drawString("inventory", 8, this.ySize - 96, 8355711);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float x, int y, int z)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        
        int i1;

        i1 = this.container.getCookProgressScaled(44);
        
        //Progress Bar
        this.drawTexturedModalRect(k + 119, l + 111, 142, 221, i1 + 1, 30);
        this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), this.container.getSmeltResult(), k + 156, l + 110);
    }
}
