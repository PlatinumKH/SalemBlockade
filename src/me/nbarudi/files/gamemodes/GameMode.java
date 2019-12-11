package me.nbarudi.files.gamemodes;

import java.util.ArrayList;

import me.nbarudi.files.randomized.Randomized;
import me.nbarudi.files.roles.Role;

public class GameMode {

	public ArrayList<Role> roles;
	public String name;
	public String desc;
	public ArrayList<Randomized> random;
	
	public GameMode(String name) {
		this.name = name;
	}
	
}
