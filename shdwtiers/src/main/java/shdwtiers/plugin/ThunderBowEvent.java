package shdwtiers.plugin;


import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.entity.Arrow;

public class ThunderBowEvent implements Listener {
  TieredMobs plugin;
  
  public ThunderBowEvent(TieredMobs plugin) {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onBowShoot(ProjectileHitEvent e) {

	    if (e.getEntity() instanceof Arrow) {
	    	
	    	if (e.getEntity().getShooter() instanceof Player) {

	    		Player player = (Player)e.getEntity().getShooter();
	    		ArrayList<String> tpbowlore = new ArrayList<>();
	    		tpbowlore.add("TELEPORT");
	    		
	  	        if (player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(tpbowlore));
		  	        World world = e.getEntity().getWorld();
		  	        Location location = e.getEntity().getLocation();
		  	        world.strikeLightningEffect(location);
	  	        
	    	} 
	  } 
	    
  }
}
