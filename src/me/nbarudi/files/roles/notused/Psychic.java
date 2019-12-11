package me.nbarudi.files.roles.notused;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;

public class Psychic extends Role {

	public Psychic(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Receive a vision every night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("On odd nights you will have a vision of three players, at least one will be Evil.");
		atrib.add("On even nights you will have a vision of two players, at least one will be Good.");
		
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
