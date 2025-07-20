package com.github.enbyte.Chimera;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class NoEnderPearlUsage implements Listener {

	private Chimera plugin;

	public NoEnderPearlUsage(Chimera plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEnderPearlThrow(ProjectileLaunchEvent event) {
		if (event.getEntityType() == EntityType.ENDER_PEARL) {
			event.setCancelled(true);
			
			if (plugin.DEBUG) {
				plugin.getLogger().info("Cancelled ender pearl throw");
			}
		}
	}
}
