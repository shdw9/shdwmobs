package shdwtiers.plugin;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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

import org.bukkit.Location;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;


public class TieredMobs extends JavaPlugin implements Listener {
  public void onEnable() {
    getConfig().options().copyDefaults();
    saveDefaultConfig();
    getServer().getPluginManager().registerEvents(this, (Plugin)this);
    getServer().getPluginManager().registerEvents(new ThunderBowEvent(this), (Plugin)this);
    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs spawn percentage set to " + ChatColor.GREEN + getConfig().getInt("Percentage") + "%");
    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs item drop percentage set to "+ ChatColor.GREEN + getConfig().getInt("DropPercentage") + "%");
    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs read spawn to console set to " + ChatColor.GREEN + getConfig().getBoolean("printConsoleSpawns"));
  }
  
  ItemStack tpbow = new ItemStack(Material.BOW);
  ItemMeta tpbowMeta = this.tpbow.getItemMeta();
  
  ItemStack helmet;
  ItemMeta helmetMeta;
  
  ItemStack chestplate;
  ItemMeta chestMeta;
  
  ItemStack leggings;
  ItemMeta leggingsMeta;
  
  ItemStack boots;
  ItemMeta bootsMeta;
  
  ItemStack crown;
  ItemMeta crownMeta;
  
  ItemStack boner;
  ItemMeta bonerMeta;
  
  ItemStack chicken;
  ItemMeta chickenMeta;
  
  ItemStack villager;
  ItemMeta villagerMeta;
  
