package mod.xtronius.rc_mod.block.misc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockRCWood extends BlockLog
{
	public static final String[] woodType = new String[] {"willow", "maple", "mahogany", "magic"};

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 3));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.field_150167_a = new IIcon[woodType.length];
        this.field_150166_b = new IIcon[woodType.length];

        for (int i = 0; i < this.field_150167_a.length; ++i)
        {
            this.field_150167_a[i] = iconRegister.registerIcon("rc_mod:" + this.getTextureName() + "_" + woodType[i]);
            this.field_150166_b[i] = iconRegister.registerIcon("rc_mod:" + this.getTextureName() + "_" + woodType[i] + "_top");
        }
    }
}