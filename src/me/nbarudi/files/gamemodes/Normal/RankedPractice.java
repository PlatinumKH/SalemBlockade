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

public class RankedPractice extends GameMode {

	public RankedPractice(String name) {
		super(name);
		this.desc = "The classic style town of salem game.";
		ArrayList<Role> roles = new ArrayList<Role>();
		
		roles.add(new Jailor("Jailor"));
		
		roles.add(new Godfather("Godfather"));
		roles.add(new Mafioso("Mafioso"));


		
		ArrayList<Randomized> random = new ArrayList<Randomized>();
		roles.add(new TownInvestigative("Town Investigative"));
		roles.add(new TownInvestigative("Town Investigative"));

		random.add(new TownKilling("Town Killing"));

		random.add(new TownSupport("Town Support"));

		random.add(new RandomTown("Random Town"));
		random.add(new RandomTown("Random Town"));
		random.add(new RandomTown("Random Town"));

		random.add(new RandomMafia("Random Mafia"));
		random.add(new RandomMafia("Random Mafia"));

		random.add(new NeutralEvil("Neutral Evil"));

		random.add(new NeutralKilling("Neutral Killing"));
		
		this.roles = roles;
		this.random = random;
		
	}

}
