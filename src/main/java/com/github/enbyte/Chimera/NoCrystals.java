package com.github.enbyte.Chimera;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoCrystals implements Listener {
	
	private Chimera plugin;
	
	public NoCrystals(Chimera plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntityType() == EntityType.END_CRYSTAL) {
			event.setCancelled(true);
			if (plugin.DEBUG) {
				plugin.getLogger().info("Cancelled end crystal explode event");
			}
		}
	}
}