  ItemStack deathSickle;
  ItemMeta deathMeta;
  
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
	            	player.getInventory().addItem(this.helmet);
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + this.helmet.getItemMeta().getDisplayName());
	            	return true;
	              } 
	          }
	          if (args[0].equalsIgnoreCase("skeleton")) {
	              if (args.length == 1) {
	            	player.getInventory().addItem(this.chestplate);
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + this.chestplate.getItemMeta().getDisplayName());
	            	return true;
	              } 
	          }
	          if (args[0].equalsIgnoreCase("creeper")) {
	              if (args.length == 1) {
	            	player.getInventory().addItem(this.leggings);
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + this.leggings.getItemMeta().getDisplayName());
	            	return true;
	              } 
	          }
	          if (args[0].equalsIgnoreCase("spider")) {
	              if (args.length == 1) {
	            	player.getInventory().addItem(this.boots);
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + this.boots.getItemMeta().getDisplayName());
	            	return true;
	              } 
	          }
	          if (args[0].equalsIgnoreCase("hallo")) {
	              if (args.length == 1) {
	            	player.getInventory().addItem(this.deathSickle);
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + this.deathSickle.getItemMeta().getDisplayName());
	            	return true;
	              } 
	          }
	          if (args[0].equalsIgnoreCase("piglin")) {
	              if (args.length == 1) {
	            	player.getInventory().addItem(this.crown);
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + this.crown.getItemMeta().getDisplayName());
	            	return true;
	              } 
	          }
	          if (args[0].equalsIgnoreCase("ender")) {
	              if (args.length == 1) {
	            	player.getInventory().addItem(this.tpbow);
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": I've given you a " + this.tpbow.getItemMeta().getDisplayName());
	            	return true;
	              } 
	          }
	          if (args[0].equalsIgnoreCase("reload")) {
	              if (args.length == 1) {
	            	Bukkit.getPluginManager().getPlugin("shdwmobs").reloadConfig();
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": Config successfully reloaded!");
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": mob spawn percentage - " + getConfig().getInt("Percentage") + "%");
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": item drop percentage - " + getConfig().getInt("DropPercentage") + "%");
	            	sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": print console spawn - " + getConfig().getBoolean("printConsoleSpawns"));
	            	System.out.println("[shdwmobs] Config reloaded");
	            	return true;
	              } 
	          }
	          else {
	        	  sender.sendMessage(ChatColor.RED + "shdw" + ChatColor.WHITE +": Try zombie, skeleton, creeper, spider, hallo, piglin");
	        	  return true;
	          }
	      } 
	      
	    }
		return false;
	  }
  
  public TieredMobs() {
	  
	String bowname = getConfig().getString("BowName");
	this.tpbowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', bowname));
	this.tpbowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
	this.tpbowMeta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
	this.tpbowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
	this.tpbowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
	ArrayList<String> lore = new ArrayList<>();
	lore.add(ChatColor.DARK_RED + "" + ChatColor.ITALIC + "Lighting On Hit");
	this.tpbowMeta.setLore(lore);
	this.tpbow.setItemMeta(this.tpbowMeta);
    
    this.helmet = new ItemStack(Material.DIAMOND_HELMET);
    this.helmetMeta = this.helmet.getItemMeta();
    String zombiehelmet = getConfig().getString("ZombieHelmetName");
    this.helmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', zombiehelmet));
    this.helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.helmetMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false); // halloween set to 10
    this.helmetMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false); // halloween
    // this.helmetMeta.addEnchant(Enchantment.WATER_WORKER, 1, false);
    this.helmetMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.helmetMeta.addEnchant(Enchantment.MENDING, 1, false);
    // this.helmetMeta.addEnchant(Enchantment.OXYGEN, 3, false);
    this.helmetMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
    ArrayList<String> loreHelm = new ArrayList<>();
    loreHelm.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop"); // halloween
    this.helmetMeta.setLore(loreHelm);
    this.helmet.setItemMeta(this.helmetMeta);
    
    this.chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
    this.chestMeta = this.chestplate.getItemMeta();
    String skeletonchestplate = getConfig().getString("SkeletonChestplateName");
    this.chestMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', skeletonchestplate));
    this.chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    // this.chestMeta.addEnchant(Enchantment.THORNS, 3, false);
    this.chestMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false); // halloween set to 10
    this.chestMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false); // halloween
    this.chestMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.chestMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.chestMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
    ArrayList<String> loreChest = new ArrayList<>();
    loreChest.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop"); // halloween
    this.chestMeta.setLore(loreChest);
    this.chestplate.setItemMeta(this.chestMeta);
    
    this.leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
    this.leggingsMeta = this.leggings.getItemMeta();
    String creeperleggings = getConfig().getString("CreeperLeggingsName");
    this.leggingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', creeperleggings));
    this.leggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.leggingsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, false); // halloween set to 10
    this.leggingsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false); // halloween
    // this.leggingsMeta.addEnchant(Enchantment.THORNS, 3, false);
    this.leggingsMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.leggingsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.leggingsMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
    ArrayList<String> loreLegg = new ArrayList<>();
    loreLegg.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop"); // halloween
    this.leggingsMeta.setLore(loreLegg);
    this.leggings.setItemMeta(this.leggingsMeta);
    
    this.boots = new ItemStack(Material.DIAMOND_BOOTS);
    this.bootsMeta = this.boots.getItemMeta();
    String spiderboots = getConfig().getString("SpiderBootsName");
    this.bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', spiderboots));
    this.bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.bootsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);  // halloween set to 10
    this.bootsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false); // halloween
    this.bootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, false);
    this.bootsMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.bootsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.bootsMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
    ArrayList<String> loreBoots = new ArrayList<>();
    loreBoots.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop"); // halloween
    this.bootsMeta.setLore(loreBoots);
    this.boots.setItemMeta(this.bootsMeta);
    
    // DEATH SICKLE
    this.deathSickle = new ItemStack(Material.NETHERITE_HOE);
    this.deathMeta = this.deathSickle.getItemMeta();
    String deathsickle = getConfig().getString("halloEventWeapon");
    this.deathMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', deathsickle));
    this.deathMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.deathMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
    this.deathMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, false);
    this.deathMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, false);
    this.deathMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, false);
    this.deathMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
    ArrayList<String> deathSi = new ArrayList<>();
    deathSi.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop"); // halloween
    this.deathMeta.setLore(deathSi);
    this.deathSickle.setItemMeta(this.deathMeta);
    
    this.crown = new ItemStack(Material.GOLDEN_HELMET);
    this.crownMeta = this.crown.getItemMeta();
    String crownhelm = getConfig().getString("PiglinHelmetName");
    this.crownMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', crownhelm));
    this.crownMeta.addEnchant(Enchantment.DURABILITY, 10, false);
    this.crownMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
    this.crownMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.crownMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.crown.setItemMeta(this.crownMeta);
    
    this.boner = new ItemStack(Material.BONE);
    this.bonerMeta = this.boner.getItemMeta();
    String bonerbone = getConfig().getString("BonerName");
    this.bonerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', bonerbone));
    this.bonerMeta.addEnchant(Enchantment.KNOCKBACK, 3, false);
    this.bonerMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.bonerMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
    this.boner.setItemMeta(this.bonerMeta);
    
    this.chicken = new ItemStack(Material.COOKED_CHICKEN);
    this.chickenMeta = this.chicken.getItemMeta();
    String drchicken = getConfig().getString("ChickenName");
    this.chickenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', drchicken));
    this.chickenMeta.addEnchant(Enchantment.LURE,  2,  false);
    this.chickenMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.chickenMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
    this.chicken.setItemMeta(this.chickenMeta);
  }
  
