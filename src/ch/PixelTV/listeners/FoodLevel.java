package ch.PixelTV.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class FoodLevel implements Listener {

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onFoodChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

}
