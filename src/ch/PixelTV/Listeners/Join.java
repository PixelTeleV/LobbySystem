package ch.PixelTV.Listeners;

import de.dytanic.cloudnet.bridge.CloudServer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        Items.gJItems(p);

        e.setJoinMessage(null);

        p.sendMessage("§aWillkommen auf dem Server und viel Spass beim spielen!");
        p.setFoodLevel(20);
        p.setMaxHealth(20);
        p.setHealth(20);


        //Tablist
        CloudServer.getInstance().updateNameTags(e.getPlayer());

    }

}