//  #############################################
//  # +---------------------------------------+ #
//  # |               zombies                 | #
//  # +---------------------------------------+ #
//  #############################################
  
  @EventHandler
  public void onZombieSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Zombie) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
    	  
        Zombie zombie = (Zombie)e.getEntity();
        zombie.setCustomName(ChatColor.GOLD +  getConfig().getString("shdwZombieName"));
        
        //e.getEntity().getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        e.getEntity().getEquipment().setHelmet(new ItemStack(Material.CARVED_PUMPKIN));
        e.getEntity().getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_AXE));
        
        zombie.setMaxHealth(zombie.getHealth() * 10.0D);
        zombie.setHealth(zombie.getMaxHealth());
        
        /*Location location = zombie.getLocation();
        if (getConfig().getBoolean("lightningOnSpawn")){
	        World world = zombie.getWorld();
        	world.strikeLightningEffect(location); */
        
        
        
        if (getConfig().getBoolean("printConsoleSpawns")) {
        	Location location = zombie.getLocation();
            System.out.println("[shdwmobs] " + getConfig().getString("shdwZombieName") + " has spawned at " + coords(location));
        }
        }
        
      } 
    } 
  
  @EventHandler
  public void onZombieKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Zombie && e.getEntity().getCustomName() != null) {
      Zombie zombie = (Zombie)e.getEntity();
      if (zombie.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwZombieName"))) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 5));
        
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        
        if (choice < dropPer) {
        	
        	if (zombie.getKiller() instanceof Player) {
        		Player p = zombie.getKiller();
              	if (zombie.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwZombieName"))) {
              		e.getDrops().add(this.helmet); 
              	    playerMsg(p,this.helmet.getItemMeta().getDisplayName());
              	}
            }
        	
        }
        
      } 
    } 
  }

//  #############################################
//  # +---------------------------------------+ #
//  # |               skeleton                | #
//  # +---------------------------------------+ #
//  #############################################
  
  @EventHandler
  public void onSkeletonSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Skeleton) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
    	  
        Skeleton skeleton = (Skeleton)e.getEntity();
        skeleton.setCustomName(ChatColor.GOLD + getConfig().getString("shdwSkeletonName"));
        skeleton.setMaxHealth(skeleton.getHealth() * 10.0D);
        skeleton.setHealth(skeleton.getMaxHealth());
        
        //e.getEntity().getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        e.getEntity().getEquipment().setHelmet(new ItemStack(Material.CARVED_PUMPKIN));
        e.getEntity().getEquipment().setItemInMainHand(new ItemStack(Material.BOW));
        
        /*Location location = skeleton.getLocation();
        if (getConfig().getBoolean("lightningOnSpawn")){
	        World world = skeleton.getWorld();
        	world.strikeLightningEffect(location); */
        
        if (getConfig().getBoolean("printConsoleSpawns")) {
        Location location = skeleton.getLocation();
        System.out.println("[shdwmobs] " + getConfig().getString("shdwSkeletonName") + " has spawned at " + coords(location));
        }
        
        }
        
      } 
    } 
  
  @EventHandler
  public void onSkeletonKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Skeleton && e.getEntity().getCustomName() != null) {
      Skeleton skeleton = (Skeleton)e.getEntity();
      if (skeleton.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwSkeletonName"))) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.BONE, 5));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        
        World world = skeleton.getWorld();
        Location location = skeleton.getLocation();
        
        if (choice < dropPer) {
        	
        	if (skeleton.getKiller() instanceof Player) {
        		Player p = skeleton.getKiller();
              	if (skeleton.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwSkeletonName"))) {
              		e.getDrops().add(this.chestplate); 
              	    playerMsg(p,this.chestplate.getItemMeta().getDisplayName());
              	}
            }
        	
            world.strikeLightningEffect(location);
            for (int i = 1; i<= 3; i++) {
            	skeleton.getWorld().spawnEntity(location,EntityType.WITHER_SKELETON);
            }
        }
        
        

      } 
    } 
  }
  
