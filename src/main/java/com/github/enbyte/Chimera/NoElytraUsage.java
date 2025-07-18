package com.github.enbyte.Chimera;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class NoElytraUsage implements Listener {
	
	private Chimera plugin;

	public NoElytraUsage(Chimera plugin) {
		this.plugin = plugin;
	}
	
	public void onElytraDeploy(EntityToggleGlideEvent event) {
		if (event.getEntityType() == EntityType.PLAYER) {
			event.setCancelled(true);
		}
	}
}
