package com.github.enbyte.Chimera;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoRespawnAnchorBomb implements Listener {
	
	private Chimera plugin;

	public NoRespawnAnchorBomb(Chimera plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onRespawnAnchorUse(PlayerInteractEvent event) {
		
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		
		if (event.getClickedBlock() == null) {
			return;
		}
		
		if (event.getClickedBlock().getType() != Material.RESPAWN_ANCHOR) {
			return;
		}
		
		if (event.getPlayer().getWorld().getEnvironment() == World.Environment.NETHER) {
			return;
		}
		
		if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.GLOWSTONE &&
			event.getPlayer().getInventory().getItemInOffHand().getType() != Material.GLOWSTONE) {
			return;
		}
		
		if (plugin.DEBUG) {
			plugin.getLogger().info("Cancelled non-nether respawn anchor use event");
		}
		
		event.setCancelled(true);
	}
}
