package me.shdwslyr.shdwmobs.Mobs;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.shdwslyr.shdwmobs.Items;
import me.shdwslyr.shdwmobs.Main;

public class customSpiders implements Listener{
	
	int percentage = Main.spawnPercentage;
	int dropPer = Main.dropPercentage;
	boolean print = Main.printConsoleSpawns;
		
	Main plugin;
	
	public customSpiders(Main main) {
		this.plugin = main;
	}
	
	  @EventHandler
	  public void onSpiderSpawn(CreatureSpawnEvent e) {
	    if (e.getEntity() instanceof Spider) {
	      Random ran = new Random();
	      int choice = ran.nextInt(100) + 1;
	      if (choice < Main.spawnPercentage) {
	        Spider spider = (Spider)e.getEntity();
	        spider.setCustomName(ChatColor.GOLD + Main.customSpiderName);
	        spider.setMaxHealth(spider.getHealth() * 10.0D);
	        spider.setHealth(spider.getMaxHealth());
	        
	        if (Main.printConsoleSpawns) {
	        Location location = spider.getLocation();
	        System.out.println("[shdwmobs] " + Main.customSpiderName + " has spawned at " + Main.coords(location));
	        }
	      } 
	    } 
	  }
	  
	  @EventHandler
	  public void onSpiderKilled(EntityDeathEvent e) {
	    if (e.getEntity() instanceof Spider && e.getEntity().getCustomName() != null) {
	      Spider spider = (Spider)e.getEntity();
	      if (spider.getCustomName().equals(ChatColor.GOLD + Main.customSpiderName)) {
	        e.getDrops().clear();
	        e.getDrops().add(new ItemStack(Material.STRING, 5));
	        e.getDrops().add(new ItemStack(Material.SPIDER_EYE, 4));
	        Random ran = new Random();
	        int choice = ran.nextInt(100) + 1;
	        if (choice < Main.dropPercentage) {

	        	if (spider.getKiller() instanceof Player) {
	        		Player p = spider.getKiller();
	              	if (spider.getCustomName().equals(ChatColor.GOLD + Main.customSpiderName)) {
	            	    int armornum = ran.nextInt(10) + 1;
	            	    if (armornum == 3) {
	            	    	Main.inventoryAdd(p, Items.frostboots());
	            	    }
	            	    else {
	            	    	ItemStack drop = Items.frostboots();
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
