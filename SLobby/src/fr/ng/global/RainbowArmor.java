package fr.ng.global;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class RainbowArmor implements Listener {
	Main main;

	public RainbowArmor(Main main) {
		this.main = main;
	}

	private ItemStack getColorArmor(Material m, Color c) {
		ItemStack i = new ItemStack(m, 1);
		i.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setColor(c);
		i.setItemMeta(meta);
		return i;
	}

	public static int helmet;
	public static int chestplate;
	public static int leggings;
	public static int boots;

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory()
				.getName()
				.equalsIgnoreCase(
						ChatColor.RED + "Armures" + ChatColor.DARK_GRAY
								+ " en cuir")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}

			if (e.getCurrentItem() != null
					&& e.getCurrentItem().hasItemMeta()
					&& e.getCurrentItem().getItemMeta().hasDisplayName()
					&& e.getCurrentItem()
							.getItemMeta()
							.getDisplayName()
							.contains(
									ChatColor.RED + "A" + ChatColor.BLUE + "r"
											+ ChatColor.YELLOW + "m"
											+ ChatColor.GREEN + "u"
											+ ChatColor.GOLD + "r"
											+ ChatColor.AQUA + "e "
											+ ChatColor.LIGHT_PURPLE + "t"
											+ ChatColor.DARK_BLUE + "e"
											+ ChatColor.WHITE + "c"
											+ ChatColor.BLACK + "h"
											+ ChatColor.DARK_PURPLE + "n"
											+ ChatColor.GRAY + "i"
											+ ChatColor.GOLD + ""
											+ ChatColor.BOLD + "color")) {
				p.getWorld().playSound(p.getLocation(), Sound.SPLASH, 1, 1);
				Bukkit.getScheduler().cancelTask(helmet);
				Bukkit.getScheduler().cancelTask(chestplate);
				Bukkit.getScheduler().cancelTask(leggings);
				Bukkit.getScheduler().cancelTask(boots);

				p.getInventory().setHelmet(
						new ItemStack(Material.LEATHER_HELMET));
				p.getInventory().setChestplate(
						new ItemStack(Material.LEATHER_CHESTPLATE));
				p.getInventory().setLeggings(
						new ItemStack(Material.LEATHER_LEGGINGS));
				p.getInventory()
						.setBoots(new ItemStack(Material.LEATHER_BOOTS));

				p.closeInventory();

				helmet = Bukkit.getServer().getScheduler()
						.scheduleSyncRepeatingTask(main, new Runnable() {
							private Random r = new Random();

							public void run() {
								Color c = Color.fromRGB(r.nextInt(255),
										r.nextInt(255), r.nextInt(255));

								if (p.getInventory().getHelmet() != null
										&& p.getInventory().getHelmet()
												.getType() == Material.LEATHER_HELMET) {
									p.getInventory()
											.setHelmet(
													getColorArmor(
															Material.LEATHER_HELMET,
															c));
								}

							}
						}, 1, 8);

				chestplate = Bukkit.getServer().getScheduler()
						.scheduleSyncRepeatingTask(main, new Runnable() {
							private Random r = new Random();

							public void run() {
								Color c2 = Color.fromRGB(r.nextInt(255),
										r.nextInt(255), r.nextInt(255));

								if (p.getInventory().getChestplate() != null
										&& p.getInventory().getChestplate()
												.getType() == Material.LEATHER_CHESTPLATE) {
									p.getInventory()
											.setChestplate(
													getColorArmor(
															Material.LEATHER_CHESTPLATE,
															c2));
								}
							}
						}, 1, 8);

				leggings = Bukkit.getServer().getScheduler()
						.scheduleSyncRepeatingTask(main, new Runnable() {
							private Random r = new Random();

							@Override
							public void run() {
								Color c3 = Color.fromRGB(r.nextInt(255),
										r.nextInt(255), r.nextInt(255));

								if (p.getInventory().getLeggings() != null
										&& p.getInventory().getLeggings()
												.getType() == Material.LEATHER_LEGGINGS) {
									p.getInventory().setLeggings(
											getColorArmor(
													Material.LEATHER_LEGGINGS,
													c3));
								}
							}
						}, 1, 8);

				boots = Bukkit.getServer().getScheduler()
						.scheduleSyncRepeatingTask(main, new Runnable() {
							private Random r = new Random();

							@Override
							public void run() {
								Color c4 = Color.fromRGB(r.nextInt(255),
										r.nextInt(255), r.nextInt(255));

								if (p.getInventory().getBoots() != null
										&& p.getInventory().getBoots()
												.getType() == Material.LEATHER_BOOTS) {
									p.getInventory().setBoots(
											getColorArmor(
													Material.LEATHER_BOOTS,

													c4));
								}
							}
						}, 1, 8);

			}
		}
	}
}
