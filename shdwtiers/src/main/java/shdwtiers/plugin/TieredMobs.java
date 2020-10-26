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
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Villager;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Player;

import org.bukkit.Location;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;


public class TieredMobs extends JavaPlugin implements Listener {
  public void onEnable() {
    getConfig().options().copyDefaults();
    saveDefaultConfig();
    getServer().getPluginManager().registerEvents(this, (Plugin)this);
    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs spawn percentage set to " + ChatColor.GREEN + getConfig().getInt("Percentage") + "%");
    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs item drop percentage set to "+ ChatColor.GREEN + getConfig().getInt("DropPercentage") + "%");
    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs kill money set to " + ChatColor.GREEN + getConfig().getInt("shdwMoney"));
    System.out.println(ChatColor.GOLD + "[shdwmobs] shdw mobs lightning on mob spawn set to " + ChatColor.GREEN + getConfig().getBoolean("lightningOnSpawn"));
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
  
  public TieredMobs() {
	  
    String bowname = getConfig().getString("BowName");
    this.tpbowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', bowname));
    this.tpbowMeta.setUnbreakable(true);
    this.tpbowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
    this.tpbowMeta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
    this.tpbowMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
    ArrayList<String> lore = new ArrayList<>();
    this.tpbowMeta.setLore(lore);
    this.tpbow.setItemMeta(this.tpbowMeta);
    
    this.helmet = new ItemStack(Material.DIAMOND_HELMET);
    this.helmetMeta = this.helmet.getItemMeta();
    String zombiehelmet = getConfig().getString("ZombieHelmetName");
    this.helmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', zombiehelmet));
    this.helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.helmetMeta.addEnchant(Enchantment.WATER_WORKER, 1, false);
    this.helmetMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.helmetMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.helmetMeta.addEnchant(Enchantment.OXYGEN, 3, false);
    this.helmetMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
    this.helmet.setItemMeta(this.helmetMeta);
    
    this.chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
    this.chestMeta = this.chestplate.getItemMeta();
    String skeletonchestplate = getConfig().getString("SkeletonChestplateName");
    this.chestMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', skeletonchestplate));
    this.chestMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.chestMeta.addEnchant(Enchantment.THORNS, 3, false);
    this.chestMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.chestMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
    this.chestplate.setItemMeta(this.chestMeta);
    
    this.leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
    this.leggingsMeta = this.leggings.getItemMeta();
    String creeperleggings = getConfig().getString("CreeperLeggingsName");
    this.leggingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', creeperleggings));
    this.leggingsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.leggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.leggingsMeta.addEnchant(Enchantment.THORNS, 3, false);
    this.leggingsMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.leggingsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
    this.leggings.setItemMeta(this.leggingsMeta);
    
    this.boots = new ItemStack(Material.DIAMOND_BOOTS);
    this.bootsMeta = this.boots.getItemMeta();
    String spiderboots = getConfig().getString("SpiderBootsName");
    this.bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', spiderboots));
    this.bootsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
    this.bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
    this.bootsMeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, false);
    this.bootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, false);
    this.bootsMeta.addEnchant(Enchantment.MENDING, 1, false);
    this.bootsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
    this.boots.setItemMeta(this.bootsMeta);
    
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
  
