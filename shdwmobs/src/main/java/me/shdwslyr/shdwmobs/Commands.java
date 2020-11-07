package me.shdwslyr.shdwmobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.command.CommandExecutor;


public class Commands implements CommandExecutor {
	
	int percentage = Main.spawnPercentage;
    int dropPer = Main.dropPercentage;
    boolean print = Main.printConsoleSpawns;
    
	Main plugin;
	
	public Commands(Main main) {
		this.plugin = main;
	}
    
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    if (cmd.getName().equalsIgnoreCase("shdwmobs") && sender instanceof Player) {
		      Player player = (Player)sender;
		      
		      if (!sender.hasPermission("shdwmobs.use")) {
		        sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": You don't have this permission bro.");
		        return true;
		      }
		      if (sender.hasPermission("shdwmobs.use")) {
		          if (args[0].equalsIgnoreCase("zombie")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.helmet());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + Items.helmet().getItemMeta().getDisplayName());
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("skeleton")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.chestplate());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + Items.chestplate().getItemMeta().getDisplayName());
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("creeper")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.leggings());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + Items.leggings().getItemMeta().getDisplayName());
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("spider")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.boots());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + Items.boots().getItemMeta().getDisplayName());
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("sickle")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.deathSickle());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + Items.deathSickle().getItemMeta().getDisplayName());
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("piglin")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.crown());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + Items.crown().getItemMeta().getDisplayName());
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("ender")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.tpbow());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + Items.tpbow().getItemMeta().getDisplayName());
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("summon")) {
		              if (args.length == 1) {
		            	Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
		                zombie.setCustomName("Summoned Mob");
		                zombie.setBaby(false);
		                zombie.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
		                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED ,9999999, 2));
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("halloset")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.deathSickle());
		            	player.getInventory().addItem(Items.halloHelm());
		            	player.getInventory().addItem(Items.halloChest());
		            	player.getInventory().addItem(Items.halloLegg());
		            	player.getInventory().addItem(Items.halloBoots());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you the Halloween set");
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("shdwSet")) {
		              if (args.length == 1) {
		            	player.getInventory().addItem(Items.shdwHelm());
		            	player.getInventory().addItem(Items.shdwChest());
		            	player.getInventory().addItem(Items.shdwLeggs());
		            	player.getInventory().addItem(Items.shdwBoots());
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you the" + ChatColor.DARK_RED + " shdw set");
		            	return true;
		              } 
		          }
		          if (args[0].equalsIgnoreCase("reload")) {
		              if (args.length == 1) {
		            	Bukkit.getPluginManager().getPlugin("shdwmobs").reloadConfig();
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": Config successfully reloaded!");
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": mob spawn percentage - " + Main.spawnPercentage + "%");
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": item drop percentage - " + Main.dropPercentage + "%");
		            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": print console spawn - " + Main.printConsoleSpawns );
		            	System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs spawn percentage set to " + ChatColor.GREEN + Main.spawnPercentage + "%");
		         	    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs item drop percentage set to "+ ChatColor.GREEN + Main.dropPercentage + "%");
		         	    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs read spawn to console set to " + ChatColor.GREEN + Main.printConsoleSpawns);
		            	System.out.println("[shdwmobs] Config reloaded");
		            	return true;
		              } 
		          }
		          else {
		        	  sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": Try zombie, skeleton, creeper, spider, sickle, piglin, ender, halloset, shdwset");
		        	  return true;
		          }
		      } 
		      
		    }
			return false;
		  }
}
