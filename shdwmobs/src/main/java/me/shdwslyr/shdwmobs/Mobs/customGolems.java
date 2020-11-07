package me.shdwslyr.shdwmobs.Mobs;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import me.shdwslyr.shdwmobs.Main;

public class customGolems implements Listener{
	
	int percentage = Main.spawnPercentage;
	int dropPer = Main.dropPercentage;
	boolean print = Main.printConsoleSpawns;
		
	Main plugin;
	
	public customGolems(Main main) {
		this.plugin = main;
	}
	
	  @EventHandler
	  public void onIronGolemSpawn(CreatureSpawnEvent e) {
		    if (e.getEntity() instanceof IronGolem) {
		    	
		    	IronGolem golem = (IronGolem)e.getEntity();
		    	
		    	if (golem.isPlayerCreated()) {
			    	golem.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION ,5190000 , 5));
			    	golem.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE ,9999999, 3));
			    	golem.addPotionEffect(new PotionEffect(PotionEffectType.SPEED ,5190000, 3));
			    	
			    	golem.setMaxHealth(golem.getHealth() * 10.0D);
			    	golem.setHealth(golem.getMaxHealth());

			        golem.setPersistent(true);
			        
			        Random ran = new Random();
			        int choice = ran.nextInt(100) + 1;
			        golem.setCustomName(ChatColor.GOLD + "Albion " + choice);
			        
			        Location location = golem.getLocation();
			        if (Main.printConsoleSpawns){
				        World world = golem.getWorld();
			        	world.strikeLightningEffect(location); 
			        	
			        }
			        
			        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			        String command = "broadcast Albion " + choice + " was spawned at " + Main.coords(location);
			        Bukkit.dispatchCommand(console, command);
		    	}

		    } 
	  } 
}
