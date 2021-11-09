package io.github.darkenedfusion;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Fruits {
	
	
	public ItemStack rumbleFruitItem() {
		
		ItemStack rumbleFruit = new ItemStack(Material.PUMPKIN_PIE);
		ItemMeta meta = rumbleFruit.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE + "Rumble Rumble Fruit");
		rumbleFruit.setItemMeta(meta);
		return rumbleFruit;
	}

}
