package dev.stan.plugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.stan.plugin.RickChat;

// Permissions:
//   mute: "rick.mute"

public class ChatListener implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		
		if (!player.hasPermission("rick.mute")) {
			
			if (event.getMessage().startsWith("rick") || (event.getMessage().startsWith("Rick"))) {
				
				if (event.getMessage().contains("help?")) {
					
					player.sendMessage(new RickChat().getCustomConfig().getString("messages.respond.help"));
				}
				
				if (event.getMessage().contains("rules?")) {
					
					player.sendMessage(new RickChat().getCustomConfig().getString("messages.respond.rules"));
				}

			}
		}
	}
}
