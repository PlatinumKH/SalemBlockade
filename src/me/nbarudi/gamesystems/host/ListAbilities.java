package me.nbarudi.gamesystems.host;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ListAbilities extends HostTemplate{

	public ListAbilities(String name) {
		super(name);
		
		String desc = "Lists all possible abilities a player can run.";
		
		ItemStack item = new ItemStack(Material.GREEN_DYE);
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
