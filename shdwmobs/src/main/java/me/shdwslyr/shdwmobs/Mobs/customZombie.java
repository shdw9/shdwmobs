package me.shdwslyr.shdwmobs.Mobs;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.shdwslyr.shdwmobs.Items;
import me.shdwslyr.shdwmobs.Main;

public class customZombie implements Listener{
	
	int percentage = Main.spawnPercentage;
	int dropPer = Main.dropPercentage;
	boolean print = Main.printConsoleSpawns;
		
	Main plugin;
	
	public customZombie(Main main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void onZombieSpawn(CreatureSpawnEvent e) {
	    if (e.getEntity() instanceof Zombie) {
	      Random ran = new Random();
	      int choice = ran.nextInt(100) + 1;
	      if (choice < Main.spawnPercentage) {
	    	  
	        Zombie zombie = (Zombie)e.getEntity();
	        zombie.setCustomName(ChatColor.GOLD +  Main.customZombieName);
	        
	        if (zombie.isBaby()) {
	        	zombie.setBaby(false);
	        }
	        
	        zombie.getEquipment().setHelmet(new ItemStack(Material.GLASS));
	        zombie.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
	        zombie.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
	        zombie.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
	        zombie.getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_AXE));
	        
	    	zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED ,9999999, 2));
	        
	        zombie.setMaxHealth(zombie.getHealth() * 10.0D);
	        zombie.setHealth(zombie.getMaxHealth());
	        
	        if (Main.printConsoleSpawns) {
	        	Location location = zombie.getLocation();
	            System.out.println("[shdwmobs] " + Main.customZombieName + " has spawned at " + Main.coords(location));
	        }
	      }
	        
	    } 
	 } 
	  
	 @EventHandler
	 public void onZombieKilled(EntityDeathEvent e) {
	    if (e.getEntity() instanceof Zombie && e.getEntity().getCustomName() != null) {
	      Zombie zombie = (Zombie)e.getEntity();
	      if (zombie.getCustomName().equals(ChatColor.GOLD + Main.customZombieName)) {
	        e.getDrops().clear();
	        e.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 5));
	        
	        Random ran = new Random();
	        int choice = ran.nextInt(100) + 1;

	        
	        if (choice < Main.dropPercentage) {
	        	
	        	if (zombie.getKiller() instanceof Player) {
	        		Player p = zombie.getKiller();
	              	if (zombie.getCustomName().equals(ChatColor.GOLD + Main.customZombieName)) {
	            	    int armornum = ran.nextInt(10) + 1;
	            	    if (armornum == 3) {
	            	    	Main.inventoryAdd(p, Items.frosthelmet());
	            	    }
	            	    else {
	            	    	ItemStack drop = Items.frosthelmet();
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
