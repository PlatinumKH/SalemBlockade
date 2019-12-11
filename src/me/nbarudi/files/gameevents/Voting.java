package me.nbarudi.files.gameevents;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import me.nbarudi.files.roles.Role;
import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.InfoManager;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;

public class Voting {
	
	public static int task = 0;
	public static double i = 0;
	public static int neededVotes = 0;
	public static HashMap<Player, Integer> pvotes = new HashMap<Player, Integer>();
	public static HashMap<Player, Player> whoVote = new HashMap<Player, Player>();
	
	public static void triggerVoting(int t) {
		Bukkit.getScheduler().cancelTask(t);
		makeVoteBook();
		neededVotes = (TownOfSalem.alive.size() / 2) + 1;
		Announcements.globalAnnounce(neededVotes + " §2are needed to judge a player!");
		
		whoVote.clear();
		pvotes.clear();
		
		for(Player p : TownOfSalem.alive) {
			pvotes.put(p, 0);
		}
		
		//Handle Boss Bar
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(TownOfSalem.instance, new Runnable() {
			public void run() {
				if(i >= 1) {
					i = 0;
					Bukkit.getScheduler().cancelTask(task);
					Night.triggerNextNight();
				}else {
					InfoManager.setBossBar("Day §b" + TownOfSalem.DayNumber+ "§r: Voting.", 1 - i);
					i = (i + 0.01);
				}
			}
		}, 20, 6);
	}
	
	public static void votePlayer(Player votee, Player voterr, int votes) {
		int tempVotes = 0;
		tempVotes = pvotes.get(votee);
		int newVotes = tempVotes + votes;
		pvotes.remove(votee);
		pvotes.put(votee, newVotes);
		if(whoVote.get(voterr) != null) {
			whoVote.remove(voterr);
			Announcements.globalAnnounce(voterr.getName() + " §2has instead voted against §r" + votee.getName() + "§a(§r" + newVotes + "§a).§r");
		}else {
			Announcements.globalAnnounce(voterr.getName() + " §2has voted against §r" + votee.getName() + "§a(§r" + newVotes + "§a).§r");
		}
		whoVote.put(voterr, votee);
		
		if(neededVotes <= newVotes) {
			Bukkit.getScheduler().cancelTask(task);
			for(Player p : TownOfSalem.alive) {
				p.getInventory().remove(p.getInventory().getItem(0));
			}
			Defense.triggerDefense(votee);
		}
		
	}
	
	public static void makeVoteBook() {
		for(Player p : TownOfSalem.alive) {
			ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta bm = (BookMeta) book.getItemMeta();
			
			ComponentBuilder msg = new ComponentBuilder("");
			
			for(Player plr : TownOfSalem.alive) {
				
				Role plrrole = TownOfSalem.plrs.get(plr.getName());
				//Role giverole = TownOfSalem.plrs.get(p.getName());
				
				if(plr.getName() == p.getName()) {
					continue;
				}else if(plrrole.teamname == "Dead") continue;
				
				msg.append(plr.getName());
				msg.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vote " + plr.getName() + " " + TownOfSalem.key));
				msg.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Vote up " + plr.getName()).create()));
				msg.append("\n");
				
				
				
			}
			
			BaseComponent[] bc = msg.create();
			
			bm.spigot().addPage(bc);
			bm.setTitle("Voting");
			book.setItemMeta(bm);
			p.getInventory().setItem(0, book);
		}
	}

}
