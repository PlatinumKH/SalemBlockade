package me.nbarudi.files.roles.notused;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;

public class Tracker extends Role {

	public Tracker(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Track one person at night to see who they visit.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("None");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		wincond.add("§6Survivor");
		
		this.teamname = "§aTown\n(§bInvestigative§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
	}

}
