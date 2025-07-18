package com.github.enbyte.Chimera;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoCrystals implements Listener {
	
	private Chimera plugin;
	
	public NoCrystals(Chimera plugin) {
		this.plugin = plugin;
	}
	
	public void onEndCrystalExplode(EntityDamageEvent event) {
		if (event.getEntityType() == EntityType.END_CRYSTAL) {
			event.setCancelled(true);
		}
	}
}
