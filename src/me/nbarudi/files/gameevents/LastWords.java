package me.nbarudi.files.gameevents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.InfoManager;

public class LastWords {
	
	public static int task = 0;
	public static double i = 0;
	
	public static void triggerLastWords(Player dead) {
		TownOfSalem.isDefending = true;
		TownOfSalem.onStand = dead;
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(TownOfSalem.instance, new Runnable() {
			public void run() {
				if(i >= 1) {
					i = 0;
					Bukkit.getScheduler().cancelTask(task);
					TownOfSalem.isDefending = false;
					TownOfSalem.onStand.setHealth(0);
					DeathInfo.postDeathInfo(TownOfSalem.onStand, "They were hung by the town.");
					Bukkit.getScheduler().scheduleSyncDelayedTask(TownOfSalem.instance, new Runnable() {
						public void run() {
							Night.triggerNextNight();
						}
					}, 40);
				}else {
					InfoManager.setBossBar("Day §b" + TownOfSalem.DayNumber+ "§r: Any Last Words?.", i);
					i = (i + 0.01);
				}
			}
		}, 20, 1);
	}

}
