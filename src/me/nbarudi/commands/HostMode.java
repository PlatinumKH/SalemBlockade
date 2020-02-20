package me.nbarudi.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.CheckPermissions;

public class HostMode extends BukkitCommand {
	
	public static ArrayList<String> hosts = new ArrayList<String>();

	public HostMode(String name) {
		super(name);
		this.description = "Enable host mode for a round of Salem: Blockade";
		this.usageMessage = "/hostmode";
	}


	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		if(CheckPermissions.checkPerms((Player)sender, 1)) {
			if(hosts.contains(sender.getName())) {
				hosts.remove(sender.getName());
				Announcements.dmAnnounce("§4Disabled §7hostmode!", (Player)sender);
				TownOfSalem.spectators.remove((Player)sender);
			}else {
				hosts.add(sender.getName());
				Announcements.dmAnnounce("§aEnabled §7hostmode!", (Player)sender);
				TownOfSalem.spectators.add((Player)sender);
			}
		}else {
			sender.sendMessage("§4Sorry! You do not have permission to enable Host Mode!");
		}
		return false;
	}

}
