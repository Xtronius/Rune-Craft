package mod.xtronius.rc_mod.creativetab;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * BC_Mod
 * 
 * CreativeTabBC_Mod
 * 
 * @author Xtronius
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CreativeTabBC_Mod_Blocks extends CreativeTabs {

    public CreativeTabBC_Mod_Blocks(int tabID, String tabLabel) {

        super(tabID, tabLabel);
    }

    @Override
    @SideOnly(Side.CLIENT)

	public Item getTabIconItem() {
		return Item.getItemFromBlock(Block.getBlockFromName("coal_block"));
	}

}
