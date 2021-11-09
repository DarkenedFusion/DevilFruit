package io.github.darkenedfusion;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;



import io.github.darkenedfusion.CooldownManager.CustomEffects;

public class RumbleFruit implements Listener {
	
	@EventHandler
	public void onShiftClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(player.hasPotionEffect(PotionEffectType.SPEED)) {
			if(player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD){
			if(a.equals(Action.LEFT_CLICK_AIR)) {
				if(player.isSneaking()) {
					if(!CooldownManager.hasCooldown(player.getUniqueId(), CustomEffects.LIGHTNING)) {
						player.getWorld().strikeLightning(player.getTargetBlock(null, 100).getLocation());
						AreaEffectCloud uZeusCircle = (AreaEffectCloud) player.getWorld().spawnEntity(player.getLocation(), EntityType.AREA_EFFECT_CLOUD);
  	  					uZeusCircle.setRadius(3);
  	  					uZeusCircle.setWaitTime(0);
  	  					uZeusCircle.setDuration(100);
  	  					uZeusCircle.setCustomName("Ultimate Zeus Circle");
  	  					uZeusCircle.setCustomNameVisible(false);
  	  					uZeusCircle.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.GRAY, 1));
					CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.LIGHTNING, 3);
					}
				}
			}
		
		}
			}
	}
	
	@EventHandler
	public void onRightShiftClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(player.hasPotionEffect(PotionEffectType.SPEED)) {
			if(player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD){
			if(a.equals(Action.RIGHT_CLICK_AIR)) {
				if(player.isSneaking()) {
					if(!CooldownManager.hasCooldown(player.getUniqueId(), CustomEffects.TELEPORT)) {
						Location location = player.getLocation().clone();
						location.add(player.getEyeLocation().getDirection().multiply(8));
						player.teleport(location);
						player.getWorld().strikeLightning(player.getLocation());
						CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.TELEPORT, 5);
					}
				}
			}
			}
		}
	}
	
	
	@EventHandler
	public void onInventorySwap(PlayerSwapHandItemsEvent event) {
		Player player = event.getPlayer();
		if(event.getOffHandItem().getType() == Material.BLAZE_ROD) {
			AreaEffectCloud uZeusCircle = (AreaEffectCloud) player.getWorld().spawnEntity(player.getLocation(), EntityType.AREA_EFFECT_CLOUD);
				uZeusCircle.setRadius(10);
				uZeusCircle.setWaitTime(0);
				uZeusCircle.setDuration(300);
				uZeusCircle.setCustomName("RAIGO Circle");
				uZeusCircle.setCustomNameVisible(false);
				uZeusCircle.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.BLACK, 2));
				
				
				new BukkitRunnable() {
					double t = 0;
					Location loc = player.getLocation().add(new Vector(0, 10, 0));
					
					

					@Override
					public void run() {
						t += 1;
						
						
						if(t == 5) {
							player.getWorld().strikeLightning(player.getLocation().add(new Vector(5, 0, 0)));
							player.setGravity(false);
							player.teleport(player.getLocation().add(new Vector(0, 1, 0)));
								
						}
						
						if(t == 10) {
							player.getWorld().strikeLightning(player.getLocation().add(new Vector(0, 0, 5)));
							player.teleport(player.getLocation().add(new Vector(0, 1, 0)));
						}
						
						if(t == 15) {
							player.getWorld().strikeLightning(player.getLocation().add(new Vector(5, 0, 5)));
							player.teleport(player.getLocation().add(new Vector(0, 1, 0)));
						}
						if(t == 16) {
							player.getWorld().strikeLightning(player.getLocation().add(new Vector(-5, 0, 0)));
							player.teleport(player.getLocation().add(new Vector(0, 1, 0)));		
						}
						
						if(t == 17) {
							player.getWorld().strikeLightning(player.getLocation().add(new Vector(0, 0, -5)));
							player.teleport(player.getLocation().add(new Vector(0, 1, 0)));
						}
						
						if(t == 18) {
							player.getWorld().strikeLightning(player.getLocation().add(new Vector(-5, 0, 5)));
							player.teleport(player.getLocation().add(new Vector(0, 1, 0)));
						}
						
						if(t == 20) {
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String commandLine = "weather thunder";
							Bukkit.dispatchCommand(console, commandLine);
						}
						
						
						if(t == 30) {
							new BukkitRunnable() {
								double phi = 0;
								
								
								
								

								@Override
								public void run() {
									phi += Math.PI/10;
									for(double theta = 0; theta <= 2*Math.PI; theta +=Math.PI/40) {
										double r = 1.5;
										double x = r*Math.cos(theta)*Math.sin(phi);
										double y = r*Math.cos(phi) + 1.5;
										double z = r*Math.sin(theta)*Math.sin(phi);
										loc.add(x,y,z);
										player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc, 0, 0, 0, 0, 1);
										loc.subtract(x,y,z);
									}
									for(Entity e : loc.getChunk().getEntities()) {
										if(e.getLocation().distance(loc) < 5.0) {
											if(!e.equals(player)) {
												e.setGlowing(true);
												
											}
										}
									}
									
								
									
									
									if(phi > 300) {
										this.cancel();
										
										}
								
							}
						
									
						
								
								
							}.runTaskTimer(DevilFruit.getInstance(), 0, 1);
						}
						
						
						if(t >= 300) {
							player.setGravity(true);
							this.cancel();
						}
						
						
					}
					
					
				}.runTaskTimer(DevilFruit.getInstance(), 0, 1);
				
				
				
				
				
				
		}
	}
}
		
	
	
	


