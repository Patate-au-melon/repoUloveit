package fr.ng.global;

import inventaire.Autres;
import inventaire.Cuir1;
import inventaire.Cuir2;
import inventaire.Cuir3;
import inventaire.Inventaire;
import inventaire.Princ;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventListener implements Listener {
	String ng = GlobalMethods.ng;
	ItemStack armorstand;
	Main main;
	Inventaire princ = new Princ();
	Inventaire autres = new Autres();
	Inventaire cuir1 = new Cuir1();
	Inventaire cuir2 = new Cuir2();
	Inventaire cuir3 = new Cuir3();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		armorstand = new ItemStack(Material.ARMOR_STAND);
		Inventory pInv = p.getInventory();
		int slot = Main.getSlot();
		ItemMeta ItemMeta = armorstand.getItemMeta();
		ItemMeta.setDisplayName(ChatColor.RED + "Garde" + ChatColor.WHITE + "-"
				+ ChatColor.DARK_GRAY + "Robe");
		ArrayList<String> desclist = new ArrayList<String>();
		desclist.add(ChatColor.YELLOW
				+ "Cliquez ici pour ouvrir la garde-robe !");
		ItemMeta.setLore(desclist);
		armorstand.setItemMeta(ItemMeta);
		if (slot > 0) {
			pInv.setItem(slot, armorstand);
		} else {
			Main.setSlot(3);
		}
		if (p.hasPermission("ng.armor.admin.clear")) {
		} else {
			ItemStack itemAir = new ItemStack(Material.AIR);
			p.getInventory().setBoots(itemAir);
			p.getInventory().setChestplate(itemAir);
			p.getInventory().setLeggings(itemAir);
			p.getInventory().setHelmet(itemAir);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Material mat = p.getItemInHand().getType();
		if (mat == Material.ARMOR_STAND) {
			princ.openInv(p);
			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onClic(InventoryClickEvent e) {
		try {
			if (e.getInventory()
					.getName()
					.equalsIgnoreCase(
							ChatColor.RED + "Garde" + ChatColor.WHITE + "-"
									+ ChatColor.DARK_GRAY + "Robe")) {
				try {
					Material current = e.getCurrentItem().getType();
					Player p = (Player) e.getWhoClicked();
					if (current == Material.IRON_CHESTPLATE) {
						autres.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (current == Material.LEATHER_CHESTPLATE) {
						cuir1.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					}
				} catch (NullPointerException ee) {
				} finally {
					e.setCancelled(true);
				}
			} else if (e
					.getInventory()
					.getName()
					.equalsIgnoreCase(
							ChatColor.RED + "Autres" + ChatColor.DARK_GRAY
									+ " armures")) {
				try {
					Material current = e.getCurrentItem().getType();
					Player p = (Player) e.getWhoClicked();
					if (current == Material.ARROW) {
						princ.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (current == Material.TNT) {
						ItemStack itemAir = new ItemStack(Material.AIR);
						p.getInventory().setBoots(itemAir);
						p.getInventory().setChestplate(itemAir);
						p.getInventory().setLeggings(itemAir);
						p.getInventory().setHelmet(itemAir);
						p.playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
					} else if (current == Material.AIR) {
					} else {
						GlobalMethods.equipArmor(current, p);
						p.playSound(p.getLocation(), Sound.SPLASH, 1, 1);
					}
				} catch (NullPointerException ee) {
				} finally {
					e.setCancelled(true);
				}
			} else if (e
					.getInventory()
					.getName()
					.equalsIgnoreCase(
							ChatColor.RED + "Armures" + ChatColor.DARK_GRAY
									+ " en cuir")) {
				try {
					Material current = e.getCurrentItem().getType();
					ItemStack item = e.getCurrentItem();
					Player p = (Player) e.getWhoClicked();
					if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Page 1")) {
						cuir1.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Page 2")) {
						cuir2.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Page 3")) {
						cuir3.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Retour")) {
						princ.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (item
							.getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(
									ChatColor.GRAY + "Supprimer l'armure")) {
						ItemStack itemAir = new ItemStack(Material.AIR);
						p.getInventory().setBoots(itemAir);
						p.getInventory().setChestplate(itemAir);
						p.getInventory().setLeggings(itemAir);
						p.getInventory().setHelmet(itemAir);
						p.playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
					} else if (item.getItemMeta().getDisplayName()
							.contains("rainbow")) {
						// à faire !!!
						GlobalMethods.equipColoredArmor(current, p, item);
						p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1, 1);
					} else {
						GlobalMethods.equipColoredArmor(current, p, item);
						p.playSound(p.getLocation(), Sound.SPLASH, 1, 1);
					}
				} catch (NullPointerException ee) {
				} finally {
					e.setCancelled(true);
				}
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	@EventHandler
	public void onEject(PlayerDropItemEvent e) {
		Material mat = e.getItemDrop().getItemStack().getType();
		if ((mat == Material.ARMOR_STAND)
				&& (e.getPlayer().hasPermission("ng.armor.admin.drop") == false)) {
			e.setCancelled(true);
		}
	}
}
