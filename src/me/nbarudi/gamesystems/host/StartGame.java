package me.nbarudi.gamesystems.host;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StartGame extends HostTemplate{

	public StartGame(String name) {
		super(name);
		
		String desc = "Start the game. (Autoassign roles, etc..)";
		
		ItemStack item = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		List<String> lore = new ArrayList<String>();
		lore.add(desc);
		im.setLore(lore);
		item.setItemMeta(im);
		
		this.desc = desc;
		this.item = item;
		this.level = 1;
	}


}
