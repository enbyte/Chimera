package com.github.enbyte.Chimera;

import java.util.Set;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class NoBannedCrafts implements Listener {
	private Chimera plugin;
	
	private final Set<Material> BANNED_ITEMS = Set.of(
			Material.MACE,
			Material.SHULKER_BOX);

	public NoBannedCrafts(Chimera plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPrepareCraft(PrepareItemCraftEvent event) {
		if (event.getRecipe() == null || event.getRecipe().getResult() == null) {
			return;
		}
		
		Material result = event.getRecipe().getResult().getType();
		
		if (BANNED_ITEMS.contains(result)) {
			event.getInventory().setResult(new ItemStack(Material.AIR));
			
            if (plugin.DEBUG) {
				plugin.getLogger().info("Attempt to craft banned item blocked");
            }
		}
		
	}
	
}
