package fr.ng.global;

import inventaire.Autres;
import inventaire.Cuir1;
import inventaire.Cuir2;
import inventaire.Cuir3;
import inventaire.Inventaire;
import inventaire.Princ;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DisplaymenuCommandExecutor implements CommandExecutor {

	ItemStack armorstand;
	String ng = GlobalMethods.ng;
	GlobalMethods gm;
	Inventaire princ = new Princ();
	Inventaire autres = new Autres();
	Inventaire cuir1 = new Cuir1();
	Inventaire cuir2 = new Cuir2();
	Inventaire cuir3 = new Cuir3();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player ps = Bukkit.getServer().getPlayer(sender.getName());
		if (args.length == 0) {
			princ.openInv(ps);
		} else {
			if (sender.hasPermission("nglobby.armor.admin.cmd")) {
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(ng
							+ "Liste des commandes de la garde-robe :\n/armor : Affiche le menu\n/armor help : Affiche l'aide du plugin\n/armor setslot [ slot ] :"
							+ " D�finit la position de l'item qui ouvre le menu\n/armor giveitem < joueur > : Donne l'item � un joueur"
							+ " (en cas de bug par exemple)\n\"[]\" indique l'obligation et \"<>\" un argument non-obligatoire.");
				} else if (args[0].equals("giveitem")) {
					if (args.length == 2) {
						try {
							if (Bukkit
									.getServer()
									.getOnlinePlayers()
									.contains(
											Bukkit.getServer().getPlayer(
													args[1]))) {
								Player target = Bukkit.getServer().getPlayer(
										args[1]);
								armorstand = new ItemStack(Material.ARMOR_STAND);
								Inventory pInv = target.getInventory();
								int slot = Main.getSlot();
								ItemMeta ItemMeta = armorstand.getItemMeta();
								ItemMeta.setDisplayName(ChatColor.RED + "Garde"
										+ ChatColor.WHITE + "-"
										+ ChatColor.DARK_GRAY + "Robe");
								ArrayList<String> desclist = new ArrayList<String>();
								desclist.add(ChatColor.YELLOW
										+ "Cliquez ici pour ouvrir la garde-robe !");
								ItemMeta.setLore(desclist);
								armorstand.setItemMeta(ItemMeta);
								pInv.setItem(slot, armorstand);
								sender.sendMessage(ng
										+ "Vous avez donn� l'item  � "
										+ args[1] + " !");
								ps.playSound(ps.getLocation(),
										Sound.SUCCESSFUL_HIT, 1, 1);
							} else {
								sender.sendMessage(ng
										+ "Ce joueur n'est pas en ligne");
								ps.playSound(ps.getLocation(), Sound.FALL_BIG,
										1, 1);
							}
						} catch (Exception e) {
							sender.sendMessage(ng
									+ "Ce joueur n'est pas en ligne");
							ps.playSound(ps.getLocation(), Sound.FALL_BIG, 1, 1);
						}
					} else {
						sender.sendMessage(GlobalMethods
								.returnErrorCMD("/armor giveitem [ joueur ]"));
						ps.playSound(ps.getLocation(), Sound.FALL_BIG, 1, 1);
						;
					}
				} else if (args[0].equals("setslot")) {
					if (args.length == 2) {
						try {
							Integer nslot = Integer.valueOf(args[1]);
							if (nslot < 10 && nslot > 0) {
								Main.setSlot(nslot - 1);
								sender.sendMessage(ng
										+ "Vous avez d�fini le slot en "
										+ args[1]);
								ps.playSound(ps.getLocation(),
										Sound.SUCCESSFUL_HIT, 1, 1);
							} else {
								sender.sendMessage(ng
										+ "Merci de mettre un nombre compris entre 1 et 9");
								ps.playSound(ps.getLocation(), Sound.FALL_BIG,
										1, 1);
							}
						} catch (Exception e) {
							sender.sendMessage(ng
									+ "Veuillez mettre un nombre !");
							ps.playSound(ps.getLocation(), Sound.FALL_BIG, 1, 1);
						}
					} else {
						sender.sendMessage(GlobalMethods
								.returnErrorCMD("/armor setslot [ slot ]"));
						ps.playSound(ps.getLocation(), Sound.FALL_BIG, 1, 1);
					}
				}
			} else {
				sender.sendMessage(GlobalMethods
						.returnErrorPerm("nglobby.armor.admin"));
				ps.playSound(ps.getLocation(), Sound.FALL_BIG, 1, 1);
			}
		}
		return false;
	}
}
