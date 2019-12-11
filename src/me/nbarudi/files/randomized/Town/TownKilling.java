package me.nbarudi.files.randomized.Town;

import java.util.ArrayList;

import me.nbarudi.files.randomized.Randomized;
import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.Town.Jailor;
import me.nbarudi.files.roles.Town.VampireHunter;
import me.nbarudi.files.roles.Town.Veteran;
import me.nbarudi.files.roles.Town.Vigilante;

public class TownKilling extends Randomized {

	public TownKilling(String name) {
		super(name);
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(new Vigilante("Vigilante"));
		roles.add(new Veteran("Veteran"));
		roles.add(new Jailor("Jailor"));
		roles.add(new VampireHunter("VampireHunter"));
	}

}
