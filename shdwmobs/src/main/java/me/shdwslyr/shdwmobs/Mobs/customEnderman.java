package me.shdwslyr.shdwmobs.Mobs;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Enderman;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.shdwslyr.shdwmobs.Items;
import me.shdwslyr.shdwmobs.Main;

public class customEnderman implements Listener {
		
	Main plugin;
	
	public customEnderman(Main main) {
		this.plugin = main;
	}
	
	  @EventHandler
	  public void onEndermanSpawn(CreatureSpawnEvent e) {
	    if (e.getEntity() instanceof Enderman) {
	      Random ran = new Random();
	      int choice = ran.nextInt(100) + 1;
	      if (choice < Main.spawnPercentage) {
	        Enderman enderman = (Enderman)e.getEntity();
	        enderman.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,9999999, 9999999));
	        enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,9999999, 2));
	        enderman.setCustomName(ChatColor.GOLD + Main.customEndermanName);
	        enderman.setMaxHealth(enderman.getHealth() * 10.0D);
	        enderman.setHealth(enderman.getMaxHealth());
	        
	        if (Main.printConsoleSpawns) {
	        Location location = enderman.getLocation();
	        System.out.println("[shdwmobs] " + Main.customEndermanName + " has spawned at " + Main.coords(location));
	        }
	      } 
	    } 
	  }
	  
	  @EventHandler
	  public void onEndermanKilled(EntityDeathEvent e) {
	    if (e.getEntity() instanceof Enderman && e.getEntity().getCustomName() != null) {
	      Enderman enderman = (Enderman)e.getEntity();
	      if (enderman.getCustomName().equals(ChatColor.GOLD + Main.customEndermanName)) {
	        e.getDrops().clear();
	        e.getDrops().add(new ItemStack(Material.ENDER_PEARL, 3));
	        Random ran = new Random();
	        int choice = ran.nextInt(100) + 1;

	        if (choice < Main.dropPercentage) {
	        	Player p = enderman.getKiller();
	        	Main.inventoryAdd(p, Items.tpbow());
	        }

	      } 
	    } 
	  }
}
