package me.nbarudi.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.nbarudi.gamesystems.host.inventory.Manager;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.CheckPermissions;

public class Menu extends BukkitCommand{

	public Menu(String name) {
		super(name);
		this.description = "Enable host mode for a round of Salem: Blockade";
		this.usageMessage = "/menu";
	}


	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		if(CheckPermissions.checkPerms((Player)sender, 1)) {
			if(!HostMode.hosts.contains(sender.getName())){
				Announcements.dmAnnounce("You must have host mode enabled to use the menu!", (Player)sender);
				return false;
			}else {
				Manager.openInventory((Player)sender);
			}
		}else {
			sender.sendMessage("§4Sorry! You do not have permission to use the Host console!");
		}
		return false;
	}

}
