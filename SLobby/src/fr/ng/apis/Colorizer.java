package fr.ng.apis;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Colorizer {

	public static ItemStack setColor(ItemStack item, int r, int g, int b) {
		LeatherArmorMeta lam = (LeatherArmorMeta) item.getItemMeta();
		lam.setColor(Color.fromRGB(r, g, b));
		item.setItemMeta(lam);
		Bukkit.getServer().getPluginManager()
				.callEvent(new ArmorColorChangeEvent(item, lam));
		return item;
	}

	public static ItemStack setColor(ItemStack item, Color color) {
		LeatherArmorMeta lam = (LeatherArmorMeta) item.getItemMeta();
		lam.setColor(color);
		item.setItemMeta(lam);
		Bukkit.getServer().getPluginManager()
				.callEvent(new ArmorColorChangeEvent(item, lam));
		return item;
	}

	public static void armorRandomColorChange(final JavaPlugin plugin,
			final Player player, final long repeatdelay, final long time,
			final boolean printStackTrace, final Color... color) {
		new BukkitRunnable() {
			public void run() {
				try {
					for (ItemStack i : player.getInventory().getArmorContents()) {
						if (i == new ItemStack(Material.LEATHER_BOOTS)
								|| i == new ItemStack(
										Material.LEATHER_CHESTPLATE)
								|| i == new ItemStack(Material.LEATHER_HELMET)
								|| i == new ItemStack(Material.LEATHER_LEGGINGS)) {
							Color[] colors = color;
							Random r = new Random();
							List<Color> colorList = Arrays.asList(colors);
							Color randomColor = colorList.get(r
									.nextInt(colorList.size()));
							setColor(i, randomColor);
						} else {
							Bukkit.getServer()
									.getLogger()
									.warning(
											"["
													+ plugin.getName()
													+ "] [Colorizer] The player "
													+ player.getName()
													+ " is not wearing any leather armour!");
							this.cancel();
							return;
						}
					}
					final int taskID = this.getTaskId();
					new BukkitRunnable() {
						public void run() {
							Bukkit.getServer().getScheduler()
									.cancelTask(taskID);
						}
					}.runTaskLater(plugin, 20 * time);
				} catch (Exception e) {
					this.cancel();
					if (printStackTrace == true) {
						e.printStackTrace();
					}
				}
			}
		}.runTaskTimer(plugin, 0L, repeatdelay);
	}
}
