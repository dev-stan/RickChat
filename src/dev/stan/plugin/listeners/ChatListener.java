package dev.stan.plugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.stan.plugin.RickChat;

// Permissions:
//   mute: "rick.mute"

public class ChatListener implements Listener {
	

	private final RickChat plugin;
	public ChatListener(RickChat plugin){

		this.plugin = plugin;
	}



	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		
		if (event.getMessage().contains("rules") || (event.getMessage().contains("?"))) {
			
			player.sendMessage(plugin.prefix + plugin.color + plugin.getCustomConfig().getString("messages.respond.rules"));
		}
	}
}
