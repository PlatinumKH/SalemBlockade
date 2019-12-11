package me.nbarudi.files.handlers;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.nbarudi.files.customevents.KillEvent;
import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.Other.Dead;
import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.ConfigManager;

public class ArsoHandler implements Listener {
	
	@EventHandler
	public void onKill(KillEvent event) {
		
		//Needed Variables
		Player p = event.getPlayer();
		Player t = event.getTarget();
		Role r = new Dead("Dead");
		
		//Get the players role
		String rolename = ConfigManager.getPlayerData().getString("PlayerData." + p.getName() + ".Role");
		for(Role role : TownOfSalem.roleinfo) {
			if(role.name == rolename) {
				r = role;
			}
		}
		
		ChatColor teamcolor = r.team;
		String teamname = r.teamname;
		
		ArrayList<String> info = new ArrayList<String>();
		info.add(p.getName());
		info.add(teamcolor.toString());
		info.add(teamname);
		
		if(p.getName() == t.getName()) {
			ConfigManager.getStorageData().set("Data.Ignite." + t.getName() + ".Information", info);
			ConfigManager.storageDataSave();
		}else {
			ConfigManager.getStorageData().set("Data.Douses." + t.getName() + ".Information", info);
			ConfigManager.storageDataSave();
		}
		
	}

}
