package me.nbarudi.gamesystems.host.inventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.nbarudi.files.gameevents.Night;
import me.nbarudi.files.roles.Role;
import me.nbarudi.gamesystems.AssignRoles;
import me.nbarudi.gamesystems.host.HostTemplate;
import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.ConfigManager;
import net.md_5.bungee.api.ChatColor;

public class Manager implements Listener {
	
	public static Inventory inv = Bukkit.createInventory(null, 54, Announcements.prefix + "§cMenu");
	
	public Manager() {
	}
	
	public static void openInventory(Player p) {
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		for(HostTemplate ht : TownOfSalem.hostcommands) {
			ItemStack item = ht.item;
			items.add(item);
		}
		
		int stand = 1;
		for(ItemStack it : items) {
			inv.setItem(stand, it);
			stand += 3;
		}
		p.openInventory(inv);
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		Inventory inven = event.getInventory();
		
		if(inven != inv) {
			return;
		}
		
		ItemStack clicked = event.getCurrentItem();
		if(clicked == null) {
			return;
		}
		String aname = clicked.getItemMeta().getDisplayName();
		System.out.print(aname);
		if(aname.equalsIgnoreCase("List Abilities")) {
			listAbilities();
		}
		
		if(aname.equalsIgnoreCase("List Visits")) {
			listVisits(player);
		}
		
		if(aname.equalsIgnoreCase("Start Game")) {
			startGame(player);
		}
		
		if(aname.equalsIgnoreCase("Run Abilities")) {
			RunAbilityManager.runAbility(player);
		}
		
		if(aname.equalsIgnoreCase("Start Countdown")) {
			Night.countdown = true;
		}
		
		event.setCancelled(true);
	}
	
	//Ability functions
	
	public void listAbilities() {}
	
	public void listVisits(Player p) {
		
		for(String k : ConfigManager.getPlayerData().getConfigurationSection("PlayerData").getKeys(false)) {
			
			Role r = TownOfSalem.plrs.get(k);
			
			org.bukkit.ChatColor cc = r.team;
			String name = r.name;
			
			StringBuilder sb = new StringBuilder();
			sb.append("§7[" + cc + name + "§7] " + ChatColor.BLUE + k + ChatColor.GRAY + " Visits: ");
			List<String> visits = ConfigManager.getPlayerData().getStringList("PlayerData." + k + ".PlannedVisit");
			
			Role r1 = TownOfSalem.plrs.get(visits.get(0));
			org.bukkit.ChatColor cc1 = r1.team;
			String name1 = r1.name;
			
			sb.append("§7[" + cc1 + name1 + "§7] " + ChatColor.GREEN + visits.get(0) + ChatColor.GRAY + " ");
			if(visits.size() >= 1) {
				
				Role r2 = TownOfSalem.plrs.get(visits.get(0));
				org.bukkit.ChatColor cc2 = r2.team;
				String name2 = r2.name;
				
				sb.append("§7[" + cc2 + name2 + "§7] " +" Into " + ChatColor.RED + visits.get(1) + ChatColor.GRAY);
			}
			sb.append("!");
			
			Announcements.dmAnnounce(sb.toString(), p);
			
		}
	}
	
	public void startGame(Player p) {
		
		Announcements.dmAnnounce("Starting the game!", p);
		AssignRoles.StartGame(TownOfSalem.gm);
		
	}
	
	
	
	public static ItemStack playerHeadMaker(String name) {
		ItemStack is = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta sm = (SkullMeta)is.getItemMeta();
		Player player = Bukkit.getPlayer(name);
		sm.setOwningPlayer(player);
		sm.setDisplayName("§b" + name);
		
		Role r = TownOfSalem.plrs.get(name);
		String rname = r.name;
		org.bukkit.ChatColor cc = r.team;
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§aRole: " + cc + rname);
		sm.setLore(lore);
		
		is.setItemMeta(sm);
		
		return null;
	}
	

}
