package me.nbarudi.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.nbarudi.utils.Announcements;

public class InventoryInteract implements Listener{
	
	@EventHandler
	public void onInteract(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		Inventory inv = event.getClickedInventory();
		
		if(player.getInventory() == inv) {
			ItemStack cItem = event.getCurrentItem();
			if(cItem == null) return;
			if(cItem.getType().equals(Material.WRITTEN_BOOK)) {
				event.setCancelled(true);
				player.closeInventory();
				player.openBook(cItem);
			}else if(cItem.getType().equals(Material.WRITABLE_BOOK)) {
				event.setCancelled(true);
				player.closeInventory();
				Announcements.dmAnnounce("§4Please do not move your will in your inventory!", player);
			}
		}
	}

}
