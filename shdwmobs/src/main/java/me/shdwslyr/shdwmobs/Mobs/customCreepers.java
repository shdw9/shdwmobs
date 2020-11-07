package me.shdwslyr.shdwmobs.Mobs;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.shdwslyr.shdwmobs.Items;
import me.shdwslyr.shdwmobs.Main;

public class customCreepers implements Listener{
	
	int percentage = Main.spawnPercentage;
	int dropPer = Main.dropPercentage;
	boolean print = Main.printConsoleSpawns;
		
	Main plugin;
	
	public customCreepers(Main main) {
		this.plugin = main;
	}
	
	  @EventHandler
	  public void onCreeperSpawn(CreatureSpawnEvent e) {
	    if (e.getEntity() instanceof Creeper) {
	      Random ran = new Random();
	      int choice = ran.nextInt(100) + 1;
	      if (choice < Main.spawnPercentage) {
	    	  
	        Creeper creeper = (Creeper)e.getEntity();
	        creeper.setPowered(true);
	        creeper.setCustomName(ChatColor.GOLD + Main.customCreeperName);
	        
	        creeper.setMaxHealth(creeper.getHealth() * 5.0D);
	        creeper.setHealth(creeper.getMaxHealth());
	        
	        if (Main.printConsoleSpawns) {
	        	Location location = creeper.getLocation();
	        	System.out.println("[shdwmobs] " + Main.customCreeperName + " has spawned at " + Main.coords(location));
	        }
	      }
	        
	    } 
	  } 
	  
	  @EventHandler
	  public void onCreeperKilled(EntityDeathEvent e) {
	    if (e.getEntity() instanceof Creeper && e.getEntity().getCustomName() != null) {
	      Creeper creeper = (Creeper)e.getEntity();
	      if (creeper.getCustomName().equals(ChatColor.GOLD + Main.customCreeperName)) {
	        e.getDrops().clear();
	        Random ran = new Random();
	        e.getDrops().add(new ItemStack(Material.GUNPOWDER, 5));
	        int choice = ran.nextInt(100) + 1;
	        
	        if (choice < Main.dropPercentage) {

	        	if (creeper.getKiller() instanceof Player) {
	        		Player p = creeper.getKiller();
	              	if (creeper.getCustomName().equals(ChatColor.GOLD + Main.customCreeperName)) {
	            	    int armornum = ran.nextInt(10) + 1;
	            	    if (armornum == 3) {
	            	    	Main.inventoryAdd(p, Items.frostleggings());
	            	    }
	            	    else {
	            	    	ItemStack drop = Items.frostleggings();
	            	    	ItemMeta dropMeta = drop.getItemMeta();
	            	    	dropMeta.setDisplayName(dropMeta.getDisplayName() + ChatColor.RED + "☠"); // adds skull and vanishing curse
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
