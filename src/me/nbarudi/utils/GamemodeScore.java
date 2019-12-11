package me.nbarudi.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import me.nbarudi.files.gamemodes.GameMode;
import me.nbarudi.files.randomized.Randomized;
import me.nbarudi.files.roles.Role;
import me.nbarudi.main.TownOfSalem;

public class GamemodeScore {
	
	public static Scoreboard modeScoreBoard;
	
	public static void setupScoreboard(TownOfSalem pl, GameMode mode) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		@SuppressWarnings("deprecation")
		Objective ob = sb.registerNewObjective("gamemode", "dummy");
		ob.setDisplayName("§b§l" + mode.name);
		ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		ArrayList<Role> roles = mode.roles;
		ArrayList<Randomized> rand = mode.random;
		int i = 16;
		for(Role r : roles) {
			Score s = ob.getScore(r.team + r.name);
			s.setScore(i);
			i--;
		}
		for(Randomized r : rand) {
			Score s = ob.getScore(r.name);
			s.setScore(i);
			i--;
		}
		modeScoreBoard = sb;
		
	}

}
