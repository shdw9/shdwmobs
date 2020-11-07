package me.shdwslyr.shdwmobs;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	
	//
	// frostySet
	//
	
	public static ItemStack tpbow() {
		
		ItemStack tpbow = new ItemStack(Material.BOW);
		ItemMeta tpbowMeta = tpbow.getItemMeta();
		String enderBow = Main.enderBow;
		tpbowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', enderBow));
		tpbowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
		tpbowMeta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
		tpbowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 7, true);
		tpbowMeta.addEnchant(Enchantment.DURABILITY, 10, true);
		tpbowMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
		tpbowMeta.setLore(lore);
		tpbow.setItemMeta(tpbowMeta);
		
		return tpbow;
	}
	
	public static ItemStack helmet() {
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
	    ItemMeta helmetMeta = helmet.getItemMeta();
	    String zombiehelmet = Main.zombieHelm;
	    helmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', zombiehelmet));
	    helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
	    helmetMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false); // halloween set to 10
	    // this.helmetMeta.addEnchant(Enchantment.WATER_WORKER, 1, false);
	    helmetMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    helmetMeta.addEnchant(Enchantment.MENDING, 1, false);
	    helmetMeta.addEnchant(Enchantment.OXYGEN, 3, false);
	    helmetMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
	    ArrayList<String> loreHelm = new ArrayList<>();
	    loreHelm.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
	    helmetMeta.setLore(loreHelm);
	    helmet.setItemMeta(helmetMeta);
		return helmet;
	}
	
	public static ItemStack chestplate() {
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
	    ItemMeta chestMeta = chestplate.getItemMeta();
	    String skeletonchestplate = Main.skeleChest;
	    chestMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', skeletonchestplate));
	    chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
	    chestMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false); // halloween set to 10
	    chestMeta.addEnchant(Enchantment.MENDING, 1, false);
	    chestMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    chestMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
	    ArrayList<String> loreChest = new ArrayList<>();
	    loreChest.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
	    chestMeta.setLore(loreChest);
	    chestplate.setItemMeta(chestMeta);
	    return chestplate;
	}
	
	public static ItemStack leggings() {
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
	    ItemMeta leggingsMeta = leggings.getItemMeta();
	    String creeperleggings = Main.creepLegg;
	    leggingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', creeperleggings));
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false); // halloween set to 10
	    leggingsMeta.addEnchant(Enchantment.MENDING, 1, false);
	    leggingsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    leggingsMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
	    ArrayList<String> loreLegg = new ArrayList<>();
	    loreLegg.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
	    leggingsMeta.setLore(loreLegg);
	    leggings.setItemMeta(leggingsMeta);
	    return leggings;
	}
	
	public static ItemStack boots() {
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
	    ItemMeta bootsMeta = boots.getItemMeta();
	    String spiderboots = Main.spidBoots;
	    bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', spiderboots));
	    bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
	    bootsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);  // halloween set to 10
	    bootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, false);
	    bootsMeta.addEnchant(Enchantment.MENDING, 1, false);
	    bootsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    bootsMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
	    ArrayList<String> loreBoots = new ArrayList<>();
	    loreBoots.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
	    bootsMeta.setLore(loreBoots);
	    boots.setItemMeta(bootsMeta);
		return boots;
	}
	
	public static ItemStack crown() {
		ItemStack crown = new ItemStack(Material.GOLDEN_HELMET);
	    ItemMeta crownMeta = crown.getItemMeta();
	    String crownhelm = ChatColor.GOLD + "Piglin Crown";
	    crownMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', crownhelm));
	    crownMeta.addEnchant(Enchantment.DURABILITY, 10, false);
	    crownMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
	    crownMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    crownMeta.addEnchant(Enchantment.MENDING, 1, false);
	    crown.setItemMeta(crownMeta);
		return crown;
	}
	
	//
	// frost set
	//
	
	public static ItemStack frosthelmet() {
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
	    ItemMeta helmetMeta = helmet.getItemMeta();
	    String zombiehelmet = Main.zombieHelm;
	    helmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', zombiehelmet));
	    helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
	    helmetMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false); // halloween set to 10
	    // this.helmetMeta.addEnchant(Enchantment.WATER_WORKER, 1, false);
	    helmetMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    helmetMeta.addEnchant(Enchantment.MENDING, 1, false);
	    helmetMeta.addEnchant(Enchantment.OXYGEN, 3, false);
	    ArrayList<String> loreHelm = new ArrayList<>();
	    loreHelm.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
	    helmetMeta.setLore(loreHelm);
	    helmet.setItemMeta(helmetMeta);
		return helmet;
	}
	
	public static ItemStack frostchestplate() {
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
	    ItemMeta chestMeta = chestplate.getItemMeta();
	    String skeletonchestplate = Main.skeleChest;
	    chestMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', skeletonchestplate));
	    chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
	    chestMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false); // halloween set to 10
	    chestMeta.addEnchant(Enchantment.MENDING, 1, false);
	    chestMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    ArrayList<String> loreChest = new ArrayList<>();
	    loreChest.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
	    chestMeta.setLore(loreChest);
	    chestplate.setItemMeta(chestMeta);
	    return chestplate;
	}
	
	public static ItemStack frostleggings() {
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
	    ItemMeta leggingsMeta = leggings.getItemMeta();
	    String creeperleggings = Main.creepLegg;
	    leggingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', creeperleggings));
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false); // halloween set to 10
	    leggingsMeta.addEnchant(Enchantment.MENDING, 1, false);
	    leggingsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    ArrayList<String> loreLegg = new ArrayList<>();
	    loreLegg.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
	    leggingsMeta.setLore(loreLegg);
	    leggings.setItemMeta(leggingsMeta);
	    return leggings;
	}
	
	public static ItemStack frostboots() {
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
	    ItemMeta bootsMeta = boots.getItemMeta();
	    String spiderboots = Main.spidBoots;
	    bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', spiderboots));
	    bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
	    bootsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);  // halloween set to 10
	    bootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, false);
	    bootsMeta.addEnchant(Enchantment.MENDING, 1, false);
	    bootsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    ArrayList<String> loreBoots = new ArrayList<>();
	    loreBoots.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Winter Item Drop");
	    bootsMeta.setLore(loreBoots);
	    boots.setItemMeta(bootsMeta);
		return boots;
	}
	
	//
	// halloween set
	//
	
	public static ItemStack deathSickle() {
		ItemStack deathSickle = new ItemStack(Material.NETHERITE_HOE);
	    ItemMeta deathMeta = deathSickle.getItemMeta();
	    String deathsickle = "&6&ldeath&8&lSickle";
	    deathMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', deathsickle));
	    deathMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    deathMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
	    deathMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, false);
	    deathMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, false);
	    deathMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, false);
	    deathMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
	    ArrayList<String> deathSi = new ArrayList<>();
	    deathSi.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop"); // halloween
	    deathMeta.setLore(deathSi);
	    deathSickle.setItemMeta(deathMeta);
	    return deathSickle;
	}
	
	public static ItemStack halloHelm() {
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
	    ItemMeta helmetMeta = helmet.getItemMeta();
	    String zombiehelmet = "&6&lspooky&8&lHelmet";
	    helmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', zombiehelmet));
	    helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    helmetMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
	    helmetMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false);
	    helmetMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    helmetMeta.addEnchant(Enchantment.MENDING, 1, false);
	    helmetMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
	    ArrayList<String> loreHelm = new ArrayList<>();
	    loreHelm.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop");
	    helmetMeta.setLore(loreHelm);
	    helmet.setItemMeta(helmetMeta);
	    return helmet;
	}
	
	public static ItemStack halloChest() {
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
	    ItemMeta chestMeta = chestplate.getItemMeta();
	    String skeletonchestplate = "&6&lspooky&8&lChestplate";
	    chestMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', skeletonchestplate));
	    chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    chestMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
	    chestMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false);
	    chestMeta.addEnchant(Enchantment.MENDING, 1, false);
	    chestMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    chestMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
	    ArrayList<String> loreChest = new ArrayList<>();
	    loreChest.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop");
	    chestMeta.setLore(loreChest);
	    chestplate.setItemMeta(chestMeta);
	    return chestplate;
	}
	
	public static ItemStack halloLegg() {
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
	    ItemMeta leggingsMeta = leggings.getItemMeta();
	    String creeperleggings = "&6&lspooky&8&lLeggings";
	    leggingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', creeperleggings));
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, false);
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false);
	    leggingsMeta.addEnchant(Enchantment.MENDING, 1, false);
	    leggingsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    leggingsMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
	    ArrayList<String> loreLegg = new ArrayList<>();
	    loreLegg.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop");
	    leggingsMeta.setLore(loreLegg);
	    leggings.setItemMeta(leggingsMeta);
	    return leggings;
	}
	
	public static ItemStack halloBoots() {
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
	    ItemMeta bootsMeta = boots.getItemMeta();
	    String spiderboots = "&6&lspooky&8&lBoots";
	    bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', spiderboots));
	    bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    bootsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);  // halloween set to 10
	    bootsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, false); // halloween
	    bootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, false);
	    bootsMeta.addEnchant(Enchantment.MENDING, 1, false);
	    bootsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    bootsMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false); // halloween
	    ArrayList<String> loreBoots = new ArrayList<>();
	    loreBoots.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Halloween 2020 Event Drop"); // halloween
	    bootsMeta.setLore(loreBoots);
	    boots.setItemMeta(bootsMeta);
	    return boots;
	}
	
	//
	// shdw set
	//
	
	public static ItemStack shdwHelm() {
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
	    ItemMeta helmetMeta = helmet.getItemMeta();
	    String zombiehelmet = "&4shdwHelmet";
	    helmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', zombiehelmet));
	    helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    helmetMeta.addEnchant(Enchantment.WATER_WORKER, 1, false);
	    helmetMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    helmetMeta.addEnchant(Enchantment.MENDING, 1, false);
	    helmetMeta.addEnchant(Enchantment.OXYGEN, 3, false);
	    helmetMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
	    helmet.setItemMeta(helmetMeta);	
	    return helmet;
	}
	
	public static ItemStack shdwChest() {
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
	    ItemMeta chestMeta = chestplate.getItemMeta();
	    String skeletonchestplate = "&4shdwChestplate";
	    chestMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', skeletonchestplate));
	    chestMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    chestMeta.addEnchant(Enchantment.THORNS, 3, false);
	    chestMeta.addEnchant(Enchantment.MENDING, 1, false);
	    chestMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
	    chestplate.setItemMeta(chestMeta);
	    return chestplate;
	}
	
	public static ItemStack shdwLeggs() {
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
	    ItemMeta leggingsMeta = leggings.getItemMeta();
	    String creeperleggings = "&4shdwLeggings";
	    leggingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', creeperleggings));
	    leggingsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    leggingsMeta.addEnchant(Enchantment.THORNS, 3, false);
	    leggingsMeta.addEnchant(Enchantment.MENDING, 1, false);
	    leggingsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
	    leggings.setItemMeta(leggingsMeta);
	    return leggings;
	}
	
	public static ItemStack shdwBoots() {
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
	    ItemMeta bootsMeta = boots.getItemMeta();
	    String spiderboots = "&4shdwBoots";
	    bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', spiderboots));
	    bootsMeta.addEnchant(Enchantment.DURABILITY, 3, false);
	    bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	    bootsMeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, false);
	    bootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, false);
	    bootsMeta.addEnchant(Enchantment.MENDING, 1, false);
	    bootsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, false);
	    boots.setItemMeta(bootsMeta);
	    return boots;
	}
}
