package mod.xtronius.rc_mod.items;

import mod.xtronius.rc_mod.block.Blocks;
import mod.xtronius.rc_mod.creativetab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLogs extends Item {

	private String texture;

	public ItemLogs(int par1, String texture) {
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.tabsRC_ModItems);
		this.texture = texture;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon("rc_mod:" + (this.texture));

	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		
		if(block != null && block.isOpaqueCube() && world.getBlock(x, y+1, z) == Block.getBlockFromName("air") && hitY == 1) {
			if(this.texture == "Logs") {
				world.setBlock(x, y+1, z, Blocks.LogFireIdle, 0, 2);
			}
			else if(this.texture == "Yew_logs") {
				world.setBlock(x, y+1, z, Blocks.LogFireIdle, 1, 2);
			}
			else if(this.texture == "Oak_logs") {
				world.setBlock(x, y+1, z, Blocks.LogFireIdle, 2, 2); 	
			}
			else if(this.texture == "Teak_logs") {
				world.setBlock(x, y+1, z, Blocks.LogFireIdle, 3, 2);
			}
			else if(this.texture == "Willow_logs") {
				world.setBlock(x, y+1, z, Blocks.LogFireIdle, 4, 2);
			}
			else if(this.texture == "Maple_logs") {
				world.setBlock(x, y+1, z, Blocks.LogFireIdle, 5, 2);
			}
			else if(this.texture == "Mahogany_logs") {
				world.setBlock(x, y+1, z, Blocks.LogFireIdle, 6, 2);
			}
			else if(this.texture == "Magic_logs") {
				world.setBlock(x, y+1, z, Blocks.LogFireIdle, 7, 2);
			}
			
			if(!player.capabilities.isCreativeMode)
				stack.stackSize--;
			return true;
		}
        return false;
    }
}