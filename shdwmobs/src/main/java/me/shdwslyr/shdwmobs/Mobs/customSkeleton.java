package me.shdwslyr.shdwmobs.Mobs;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.shdwslyr.shdwmobs.Items;
import me.shdwslyr.shdwmobs.Main;

public class customSkeleton implements Listener{
	
	int percentage = Main.spawnPercentage;
	int dropPer = Main.dropPercentage;
	boolean print = Main.printConsoleSpawns;
		
	Main plugin;
	
	public customSkeleton(Main main) {
		this.plugin = main;
	}
	
	  @EventHandler
	  public void onSkeletonSpawn(CreatureSpawnEvent e) {
	    if (e.getEntity() instanceof Skeleton) {
	      Random ran = new Random();
	      int choice = ran.nextInt(100) + 1;
	      if (choice < Main.spawnPercentage) {
	    	  
	        Skeleton skeleton = (Skeleton)e.getEntity();
	        skeleton.setCustomName(ChatColor.GOLD + Main.customSkeleName);
	        skeleton.setMaxHealth(skeleton.getHealth() * 10.0D);
	        skeleton.setHealth(skeleton.getMaxHealth());
	        
	        skeleton.getEquipment().setHelmet(new ItemStack(Material.GLASS));
	        skeleton.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
	        skeleton.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
	        skeleton.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
	        skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.BOW));
	        
	        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED ,9999999, 3));
	        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE ,9999999, 1));
	        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE ,9999999, 1));

	        
	        if (Main.printConsoleSpawns) {
	        Location location = skeleton.getLocation();
	        System.out.println("[shdwmobs] " + Main.customSkeleName + " has spawned at " + Main.coords(location));
	        }
	        
	        }
	        
	      } 
	    } 
	  
	  @EventHandler
	  public void onSkeletonKilled(EntityDeathEvent e) {
	    if (e.getEntity() instanceof Skeleton && e.getEntity().getCustomName() != null) {
	      Skeleton skeleton = (Skeleton)e.getEntity();
	      if (skeleton.getCustomName().equals(ChatColor.GOLD + Main.customSkeleName)) {
	        e.getDrops().clear();
	        e.getDrops().add(new ItemStack(Material.BONE, 5));
	        Random ran = new Random();
	        int choice = ran.nextInt(100) + 1;
	        
	        World world = skeleton.getWorld();
	        Location location = skeleton.getLocation();
	        
	        if (choice < Main.dropPercentage) {
	        	
	        	if (skeleton.getKiller() instanceof Player) {
	        		Player p = skeleton.getKiller();
	              	if (skeleton.getCustomName().equals(ChatColor.GOLD + Main.customSkeleName)) {
	            	    int armornum = ran.nextInt(10) + 1;
	            	    if (armornum == 3) {
	            	    	Main.inventoryAdd(p, Items.frostchestplate());
	            	    }
	            	    else {
	            	    	ItemStack drop = Items.frostchestplate();
	            	    	ItemMeta dropMeta = drop.getItemMeta();
	            	    	dropMeta.setDisplayName(dropMeta.getDisplayName() + ChatColor.RED + "☠");
	            	    	dropMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
	            	    	drop.setItemMeta(dropMeta);
		              		Main.inventoryAdd(p, drop);
	            	    }
	              	}
	            }
	        	
	        }
	        
	        

	      } 
	    } 
	  }
}
