package ch.PixelTV.Listeners;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.player.CloudPlayer;
import de.dytanic.cloudnet.lib.player.permission.PermissionGroup;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Coded by PixelTeleV
 * 30.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Chat implements Listener {

    private final boolean permissionService = Bukkit.getPluginManager().isPluginEnabled("CloudNetAPI");

    @EventHandler
    public void handle(AsyncPlayerChatEvent e)
    {
        PermissionGroup permissionGroup = permissionService ? CloudServer.getInstance()
                .getCachedPlayer(e.getPlayer().getUniqueId()).getPermissionEntity().getHighestPermissionGroup(CloudAPI.getInstance().getPermissionPool())
                :
                null;

        if (permissionGroup == null)
        {
            return;
        }

        e.setFormat(permissionGroup.getDisplay() + e.getPlayer() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
    }

}
