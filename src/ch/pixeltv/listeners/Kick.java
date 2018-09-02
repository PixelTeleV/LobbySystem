package ch.pixeltv.listeners;

import ch.pixeltv.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Kick implements Listener {

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();

        e.setReason("Du wurdest vom lokalen Server gekickt!");
        e.setLeaveMessage(null);

        if(Main.buildmode.contains(p)) {
            Main.buildmode.remove(p);
        }

        if(Main.fly.contains(p)) {
            Main.fly.remove(p);
        }
    }

}
