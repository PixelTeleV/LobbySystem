package ch.pixeltv.listeners;

import ch.pixeltv.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Drop implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(Main.buildmode.contains(e.getPlayer())){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

}
