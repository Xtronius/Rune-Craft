package mod.xtronius.rc_mod.creativetab;

import mod.xtronius.rc_mod.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTab {
	
	public static CreativeTabs tabsRC_ModItems = new CreativeTabBC_Mod_Items(CreativeTabs.getNextID(), Reference.Creative_Tabs_Items);
	public static CreativeTabs tabsRC_ModBlocks = new CreativeTabBC_Mod_Blocks(CreativeTabs.getNextID(), Reference.Creative_Tabs_Blocks);

}
