package ch.pixeltv.listeners;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.player.permission.PermissionGroup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        PermissionGroup permissionGroup = permissionService ? CloudServer.getInstance()
                .getCachedPlayer(e.getPlayer().getUniqueId()).getPermissionEntity().getHighestPermissionGroup(CloudAPI.getInstance().getPermissionPool())
                :
                null;

        if (permissionGroup == null) {
            return;
        }

        // e.setFormat(permissionGroup.getPrefix() + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));

        if (p.hasPermission("Rank.Admin")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §4" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else if (p.hasPermission("Rank.Developer")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §b" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else if (p.hasPermission("Rank.SrModerator")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §c" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else if (p.hasPermission("Rank.Moderator")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §c" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else if (p.hasPermission("Rank.Builder")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §9" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else if (p.hasPermission("Rank.Supporter")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §3" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else if (p.hasPermission("Rank.YouTuber")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §5" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else if (p.hasPermission("Rank.PremiumPlus")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §e" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else if (p.hasPermission("Rank.Premium")) {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §6" + e.getPlayer().getName() + "§8» §7" + e.getMessage().replaceAll("§", "&"));
        } else {
            e.setFormat(permissionGroup.getPrefix() + " §8┃ §a" + e.getPlayer().getName() + "§8» §7" + e.getMessage());
        }
    }
}
