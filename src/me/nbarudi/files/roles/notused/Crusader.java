package me.nbarudi.files.roles.notused;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;

public class Crusader extends Role {

	public Crusader(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Protect one person during the night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("Grant your target Powerful defense.");
		atrib.add("You will know if your target is attacked.");
		atrib.add("You will attack one person visiting your target.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		wincond.add("§6Survivor");
		
		this.teamname = "§aTown\n(§bProtective§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
	}

}
