package com.github.enbyte.Chimera;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class NoEnchants implements Listener {
	private Chimera plugin;

	public NoEnchants(Chimera plugin) {
		this.plugin = plugin;
	}
	
	public static final Map<Enchantment, Integer> BLOCKED_ENCHANTMENTS = Map.of(
			Enchantment.PROTECTION, 4,
			Enchantment.SHARPNESS, 5);
	
	@EventHandler
	public void onVillagerGetBook(VillagerAcquireTradeEvent event) {
		
		if (event.getRecipe().getResult().getType() != Material.ENCHANTED_BOOK) {
			return;
		}

		// Use intermediate variables and import another billion types or draw 25
		for (Map.Entry<Enchantment, Integer> entry : ((EnchantmentStorageMeta) event.getRecipe().getResult().getItemMeta()).getStoredEnchants().entrySet()) {
			Enchantment ench = entry.getKey();
			int level = entry.getValue();
			
			if (BLOCKED_ENCHANTMENTS.containsKey(ench)) {
				if (BLOCKED_ENCHANTMENTS.get(ench) == level) {
					event.setCancelled(true);
					plugin.getLogger().info("Blocked villager trade acquire of forbidden book");
				}
			}
		}
	}
	
	@EventHandler
	public void onTableGetBook(PrepareItemEnchantEvent event) {
		EnchantmentOffer[] offers = event.getOffers();
		
		for (int i = 0; i < offers.length; i++) {
			if (BLOCKED_ENCHANTMENTS.containsKey(offers[i].getEnchantment())) {
				if (BLOCKED_ENCHANTMENTS.get(offers[i].getEnchantment()) == offers[i].getEnchantmentLevel()) {
					offers[i] = null;
					
					plugin.getLogger().info("Blocked villager trade acquire of forbidden book");
				}
			}
		}
		
	}

}
