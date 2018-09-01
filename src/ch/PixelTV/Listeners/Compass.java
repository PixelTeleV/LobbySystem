package ch.PixelTV.Listeners;

import ch.PixelTV.Main.Main;
import ch.PixelTV.Utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Compass implements Listener {

    public static void openCompass(Player p) {

        Inventory compass = Bukkit.createInventory(null, 3 * 9, "§6Navigator");
        ItemStack placeholder = ItemUtils.getItem(Material.STAINED_GLASS_PANE, " ", "", 15, 1);
        ItemStack placeholder2 = ItemUtils.getItem(Material.STAINED_GLASS_PANE, " ", "", 5, 1);
        ItemStack spawn = ItemUtils.getItem(Material.NETHER_STAR, "§bSpawn", "§7Rechtsklick zum §ateleportieren§7!", 0, 1);
        ItemStack freebuild = ItemUtils.getItem(Material.GRASS, "§aFreeBuild", "§7Rechtsklick zum §ateleportieren§7!", 0, 1);
        ItemStack team = ItemUtils.getHead(p.getName(), "§aTeam", "§7Rechtsklick zum §ateleportieren§7!", 1);

        compass.setItem(0, placeholder2);
        compass.setItem(1, placeholder);
        compass.setItem(2, placeholder2);
        compass.setItem(3, placeholder2);
        compass.setItem(4, placeholder2);
        compass.setItem(5, placeholder2);
        compass.setItem(6, placeholder2);
        compass.setItem(7, placeholder);
        compass.setItem(8, placeholder2);
        compass.setItem(9, placeholder);
        compass.setItem(10, placeholder);
        compass.setItem(11, freebuild);
        compass.setItem(12, placeholder2);
        compass.setItem(13, spawn);
        compass.setItem(14, placeholder2);
        compass.setItem(15, team);
        compass.setItem(16, placeholder);
        compass.setItem(17, placeholder);
        compass.setItem(18, placeholder2);
        compass.setItem(19, placeholder);
        compass.setItem(20, placeholder2);
        compass.setItem(21, placeholder2);
        compass.setItem(22, placeholder2);
        compass.setItem(23, placeholder2);
        compass.setItem(24, placeholder2);
        compass.setItem(25, placeholder);
        compass.setItem(26, placeholder2);

        //Oeffnet Kompass
        p.openInventory(compass);

    }

    public static void openPlayerHider(Player p) {

        Inventory playerhider = Bukkit.createInventory(null, InventoryType.BREWING, "§6Sichtbarkeit");

        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                playerhider.setItem(3, ItemUtils.getItem(Material.STAINED_GLASS_PANE, "§6Welche Spieler möchtest du sehen?",
                        "§7Wähle sie hier aus!", 0, 1));

                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        playerhider.setItem(0, ItemUtils.getItem(Material.STAINED_GLASS_PANE, "§aAlle Spieler anzeigen",
                                "§7Klicke um auszuwählen!", 10, 1));

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                playerhider.setItem(1, ItemUtils.getItem(Material.STAINED_GLASS_PANE, " ",
                                        "", 15, 1));

                                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {
                                        playerhider.setItem(2, ItemUtils.getItem(Material.STAINED_GLASS_PANE, "§cKeine Spieler anzeigen",
                                                "§7Klicke um auszuwählen!", 8, 1));

                                    }
                                }, 2);

                            }
                        }, 2);

                    }
                }, 2);

            }
        }, 2);

        //Open Playerhider
        p.openInventory(playerhider);
    }

}
