package ch.PixelTV.Listeners;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.event.bukkit.BukkitPlayerUpdateEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Coded by PixelTeleV
 * 30.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Tablist implements Listener {

    @EventHandler
    public void handleUpdate(BukkitPlayerUpdateEvent e)
    {
        if (Bukkit.getPlayer(e.getCloudPlayer().getUniqueId()) != null && e.getCloudPlayer().getServer() != null && e.getCloudPlayer().getServer().equalsIgnoreCase(CloudAPI.getInstance().getServerId()))
        {
            de.dytanic.cloudnet.bridge.CloudServer.getInstance().updateNameTags(Bukkit.getPlayer(e.getCloudPlayer().getUniqueId()));
        }
    }

}
