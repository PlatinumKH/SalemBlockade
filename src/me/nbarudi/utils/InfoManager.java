package me.nbarudi.utils;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;



public class InfoManager {
	
	
	public static BarColor bc = BarColor.BLUE;
	public static BarStyle bs = BarStyle.SOLID;
	public static BarFlag bf = BarFlag.DARKEN_SKY;
	public static BossBar bb = Bukkit.createBossBar("Waiting..", bc, bs, bf);
	
	public static void setBossBar(String message, double progress) {
		for(Player p : Bukkit.getOnlinePlayers()) {
		bb.setTitle(message);
		bb.setProgress(progress);
		bb.addPlayer(p);
		bb.setVisible(true);
		}
	}

}
