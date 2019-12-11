package me.nbarudi.files.gameevents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.InfoManager;

public class Hanging {
	
	public static int task = 0;
	public static double i = 0;
	
	
	public static void triggerHanging(Player dead) {
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(TownOfSalem.instance, new Runnable() {
			public void run() {
				if(i >= 1) {
					i = 0;
					Bukkit.getScheduler().cancelTask(task);
					//ToDo: Trigger a death info system
				}else {
					InfoManager.setBossBar("Day §b" + TownOfSalem.DayNumber+ "§r: May god have mercy on your soul!?.", 1 - i);
					i = (i + 0.01);
				}
			}
		}, 20, 1);
	}

}
