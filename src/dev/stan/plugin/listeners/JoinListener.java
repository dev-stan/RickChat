package dev.stan.plugin.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.stan.plugin.RickChat;

public class JoinListener implements Listener {

	private final RickChat plugin;

	public JoinListener(RickChat plugin) {

		this.plugin = plugin;
		plugin.getCustomConfig().getList("messages.respond.welcome-back");
	}
	


	

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		for (Player p : Bukkit.getOnlinePlayers()) {
			
			if (p.getName().equalsIgnoreCase(plugin.getCustomConfig().getString("special-player"))) 
				
				p.sendMessage("messages.respond");
			

			p.sendMessage(plugin.prefix + plugin.color + plugin.getCustomConfig().getString("messages.respond.welcome-back"));
		}
	}
}
