package me.nbarudi.files.randomized.Town;

import java.util.ArrayList;

import me.nbarudi.files.randomized.Randomized;
import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.Town.Bodyguard;
import me.nbarudi.files.roles.Town.Doctor;
import me.nbarudi.files.roles.Town.Escort;
import me.nbarudi.files.roles.Town.Investigator;
import me.nbarudi.files.roles.Town.Jailor;
import me.nbarudi.files.roles.Town.Lookout;
import me.nbarudi.files.roles.Town.Mayor;
import me.nbarudi.files.roles.Town.Medium;
import me.nbarudi.files.roles.Town.Retributionist;
import me.nbarudi.files.roles.Town.Sheriff;
import me.nbarudi.files.roles.Town.Spy;
import me.nbarudi.files.roles.Town.Transporter;
import me.nbarudi.files.roles.Town.VampireHunter;
import me.nbarudi.files.roles.Town.Veteran;
import me.nbarudi.files.roles.Town.Vigilante;

public class RandomTown extends Randomized {

	public RandomTown(String name) {
		super(name);
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(new Bodyguard("Bodyguard"));
		roles.add(new Doctor("Doctor"));
		roles.add(new Escort("Escort"));
		roles.add(new Investigator("Investigator"));
		roles.add(new Jailor("Jailor"));
		roles.add(new Lookout("Lookout"));
		roles.add(new Mayor("Mayor"));
		roles.add(new Medium("Medium"));
		roles.add(new Retributionist("Retributionist"));
		roles.add(new Sheriff("Sheriff"));
		roles.add(new Spy("Spy"));
		roles.add(new Transporter("Transporter"));
		roles.add(new VampireHunter("VampireHunter"));
		roles.add(new Veteran("Veteran"));
		roles.add(new Vigilante("Vigilante"));
	}

}
