package ch.PixelTV.listeners;

import ch.PixelTV.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Build implements Listener {

    @EventHandler
    public void on(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        if (Main.buildmode.contains(p)) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void on(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (Main.buildmode.contains(player)) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }

    }

}
