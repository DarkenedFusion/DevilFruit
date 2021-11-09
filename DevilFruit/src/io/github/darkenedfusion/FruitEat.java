package io.github.darkenedfusion;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class FruitEat implements Listener {
	
	 private Fruits fruits = new Fruits();
	
	@EventHandler
	public void onRumbleEat(PlayerItemConsumeEvent event) {
		Player player = event.getPlayer();
		//ItemStack rumbleFruit = fruits.rumbleFruitItem();
		if(event.getItem().getItemMeta().getDisplayName().contains("Rumble Rumble Fruit")) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
			player.sendMessage(ChatColor.GRAY + "You ate the " + ChatColor.BLUE + "Rumble Rumble Fruit");
		}
	}

}
