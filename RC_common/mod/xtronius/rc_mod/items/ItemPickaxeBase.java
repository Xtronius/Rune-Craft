package mod.xtronius.rc_mod.items;

import mod.xtronius.rc_mod.creativetab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPickaxeBase extends Item {

	private String texture;
	private int axeID;

	public ItemPickaxeBase(int par1, String texture, int axeID) {
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.tabsRC_ModItems);
		this.texture = texture;
		this.axeID = axeID;
	}

	public boolean isFull3D() {
		return true;
	}
	
	public boolean canHarvestBlock(Block block)
    {
        return func_150897_b(block);
    }
	
	public boolean func_150897_b(Block p_150897_1_)
    {
        return true;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon("rc_mod:" + (this.texture));

	}
}