  @EventHandler
  public void onZombieSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Zombie) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
    	  
        Zombie zombie = (Zombie)e.getEntity();
        zombie.setCustomName(ChatColor.GOLD + "shdwZombie");
        
        e.getEntity().getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        e.getEntity().getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        e.getEntity().getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
        
        zombie.setMaxHealth(zombie.getHealth() * 10.0D);
        zombie.setHealth(zombie.getMaxHealth());
        
        /*Location location = zombie.getLocation();
        if (getConfig().getBoolean("lightningOnSpawn")){
	        World world = zombie.getWorld();
        	world.strikeLightningEffect(location); */
        }
        
      } 
    } 
  
  
  @EventHandler
  public void onZombieKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Zombie && e.getEntity().getCustomName() != null) {
      Zombie zombie = (Zombie)e.getEntity();
      if (zombie.getCustomName().equals(ChatColor.GOLD + "shdwZombie")) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 5));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        if (choice < dropPer) {
          e.getDrops().add(this.helmet); 
        }
        else {
        	Player player = zombie.getKiller();
        	giveMoney(player);
        }
      } 
    } 
  }
  
  @EventHandler
  public void onSkeletonSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Skeleton) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
    	  
        Skeleton skeleton = (Skeleton)e.getEntity();
        skeleton.setCustomName(ChatColor.GOLD + "shdwSkeleton");
        skeleton.setMaxHealth(skeleton.getHealth() * 10.0D);
        skeleton.setHealth(skeleton.getMaxHealth());
        
        e.getEntity().getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        e.getEntity().getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        e.getEntity().getEquipment().setItemInMainHand(this.tpbow);
        
        /*Location location = skeleton.getLocation();
        if (getConfig().getBoolean("lightningOnSpawn")){
	        World world = skeleton.getWorld();
        	world.strikeLightningEffect(location); */
        }
        
      } 
    } 
  
  
  @EventHandler
  public void onSkeletonKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Skeleton && e.getEntity().getCustomName() != null) {
      Skeleton skeleton = (Skeleton)e.getEntity();
      if (skeleton.getCustomName().equals(ChatColor.GOLD + "shdwSkeleton")) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.BONE, 5));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        if (choice < dropPer) {
          e.getDrops().add(this.chestplate); 
          // e.getDrops().add(this.boner);
        }
        else {
        	Player player = skeleton.getKiller();
        	giveMoney(player);
        }
      } 
    } 
  }
  
  @EventHandler
  public void onCreeperSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Creeper) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
    	  
        Creeper creeper = (Creeper)e.getEntity();
        creeper.setPowered(true);
        creeper.setCustomName(ChatColor.GOLD + "shdwCreeper");
        
        creeper.setMaxHealth(creeper.getHealth() * 5.0D);
        creeper.setHealth(creeper.getMaxHealth());
        
        /*Location location = creeper.getLocation();
        if (getConfig().getBoolean("lightningOnSpawn")){
	        World world = creeper.getWorld();
        	world.strikeLightningEffect(location); */
        }
        
      } 
    } 
  
  
  @EventHandler
  public void onCreeperKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Creeper && e.getEntity().getCustomName() != null) {
      Creeper creeper = (Creeper)e.getEntity();
      if (creeper.getCustomName().equals(ChatColor.GOLD + "shdwCreeper")) {
        e.getDrops().clear();
        Random ran = new Random();
        e.getDrops().add(new ItemStack(Material.GUNPOWDER, 5));
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        if (choice < dropPer) {
          e.getDrops().add(this.leggings); 
        }
        else {
        	Player player = creeper.getKiller();
        	giveMoney(player);
        }
      } 
    } 
  }
  
  @EventHandler
  public void onSpiderSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Spider) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
        Spider spider = (Spider)e.getEntity();
        spider.setCustomName(ChatColor.GOLD + "shdwSpider");
        spider.setMaxHealth(spider.getHealth() * 10.0D);
        spider.setHealth(spider.getMaxHealth());
      } 
    } 
  }
  
  @EventHandler
  public void onSpiderKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Spider && e.getEntity().getCustomName() != null) {
      Spider spider = (Spider)e.getEntity();
      if (spider.getCustomName().equals(ChatColor.GOLD + "shdwSpider")) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.STRING, 5));
        e.getDrops().add(new ItemStack(Material.SPIDER_EYE, 4));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        if (choice < dropPer) {
          e.getDrops().add(this.boots); 
        }
        else {
        	Player player = spider.getKiller();
        	giveMoney(player);
        }
      } 
    } 
  }
  
  @EventHandler
  public void onEndermanSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Enderman) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
        Enderman enderman = (Enderman)e.getEntity();
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,9999999, 9999999));
        enderman.setCustomName(ChatColor.GOLD + "shdwEnderman");
        enderman.setMaxHealth(enderman.getHealth() * 10.0D);
        enderman.setHealth(enderman.getMaxHealth());
      } 
    } 
  }
  
  @EventHandler
  public void onEndermanKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Enderman && e.getEntity().getCustomName() != null) {
      Enderman enderman = (Enderman)e.getEntity();
      if (enderman.getCustomName().equals(ChatColor.GOLD + "shdwEnderman")) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.ENDER_PEARL, 3));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        if (choice < dropPer) {
          e.getDrops().add(this.tpbow); 
        }
        else {
        	Player player = enderman.getKiller();
        	giveMoney(player);
        }
      } 
    } 
  }
  
  @EventHandler
  public void onPiglinSpawn(CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Piglin) {
      Random ran = new Random();
      int choice = ran.nextInt(100) + 1;
      int percentage = getConfig().getInt("Percentage");
      if (choice < percentage) {
    	  
        Piglin piglin = (Piglin)e.getEntity();
        piglin.setCustomName(ChatColor.GOLD + "shdwPiglin");
        
        e.getEntity().getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        e.getEntity().getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        e.getEntity().getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
        
        /*Location location = piglin.getLocation();
        if (getConfig().getBoolean("lightningOnSpawn")){
	        World world = piglin.getWorld();
        	world.strikeLightningEffect(location); 
        }*/
        
        piglin.setMaxHealth(piglin.getHealth() * 10.0D);
        piglin.setHealth(piglin.getMaxHealth());
      } 
    } 
  }
  
  @EventHandler
  public void onPiglinKilled(EntityDeathEvent e) {
    if (e.getEntity() instanceof Piglin && e.getEntity().getCustomName() != null) {
      Piglin piglin = (Piglin)e.getEntity();
      if (piglin.getCustomName().equals(ChatColor.GOLD + "shdwPiglin")) {
        e.getDrops().clear();
        e.getDrops().add(new ItemStack(Material.GOLD_INGOT, 3));
        Random ran = new Random();
        int choice = ran.nextInt(100) + 1;
        int dropPer = getConfig().getInt("DropPercentage");
        if (choice < dropPer) {
          e.getDrops().add(this.crown); 
        }
        else {
        	Player player = piglin.getKiller();
        	giveMoney(player);
        }
      } 
    } 
  }
  
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
	    	
	    	golem.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION ,9999999, 9999999));
	    	golem.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE ,9999999, 3));
	        golem.setInvulnerable(true);
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
  
  public void giveMoney(Player p) {
	  int shdwMoney = getConfig().getInt("shdwMoney");
	  ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
      String command = "eco give " + p.getPlayerListName() + " " + shdwMoney;
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

