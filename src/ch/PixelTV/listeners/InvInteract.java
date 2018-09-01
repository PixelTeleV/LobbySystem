package ch.PixelTV.listeners;

import ch.PixelTV.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class InvInteract implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (Main.buildmode.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }

        if (e.getInventory().getName().equalsIgnoreCase("§6Sichtbarkeit")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAlle Spieler anzeigen")) {
                p.sendMessage(Main.pr + "Dir werden nun §aalle §eSpieler §aangezeigt§7!");
                p.closeInventory();
                Items.gJItems(p);
                if (!Main.pall.contains(p)) {
                    Main.pall.add(p);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        p.showPlayer(all);
                    }

                    if (Main.pnone.contains(p)) {
                        Main.pnone.remove(p);
                    }
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName()
                    .equalsIgnoreCase("§cKeine Spieler anzeigen")) {
                p.sendMessage(Main.pr + "Dir werden nun §ckeine §eSpieler §aangezeigt§7!");
                p.closeInventory();
                Items.gJItems(p);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    p.hidePlayer(all);
                }
                if (!Main.pnone.contains(p)) {
                    Main.pnone.add(p);

                    if (Main.pall.contains(p)) {
                        Main.pall.remove(p);
                    }
                }
            }
        }

        if (e.getInventory().getName().equalsIgnoreCase("§6Navigator")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpawn")) {
                Location locs = new Location(Bukkit.getWorld("world"), 0.0, 100.0, 0.0);
                p.teleport(locs);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFreeBuild")) {
                Location locf = new Location(Bukkit.getWorld("world"), -20.0, 100.0, -20.0);
                p.teleport(locf);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTeam")) {
                Location loct = new Location(Bukkit.getWorld("world"), 20.0, 100.0, 20.0);
                p.teleport(loct);
            }
        }
    }
}
