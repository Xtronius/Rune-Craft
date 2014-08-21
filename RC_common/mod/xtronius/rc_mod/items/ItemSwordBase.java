package mod.xtronius.rc_mod.items;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.List;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.creativetab.CreativeTab;
import mod.xtronius.rc_mod.handlers.LevelManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemSwordBase extends Item
{
	private static LevelManager lvlManager = new LevelManager()    ;
    private String texture;

    public ItemSwordBase(int par1, String texture, int swordID)
    {
        super();
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTab.tabsRC_ModItems);
        this.texture = texture;
    }
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean par4) {
		super.addInformation(stack, player, list, par4);
		list.add("Attack Damage: ");
    }
//    /**
//     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
//     * update it's contents.
//     */
//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
//		if (!world.isRemote) {
//			if (entity instanceof EntityPlayerMP) {
//				EntityPlayerMP player = (EntityPlayerMP) entity;
//				if(player != null && player.inventory != null && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() != null) {
//					if (player.inventory.getCurrentItem().getItem() == this) {
//					}
//				}
//			}
//		}
//	}

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }
    
    public double getDamage(EntityPlayer player) {
    	return 0;
    }
}
