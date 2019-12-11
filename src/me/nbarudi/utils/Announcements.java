package me.nbarudi.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.nbarudi.files.roles.Role;

public class Announcements {
	
	public static String prefix = "§7[§aSalem: §5Blockade §bExpansion§7] ";
	
	public static void giveRoleInfo(Role r, Player p) {
		
		p.sendMessage("§6§lRole: " + r.team + r.name + "\n");
		
		p.sendMessage("§6§lAttack: §b§l" + BookSetup.ConvertAttack(r.attack) + "\n");
		p.sendMessage("§6§lDefense: §b§l" + BookSetup.ConvertDefense(r.defense) + "\n");
		
		p.sendMessage("§6§lAlignment: " + r.teamname + "\n");
		
		StringBuilder attrib = new StringBuilder();
		attrib.append("§6§lAttributes\n\n§r");
		for (String string : r.attributes) {
			attrib.append("- " + string + "§r\n");
		}
		p.sendMessage(attrib.toString());
		
		StringBuilder abilitb = new StringBuilder();
		abilitb.append("§6§lAbilities\n\n§r");
		for (String string : r.abilities) {
			abilitb.append("- " + string + "§r\n");
		}
		p.sendMessage(abilitb.toString());
		
		StringBuilder winconb = new StringBuilder();
		winconb.append("§6§lYou win with: \n\n§r");
		for (String string : r.winconditions) {
			winconb.append("- " + string + "§r\n");
		}
		p.sendMessage(winconb.toString());
		
	}
	
	public static void globalAnnounce(String msg) {
		Bukkit.broadcastMessage(prefix + msg);
	}
	
	public static void dmAnnounce(String msg, Player p) {
		p.sendMessage(prefix + msg);
	}

}
