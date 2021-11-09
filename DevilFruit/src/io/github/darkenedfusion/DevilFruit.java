package io.github.darkenedfusion;

import org.bukkit.plugin.java.JavaPlugin;





public class DevilFruit extends JavaPlugin {
	
	private static DevilFruit instance;

	@Override
	public void onEnable() {
		instance = this;
		
		this.getCommand("grant").setExecutor(new GiveFruit());
		
		this.getServer().getPluginManager().registerEvents(new RumbleFruit(), this);
		this.getServer().getPluginManager().registerEvents(new FruitEat(), this);
	
	}
	
	public static DevilFruit getInstance() {
		return instance;
	}
}
