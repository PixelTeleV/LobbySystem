package ch.pixeltv.listeners;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.player.CloudPlayer;
import de.dytanic.cloudnet.lib.player.PlayerExecutor;
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
        CloudPlayer player = CloudAPI.getInstance().getOnlinePlayer(p.getUniqueId());
        PlayerExecutor playerExecutor = player.getPlayerExecutor();

        Items.gJItems(p);

        e.setJoinMessage(null);

        p.sendMessage("§aWillkommen auf §5EpicPixelMC.de §aund viel Spass beim Spielen!");
        p.setFoodLevel(20);
        p.setMaxHealth(20);
        p.setHealth(20);

        //Actionbar on Join
        playerExecutor.sendActionbar(player, "§aWillkommen §7auf §5EpicPixelMC.de§7!");


        //Tablist
        CloudServer.getInstance().updateNameTags(e.getPlayer());

    }

}
