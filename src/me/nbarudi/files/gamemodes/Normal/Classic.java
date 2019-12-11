package me.nbarudi.files.gamemodes.Normal;

import java.util.ArrayList;

import me.nbarudi.files.gamemodes.GameMode;
import me.nbarudi.files.randomized.Randomized;
import me.nbarudi.files.randomized.Town.RandomTown;
import me.nbarudi.files.randomized.Town.TownKilling;
import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.Mafia.Framer;
import me.nbarudi.files.roles.Mafia.Godfather;
import me.nbarudi.files.roles.Mafia.Mafioso;
import me.nbarudi.files.roles.Neutral.Executioner;
import me.nbarudi.files.roles.Neutral.Jester;
import me.nbarudi.files.roles.Neutral.SerialKiller;
import me.nbarudi.files.roles.Town.Doctor;
import me.nbarudi.files.roles.Town.Escort;
import me.nbarudi.files.roles.Town.Investigator;
import me.nbarudi.files.roles.Town.Jailor;
import me.nbarudi.files.roles.Town.Lookout;
import me.nbarudi.files.roles.Town.Medium;
import me.nbarudi.files.roles.Town.Sheriff;

public class Classic extends GameMode {

	public Classic(String name) {
		super(name);
		this.desc = "The classic style town of salem game.";
		ArrayList<Role> roles = new ArrayList<Role>();
		
		roles.add(new Jailor("Jailor"));
		roles.add(new Sheriff("Sheriff"));
		roles.add(new Doctor("Doctor"));
		roles.add(new Investigator("Investigator"));
		roles.add(new Medium("Medium"));
		roles.add(new Godfather("Godfather"));
		roles.add(new Framer("Framer"));
		roles.add(new Executioner("Executioner"));
		roles.add(new Escort("Escort"));
		roles.add(new Mafioso("Mafioso"));
		roles.add(new Lookout("Lookout"));
		roles.add(new SerialKiller("Serial Killer"));
		roles.add(new Jester("Jester"));
		
		ArrayList<Randomized> random = new ArrayList<Randomized>();
		random.add(new TownKilling("Town Killing"));
		random.add(new RandomTown("Random Town"));
		
		this.roles = roles;
		this.random = random;
		
	}

}
