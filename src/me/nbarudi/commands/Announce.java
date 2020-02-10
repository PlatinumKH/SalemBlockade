package me.nbarudi.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.CheckPermissions;

public class Announce extends BukkitCommand {
	
	public Announce(String name) {
		super(name);
		this.description = "Announce a server wide message";
		this.usageMessage = "/announce <message>";
	}


	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		if(CheckPermissions.checkPerms((Player)sender, 1)) {
			if(HostMode.hosts.contains(sender.getName())) {
				StringBuilder sb = new StringBuilder();
				for(String a : args) {
					sb.append(a + " ");
				}
				
				Announcements.globalAnnounce(sb.toString());
				
			}else {
				Announcements.dmAnnounce("§4Sorry! You must be in host mode to announce a message!", (Player)sender);
			}
		}else {
			sender.sendMessage("§4Sorry! You do not have permission to announce a message");
		}
		return false;
	}

}
