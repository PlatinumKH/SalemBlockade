package me.nbarudi.files.gameevents;

import org.bukkit.entity.Player;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.Other.Dead;
import me.nbarudi.gamesystems.Wills;
import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;

public class DeathInfo {
	
	//ToDo: Set up a system to give info on a dead player when info is required.
	public static void postDeathInfo(Player p, String reason) {
		Role role = TownOfSalem.plrs.get(p.getName());
		TownOfSalem.plrs.remove(p.getName());
		TownOfSalem.plrs.put(p.getName(), new Dead("Dead"));
		Announcements.globalAnnounce(p.getName() + " §2has Died.");
		Announcements.globalAnnounce(p.getName() + "§2: " + reason);
		Announcements.globalAnnounce(p.getName() + " §2was the " + role.team + role.name + "§2!");
		Announcements.globalAnnounce("§2Everyone has been given a copy of §r" + p.getName() + "§2's will.");
		Wills.spreadWill(p);
	}

}
