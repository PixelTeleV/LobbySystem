package ch.PixelTV.listeners;

import ch.PixelTV.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Damage implements Listener {

    @EventHandler(priority=EventPriority.HIGHEST)
    public void on(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (Main.buildmode.contains(event.getEntity())) {
                event.setCancelled(false);
            } else {
                event.setCancelled(true);
            }
        }
    }

}
