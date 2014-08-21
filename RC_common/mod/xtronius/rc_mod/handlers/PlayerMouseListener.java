package mod.xtronius.rc_mod.handlers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerMouseListener {

	@SubscribeEvent
	public void playerClickListerner(PlayerInteractEvent event) {
		if(!event.entityPlayer.worldObj.isRemote)
			if (event.action.equals(event.action.RIGHT_CLICK_AIR)) {
				if(event.entityPlayer != null) {
					if(event.entityPlayer.inventory != null) {
						if(event.entityPlayer.inventory.getCurrentItem() != null) {
							if(event.entityPlayer.inventory.getCurrentItem().getItem() != null) {
								if(event.entityPlayer.inventory.getCurrentItem().getItem().equals(Item.getItemById(383))) {
									int mob = event.entityPlayer.inventory.getCurrentItem().getItem().getDisplayDamage(event.entityPlayer.inventory.getCurrentItem());
									ItemMonsterPlacer.spawnCreature(event.entityPlayer.worldObj, mob, event.entityPlayer.posX, event.entityPlayer.posY+1, event.entityPlayer.posZ);
								}
							}
						}
					}
				}
			}
	}
}
