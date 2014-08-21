package mod.xtronius.rc_mod.handlers;

import java.util.Random;

import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;

public class LevelManager {
	Random rand = new Random();
	
	public static void addWoodCuttingHarvest(EntityPlayer player, double xpIncreaseAmount) {
			
			ExtendedPlayer props = ExtendedPlayer.get(player);
			
			if(props != null) {
				int currentLvl = props.getLvl("WoodCutting");
				double currentExp = props.getExp("WoodCutting");
				double xpUntilNextLvl = props.getExpUntilNextLvl("WoodCutting");
				
				if(currentLvl < 100) {
					currentExp += xpIncreaseAmount;
					xpUntilNextLvl -= xpIncreaseAmount;
					
					if(xpUntilNextLvl <= 0) {
						currentLvl ++;
						sendLvlUpMessage(player, "Wood-Cutting", currentLvl);
							
						EntityFireworkRocket entity = new EntityFireworkRocket(player.worldObj, (double)((float)player.posX), (double)((float)player.posY), (double)((float)player.posZ), new ItemStack(Item.getItemById(401)));
			            entity.motionY = entity.motionY/1000;
						player.worldObj.spawnEntityInWorld(entity);
						
						xpUntilNextLvl = experienceForLevel(currentLvl);
					}
					
					System.out.println("CurrentLvl" + "   " + "CurrentXP" + "   " + "XPUntilNextLvl");
					System.out.println(currentLvl + "   " + currentExp + "   " + xpUntilNextLvl);
					
					props.setLvl("WoodCutting", currentLvl);
					props.setExp("WoodCutting", currentExp);
					props.setExpUntilNextLvl("WoodCutting", xpUntilNextLvl);
				}
			}
	}
	
