package me.nbarudi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.nbarudi.files.gameevents.Voting;

public class ForceVote extends BukkitCommand{

	public ForceVote(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		Player target = Bukkit.getPlayer(args[0]);
		Voting.votePlayer(target, (Player)sender, 15);
		return false;
	}

}