//  #############################################
//  # +---------------------------------------+ #
//  # |              wskeleton                | #
//  # +---------------------------------------+ #
//  #############################################
  
  @EventHandler
  public void onWitherSkelSpawn(CreatureSpawnEvent e) {
	    if (e.getEntity() instanceof WitherSkeleton) {
	    	
	    	WitherSkeleton withersk = (WitherSkeleton)e.getEntity();
	    	
        	Location l = withersk.getLocation();
        	
        	String world = "world";
        	
        	if (world.contains(l.getWorld().getName())) {
        		
    	        Random ran = new Random();
    	        int choice = ran.nextInt(100) + 1;
    	        if (choice < 20) { // 50% chance to spawn shdwWitherSkeleton

    	        	withersk.setCustomName(ChatColor.GOLD + getConfig().getString("shdwWitherSkeleName"));
    	        	
    	        	e.getEntity().getEquipment().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
    	        	e.getEntity().getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_AXE));
    	        
    	        	withersk.setMaxHealth(withersk.getHealth() * 5.0D);
    	        	withersk.setHealth(withersk.getMaxHealth());
    	        	// System.out.println("Successfully spawned in: " + l.getWorld().getName());
    	        	
    	        	if (getConfig().getBoolean("printConsoleSpawns")) {
    	        	Location location = withersk.getLocation();
    	            System.out.println("[shdwmobs] " + getConfig().getString("shdwWitherSkeleName") + " has spawned at " + coords(location));
    	        	}
    	        } 
        	}
        	else {
        		System.out.println("Can't spawn in: " + l.getWorld().getName() + "!");
        	}

	    }
  }
  
  @EventHandler
  public void onWitherSkDeath(EntityDeathEvent e) {
    if (e.getEntity() instanceof WitherSkeleton && e.getEntity().getCustomName() != null) {
    	
      WitherSkeleton skeleton = (WitherSkeleton)e.getEntity();
      Entity killer = skeleton.getKiller();
      
      if (killer instanceof Player) {
    	  Player p = skeleton.getKiller();
          if (!p.getInventory().contains(this.deathSickle, 1)) {
        	  if (skeleton.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwWitherSkeleName"))) {
        	        e.getDrops().clear();
        	        e.getDrops().add(this.deathSickle);
        	        e.getDrops().add(new ItemStack(Material.PUMPKIN_PIE, 3));
        	        playerMsg(p, this.deathSickle.getItemMeta().getDisplayName());
        	  }
        	       
          }
      }

    }
  } 

