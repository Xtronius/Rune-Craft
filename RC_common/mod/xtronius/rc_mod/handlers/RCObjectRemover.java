package mod.xtronius.rc_mod.handlers;

import net.minecraft.item.Item;

public class RCObjectRemover {

	public RCObjectRemover() {
		Item.getItemById(271).setCreativeTab(null);//Wood Axe
		Item.getItemById(275).setCreativeTab(null);//Stone Axe
		Item.getItemById(286).setCreativeTab(null);//Gold Axe
		Item.getItemById(279).setCreativeTab(null);//Diamond Axe
		
		Item.getItemById(270).setCreativeTab(null);
		Item.getItemById(274).setCreativeTab(null);
		Item.getItemById(285).setCreativeTab(null);
		Item.getItemById(278).setCreativeTab(null);
	}
}
