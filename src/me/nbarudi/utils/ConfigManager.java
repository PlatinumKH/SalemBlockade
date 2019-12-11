package me.nbarudi.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	static FileConfiguration points;
    static File pdfile;
    
    static FileConfiguration storage;
    static File sfile;
    
    public static void setup() {
        pdfile = new File("plugins/SalemBlockade", "PlayerData.yml");
        sfile = new File("plugins/SalemBlockade", "DataStorage.yml");
        
        if (!pdfile.exists()) {
            try {
                pdfile.createNewFile();
            } catch (IOException e) {
            }
        }
        
        if (!sfile.exists()) {
            try {
                sfile.createNewFile();
            } catch (IOException e) {
            }
        }

        points = YamlConfiguration.loadConfiguration(pdfile);
        storage = YamlConfiguration.loadConfiguration(sfile);
    }
    
    //Points File
    public static FileConfiguration getPlayerData() {
        return points;
    }

    public static void playerDataSave() {
        try {
        	points.save(pdfile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save PlayerData.yml!");
        }
    }

    public static void playerDataReload() {
    	points = YamlConfiguration.loadConfiguration(pdfile);
    }
    
    //Storage File
    public static FileConfiguration getStorageData() {
        return storage;
    }

    public static void storageDataSave() {
        try {
        	storage.save(sfile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save DataStorage.yml!");
        }
    }

    public static void storageDataReload() {
    	storage = YamlConfiguration.loadConfiguration(sfile);
    }
    
    
    
}
