package ch.pixeltv.listeners;

import ch.pixeltv.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Coded by PixelTeleV
 * 04.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Reload implements Listener {

    @EventHandler
    public void onReload(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String cmd = e.getMessage();

        if(cmd.equalsIgnoreCase("/rl") || cmd.equalsIgnoreCase("/reload")) {
            if(p.hasPermission("System.Reload")) {
                e.setCancelled(true);
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(Main.pr + "§4ACHTUNG: §7Der Server wird neugeladen!");
                Bukkit.broadcastMessage(Main.pr + "§cBitte keine Nachrichten schreiben!");
                Bukkit.broadcastMessage(" ");
                Bukkit.reload();
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(Main.pr + "§aDer Reload ist abgeschlossen!");
                Bukkit.broadcastMessage(Main.pr + "§aDu kannst nun normal weiterspielen!");
                Bukkit.broadcastMessage(Main.pr + "§aViel Spass weiterhin auf §5EpicPixelMC.de§a!");
                Bukkit.broadcastMessage(" ");
            } else {
                p.sendMessage(Main.noperm);
            }
        }
    }

}
