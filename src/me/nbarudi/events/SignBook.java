package me.nbarudi.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

import me.nbarudi.utils.Announcements;

public class SignBook implements Listener{
	
	@EventHandler
	public void onSign(PlayerEditBookEvent event) {
		if(event.isSigning()) {
			event.setCancelled(true);
			Announcements.dmAnnounce("§4Please do not sign your wills!", event.getPlayer());
		}
	}

}
