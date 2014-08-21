package mod.xtronius.rc_mod.tileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.xtronius.rc_mod.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityFurnace1 extends TileEntity
{
	@Override
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        AxisAlignedBB bb = INFINITE_EXTENT_AABB;
        Block type = getBlockType();
        if (type == Blocks.RCFurnace)
        {
            bb = AxisAlignedBB.getAABBPool().getAABB(xCoord - 1.5, yCoord, zCoord - 1.5, xCoord + 2.5, yCoord + 3.5, zCoord + 2.5);
        }
        return bb;
    }
}
