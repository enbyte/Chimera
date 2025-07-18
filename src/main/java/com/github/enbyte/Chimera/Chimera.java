package com.github.enbyte.Chimera;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Chimera extends JavaPlugin {
	
	private static Plugin plugin;
	@Override
	public void onEnable() {
		
		plugin = this;
		getLogger().info("Chimera v0.0.1-1.21.7 started up.");
		
		registerEvents(plugin, 
				new HashedWorldUpdateRecorder(this));
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Chimera v0.0.1-1.21.7 shut down.");
	}
	
	public static void registerEvents(Plugin plugin, Listener... listeners) {
		for (Listener l : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(l, plugin);
		}
	}
}
