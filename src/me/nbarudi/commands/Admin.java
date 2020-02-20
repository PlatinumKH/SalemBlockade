package me.nbarudi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.nbarudi.files.customevents.KillEvent;
import me.nbarudi.main.TownOfSalem;
import net.md_5.bungee.api.ChatColor;

public class Admin extends BukkitCommand {

	public Admin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		if(args.length < 2) {
			sender.sendMessage(ChatColor.RED + "Please do not use this command. It is all handled for you at night.");
			return false;
		}
		
		if(!args[0].equals(TownOfSalem.key)) {
			sender.sendMessage(ChatColor.RED + "Please do not use this command. It is all handled for you at night.");
			return false;
		}
		
		if(args[1].equalsIgnoreCase("kill")) {
			Player t = Bukkit.getPlayer(args[2]);
			if(t == null) {
				sender.sendMessage("Sorry, can't find the player you stated!");
				return false;
			}
			
			KillEvent event = new KillEvent((Player) sender, t);
			
			Bukkit.getServer().getPluginManager().callEvent(event);
			sender.sendMessage("Running kill event on player " + t.getName());
			return false;
		}
		
		return false;
	}

}
