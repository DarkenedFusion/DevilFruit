package io.github.darkenedfusion;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveFruit implements CommandExecutor {
	 private Fruits fruits = new Fruits();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("grant")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Console cannot run this command!");
				return true;
			}
			Player player = (Player) sender;
			if(args.length == 0) {
				player.sendMessage(ChatColor.RED + "Please type in an item name!");
				return true;
			}
			if(player.isOp()) {
				if(args[0].equalsIgnoreCase("rumble")) {
					player.getInventory().addItem(fruits.rumbleFruitItem());
					
				}
			}
		}
		return true;

	}
}
