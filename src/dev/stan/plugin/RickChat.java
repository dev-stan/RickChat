package dev.stan.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import dev.stan.plugin.listeners.ChatListener;

public class RickChat extends JavaPlugin{
	
    private File customConfigFile;
    private FileConfiguration customConfig;
    
    public String prefix;
    public String color;
    

    
    @Override
    public void onEnable(){
    	getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        createCustomConfig();
        

        prefix = ChatColor.translateAlternateColorCodes('&', this.getCustomConfig().getString("messages.default.prefix"));
        color = ChatColor.translateAlternateColorCodes('&', this.getCustomConfig().getString("messages.default.color"));
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
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
			player.sendMessage(this.prefix + this.color + this.getCustomConfig().getString("messages.default.base-command"));
		}
		return false;
	}

}



