package fr.ng.global;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
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
				+ "Cliquez ici pour\nouvrir la garde-robe !");
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
			GlobalMethods.openInv(p, "Princ");
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
						GlobalMethods.openInv(p, "M�taux");
					} else if (current == Material.LEATHER_CHESTPLATE) {
						GlobalMethods.openInv(p, "Cuir");
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
						GlobalMethods.openInv(p, "Princ");
					} else if (current == Material.TNT) {
						ItemStack itemAir = new ItemStack(Material.AIR);
						p.getInventory().setBoots(itemAir);
						p.getInventory().setChestplate(itemAir);
						p.getInventory().setLeggings(itemAir);
						p.getInventory().setHelmet(itemAir);
					} else {
						GlobalMethods.equipArmor(current, p);
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
						GlobalMethods.openInv(p, "Cuir");
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Page 2")) {
						GlobalMethods.openInv(p, "Cuir2");
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Page 3")) {
						GlobalMethods.openInv(p, "Cuir3");
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Retour")) {
						GlobalMethods.openInv(p, "Princ");
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
					} else {
						GlobalMethods.equipColoredArmor(current, p, item);
					}
				} catch (NullPointerException ee) {
				} finally {
					e.setCancelled(true);
				}
			} else if (e.getInventory().getName()
					.equalsIgnoreCase(ChatColor.RED + "ERREUR")) {
				e.setCancelled(true);

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
