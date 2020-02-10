package me.nbarudi.gamesystems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.nbarudi.files.customevents.KillEvent;
import me.nbarudi.files.roles.Role;
import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.ConfigManager;

public class AbilityHandler {
	
	public static void runAbilities() {
		//Controls
		//Transports
		
		//RoleBlocking
		for(String key : ConfigManager.getStorageData().getConfigurationSection("Data.Roleblocked").getKeys(false)) {
			Player player = Bukkit.getPlayer(key);
			List<String> info = ConfigManager.getStorageData().getStringList("Data.Roleblocked." + key + ".Information");
			removeAbility(player);
		}
		//Alerting
		for(String key : ConfigManager.getStorageData().getConfigurationSection("Data.Alerts").getKeys(false)) {
			for(String names : ConfigManager.getPlayerData().getStringList("PlayerData." + key + ".PlannedVisit")) {
				Player dead = Bukkit.getPlayer(names);
				Player player = Bukkit.getPlayer(key);
				KillEvent event = new KillEvent(player, dead);
				Bukkit.getPluginManager().callEvent(event);
				TownOfSalem.tempImmune.add(player.getName());
			}
		}
		//Killing
		for(String key : ConfigManager.getStorageData().getConfigurationSection("Data.Kills").getKeys(false)) {
		}
	}
	
	public static void removeAbility(Player removal) {
		Role role = TownOfSalem.plrs.get(removal.getName());
		if(role.rbimmune) return;
		for(String k1 : ConfigManager.getStorageData().getConfigurationSection("Data.").getKeys(false)) {
			for(String k2 : ConfigManager.getStorageData().getConfigurationSection("Data." + k1).getKeys(false)) {
				for(String k3 : ConfigManager.getStorageData().getConfigurationSection("Data." + k1 + "." + k2).getKeys(false)) {
					List<String> info = ConfigManager.getStorageData().getStringList("Data." + k1 + "." + k2 + "." + k3 + ".Information");
					if(info.contains(removal.getName())) {
						ConfigManager.getStorageData().set("Data." + k1 + "." + k2, null);
						Announcements.dmAnnounce("§cSomeone occupied your night. You were RoleBlocked", removal);
						ConfigManager.storageDataSave();
						ConfigManager.getPlayerData().set("PlayerData." + k2 + ".PlannedVisit", new ArrayList<String>());
					}
				}
			}
		}
	}

}
