package com.github.enbyte.Chimera;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class NoElytraUsage implements Listener {
	
	private Chimera plugin;

	public NoElytraUsage(Chimera plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityToggleGlide(EntityToggleGlideEvent event) {
		if (event.getEntityType() == EntityType.PLAYER) {
			event.setCancelled(true);
			
			if (plugin.DEBUG) {
				plugin.getLogger().info("Cancelled glide event");
			}
		}
	}
}
