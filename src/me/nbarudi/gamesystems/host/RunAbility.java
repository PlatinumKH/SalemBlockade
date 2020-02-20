package me.nbarudi.gamesystems.host;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RunAbility extends HostTemplate{

	public RunAbility(String name) {
		super(name);
		
		String desc = "Run a given roles ability to a given player.";
		
		ItemStack item = new ItemStack(Material.YELLOW_WOOL);
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