	public static void addMiningHarvest(EntityPlayer player, double xpIncreaseAmount) {
			
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		if(props != null) {
			int currentLvl = props.getLvl("Mining");
			double currentExp = props.getExp("Mining");
			double xpUntilNextLvl = props.getExpUntilNextLvl("Mining");
			
			if(currentLvl < 100) {
				currentExp += xpIncreaseAmount;
				xpUntilNextLvl -= xpIncreaseAmount;
				
				if(xpUntilNextLvl <= 0) {
					currentLvl ++;
					sendLvlUpMessage(player, "Mining", currentLvl);
					
					EntityFireworkRocket entity = new EntityFireworkRocket(player.worldObj, (double)((float)player.posX), (double)((float)player.posY), (double)((float)player.posZ), new ItemStack(Item.getItemById(401)));
		            entity.motionY = entity.motionY/1000;
					player.worldObj.spawnEntityInWorld(entity);
					
					xpUntilNextLvl = experienceForLevel(currentLvl);
				}
				
				System.out.println("CurrentLvl" + "   " + "CurrentXP" + "   " + "XPUntilNextLvl");
				System.out.println(currentLvl + "   " + currentExp + "   " + xpUntilNextLvl);
				
				props.setLvl("Mining", currentLvl);
				props.setExp("Mining", currentExp);
				props.setExpUntilNextLvl("Mining", xpUntilNextLvl);
			}
		}
	}
	public static void addAttack(EntityPlayer player, double xpIncreaseAmount) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		if(props != null) {
			int currentLvl = props.getLvl("Attack");
			double currentExp = props.getExp("Attack");
			double xpUntilNextLvl = props.getExpUntilNextLvl("Attack");
			
			if(currentLvl < 100) {
				currentExp += xpIncreaseAmount;
				xpUntilNextLvl -= xpIncreaseAmount;
				
				if(xpUntilNextLvl <= 0) {
					currentLvl ++;
					sendLvlUpMessage(player, "Attack", currentLvl);
					
					EntityFireworkRocket entity = new EntityFireworkRocket(player.worldObj, (double)((float)player.posX), (double)((float)player.posY), (double)((float)player.posZ), new ItemStack(Item.getItemById(401)));
		            entity.motionY = entity.motionY/1000;
					player.worldObj.spawnEntityInWorld(entity);
					
					xpUntilNextLvl = experienceForLevel(currentLvl);
				}
				
				System.out.println("CurrentLvl" + "   " + "CurrentXP" + "   " + "XPUntilNextLvl");
				System.out.println(currentLvl + "   " + currentExp + "   " + xpUntilNextLvl);
				
				props.setLvl("Attack", currentLvl);
				props.setExp("Attack", currentExp);
				props.setExpUntilNextLvl("Attack", xpUntilNextLvl);
			}
		}
	}
	
	public static void addStrength(EntityPlayer player, double xpIncreaseAmount) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		if(props != null) {
			int currentLvl = props.getLvl("Strength");
			double currentExp = props.getExp("Strength");
			double xpUntilNextLvl = props.getExpUntilNextLvl("Strength");
			
			if(currentLvl < 100) {
				currentExp += xpIncreaseAmount;
				xpUntilNextLvl -= xpIncreaseAmount;
				
				if(xpUntilNextLvl <= 0) {
					currentLvl ++;
					sendLvlUpMessage(player, "Strength", currentLvl);
					
					EntityFireworkRocket entity = new EntityFireworkRocket(player.worldObj, (double)((float)player.posX), (double)((float)player.posY), (double)((float)player.posZ), new ItemStack(Item.getItemById(401)));
		            entity.motionY = entity.motionY/1000;
					player.worldObj.spawnEntityInWorld(entity);
					
					xpUntilNextLvl = experienceForLevel(currentLvl);
				}
				
				System.out.println("CurrentLvl" + "   " + "CurrentXP" + "   " + "XPUntilNextLvl");
				System.out.println(currentLvl + "   " + currentExp + "   " + xpUntilNextLvl);
				
				props.setLvl("Strength", currentLvl);
				props.setExp("Strength", currentExp);
				props.setExpUntilNextLvl("Strength", xpUntilNextLvl);
			}
		}
	}
	
	public static void addDefense(EntityPlayer player, double xpIncreaseAmount) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		if(props != null) {
			int currentLvl = props.getLvl("Defense");
			double currentExp = props.getExp("Defense");
			double xpUntilNextLvl = props.getExpUntilNextLvl("Defense");
			
			if(currentLvl < 100) {
				currentExp += xpIncreaseAmount;
				xpUntilNextLvl -= xpIncreaseAmount;
				
				if(xpUntilNextLvl <= 0) {
					currentLvl ++;
					sendLvlUpMessage(player, "Defense", currentLvl);
					
					EntityFireworkRocket entity = new EntityFireworkRocket(player.worldObj, (double)((float)player.posX), (double)((float)player.posY), (double)((float)player.posZ), new ItemStack(Item.getItemById(401)));
		            entity.motionY = entity.motionY/1000;
					player.worldObj.spawnEntityInWorld(entity);
					
					xpUntilNextLvl = experienceForLevel(currentLvl);
				}
				
				System.out.println("CurrentLvl" + "   " + "CurrentXP" + "   " + "XPUntilNextLvl");
				System.out.println(currentLvl + "   " + currentExp + "   " + xpUntilNextLvl);
				
				props.setLvl("Defense", currentLvl);
				props.setExp("Defense", currentExp);
				props.setExpUntilNextLvl("Defense", xpUntilNextLvl);
			}
		}
	}
	
	public static void addMeleCombatShared(EntityPlayer player, double xpIncreaseAmount) {
		double divdedXP = (xpIncreaseAmount/3);
		addAttack(player, divdedXP);
		addStrength(player, divdedXP);
		addDefense(player, divdedXP);
	}
	
	public static void addFireMaking(EntityPlayer player, double xpIncreaseAmount) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		if(props != null) {
			int currentLvl = props.getLvl("FireMaking");
			double currentExp = props.getExp("FireMaking");
			double xpUntilNextLvl = props.getExpUntilNextLvl("FireMaking");
			
			if(currentLvl < 100) {
				currentExp += xpIncreaseAmount;
				xpUntilNextLvl -= xpIncreaseAmount;
				
				if(xpUntilNextLvl <= 0) {
					currentLvl ++;
					sendLvlUpMessage(player, "Fire Making", currentLvl);
					
					EntityFireworkRocket entity = new EntityFireworkRocket(player.worldObj, (double)((float)player.posX), (double)((float)player.posY), (double)((float)player.posZ), new ItemStack(Item.getItemById(401)));
		            entity.motionY = entity.motionY/1000;
					player.worldObj.spawnEntityInWorld(entity);
					
					xpUntilNextLvl = experienceForLevel(currentLvl);
				}
				
				System.out.println("CurrentLvl" + "   " + "CurrentXP" + "   " + "XPUntilNextLvl");
				System.out.println(currentLvl + "   " + currentExp + "   " + xpUntilNextLvl);
				
				props.setLvl("FireMaking", currentLvl);
				props.setExp("FireMaking", currentExp);
				props.setExpUntilNextLvl("FireMaking", xpUntilNextLvl);
			}
		}
	}
	
	public static int getLvl(EntityPlayer player, String LevelName) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		if(props != null) {
			return props.getLvl("LevelName");
		}
		return 0;
	}
	private static double experienceForLevel(int level)
	{
		double total = 0;
		int i = level;
			total += Math.floor((300 * Math.pow(2, i / 7.0)) + i);
			
		return Math.floor(total / 4);
	}
	
	private static void sendLvlUpMessage(EntityPlayer player, String lvlName, int currentLvl) {
		//player.addChatMessage("\u00a7a" + "Congratulation Your Attack Level Is Now" + lvlName + currentLvl + "!");
		player.addChatMessage(new ChatComponentText("\u00a7a" + "Congratulation Your " + lvlName +  " Level Is Now " + currentLvl + "!"));
	}
}
