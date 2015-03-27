package fr.ng.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	File conf = new File("plugins/LobbyArmor/Lobby.yml");
	FileConfiguration configlobby = YamlConfiguration.loadConfiguration(conf);
	public static int slot;

	public void onEnable() {
		try {
			slot = configlobby.getInt("slot") - 1;
		} catch (Exception e) {
			e.printStackTrace();
			configlobby.set("slot", 4);
			slot = 3;
		}
		CommandExecutor exempleExecutor = new DisplaymenuCommandExecutor();
		getCommand("armor").setExecutor(exempleExecutor);
		Bukkit.getPluginManager().registerEvents(
				new fr.ng.global.EventListener(), this);
	}

	public void onDisable() {
		configlobby.set("slot", slot+1);
		try {
			configlobby.save(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getSlot() {
		return slot;
	}
	
	public static void setSlot(int nbr){
		slot = nbr;
	}
}
