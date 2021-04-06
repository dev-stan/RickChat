package dev.stan.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import dev.stan.plugin.listeners.ChatListener;

public class RickChat extends JavaPlugin implements Listener {
	
	private File customConfigFile;
	private FileConfiguration customConfig;
	
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		
		createCustomConfig();
	}
	
	public FileConfiguration getCustomConfig() {
		return this.customConfig;
	}
	
	private void createCustomConfig() {
	    customConfigFile = new File(getDataFolder(), "custom.yml");
	    if (!customConfigFile.exists()) {
	        customConfigFile.getParentFile().mkdirs();
	        saveResource("custom.yml", false);
	     }

	    customConfig= new YamlConfiguration();
	    try {
	        customConfig.load(customConfigFile);
	    } catch (IOException | InvalidConfigurationException e) {
	        e.printStackTrace();
	    }
	}
	

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("rick")) {
			
			player.sendMessage(this.getConfig().getString("plugin-help"));
			
		}
		
		return false;
		
	}

}



