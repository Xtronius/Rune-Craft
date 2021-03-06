package mod.xtronius.rc_mod.furnaceRecipies;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.xtronius.rc_mod.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class RCIngotFurnace1Recipes{

	private static final RCIngotFurnace1Recipes smeltingBase = new RCIngotFurnace1Recipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final RCIngotFurnace1Recipes smelting()
    {
        return smeltingBase;
    }

    private RCIngotFurnace1Recipes()
    {   	
    	this.addSmelting(Block.getIdFromBlock(Block.getBlockFromName("iron_ore")), new ItemStack(Item.getItemById(265)), 0.7F);
        this.addSmelting(Block.getIdFromBlock(Block.getBlockFromName("gold_ore")), new ItemStack(Item.getItemById(266)), 1.0F);
        this.addSmelting(Block.getIdFromBlock(Block.getBlockFromName("diamond_ore")), new ItemStack(Item.getItemById(264)), 1.0F);
        this.addSmelting(Block.getIdFromBlock(Block.getBlockFromName("coal_ore")), new ItemStack(Item.getItemById(263)), 1.0F);
        this.addSmelting(Block.getIdFromBlock(Block.getBlockFromName("emerald_ore")), new ItemStack(Item.getItemById(388)), 0.1F);
        this.addSmelting(Block.getIdFromBlock(Block.getBlockFromName("lapis_ore")), new ItemStack(Item.getItemById(351), 1, 4), 0.2F);
        this.addSmelting(Block.getIdFromBlock(Block.getBlockFromName("quartz_ore")), new ItemStack(Item.getItemById(406)), 0.2F);
    }

    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(int par1, ItemStack stack, float par3)
    {
        this.smeltingList.put(Integer.valueOf(par1), stack);
        this.experienceList.put(Integer.valueOf(Item.getIdFromItem(stack.getItem())), Float.valueOf(par3));
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    @Deprecated //In favor of ItemStack sensitive version
    public float getExperience(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(Item.getIdFromItem(itemstack.getItem()), itemstack.getItemDamage()), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(Item.getIdFromItem(item.getItem())));
    }

    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public float getExperience(ItemStack item)
    {
    	System.out.println("hello");
        return 1;
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return metaSmeltingList;
    }
}
