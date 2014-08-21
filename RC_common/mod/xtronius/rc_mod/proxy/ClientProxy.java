package mod.xtronius.rc_mod.proxy;


import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.renderer.RenderFurnace1;
import mod.xtronius.rc_mod.renderer.RenderLogFire;
import mod.xtronius.rc_mod.tileEntity.TileEntityFurnace1;
import mod.xtronius.rc_mod.tileEntity.TileEntityLogFire;
import mod.xtronius.rc_mod.util.KeyBindings;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.client.registry.ClientRegistry;

/**
 * BC_Mod
 * 
 * ClientProxy
 * 
 * @author xtronius
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ClientProxy extends CommonProxy {
	 public static int renderBCFenceID;
	 static int startEntityId = 345;
	 @Override
	 public void registerRenderInformation()
	  {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFurnace1.class, new RenderFurnace1());
		
		 if(rc_mod.playerSettings.settings.getPlayerSettingsValues("RenderRCFire", "b").equals(true))
			 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLogFire.class, new RenderLogFire());
	  }
	 @Override
	 public void initSounds() {
		 
	 }
	 
	 public void initKeyBindings() {
		 KeyBindings.init();
	 }
	 
	 public static int getUniqueEntityId() {
	        do startEntityId++;
	        while (EntityList.getStringFromID(startEntityId) != null);
	        return startEntityId;
	  }
}
