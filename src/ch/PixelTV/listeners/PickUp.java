package ch.PixelTV.listeners;

import ch.PixelTV.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class PickUp implements Listener {

    @EventHandler
    public void on(PlayerPickupItemEvent e){
        if(Main.buildmode.contains(e.getPlayer())){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

}
