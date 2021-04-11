package dev.stan.plugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.stan.plugin.RickChat;


public class ChatListener implements Listener {
	
	

	private final RickChat plugin;
	public ChatListener(RickChat plugin){

		this.plugin = plugin;
	}
	

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		
		if (plugin.getCustomConfig().getBoolean("messages.respond.rules.enabled")) {
			
			if (event.getMessage().contains("rules") || (event.getMessage().contains("?"))) {
				
				player.sendMessage(plugin.prefix + plugin.color + plugin.getCustomConfig().getString("messages.respond.rules.message"));
			}
		}
		
		if (plugin.getCustomConfig().getBoolean("messages.respond.pvp.enabled")) {
			
			if (event.getMessage().contains("can") || (event.getMessage().contains("pvp")) || (event.getMessage().contains("?"))) {
				
				player.sendMessage(plugin.prefix + plugin.color + plugin.getCustomConfig().getString("messages.respond.pvp.message"));
				
			}
		}
		
		if (plugin.getCustomConfig().getBoolean("messages.respond.help.enabled")) {
			
			if (event.getMessage().contains("help") || (event.getMessage().contains("command")) || (event.getMessage().contains("?"))) {
				
				player.sendMessage(plugin.prefix + plugin.color + plugin.getCustomConfig().getString("messages.respond.help.message"));
				
			}
		}
		
		if (plugin.getCustomConfig().getBoolean("messages.respond.grief.enabled")) {
			
			if (event.getMessage().contains("can") || (event.getMessage().contains("grief")) || (event.getMessage().contains("?"))) {
				
				player.sendMessage(plugin.prefix + plugin.color + plugin.getCustomConfig().getString("messages.respond.grief.message"));
				
			}
		}
	}
}
