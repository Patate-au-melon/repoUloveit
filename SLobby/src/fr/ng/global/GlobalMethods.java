package fr.ng.global;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;

public class GlobalMethods {
	// Variables
	public static String ng = ChatColor.BLACK + "[" + ChatColor.RED + "N"
			+ ChatColor.BLACK + "-" + ChatColor.DARK_GRAY + "G"
			+ ChatColor.BLACK + "] " + ChatColor.YELLOW;
	protected static Inventory inv;
	static ItemStack errorItem = transItem(new ItemStack(Material.BARRIER),
			ChatColor.RED + "Indisponible", ChatColor.RED
					+ "Vous n'avez pas cet item");
	protected static ItemStack item = null;

	// Méthodes qu'on trouve partout
	public static String returnErrorPerm(String perms) {
		String perm = ng + ChatColor.RED + "Il vous faut la permission "
				+ perms;
		return perm;

	}

	public static String returnErrorCMD(String cmd) {
		String com = ng + ChatColor.RED + "La commande est : " + cmd;
		return com;

	}

	public static void openInv(Player p, String invName) {
		// inventaire principal
		if (invName.equalsIgnoreCase("Princ")) {
			inv = Bukkit.createInventory(null, InventoryType.HOPPER,
					ChatColor.RED + "Garde" + ChatColor.WHITE + "-"
							+ ChatColor.DARK_GRAY + "Robe");
			ItemStack armMét = transItem(
					new ItemStack(Material.IRON_CHESTPLATE), ChatColor.RED
							+ "Autres" + ChatColor.DARK_GRAY + " armures",
					ChatColor.BOLD + "" + ChatColor.DARK_GRAY
							+ "Menu des autres armures");
			ItemStack armCuir = transItem(new ItemStack(
					Material.LEATHER_CHESTPLATE), ChatColor.RED + "Armures"
					+ ChatColor.DARK_GRAY + " en cuir", ChatColor.BOLD + ""
					+ ChatColor.DARK_GRAY + "Menu des armures en cuir");
			inv.setItem(3, armMét);
			inv.setItem(1, armCuir);
			// inventaire métal
		} else if (invName.equalsIgnoreCase("Métaux")) {
			inv = Bukkit.createInventory(null, 54, ChatColor.RED + "Autres"
					+ ChatColor.DARK_GRAY + " armures");
			ItemStack chesFer;
			if (p.hasPermission("ng.armor.chesFer")) {
				chesFer = transItem(new ItemStack(Material.IRON_CHESTPLATE),
						ChatColor.GRAY + "Plastron en fer", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron en fer !", p);
			} else {
				chesFer = errorItem;
			}
			inv.setItem(19, chesFer);
			ItemStack casFer = null;
			if (p.hasPermission("ng.armor.casFer")) {
				casFer = transItem(new ItemStack(Material.IRON_HELMET),
						ChatColor.GRAY + "Casque en fer", ChatColor.YELLOW
								+ "Cliquez pour mettre un casque en fer !", p);
			} else {
				casFer = errorItem;
			}
			inv.setItem(10, casFer);
			if (p.hasPermission("ng.armor.pantFer")) {
				item = transItem(new ItemStack(Material.IRON_LEGGINGS),
						ChatColor.GRAY + "Pantalon en fer", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon en fer !", p);
			} else {
				item = errorItem;
			}
			inv.setItem(28, item);
			ItemStack bootFer = null;
			if (p.hasPermission("ng.armor.bootFer")) {
				bootFer = transItem(new ItemStack(Material.IRON_BOOTS),
						ChatColor.GRAY + "Bottes en fer", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes en fer !", p);
			} else {
				bootFer = errorItem;
			}
			inv.setItem(37, bootFer);
			// diams
			ItemStack chesDiams;
			if (p.hasPermission("ng.armor.chesDiams")) {
				chesDiams = transItem(
						new ItemStack(Material.DIAMOND_CHESTPLATE),
						ChatColor.GRAY + "Plastron en diamant",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron en diamant !",
						p);
			} else {
				chesDiams = errorItem;
			}
			inv.setItem(21, chesDiams);
			ItemStack casDiams = null;
			if (p.hasPermission("ng.armor.casDiams")) {
				casDiams = transItem(new ItemStack(Material.DIAMOND_HELMET),
						ChatColor.GRAY + "Casque en diamant", ChatColor.YELLOW
								+ "Cliquez pour mettre un casque en diamant !",
						p);
			} else {
				casDiams = errorItem;
			}
			inv.setItem(12, casDiams);
			if (p.hasPermission("ng.armor.pantDiams")) {
				item = transItem(
						new ItemStack(Material.DIAMOND_LEGGINGS),
						ChatColor.GRAY + "Pantalon en diamant",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon en diamant !",
						p);
			} else {
				item = errorItem;
			}
			inv.setItem(30, item);
			ItemStack bootDiams = null;
			if (p.hasPermission("ng.armor.bootDiams")) {
				bootDiams = transItem(
						new ItemStack(Material.DIAMOND_BOOTS),
						ChatColor.GRAY + "Bottes en diamant",
						ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes en diamant !",
						p);
			} else {
				bootDiams = errorItem;
			}
			inv.setItem(39, bootDiams);
			// or
			ItemStack chesOr;
			if (p.hasPermission("ng.armor.chesOr")) {
				chesOr = transItem(new ItemStack(Material.GOLD_CHESTPLATE),
						ChatColor.GRAY + "Plastron en or", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron en or !", p);
			} else {
				chesOr = errorItem;
			}
			inv.setItem(23, chesOr);
			ItemStack casOr = null;
			if (p.hasPermission("ng.armor.casOr")) {
				casOr = transItem(new ItemStack(Material.GOLD_HELMET),
						ChatColor.GRAY + "Casque en or", ChatColor.YELLOW
								+ "Cliquez pour mettre un casque en or !", p);
			} else {
				casOr = errorItem;
			}
			inv.setItem(14, casOr);
			if (p.hasPermission("ng.armor.pantOr")) {
				item = transItem(new ItemStack(Material.GOLD_LEGGINGS),
						ChatColor.GRAY + "Pantalon en or", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon en or !", p);
			} else {
				item = errorItem;
			}
			inv.setItem(32, item);
			ItemStack bootOr = null;
			if (p.hasPermission("ng.armor.bootOr")) {
				bootOr = transItem(new ItemStack(Material.GOLD_BOOTS),
						ChatColor.GRAY + "Bottes en or", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes en or !", p);
			} else {
				bootOr = errorItem;
			}
			inv.setItem(41, bootOr);
			// chained
			ItemStack chesCha;
			if (p.hasPermission("ng.armor.chesCha")) {
				chesCha = transItem(
						new ItemStack(Material.CHAINMAIL_CHESTPLATE),
						ChatColor.GRAY + "Cotte de mailles", ChatColor.YELLOW
								+ "Cliquez pour mettre une cotte de mailles !",
						p);
			} else {
				chesCha = errorItem;
			}
			inv.setItem(25, chesCha);
			ItemStack casCha = null;
			if (p.hasPermission("ng.armor.casCha")) {
				casCha = transItem(new ItemStack(Material.CHAINMAIL_HELMET),
						ChatColor.GRAY + "Casque en mailles", ChatColor.YELLOW
								+ "Cliquez pour mettre un casque en mailles !",
						p);
			} else {
				casCha = errorItem;
			}
			inv.setItem(16, casCha);
			if (p.hasPermission("ng.armor.pantCha")) {
				item = transItem(
						new ItemStack(Material.CHAINMAIL_LEGGINGS),
						ChatColor.GRAY + "Pantalon en mailles",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon en mailles !",
						p);
			} else {
				item = errorItem;
			}
			inv.setItem(34, item);
			ItemStack bootCha = null;
			if (p.hasPermission("ng.armor.bootCha")) {
				bootCha = transItem(
						new ItemStack(Material.CHAINMAIL_BOOTS),
						ChatColor.GRAY + "Bottes en mailles",
						ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes en mailles !",
						p);
			} else {
				bootCha = errorItem;
			}
			inv.setItem(43, bootCha);
			// arrow
			ItemStack arrow;
			arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
					+ "Retour", ChatColor.YELLOW
					+ "Cliquez pour aller en arrière", p);
			inv.setItem(51, arrow);
			// tnt
			ItemStack destroy;
			destroy = transItem(new ItemStack(Material.TNT), ChatColor.GRAY
					+ "Armure en air", ChatColor.YELLOW
					+ "Cliquez pour réinitialiser l'armure", p);
			inv.setItem(47, destroy);
			// inv cuir
		} else if (invName.equalsIgnoreCase("Cuir")) {
			inv = Bukkit.createInventory(null, InventoryType.CHEST,
					ChatColor.RED + "Armures" + ChatColor.DARK_GRAY
							+ " en cuir");
			// red
			if (p.hasPermission("ng.armor.casLeaRed")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir rouge",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque rouge !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.RED);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(9, item);
			if (p.hasPermission("ng.armor.chesLeaRed")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron rouge", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron rouge !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.RED);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(18, item);
			if (p.hasPermission("ng.armor.pantLeaRed")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon rouge", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon rouge ! !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.RED);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(27, item);
			if (p.hasPermission("ng.armor.bootLeaRed")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes rouges", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes rouges !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.RED);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(36, item);
			// tnt
			ItemStack destroy;
			destroy = transItem(new ItemStack(Material.TNT), ChatColor.GRAY
					+ "Armure en air", ChatColor.YELLOW
					+ "Cliquez pour réinitialiser l'armure", p);
			inv.setItem(47, destroy);
			// inv error
		} else {
			inv = Bukkit.createInventory(null, InventoryType.HOPPER,
					ChatColor.RED + "ERREUR");
		}
		p.openInventory(inv);
	}

	@SuppressWarnings("unused")
	private static ItemStack enchant(ItemStack itemS, Player p) {
		Material mat = itemS.getType();
		ItemStack itemNS = itemS;
		if (mat == p.getInventory().getBoots().getType()) {
			itemNS.addEnchantment(Enchantment.DURABILITY, 3);
		} else if (mat == p.getInventory().getChestplate().getType()) {
			itemNS.addEnchantment(Enchantment.DURABILITY, 3);
		} else if (mat == p.getInventory().getLeggings().getType()) {
			itemNS.addEnchantment(Enchantment.DURABILITY, 3);
		} else if (mat == p.getInventory().getHelmet().getType()) {
			itemNS.addEnchantment(Enchantment.DURABILITY, 3);
		}
		return itemNS;
	}

	public static void equipColoredArmor(Material mat, Player p, ItemStack item2) {
		ItemStack item = new ItemStack(mat);
		item.setItemMeta(item2.getItemMeta());
		if (mat == Material.LEATHER_HELMET) {
			p.getInventory().setHelmet(item);
		} else if (mat == Material.LEATHER_CHESTPLATE) {
			p.getInventory().setChestplate(item);
		} else if (mat == Material.LEATHER_BOOTS) {
			p.getInventory().setBoots(item);
		} else if (mat == Material.LEATHER_LEGGINGS) {
			p.getInventory().setLeggings(item);
		}
	}

	public static void equipArmor(Material mat, Player p) {
		ItemStack item = new ItemStack(mat);
		if ((mat == Material.CHAINMAIL_BOOTS)
				|| (mat == Material.DIAMOND_BOOTS)
				|| (mat == Material.IRON_BOOTS) || (mat == Material.GOLD_BOOTS)) {
			p.getInventory().setBoots(item);
		} else if ((mat == Material.CHAINMAIL_CHESTPLATE)
				|| (mat == Material.DIAMOND_CHESTPLATE)
				|| (mat == Material.IRON_CHESTPLATE)
				|| (mat == Material.GOLD_CHESTPLATE)) {
			p.getInventory().setChestplate(item);
		} else if ((mat == Material.CHAINMAIL_LEGGINGS)
				|| (mat == Material.DIAMOND_LEGGINGS)
				|| (mat == Material.IRON_LEGGINGS)
				|| (mat == Material.GOLD_LEGGINGS)) {
			p.getInventory().setLeggings(item);
		} else if ((mat == Material.CHAINMAIL_HELMET)
				|| (mat == Material.DIAMOND_HELMET)
				|| (mat == Material.IRON_HELMET)
				|| (mat == Material.GOLD_HELMET)) {
			p.getInventory().setHelmet(item);
		}
	}

	public static ItemStack transItem(ItemStack item, String nom, String desc,
			Player p) {
		ItemMeta ItemMeta = item.getItemMeta();
		ItemMeta.setDisplayName(nom);
		ArrayList<String> desclist = new ArrayList<String>();
		desclist.add(desc);
		ItemMeta.setLore(desclist);
		item.setItemMeta(ItemMeta);
		return item;
	}

	public static ItemStack transItem(ItemStack item, String nom, String desc) {
		ItemMeta ItemMeta = item.getItemMeta();
		ItemMeta.setDisplayName(nom);
		ArrayList<String> desclist = new ArrayList<String>();
		desclist.add(desc);
		ItemMeta.setLore(desclist);
		item.setItemMeta(ItemMeta);
		return item;
	}

	public static ItemStack transItem(ItemStack item, String nom, String desc,
			MaterialData itemNbr) {
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(nom);
		ArrayList<String> desclist = new ArrayList<String>();
		desclist.add(desc);
		itemMeta.setLore(desclist);
		item.setItemMeta(itemMeta);
		item.setData(itemNbr);
		return item;
	}
}
