package me.nbarudi.files.roles.Other;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;

public class Dead extends Role {

	public Dead(String name) {
		super(name);
		this.teamname = "Dead";
		this.team = ChatColor.BLACK;
		this.attack = 0;
		this.defense = 0;
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("You are dead.");
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("You can talk to each other in the dead chat");
		abil.add("If there is a medium, you may communicate with them");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§0No one");
		
		this.abilities = abil;
		this.attributes = atrib;
		this.winconditions = wincond;
		
	}

}