//  #############################################
//  # +---------------------------------------+ #
//  # |               creeper                 | #
//  # +---------------------------------------+ #
//  #############################################
  
  @EventHandler
  public void onCreeperSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Creeper) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
    	  
        Creeper creeper = (Creeper)e.getEntity();
        creeper.setPowered(true);
        creeper.setCustomName(ChatColor.GOLD + getConfig().getString("shdwCreeperName"));
        
        creeper.setMaxHealth(creeper.getHealth() * 5.0D);
        creeper.setHealth(creeper.getMaxHealth());
        
        /*Location location = creeper.getLocation();
        if (getConfig().getBoolean("lightningOnSpawn")){
	        World world = creeper.getWorld();
        	world.strikeLightningEffect(location); */
        
        if (getConfig().getBoolean("printConsoleSpawns")) {
        Location location = creeper.getLocation();
        System.out.println("[shdwmobs] " + getConfig().getString("shdwCreeperName") + " has spawned at " + coords(location));
        }
        }
        
      } 
    } 
  
  @EventHandler
  public void onCreeperKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Creeper && e.getEntity().getCustomName() != null) {
      Creeper creeper = (Creeper)e.getEntity();
      if (creeper.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwCreeperName"))) {
        e.getDrops().clear();
        Random ran = new Random();
        e.getDrops().add(new ItemStack(Material.GUNPOWDER, 5));
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        
        if (choice < dropPer) {

        	if (creeper.getKiller() instanceof Player) {
        		Player p = creeper.getKiller();
              	if (creeper.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwCreeperName"))) {
              		e.getDrops().add(this.leggings); 
              	    playerMsg(p,this.leggings.getItemMeta().getDisplayName());
              	}
            }
        }
        
      } 
    } 
  }

//  #############################################
//  # +---------------------------------------+ #
//  # |               spiders                 | #
//  # +---------------------------------------+ #
//  #############################################
  
  @EventHandler
  public void onSpiderSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Spider) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
        Spider spider = (Spider)e.getEntity();
        spider.setCustomName(ChatColor.GOLD + getConfig().getString("shdwSpiderName"));
        spider.setMaxHealth(spider.getHealth() * 10.0D);
        spider.setHealth(spider.getMaxHealth());
        
        if (getConfig().getBoolean("printConsoleSpawns")) {
        Location location = spider.getLocation();
        System.out.println("[shdwmobs] " + getConfig().getString("shdwSpiderName") + " has spawned at " + coords(location));
        }
      } 
    } 
  }
  
  @EventHandler
  public void onSpiderKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Spider && e.getEntity().getCustomName() != null) {
      Spider spider = (Spider)e.getEntity();
      if (spider.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwSpiderName"))) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.STRING, 5));
        e.getDrops().add(new ItemStack(Material.SPIDER_EYE, 4));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        
        if (choice < dropPer) {

        	if (spider.getKiller() instanceof Player) {
        		Player p = spider.getKiller();
              	if (spider.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwSpiderName"))) {
              		e.getDrops().add(this.boots); 
              	    playerMsg(p,this.boots.getItemMeta().getDisplayName());
              	}
            }
        	
        }
        
      } 
    } 
  }

  
//  #############################################
//  # +---------------------------------------+ #
//  # |              endermen                 | #
//  # +---------------------------------------+ #
//  #############################################
  
  @EventHandler
  public void onEndermanSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Enderman) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
        Enderman enderman = (Enderman)e.getEntity();
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,9999999, 9999999));
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,9999999, 2));
        enderman.setCustomName(ChatColor.GOLD + getConfig().getString("shdwEndermanName"));
        enderman.setMaxHealth(enderman.getHealth() * 10.0D);
        enderman.setHealth(enderman.getMaxHealth());
        
        if (getConfig().getBoolean("printConsoleSpawns")) {
        Location location = enderman.getLocation();
        System.out.println("[shdwmobs] " + getConfig().getString("shdwEndermanName") + " has spawned at " + coords(location));
        }
      } 
    } 
  }
  
  @EventHandler
  public void onEndermanKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Enderman && e.getEntity().getCustomName() != null) {
      Enderman enderman = (Enderman)e.getEntity();
      if (enderman.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwEndermanName"))) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.ENDER_PEARL, 3));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");

        if (choice < dropPer) {
        	e.getDrops().add(this.tpbow); 
        }

      } 
    } 
  }

