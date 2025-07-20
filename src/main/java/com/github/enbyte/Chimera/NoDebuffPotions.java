package com.github.enbyte.Chimera;

import java.util.Set;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.potion.PotionEffectType;

public class NoDebuffPotions implements Listener {
	
	private Chimera plugin;
	
	private static final Set<PotionEffectType> debuffPotions = Set.of(
			PotionEffectType.SLOW_FALLING,
			PotionEffectType.SLOWNESS,
			PotionEffectType.WEAKNESS,
			PotionEffectType.POISON,
			PotionEffectType.INFESTED,
			PotionEffectType.OOZING,
			PotionEffectType.WEAVING,
			PotionEffectType.WIND_CHARGED
		);

	public NoDebuffPotions(Chimera plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPotionEffect(EntityPotionEffectEvent event) {
		if (!(event.getEntityType() == EntityType.PLAYER)) {
			return;
		}
		
		if (!(event.getAction() == EntityPotionEffectEvent.Action.ADDED)) {
			return;
		}
		
		if (debuffPotions.contains(event.getNewEffect().getType())) { // TODO: Players can't apply negative effects to themselves
			event.setCancelled(true);								  // No way to check which entity applied event so idk (this is not super important)
			
			if (plugin.DEBUG) {
				plugin.getLogger().info("Cancelled potion debuff effect");
			}
		}

		
		
	}
}
