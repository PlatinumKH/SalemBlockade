package me.nbarudi.files.customevents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ForgeEvent extends Event{

	Player p;
	Player t;
	
	public ForgeEvent(Player player, Player target) {
		p = player;
		t = target;
	}
	
	
	public Player getPlayer() {
		return p;
	}
	
	public Player getTarget() {
		return t;
	}
	
	
	private static final HandlerList handlers = new HandlerList();
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	static public HandlerList getHandlerList() {
		return handlers;
	}
	

}
