package me.nbarudi.gamesystems.host;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StartCountdown extends HostTemplate{

	public StartCountdown(String name) {
		super(name);
		
		String desc = "Start the 45 second night countdown!";
		String desc2 = "§4ONLY DO THIS IF YOU HAVE ALREADY RUN ALL THE ABILITIES";
		
		ItemStack item = new ItemStack(Material.BLACK_WOOL);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		List<String> lore = new ArrayList<String>();
		lore.add(desc);
		lore.add(desc2);
		im.setLore(lore);
		item.setItemMeta(im);
		
		this.desc = desc;
		this.item = item;
		this.level = 1;
		
	}


}
