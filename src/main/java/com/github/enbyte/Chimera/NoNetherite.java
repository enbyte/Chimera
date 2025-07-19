package com.github.enbyte.Chimera;

import java.util.EnumSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.SmithItemEvent;

public class NoNetherite implements Listener {
	
	private Chimera plugin;

	public NoNetherite(Chimera plugin) {
		this.plugin = plugin;
	}
	
	private static final Set<Material> NETHERITE_GEAR_MATERIALS = EnumSet.of(
            Material.NETHERITE_SWORD,
            Material.NETHERITE_PICKAXE,
            Material.NETHERITE_AXE,
            Material.NETHERITE_SHOVEL,
            Material.NETHERITE_HOE,
            Material.NETHERITE_HELMET,
            Material.NETHERITE_CHESTPLATE,
            Material.NETHERITE_LEGGINGS,
            Material.NETHERITE_BOOTS
    );
	
	@EventHandler
	public void onSmithItem(SmithItemEvent event) {
		Material smithedItem = event.getInventory().getResult().getType();
		
		if (NETHERITE_GEAR_MATERIALS.contains(smithedItem)) {
			event.setCancelled(true);
			if (plugin.DEBUG) {
				plugin.getLogger().info("Netherite item smith event cancelled");
			}
		}
	}
}
