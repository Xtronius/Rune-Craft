package mod.xtronius.rc_mod.lib;

import java.util.HashMap;

import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import mod.xtronius.rc_mod.rc_mod;
import mod.xtronius.rc_mod.container.BankContainer;
import mod.xtronius.rc_mod.handlers.RCTickHandler;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketBankInvSync;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketInitCombatStyle;
import mod.xtronius.rc_mod.packetHandling.packets.generalPackets.PacketSwitchCombatStyle;
import mod.xtronius.rc_mod.proxy.CommonProxy;
import mod.xtronius.rc_mod.util.enumClasses.MeleCombatStyles;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties
{

	private HashMap<String, Integer> playerLvl = new HashMap<String, Integer>();
	private HashMap<String, Double> playerExp = new HashMap<String, Double>();
	private HashMap<String, Double> playerExpUntilNextLvl = new HashMap<String, Double>();
	
	/*Array of the level names for display**/
	public static String AttackStr = "Attack", StrengthStr = "Strength", DefenceStr  = "Defense", RangeStr = "Range", PrayerStr = "Prayer", MageStr = "Mage", RuneCraftingStr = "Rune Crafting", ConstructionStr = "Construction", DungeoneeringStr = "Dungeoneering", ConstitutionStr = "Constitution", AgilityStr = "Agility", HerbloreStr = "Herblore", ThievingStr = "Thieving", CraftingStr = "Crafting", FletchingStr = "Fletching", SlayerStr = "Slayer", HuntingStr = "Hunting", MiningStr = "Mining", SmithingStr = "Smithing", FishingStr = "Fishing", CookingStr = "Cooking", FireMakingStr = "Fire Making", WoodCuttingStr = "Wood Cutting", FarmingStr = "Farming", SummoningStr = "Summoning"; 
	public static String[] SkillsStr = new String[] {AttackStr, StrengthStr, DefenceStr, RangeStr, PrayerStr, MageStr, RuneCraftingStr, ConstructionStr, DungeoneeringStr, ConstitutionStr, AgilityStr, HerbloreStr, ThievingStr, CraftingStr, FletchingStr, SlayerStr, HuntingStr, MiningStr, SmithingStr, FishingStr, CookingStr, FireMakingStr, WoodCuttingStr, FarmingStr, SummoningStr};

	/*Array of the level names for saving**/
	public static String AttackNoSpaceStr = "Attack", StrengthNoSpaceStr = "Strength", DefenceNoSpaceStr = "Defense", RangeNoSpaceStr = "Range", PrayerNoSpaceStr = "Prayer", MageNoSpaceStr = "Mage", RuneCraftingNoSpaceStr = "RuneCrafting", ConstructionNoSpaceStr = "Construction", DungeoneeringNoSpaceStr = "Dungeoneering", ConstitutionNoSpaceStr = "Constitution", AgilityNoSpaceStr = "Agility", HerbloreNoSpaceStr = "Herblore", ThievingNoSpaceStr = "Thieving", CraftingNoSpaceStr = "Crafting", FletchingNoSpaceStr = "Fletching", SlayerNoSpaceStr = "Slayer", HuntingNoSpaceStr = "Hunting", MiningNoSpaceStr = "Mining", SmithingNoSpaceStr = "Smithing", FishingNoSpaceStr = "Fishing", CookingNoSpaceStr = "Cooking", FireMakingNoSpaceStr = "FireMaking", WoodCuttingNoSpaceStr = "WoodCutting", FarmingNoSpaceStr = "Farming", SummoningNoSpaceStr = "Summoning"; 
	public static String[] SkillsNoSpaceStr = new String[] {AttackNoSpaceStr, StrengthNoSpaceStr, DefenceNoSpaceStr, RangeNoSpaceStr, PrayerNoSpaceStr, MageNoSpaceStr, RuneCraftingNoSpaceStr, ConstructionNoSpaceStr, DungeoneeringNoSpaceStr, ConstitutionNoSpaceStr, AgilityNoSpaceStr, HerbloreNoSpaceStr, ThievingNoSpaceStr, CraftingNoSpaceStr, FletchingNoSpaceStr, SlayerNoSpaceStr, HuntingNoSpaceStr, MiningNoSpaceStr, SmithingNoSpaceStr, FishingNoSpaceStr, CookingNoSpaceStr, FireMakingNoSpaceStr, WoodCuttingNoSpaceStr, FarmingNoSpaceStr, SummoningStr};
		
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	private final EntityPlayer player;
	private boolean resetNBT = false;
	
	private Enum currentMeleAttackStyle = MeleCombatStyles.ATTACK;
	private int meleCombatStyleGuiCoolDown = 0;
	
	public int attackCoolDown = 0;
	
	public ItemStack[] playerBankStorage = new ItemStack[4212];
	
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		//init values to store
		
		for(int lvlID = 0; lvlID < this.SkillsNoSpaceStr.length; lvlID++) {
			if(this.playerLvl.get(this.SkillsNoSpaceStr[lvlID] + "Lvl") == null && this.playerExp.get(this.SkillsNoSpaceStr[lvlID] + "Exp") == null && this.playerExpUntilNextLvl.get(this.SkillsNoSpaceStr[lvlID] + "ExpUntilNextLvl") == null) {
				this.playerLvl.put(this.SkillsNoSpaceStr[lvlID] + "Lvl", 1);
				this.playerExp.put(this.SkillsNoSpaceStr[lvlID] + "Exp", (double) 0);
				this.playerExpUntilNextLvl.put(this.SkillsNoSpaceStr[lvlID] + "ExpUntilNextLvl", (double) 83);
			}
		}
	}
	
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}
	
	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	private static String getSaveKey(EntityPlayer player) {
		return player.getDisplayName() + ":" + EXT_PROP_NAME;
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		
		NBTTagCompound properties = new NBTTagCompound();
		
		if(!this.player.worldObj.isRemote) {
			
			/** Null Check Init */
			properties.setString("RC_Mod", "NullCheckForNBT");
			
			/** Lvl Saving */
			for(int lvlID = 0; lvlID < this.SkillsNoSpaceStr.length; lvlID++) {
				properties.setInteger(this.SkillsNoSpaceStr[lvlID] + "Lvl", this.playerLvl.get(this.SkillsNoSpaceStr[lvlID] + "Lvl"));
				properties.setDouble(this.SkillsNoSpaceStr[lvlID] + "Exp", this.playerExp.get(this.SkillsNoSpaceStr[lvlID] + "Exp"));
				properties.setDouble(this.SkillsNoSpaceStr[lvlID] + "ExpUntilNextLvl", this.playerExpUntilNextLvl.get(this.SkillsNoSpaceStr[lvlID] + "ExpUntilNextLvl"));
			}
			
			properties.setString("MeleAttackStyle", this.currentMeleAttackStyle.toString());
		
			compound.setTag(EXT_PROP_NAME, properties);
			
			/** Bank Handling */
	    	 NBTTagList nbttaglist = new NBTTagList();
	    	  
	        for (int i = 0; i < this.playerBankStorage.length; ++i) {
	            if (this.playerBankStorage[i] != null) {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setInteger("BankSlot", i);
	                this.playerBankStorage[i].writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }
	        compound.setTag("BankItems", nbttaglist);
		}
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound) {
		
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		
		if(!this.player.worldObj.isRemote) {
		
			/** Null Check */
			if(properties.hasKey("RC_Mod") && this.resetNBT == false) {
				
				/** Lvl Loading */
				for(int lvlID = 0; lvlID < this.SkillsNoSpaceStr.length; lvlID++) {
					this.playerLvl.put(this.SkillsNoSpaceStr[lvlID] + "Lvl", properties.getInteger(this.SkillsNoSpaceStr[lvlID] + "Lvl"));
					this.playerExp.put(this.SkillsNoSpaceStr[lvlID] + "Exp", properties.getDouble(this.SkillsNoSpaceStr[lvlID] + "Exp"));
					this.playerExpUntilNextLvl.put(this.SkillsNoSpaceStr[lvlID] + "ExpUntilNextLvl", properties.getDouble(this.SkillsNoSpaceStr[lvlID] + "ExpUntilNextLvl"));
				}
				
				this.currentMeleAttackStyle = Enum.valueOf(MeleCombatStyles.class, properties.getString("MeleAttackStyle"));	
			
				/** Bank Handling */
				
				BankContainer bank = new BankContainer(this.player.inventory, this.player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
				RCTickHandler.BankContainerMapSERVER.put(this.player, bank);
				
				NBTTagList nbttaglist = (NBTTagList) compound.getTag("BankItems");
				for (int i = 0; i < nbttaglist.tagCount(); ++i) {

					NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
					int j = nbttagcompound1.getInteger("BankSlot");
					System.out.println("This tag has a slot number of: " + j);
					
					if (j >= 0 && j < this.playerBankStorage.length) {
						this.playerBankStorage[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
					}
					
				}
				
				for(int f = 0; f < this.playerBankStorage.length; f++) {
					System.out.println("ItemStack: " + this.playerBankStorage[f] + " Slot: " + f);
				}
					
				for(int slotIndex = 0; slotIndex < this.playerBankStorage.length; slotIndex++) {
					
					ItemStack stack = this.playerBankStorage[slotIndex];
					if(bank != null) {
						if(stack != null) {
							if(slotIndex < 468)
								bank.invBank.setInventorySlotContents(0, slotIndex, stack);
							if(slotIndex < (468 * 2))
								bank.invBank.setInventorySlotContents(1, slotIndex, stack);
							if(slotIndex < (468 * 3))
								bank.invBank.setInventorySlotContents(2, slotIndex, stack);
							if(slotIndex < (468 * 4))
								bank.invBank.setInventorySlotContents(3, slotIndex, stack);
							if(slotIndex < (468 * 5))
								bank.invBank.setInventorySlotContents(4, slotIndex, stack);
							if(slotIndex < (468 * 6))
								bank.invBank.setInventorySlotContents(5, slotIndex, stack);
							if(slotIndex < (468 * 7))
								bank.invBank.setInventorySlotContents(6, slotIndex, stack);
							if(slotIndex < (468 * 8))
								bank.invBank.setInventorySlotContents(7, slotIndex, stack);
							if(slotIndex < (468 * 9))
								bank.invBank.setInventorySlotContents(8, slotIndex, stack);
							
//							System.out.println(bank.invBank.getStackInSlot(slotIndex));
							System.out.println("Setting Stack: " + this.playerBankStorage[slotIndex] + " To Slot: " + slotIndex);
						}
					}
				}
			}
			for(int i = 0; i < this.playerBankStorage.length; i++)
				this.playerBankStorage[i] = null;
			this.saveNBTData(compound);
		}
	}
	
	public static void saveProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	public static void loadProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if(savedData != null) {
			playerData.loadNBTData(savedData);
		}
		//TODO sync the playerData in the Server and the Client by sending many packets
	}
	
	public int getMeleCombatStyleInt() { 
		int result = 0;
		if(this.currentMeleAttackStyle != null) 
			if(this.currentMeleAttackStyle == MeleCombatStyles.ATTACK)
				result = 0;
			if(this.currentMeleAttackStyle == MeleCombatStyles.STRENGTH)
				result = 1;
			if(this.currentMeleAttackStyle == MeleCombatStyles.DEFENSE)
				result = 2;
			if(this.currentMeleAttackStyle == MeleCombatStyles.SHARED)
				result = 3;
			
			return result;
		}
	
	public Enum getMeleCombatStyle() { if(this.currentMeleAttackStyle != null) return this.currentMeleAttackStyle; return MeleCombatStyles.ATTACK; }
	public void setMeleCombatStyle(Enum style) {if(style != null) this.currentMeleAttackStyle = style;}
	
	public int getMeleCombatStyleGuiCoolDown() { return meleCombatStyleGuiCoolDown; }
	public void setMeleCombatStyleGuiCoolDown(int meleCombatStyleGuiCoolDown) { this.meleCombatStyleGuiCoolDown = meleCombatStyleGuiCoolDown; }
	
	public int getLvl(String lvl) { if(this.playerLvl.get(lvl + "Lvl") != null) return this.playerLvl.get(lvl + "Lvl"); return 0; }
	public void setLvl(String lvl, int value) { this.playerLvl.put(lvl + "Lvl", value); }
	
	public double getExp(String lvl) { if(this.playerExp.get(lvl + "Exp") != null) return this.playerExp.get(lvl + "Exp"); return 0; }
	public void setExp(String lvl, double value) { this.playerExp.put(lvl + "Exp", value); }
	
	public double getExpUntilNextLvl(String lvl) { if(this.playerExpUntilNextLvl.get(lvl + "ExpUntilNextLvl") != null) return this.playerExpUntilNextLvl.get(lvl + "ExpUntilNextLvl"); return 0; }
	public void setExpUntilNextLvl(String lvl, double value) { this.playerExpUntilNextLvl.put(lvl + "ExpUntilNextLvl", value); }
	
	@Override
	public void init(Entity entity, World world) {}
}