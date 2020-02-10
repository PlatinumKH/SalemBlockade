package me.nbarudi.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class CheckPermissions {

	public static boolean checkPerms(Player p, int level) {
		ArrayList<String> rname = new ArrayList<String>();
		if(level == 0) {
			rname.add("User");
			rname.add("Host");
			rname.add("Admin");
			rname.add("Manager");
		}
		if(level == 1) {
			rname.add("Host");
			rname.add("Admin");
			rname.add("Manager");
		}
		if(level == 2) {
			rname.add("Admin");
			rname.add("Manager");
		}
		if(level == 3) {
			rname.add("Manager");
		}
		for(String i : rname) {
			if(ConfigManager.getRankData().getString("Players." + p.getName() + ".Rank").equalsIgnoreCase(i)) {
				return true;
			}
		}
		return false;
	}

}
