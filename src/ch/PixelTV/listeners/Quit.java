package ch.PixelTV.listeners;

import ch.PixelTV.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Quit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        e.setQuitMessage(null);

        if(Main.buildmode.contains(p)) {
            Main.buildmode.remove(p);
        }

        if(Main.fly.contains(p)) {
            Main.fly.remove(p);
        }
    }

}
