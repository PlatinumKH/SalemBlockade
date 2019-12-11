package me.nbarudi.utils;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import me.nbarudi.files.roles.Role;
import me.nbarudi.main.TownOfSalem;

public class BookSetup {
	
	public static ItemStack makeBook(String name, ChatColor team, int a, int d, ArrayList<String> atrib, ArrayList<String> abil, ArrayList<String> wincondition, String teamname) {
		
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		
		BookMeta bm = (BookMeta) book.getItemMeta();
		
		bm.setTitle(team + name);
		bm.setAuthor("Town Of Salem");
		
		String attack = null;
		String defense= null;
		
		attack = ConvertAttack(a);
		
		defense = ConvertDefense(d);
		
		StringBuilder role = new StringBuilder();
		role.append(team + name + "\n");
		role.append("§6§lAlignment: " + teamname +"§r\n");
		role.append("§6§lAttack: " + "§b§l" + attack + "§r\n");
		role.append("§6§lDefense: " + "§b§l" + defense + "§r\n");
		
		bm.addPage(role.toString());
		
		StringBuilder attrib = new StringBuilder();
		attrib.append("§6§lAttributes\n\n§r");
		for (String string : atrib) {
			attrib.append("- " + string + "§r\n");
		}
		bm.addPage(attrib.toString());
		
		StringBuilder abilitb = new StringBuilder();
		abilitb.append("§6§lAbilities\n\n§r");
		for (String string : abil) {
			abilitb.append("- " + string + "§r\n");
		}
		bm.addPage(abilitb.toString());
		
		StringBuilder winconb = new StringBuilder();
		winconb.append("§6§lYou win with: \n\n§r");
		for (String string : wincondition) {
			winconb.append("- " + string + "§r\n");
		}
		bm.addPage(winconb.toString());
		
		book.setItemMeta(bm);
		
		return book;
	}
	
	public static String ConvertAttack(int a) {
		String attack = null;
		if(a == 0) attack = "None";
		if(a == 1) attack = "Basic";
		if(a == 2) attack = "Powerful";
		if(a == 3) attack = "Unstoppable";
		
		return attack;
		
	}
	
	public static String ConvertDefense(int d) {
		String defense = null;
		if(d == 0) defense = "None";
		if(d == 1) defense = "Basic";
		if(d == 2) defense = "Strong";
		if(d == 3) defense = "Invinicble";
		
		return defense;
	}
	
	public static void genBook(Player p) {
		Role r = TownOfSalem.plrs.get(p.getName());
		
		p.getInventory().addItem(makeBook(r.name, r.team, r.attack, r.defense, r.attributes, r.abilities, r.winconditions, r.teamname));
		
	}

}
