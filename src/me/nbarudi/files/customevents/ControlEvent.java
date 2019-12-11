package me.nbarudi.files.customevents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ControlEvent extends Event{

	Player p;
	Player t;
	Player t2;
	
	public ControlEvent(Player player, Player target, Player target2) {
		p = player;
		t = target;
		t2 = target2;
	}
	
	
	public Player getPlayer() {
		return p;
	}
	
	public Player getTarget() {
		return t;
	}
	
	public Player getSecondTarget() {
		return t2;
	}
	
	
	private static final HandlerList handlers = new HandlerList();
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	static public HandlerList getHandlerList() {
		return handlers;
	}
	

}
