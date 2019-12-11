package me.nbarudi.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.nbarudi.main.TownOfSalem;

public class PlayerChat implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		if(TownOfSalem.isDefending && event.getPlayer() != TownOfSalem.onStand) {
			event.setCancelled(true);
		}
	}

}
