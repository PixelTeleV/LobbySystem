package ch.pixeltv.listeners;

import ch.pixeltv.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

/**
 * Coded by PixelTeleV
 * 04.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Unknown implements Listener {

    @EventHandler
    public void onUnknown(PlayerCommandPreprocessEvent e) {
        if(!(e.isCancelled())) {
            Player p = e.getPlayer();
            String msg = e.getMessage().split(" ")[0];
            HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
            if(topic == null) {
                p.sendMessage(Main.pr + "§cDer Befehl §a" + msg + " §cexistiert nicht§7!");
                e.setCancelled(true);
            }
        }
    }

}

