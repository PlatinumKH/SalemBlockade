package me.nbarudi.files.gameevents;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.InfoManager;

public class Judgement implements Listener{
	
	
	public static int task = 0;
	public static double i = 0;
	public static HashMap<Player, Boolean> votes = new HashMap<Player, Boolean>();
	static int totalGuilties = 0;
	static int totalInnos = 0;
	
	public static void triggerJudgement() {
		TownOfSalem.isDefending = false;
		Announcements.globalAnnounce("§2Town may now vote §aInnocent §2(inno in chat) or §4Guilty §2(guilty in chat)");
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(TownOfSalem.instance, new Runnable() {
			public void run() {
				if(i >= 1) {
					i = 0;
					Bukkit.getScheduler().cancelTask(task);
					giveVoteInfo();
					TownOfSalem.isDefending = true;
					if(totalGuilties > totalInnos) {
						Announcements.globalAnnounce(TownOfSalem.onStand.getName() + " §2has been voted §4Guilty§2!");
						LastWords.triggerLastWords(TownOfSalem.onStand);
					}else {
						Announcements.globalAnnounce(TownOfSalem.onStand.getName() + " §2has been voted §aInnocent§2!");
						Voting.triggerVoting(task);
					}
				}else {
					InfoManager.setBossBar("Day §b" + TownOfSalem.DayNumber+ "§r: Judgement.", 1 - i);
					i = (i + 0.01);
				}
			}
		}, 100, 4);
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String msg = event.getMessage();
		
		if(event.getPlayer() == TownOfSalem.onStand) return;
		
		if(votes.get(event.getPlayer()) != null) {
			if(msg.equalsIgnoreCase("guilty")) {
				votes.put(event.getPlayer(), true);
				Announcements.globalAnnounce(event.getPlayer().getName() + " has changed voted!");
				event.setCancelled(true);
			}else if(msg.equalsIgnoreCase("inno")) {
				votes.put(event.getPlayer(), false);
				Announcements.globalAnnounce(event.getPlayer().getName() + " has changed voted!");
				event.setCancelled(true);
			}
		}else {
			if(msg.equalsIgnoreCase("guilty")) {
				votes.put(event.getPlayer(), true);
				Announcements.globalAnnounce(event.getPlayer().getName() + " has voted!");
				event.setCancelled(true);
			}else if(msg.equalsIgnoreCase("inno")) {
				votes.put(event.getPlayer(), false);
				Announcements.globalAnnounce(event.getPlayer().getName() + " has voted!");
				event.setCancelled(true);
			}
		}
	}
	
	public static void giveVoteInfo() {
		votes.forEach((p, v) ->{
			if(v) {
				if(TownOfSalem.mayor == p && TownOfSalem.mayorRevealed) {
					totalGuilties = totalGuilties + 2;
				}
				totalGuilties++;
				Announcements.globalAnnounce(p.getName() + " §2voted §4Guilty§2!");
			}else {
				totalInnos++;
				Announcements.globalAnnounce(p.getName() + " §2voted §eInnocent§2!");
			}
		});
		
		Announcements.globalAnnounce("§2The vote ended with §b" + totalGuilties + " §4Guilties§2, and §b" + totalInnos + "§2 Innocents");
		
	}

}
