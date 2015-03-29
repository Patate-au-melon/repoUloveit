package fr.ng.apis;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ArmorColorChangeEvent extends Event implements Cancellable {

	private static HandlerList handlers = new HandlerList();
	private boolean cancelled;
	public ItemStack item;
	public LeatherArmorMeta itemmeta;
	public Color color;

	public ArmorColorChangeEvent(ItemStack item, LeatherArmorMeta meta) {
		this.item = item;
		this.itemmeta = meta;
		this.color = meta.getColor();
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean value) {
		cancelled = value;
	}

	public ItemStack getItem() {
		return item;
	}

	public LeatherArmorMeta getItemMeta() {
		return itemmeta;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		itemmeta.setColor(color);
	}

	public Player getWearer() {
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			if (p.getInventory().contains(item)
					|| p.getInventory().getArmorContents().equals(item)) {
				if (item.getItemMeta() == itemmeta) {
					return p;
				}
			}
		}
		return null;
	}
}
