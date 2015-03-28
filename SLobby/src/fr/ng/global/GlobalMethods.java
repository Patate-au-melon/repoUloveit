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
			inv.setItem(23, chesDiams);
			ItemStack casDiams = null;
			if (p.hasPermission("ng.armor.casDiams")) {
				casDiams = transItem(new ItemStack(Material.DIAMOND_HELMET),
						ChatColor.GRAY + "Casque en diamant", ChatColor.YELLOW
								+ "Cliquez pour mettre un casque en diamant !",
						p);
			} else {
				casDiams = errorItem;
			}
			inv.setItem(14, casDiams);
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
			inv.setItem(32, item);
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
			inv.setItem(41, bootDiams);
			// or
			ItemStack chesOr;
			if (p.hasPermission("ng.armor.chesOr")) {
				chesOr = transItem(new ItemStack(Material.GOLD_CHESTPLATE),
						ChatColor.GRAY + "Plastron en or", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron en or !", p);
			} else {
				chesOr = errorItem;
			}
			inv.setItem(21, chesOr);
			ItemStack casOr = null;
			if (p.hasPermission("ng.armor.casOr")) {
				casOr = transItem(new ItemStack(Material.GOLD_HELMET),
						ChatColor.GRAY + "Casque en or", ChatColor.YELLOW
								+ "Cliquez pour mettre un casque en or !", p);
			} else {
				casOr = errorItem;
			}
			inv.setItem(12, casOr);
			if (p.hasPermission("ng.armor.pantOr")) {
				item = transItem(new ItemStack(Material.GOLD_LEGGINGS),
						ChatColor.GRAY + "Pantalon en or", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon en or !", p);
			} else {
				item = errorItem;
			}
			inv.setItem(30, item);
			ItemStack bootOr = null;
			if (p.hasPermission("ng.armor.bootOr")) {
				bootOr = transItem(new ItemStack(Material.GOLD_BOOTS),
						ChatColor.GRAY + "Bottes en or", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes en or !", p);
			} else {
				bootOr = errorItem;
			}
			inv.setItem(39, bootOr);
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
					+ "Supprimer l'armure", ChatColor.YELLOW
					+ "Cliquez pour réinitialiser l'armure", p);
			inv.setItem(47, destroy);
			// inv cuir
		} else if (invName.equalsIgnoreCase("Cuir")) {
			inv = Bukkit.createInventory(null, 54, ChatColor.RED + "Armures"
					+ ChatColor.DARK_GRAY + " en cuir");
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
			inv.setItem(17, item);
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
			inv.setItem(26, item);
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
			inv.setItem(35, item);
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
			inv.setItem(44, item);
			// yellow
			if (p.hasPermission("ng.armor.casLeaYel")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir jaune",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque jaune !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.YELLOW);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(11, item);
			if (p.hasPermission("ng.armor.chesLeaYel")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron jaune", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron jaune !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.YELLOW);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(20, item);
			if (p.hasPermission("ng.armor.pantLeaYel")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon jaune", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon jaune !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.YELLOW);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(29, item);
			if (p.hasPermission("ng.armor.bootLeaYel")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes jaunes", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes jaunes !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.YELLOW);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(38, item);
			// bleu
			if (p.hasPermission("ng.armor.casLeaBlue")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir bleu",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque bleu !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.BLUE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(13, item);
			if (p.hasPermission("ng.armor.chesLeaBlue")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron bleu", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron bleu !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.BLUE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(22, item);
			if (p.hasPermission("ng.armor.pantLeaBlue")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon bleu", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon bleu !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.BLUE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(31, item);
			if (p.hasPermission("ng.armor.bootLeaBlue")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes bleus", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes bleues !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.BLUE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(40, item);
			// green
			if (p.hasPermission("ng.armor.casLeaGre")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir vert",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque vert !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.GREEN);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(15, item);
			if (p.hasPermission("ng.armor.chesLeaGre")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron vert", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron vert !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.GREEN);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(24, item);
			if (p.hasPermission("ng.armor.pantLeaGre")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon vert", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon vert !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.GREEN);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(33, item);
			if (p.hasPermission("ng.armor.bootLeaGre")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes vertes", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes vertes !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.GREEN);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(42, item);
			// normal
			if (p.hasPermission("ng.armor.casLeaNor")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir normal",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque normal !", p);
			} else {
				item = errorItem;
			}
			inv.setItem(9, item);
			if (p.hasPermission("ng.armor.chesLeaNor")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron normal", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron normal !", p);
			} else {
				item = errorItem;
			}
			inv.setItem(18, item);
			if (p.hasPermission("ng.armor.pantLeaNor")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon normal", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon normal ! !",
						p);
			} else {
				item = errorItem;
			}
			inv.setItem(27, item);
			if (p.hasPermission("ng.armor.bootLeaNor")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes normals", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes normales !",
						p);
			} else {
				item = errorItem;
			}
			inv.setItem(36, item);
			// tnt
			ItemStack destroy;
			destroy = transItem(new ItemStack(Material.TNT), ChatColor.GRAY
					+ "Supprimer l'armure", ChatColor.YELLOW
					+ "Cliquez pour réinitialiser l'armure", p);
			inv.setItem(49, destroy);
			// arrow 2
			ItemStack arrow;
			arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
					+ "Page 2", ChatColor.YELLOW
					+ "Cliquez pour aller à la page 2", p);
			inv.setItem(51, arrow);
			// arrow
			arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
					+ "Retour", ChatColor.YELLOW
					+ "Cliquez pour aller en arrière", p);
			inv.setItem(47, arrow);
			// inv cuir 2
		} else if (invName.equalsIgnoreCase("Cuir2")) {
			inv = Bukkit.createInventory(null, 54, ChatColor.RED + "Armures"
					+ ChatColor.DARK_GRAY + " en cuir");
			// blanc
			if (p.hasPermission("ng.armor.casLeaWhi")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir blanc",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque blanc !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.WHITE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(17, item);
			if (p.hasPermission("ng.armor.chesLeaWhi")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron blanc", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron blanc !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.WHITE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(26, item);
			if (p.hasPermission("ng.armor.pantLeaWhi")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon blanc", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon blanc ! !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.WHITE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(35, item);
			if (p.hasPermission("ng.armor.bootLeaWhi")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes blanches", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes blanches !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.WHITE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(44, item);
			// violet
			if (p.hasPermission("ng.armor.casLeaVio")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir violet",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque violet !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.PURPLE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(11, item);
			if (p.hasPermission("ng.armor.chesLeaVio")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron violet", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron violet !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.PURPLE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(20, item);
			if (p.hasPermission("ng.armor.pantLeaVio")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon violet", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon violet !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.PURPLE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(29, item);
			if (p.hasPermission("ng.armor.bootLeaVio")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes violettes", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes violettes !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.PURPLE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(38, item);
			// noir
			if (p.hasPermission("ng.armor.casLeaBla")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir noir",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque noir !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.BLACK);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(13, item);
			if (p.hasPermission("ng.armor.chesLeaBla")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron noir", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron noir !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.BLACK);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(22, item);
			if (p.hasPermission("ng.armor.pantLeaBla")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon noir", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon noir !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.BLACK);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(31, item);
			if (p.hasPermission("ng.armor.bootLeaBla")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes noires", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes noires !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.BLACK);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(40, item);
			// orange
			if (p.hasPermission("ng.armor.casLeaOra")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir orange",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque orange !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.ORANGE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(15, item);
			if (p.hasPermission("ng.armor.chesLeaOra")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron orange", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron orange !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.ORANGE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(24, item);
			if (p.hasPermission("ng.armor.pantLeaOra")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon orange", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon orange !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.ORANGE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(33, item);
			if (p.hasPermission("ng.armor.bootLeaOra")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes oranges", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes oranges !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.ORANGE);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(42, item);
			// rose
			if (p.hasPermission("ng.armor.casLeaRos")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir rose",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque rose !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.FUCHSIA);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(9, item);
			if (p.hasPermission("ng.armor.chesLeaRos")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron rose", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron rose !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.FUCHSIA);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(18, item);
			if (p.hasPermission("ng.armor.pantLeaRos")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon rose", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon rose ! !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.FUCHSIA);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(27, item);
			if (p.hasPermission("ng.armor.bootLeaRos")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes roses", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes roses !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.FUCHSIA);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(36, item);
			// tnt
			ItemStack destroy;
			destroy = transItem(new ItemStack(Material.TNT), ChatColor.GRAY
					+ "Supprimer l'armure", ChatColor.YELLOW
					+ "Cliquez pour réinitialiser l'armure", p);
			inv.setItem(49, destroy);
			// arrow 1
			ItemStack arrow;
			arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
					+ "Page 1", ChatColor.YELLOW
					+ "Cliquez pour aller à la page 1", p);
			inv.setItem(47, arrow);
			// arrow 3
			arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
					+ "Page 3", ChatColor.YELLOW
					+ "Cliquez pour aller à la page 3", p);
			inv.setItem(51, arrow);
			// inv cuir 3
		} else if (invName.equalsIgnoreCase("Cuir3")) {
			inv = Bukkit.createInventory(null, 54, ChatColor.RED + "Armures"
					+ ChatColor.DARK_GRAY + " en cuir");
			// marron
			if (p.hasPermission("ng.armor.casLeaMar")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir marron",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque marron !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.MAROON);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(17, item);
			if (p.hasPermission("ng.armor.chesLeaMar")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron marron", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron marron !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.MAROON);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(26, item);
			if (p.hasPermission("ng.armor.pantLeaMar")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon marron", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon marron ! !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.MAROON);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(35, item);
			if (p.hasPermission("ng.armor.bootLeaMar")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes marron", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes marron !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.MAROON);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(44, item);
			// gris
			if (p.hasPermission("ng.armor.casLeaGri")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir gris",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque gris !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.GRAY);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(11, item);
			if (p.hasPermission("ng.armor.chesLeaGri")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron gris", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron gris !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.GRAY);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(20, item);
			if (p.hasPermission("ng.armor.pantLeaGri")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon gris", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon gris !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.GRAY);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(29, item);
			if (p.hasPermission("ng.armor.bootLeaGri")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes gris", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes gris !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.GRAY);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(38, item);
			// vert clair
			if (p.hasPermission("ng.armor.casLeaLim")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir vert clair",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque vert clair !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.LIME);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(13, item);
			if (p.hasPermission("ng.armor.chesLeaLim")) {
				item = transItem(
						new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron vert clair",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron vert clair !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.LIME);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(22, item);
			if (p.hasPermission("ng.armor.pantLeaLim")) {
				item = transItem(
						new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon vert clair",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon vert clair !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.LIME);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(31, item);
			if (p.hasPermission("ng.armor.bootLeaLim")) {
				item = transItem(
						new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes vert clair",
						ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes vert clair !",
						p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.LIME);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(40, item);
			// cyan
			if (p.hasPermission("ng.armor.casLeaCya")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir cyan",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque cyan !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.AQUA);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(15, item);
			if (p.hasPermission("ng.armor.chesLeaCya")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron cyan", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron cyan !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.AQUA);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(24, item);
			if (p.hasPermission("ng.armor.pantLeaCya")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon cyan", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon cyan !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.AQUA);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(33, item);
			if (p.hasPermission("ng.armor.bootLeaCya")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes cyans", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes cyan !", p);
				LeatherArmorMeta armorMeta = (LeatherArmorMeta) item
						.getItemMeta();
				armorMeta.setColor(Color.AQUA);
				item.setItemMeta(armorMeta);
			} else {
				item = errorItem;
			}
			inv.setItem(42, item);
			// multi-color
			if (p.hasPermission("ng.armor.casLeaRai")) {
				item = transItem(new ItemStack(Material.LEATHER_HELMET),
						ChatColor.GRAY + "Casque en cuir rainbow",
						ChatColor.YELLOW
								+ "Cliquez pour mettre un casque rainbow !", p);
			} else {
				item = errorItem;
			}
			inv.setItem(9, item);
			if (p.hasPermission("ng.armor.chesLeaRai")) {
				item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
						ChatColor.GRAY + "Plastron rainbow", ChatColor.YELLOW
								+ "Cliquez pour mettre un plastron rainbow !",
						p);
			} else {
				item = errorItem;
			}
			inv.setItem(18, item);
			if (p.hasPermission("ng.armor.pantLeaRai")) {
				item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
						ChatColor.GRAY + "Pantalon rainbow", ChatColor.YELLOW
								+ "Cliquez pour mettre un pantalon rainbow !",
						p);
			} else {
				item = errorItem;
			}
			inv.setItem(27, item);
			if (p.hasPermission("ng.armor.bootLeaRai")) {
				item = transItem(new ItemStack(Material.LEATHER_BOOTS),
						ChatColor.GRAY + "Bottes rainbow", ChatColor.YELLOW
								+ "Cliquez pour mettre des bottes rainbow !", p);
			} else {
				item = errorItem;
			}
			inv.setItem(36, item);
			// tnt
			ItemStack destroy;
			destroy = transItem(new ItemStack(Material.TNT), ChatColor.GRAY
					+ "Supprimer l'armure", ChatColor.YELLOW
					+ "Cliquez pour réinitialiser l'armure", p);
			inv.setItem(49, destroy);
			// arrow 2
			ItemStack arrow;
			arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
					+ "Page 2", ChatColor.YELLOW
					+ "Cliquez pour aller à la page 2", p);
			inv.setItem(47, arrow);
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