//  #############################################
//  # +---------------------------------------+ #
//  # |               piglin                  | #
//  # +---------------------------------------+ #
//  #############################################
  
  @EventHandler
  public void onPiglinSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Piglin) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
    	  
        Piglin piglin = (Piglin)e.getEntity();
        piglin.setCustomName(ChatColor.GOLD + getConfig().getString("shdwPiglinName"));
        
        e.getEntity().getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        e.getEntity().getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
        
        /*Location location = piglin.getLocation();
        if (getConfig().getBoolean("lightningOnSpawn")){
	        World world = piglin.getWorld();
        	world.strikeLightningEffect(location); 
        }*/
        
        if (getConfig().getBoolean("printConsoleSpawns")) {
        Location location = piglin.getLocation();
        System.out.println("[shdwmobs] " + getConfig().getString("shdwPiglinName") + " has spawned at " + coords(location));
        }
        
        piglin.setMaxHealth(piglin.getHealth() * 10.0D);
        piglin.setHealth(piglin.getMaxHealth());
      } 
    } 
  }
  
  @EventHandler
  public void onPiglinKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Piglin && e.getEntity().getCustomName() != null) {
      Piglin piglin = (Piglin)e.getEntity();
      if (piglin.getCustomName().equals(ChatColor.GOLD + getConfig().getString("shdwPiglinName"))) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.GOLD_INGOT, 3));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        
        if (choice < dropPer) {
        	e.getDrops().add(this.crown); 
        }

      } 
    } 
  }
  
//  #############################################
//  # +---------------------------------------+ #
//  # |                MISC                   | #
//  # +---------------------------------------+ #
//  #############################################
  
  @EventHandler
  public void onChickenSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Chicken) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("ChickenPercentage");
      if (choice < percentage) {
    	  
        Chicken chicken = (Chicken)e.getEntity();
        chicken.setCustomName(ChatColor.GOLD + "DrChicken");
        
        e.getEntity().getEquipment().setHelmet(this.crown);
        
        chicken.setMaxHealth(chicken.getHealth() * 10.0D);
        chicken.setHealth(chicken.getMaxHealth());
      } 
    } 
  }
  
  @EventHandler
  public void onChickenKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Chicken && e.getEntity().getCustomName() != null) {
      Chicken chicken = (Chicken)e.getEntity();
       if (chicken.getCustomName().equals(ChatColor.GOLD + "DrChicken")) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, 3));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        if (choice < dropPer)
          e.getDrops().add(this.chicken); 
      } 
    } 
  }
  
  @EventHandler
  public void onVillagerKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Villager) {
      Villager villager = (Villager)e.getEntity();
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.BONE, 2));
        e.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 2));
    } 
  }
  
  @EventHandler
  public void onIronGolemSpawn(CreatureSpawnEvent e) {
	    if (e.getEntity() instanceof IronGolem) {
	    	
	    	IronGolem golem = (IronGolem)e.getEntity();
	    	
	    	// golem.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION ,9999999, 9999999));
	    	golem.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE ,9999999, 3));
	    	golem.addPotionEffect(new PotionEffect(PotionEffectType.SPEED ,9999999, 3));
	    	
	    	golem.setMaxHealth(golem.getHealth() * 10.0D);
	    	golem.setHealth(golem.getMaxHealth());
	    	
	        // golem.setInvulnerable(true);
	        golem.setPersistent(true);
	        
	        Random ran = new Random();
	        int choice = ran.nextInt(100) + 1;
	        golem.setCustomName(ChatColor.GOLD + "Albion " + choice);
	        
	        Location location = golem.getLocation();
	        if (getConfig().getBoolean("lightningOnSpawn")){
		        World world = golem.getWorld();
	        	world.strikeLightningEffect(location); 
	        }
	        
	        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	        String command = "broadcast Albion " + choice + " was spawned at " + coords(location);
	        Bukkit.dispatchCommand(console, command);
	    } 
  } 
  
  public void playerMsg(Player p, String itemname) {
	  
	  String playername = p.getDisplayName();
	  
	  ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
      String command = "broadcast &6" + p.getPlayerListName() +  " &6has gotten a " + itemname;
      Bukkit.dispatchCommand(console, command);
	  
  }
  
  public static String coords(Location n) {

	  int x = n.getBlockX();
	  
	  int y = n.getBlockY();
	  
	  int z = n.getBlockZ();
		
	  String coords = x + ", " + y + ", " + z;
      
	  return coords;
  }
  
}

