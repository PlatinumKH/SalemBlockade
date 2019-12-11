package me.nbarudi.files.gameevents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.InfoManager;

public class Defense {
	public static int task = 0;
	public static double i = 0;
	public static void triggerDefense(Player votee) {
		
		TownOfSalem.isDefending = true;
		TownOfSalem.onStand = votee;
		
		Announcements.globalAnnounce(votee.getName() + "§a you are being tried for actions against the town. What is your defense?");
		//Teleport Player to the stand.
		
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(TownOfSalem.instance, new Runnable() {
			public void run() {
				if(i >= 1) {
					i = 0;
					Bukkit.getScheduler().cancelTask(task);
					TownOfSalem.isDefending = false;
					Judgement.triggerJudgement();
				}else {
					InfoManager.setBossBar("Day §b" + TownOfSalem.DayNumber+ "§r: Defense.", i);
					i = (i + 0.01);
				}
			}
		}, 60, 3);
	}

}
