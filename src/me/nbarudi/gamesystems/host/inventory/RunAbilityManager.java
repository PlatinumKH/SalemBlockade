package me.nbarudi.gamesystems.host.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;

public class RunAbilityManager implements Listener{

	public static Inventory inv = Bukkit.createInventory(null, 56, Announcements.prefix + "§cMenu");
	
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
		
		SkullMeta sm = (SkullMeta)clicked.getItemMeta();
		Player p = (Player)sm.getOwningPlayer();
		
		
		
	}
	
	public static void runAbility(Player sender) {
		
		
		if(TownOfSalem.gameStarted) {
			TownOfSalem.plrs.forEach((k, v)->{
				ItemStack head = Manager.playerHeadMaker(k);
				inv.addItem(head);
				
			});
		}
		
	}
	

}
