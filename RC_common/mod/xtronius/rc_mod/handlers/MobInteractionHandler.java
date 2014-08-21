package mod.xtronius.rc_mod.handlers;

import java.util.Random;

import mod.xtronius.rc_mod.lib.EntityInfo;
import mod.xtronius.rc_mod.lib.ExtendedPlayer;
import mod.xtronius.rc_mod.lib.WeaponInfo;
import mod.xtronius.rc_mod.util.RCPlayer;
import mod.xtronius.rc_mod.util.enumClasses.EnumLvlInfo;
import mod.xtronius.rc_mod.util.enumClasses.MeleCombatStyles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MobInteractionHandler {
	
	private EntityInfo entityInfo = new EntityInfo();
	private WeaponInfo weaponInfo = new WeaponInfo();
	private Random rand = new Random();
	
	@SubscribeEvent
	public void EntityInteractHandler(EntityInteractEvent event) {
		if(!event.entityPlayer.worldObj.isRemote && event.target instanceof EntityLiving) {
		EntityLiving entityLiving =  (EntityLiving)event.target;
		System.out.println(entityLiving.getCustomNameTag());
		}
	}
	
	@SubscribeEvent
	public void PlayerAttackEntityHandler(AttackEntityEvent event) {
		if (!event.entityPlayer.worldObj.isRemote && event.target instanceof EntityLiving && event.entityPlayer != null) {	
			EntityLiving entityLiving = (EntityLiving) event.target;
			ExtendedPlayer props = ExtendedPlayer.get(event.entityPlayer);
			System.out.println(props.attackCoolDown);
			
			if (props != null && hasCombatLvl(event.target) && props.attackCoolDown < 1) {	
				float result = 0F;
				int attackLvl = props.getLvl("Attack");
				int strengthLvl = props.getLvl("Strength");
				int defenseLvl = props.getLvl("Defense");
				float mobHealth = entityLiving.getHealth();
				int combatLvl = event.target.getEntityData().getInteger("CombatLvl");
				String mobName = event.target.getEntityData().getString("MobType");
				
				if (inventoryCheck(event.entityPlayer) && attackLvl >= weaponInfo.weaponLvl.get(event.entityPlayer.inventory.getCurrentItem().getItem())) {
					props.attackCoolDown = 40;	
					float weaponDamage = weaponInfo.weaponDamage.get(event.entityPlayer.inventory.getCurrentItem().getItem());
					MeleCombatStyles styles = Enum.valueOf(MeleCombatStyles.class, props.getMeleCombatStyle().toString());
					switch(styles) {
						case ATTACK:
							result = calaulateAttack(event.entityPlayer, mobName, attackLvl, combatLvl, weaponDamage);
							break;
						case STRENGTH:
							result = calaulateStength(event.entityPlayer, mobName, strengthLvl, combatLvl, weaponDamage);
							break;
						case DEFENSE:
							result = calaulateDefense(event.entityPlayer, mobName, defenseLvl, combatLvl, weaponDamage);;
							break;
						case SHARED:
							result = calaulateShared(event.entityPlayer, mobName, attackLvl, strengthLvl, defenseLvl, combatLvl, weaponDamage);
							break;
					}
					event.entityPlayer.getAttributeMap().getAttributeInstanceByName("generic.attackDamage").setBaseValue(result);				
				} else if(inventoryCheck(event.entityPlayer) && !(attackLvl >= weaponInfo.weaponLvl.get(event.entityPlayer.inventory.getCurrentItem().getItem()))) {
					event.entityPlayer.getAttributeMap().getAttributeInstanceByName("generic.attackDamage").setBaseValue(0);
					RCPlayer.messagePlayer(event.entityPlayer, "You Are Not Capable of Wielding a Tool of This Caliber of Power! You Must be at Least Lvl " + weaponInfo.weaponLvl.get(event.entityPlayer.inventory.getCurrentItem().getItem()));
				} else {
					props.attackCoolDown = 40;
					MeleCombatStyles styles = Enum.valueOf(MeleCombatStyles.class, props.getMeleCombatStyle().toString());
					switch(styles) {
						case ATTACK:
							result = calaulateAttack(event.entityPlayer, mobName, attackLvl, combatLvl, 0);
							break;
						case STRENGTH:
							result = calaulateStength(event.entityPlayer, mobName, strengthLvl, combatLvl, 0); 
							break;
						case DEFENSE:
							result = calaulateDefense(event.entityPlayer, mobName, defenseLvl, combatLvl, 0); 
							break;
						case SHARED:
							result = calaulateShared(event.entityPlayer, mobName, attackLvl, strengthLvl, defenseLvl, combatLvl, 0); 
							break;
					}
					event.entityPlayer.getAttributeMap().getAttributeInstanceByName("generic.attackDamage").setBaseValue(result);
				}
			} else
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void EntitySpawnHandler(EntityJoinWorldEvent event) {
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityLiving) {
			EntityLiving entityLiving =  (EntityLiving)event.entity;
			if(this.entityInfo.getIsEntityLiving(entityLiving.getCommandSenderName()))
				if(!event.entity.getEntityData().hasKey("CombatLvl") && !(event.entity.getEntityData().hasKey("MobType"))) {
					
					int entityCombatLvl = 0;
					
					if(!entityLiving.isChild())
						entityCombatLvl = rand.nextInt((entityInfo.EntityLvlMax.get(entityLiving.getCommandSenderName()) - entityInfo.EntityLvlMin.get(entityLiving.getCommandSenderName())));
					else	
						entityCombatLvl = rand.nextInt((entityInfo.EntityLvlMaxChild.get(entityLiving.getCommandSenderName()) - entityInfo.EntityLvlMinChild.get(entityLiving.getCommandSenderName())));
						
						event.entity.getEntityData().setInteger("CombatLvl", (entityCombatLvl + 1));
						event.entity.getEntityData().setString("MobType", entityLiving.getCommandSenderName());
						entityLiving.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(entityInfo.EntityMobHealth.get(entityLiving.getCommandSenderName()));
						entityLiving.getDataWatcher().updateObject(6, Float.valueOf(MathHelper.clamp_float(entityInfo.EntityMobHealth.get(entityLiving.getCommandSenderName()), 0.0F, entityInfo.EntityMobHealth.get(entityLiving.getCommandSenderName()) + 1)));
						entityLiving.setCustomNameTag((entityLiving.getEntityData().getString("MobType") + " Lvl: " + event.entity.getEntityData().getInteger("CombatLvl")));
				}
		}
	}
	
	private float calaulateAttack(EntityPlayer player, String mobName, float attackLvl, float combatLvl, float weaponDamage) {
		float result = 0;
		result = (weaponDamage + (attackLvl/combatLvl));
		
		System.out.println(this.entityInfo.EntityMobHealth.get(mobName));
		if(result < this.entityInfo.EntityMobHealth.get(mobName))
			LevelManager.addAttack(player, ((result/this.entityInfo.EntityMobHealth.get(mobName)) * this.entityInfo.EntityMobXp.get(mobName)));
		else
		LevelManager.addAttack(player, this.entityInfo.EntityMobXp.get(mobName));
		return result;
	}
	
	private float calaulateStength(EntityPlayer player, String mobName, float strengthLvl, float combatLvl, float weaponDamage) {
		float result = 0;
		result = (weaponDamage + (strengthLvl/combatLvl));
		if(result < this.entityInfo.EntityMobHealth.get(mobName))
			LevelManager.addStrength(player, ((result/this.entityInfo.EntityMobHealth.get(mobName)) * this.entityInfo.EntityMobXp.get(mobName)));
		else
			LevelManager.addStrength(player, this.entityInfo.EntityMobXp.get(mobName));
		return result;
	}
	
	private float calaulateDefense(EntityPlayer player, String mobName, float defenseLvl, float combatLvl, float weaponDamage) {
		float result = 0;
		result = (weaponDamage + (defenseLvl/combatLvl));
		if(result < this.entityInfo.EntityMobHealth.get(mobName))
			LevelManager.addDefense(player, ((result/this.entityInfo.EntityMobHealth.get(mobName)) * this.entityInfo.EntityMobXp.get(mobName)));
		else
			LevelManager.addDefense(player, this.entityInfo.EntityMobXp.get(mobName));
		return result;
	}
	
	private float calaulateShared(EntityPlayer player, String mobName, float attackLvl, float strengthLvl, float defenseLvl, float combatLvl, float weaponDamage) {
		float result = 0;
		float adverage = ((attackLvl + strengthLvl + defenseLvl)/3);
		result = (weaponDamage + (adverage/combatLvl));
		if(result < this.entityInfo.EntityMobHealth.get(mobName))
			LevelManager.addMeleCombatShared(player, ((result/this.entityInfo.EntityMobHealth.get(mobName)) * this.entityInfo.EntityMobXp.get(mobName)));
		else
			LevelManager.addMeleCombatShared(player, this.entityInfo.EntityMobXp.get(mobName));
		return result;
	}
	
	private boolean hasCombatLvl(Entity target) { return target.getEntityData().hasKey("CombatLvl"); }
	
	private boolean inventoryCheck(EntityPlayer player) {
		return player.inventory != null && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() != null && weaponInfo.weaponDamage.get(player.inventory.getCurrentItem().getItem()) != null; 
	}
}
