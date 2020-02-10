package me.nbarudi.events;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.nbarudi.utils.ConfigManager;
import me.nbarudi.utils.GamemodeScore;

public class PlayerJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		//TownOfSalem.plrs.put(p.getName(), new Dead("Dead"));
		
		p.setScoreboard(GamemodeScore.modeScoreBoard);
		
		
		//Config Setup!
		
		if(ConfigManager.getPlayerData().getConfigurationSection("PlayerData." + p.getName()) == null) {
			ConfigManager.getPlayerData().createSection("PlayerData");
			ConfigManager.getPlayerData().set("PlayerData." + p.getName() + ".Role", "Dead");
			ConfigManager.getPlayerData().set("PlayerData." + p.getName() + ".PlannedVisit", new ArrayList<String>());
			ConfigManager.getPlayerData().set("PlayerData." + p.getName() + ".TeamMembers" , new ArrayList<String>());
			ConfigManager.playerDataSave();
		}
		
		if(ConfigManager.getRankData().getConfigurationSection("Players." + p.getName()) == null) {
			ConfigManager.getRankData().set("Players." + p.getName() + ".Rank", "User");
			ConfigManager.getRankData().set("Players." + p.getName() + ".UUID", p.getUniqueId());
			ConfigManager.ranksSave();
		}
		
	}

}
