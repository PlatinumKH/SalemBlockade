package me.nbarudi.files.gameevents;

import org.bukkit.Bukkit;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.InfoManager;

public class GameTrigger {
	
	public static void startGame() {
//		AssignRoles.StartGame(TownOfSalem.gm);
//		TownOfSalem.plrs.forEach((s, r) ->{
//			Player p = Bukkit.getPlayer(s);
//			if(r.teamname == "Mafia") {
//				TownOfSalem.mafia.add(p);
//				if(r.name == "Mafioso") {
//					TownOfSalem.mafioso = p;
//				}else if(r.name == "Godfather") {
//					TownOfSalem.gf = p;
//				}
//			}
//		});
		InfoManager.setBossBar("§b§lRoles Assigned..", 1);
		Bukkit.getScheduler().scheduleSyncDelayedTask(TownOfSalem.instance, new Runnable() {
			public void run() {
				InfoManager.bb.removeAll();
				Day.triggerDay1();
			}
		}, 60);
	}

}
