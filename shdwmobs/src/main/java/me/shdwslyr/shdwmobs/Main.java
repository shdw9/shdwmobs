package me.shdwslyr.shdwmobs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.connorlinfoot.titleapi.TitleAPI;

import me.shdwslyr.shdwmobs.Mobs.customCreepers;
import me.shdwslyr.shdwmobs.Mobs.customEnderman;
import me.shdwslyr.shdwmobs.Mobs.customGolems;
import me.shdwslyr.shdwmobs.Mobs.customSkeleton;
import me.shdwslyr.shdwmobs.Mobs.customSpiders;
import me.shdwslyr.shdwmobs.Mobs.customZombie;

import org.bukkit.World;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Villager;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.EnderDragon;

import org.bukkit.Location;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class Main extends JavaPlugin implements Listener {
	
	public static int spawnPercentage;
	public static int dropPercentage;
	public static boolean printConsoleSpawns;
	
	public static String customZombieName;
	public static String customSkeleName;
	public static String customCreeperName;
	public static String customSpiderName;
	public static String customEndermanName;
	
	public static String zombieHelm;
	public static String skeleChest;
	public static String creepLegg;
	public static String spidBoots;
	public static String enderBow;
	
	
	public static String coords(Location n) {

		  int x = n.getBlockX();
		  
		  int y = n.getBlockY();
		  
		  int z = n.getBlockZ();
			
		  String coords = x + ", " + y + ", " + z;
	      
		  return coords;
	}

	public void onEnable() {
	    getConfig().options().copyDefaults();
	    saveDefaultConfig();
	    getServer().getPluginManager().registerEvents(this, (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new customZombie(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new customEnderman(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new customCreepers(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new customSkeleton(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new customSpiders(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new customGolems(this), (Plugin)this);
	    getCommand("shdwmobs").setExecutor((CommandExecutor)new Commands(this));
	    
	    Main.spawnPercentage = getConfig().getInt("Percentage");
	    Main.dropPercentage = getConfig().getInt("DropPercentage");
	    Main.printConsoleSpawns = getConfig().getBoolean("printConsoleSpawns");
	    
	    Main.customZombieName = getConfig().getString("shdwZombieName");
	    Main.customSkeleName = getConfig().getString("shdwSkeletonName");
	    Main.customCreeperName = getConfig().getString("shdwCreeperName");
	    Main.customSpiderName = getConfig().getString("shdwSpiderName");
	    Main.customEndermanName = getConfig().getString("shdwEndermanName");
	    
	    Main.zombieHelm = getConfig().getString("ZombieHelmetName");
	    Main.skeleChest = getConfig().getString("SkeletonChestplateName");
	    Main.creepLegg = getConfig().getString("CreeperLeggingsName");
	    Main.spidBoots = getConfig().getString("SpiderBootsName");
	    Main.enderBow = getConfig().getString("BowName");

	    
	    System.out.println("[shdwmobs] shdw mobs spawn percentage set to " + Main.spawnPercentage + "%");
	    System.out.println("[shdwmobs] shdw mobs item drop percentage set to "+ Main.dropPercentage + "%");
	    System.out.println("[shdwmobs] shdw mobs read spawn to console set to " + Main.printConsoleSpawns);
	}
	
	
	public static void playerMsg(Player p, ItemStack item) {
		  World w = p.getWorld();
		  String itemname = item.getItemMeta().getDisplayName();
		  w.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
	      TitleAPI.sendTitle(p,20,40,20,"&dLucky Drop!"," &8It looks like a " + itemname + "&8 dropped!");
	      p.sendMessage(ChatColor.RED + "shdw" + ChatColor.GOLD +": Lucky drop! The " + itemname + ChatColor.GOLD + " has a "+ Main.dropPercentage + "% drop rate!");
	      System.out.println(p.getPlayerListName() + " has received a " + itemname);
		  
	}
	
	public static boolean isInventoryFull(Player p)
	{
		Inventory inv = p.getInventory();
	    return inv.firstEmpty() == -1;
	}
	
	public static void inventoryAdd(Player p, ItemStack item) {
		if (isInventoryFull(p)) {
			TitleAPI.sendTitle(p,20,40,20,"&cInventory is full!","&cDropping the items on the floor!");
			p.getWorld().dropItem(p.getLocation(), item);
		}
		else {
			p.getInventory().addItem(item);
			playerMsg(p,item);
		}
	}
}
