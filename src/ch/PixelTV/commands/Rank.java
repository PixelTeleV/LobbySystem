package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.player.PlayerExecutor;
import de.dytanic.cloudnet.lib.player.CloudPlayer;
import de.dytanic.cloudnet.lib.player.permission.GroupEntityData;
import de.dytanic.cloudnet.lib.player.permission.PermissionGroup;
import de.dytanic.cloudnet.lib.player.permission.PermissionPool;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Coded by PixelTeleV
 * 01.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Rank implements CommandExecutor {

    private final boolean permissionService = Bukkit.getPluginManager().isPluginEnabled("CloudNetAPI");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        PermissionGroup permissionGroup = permissionService ? CloudServer.getInstance()
                .getCachedPlayer(p.getPlayer().getUniqueId()).getPermissionEntity().getHighestPermissionGroup(CloudAPI.getInstance().getPermissionPool())
                :
                null;
        PermissionPool permissionPool = CloudAPI.getInstance().getPermissionPool();
        CloudPlayer player = CloudAPI.getInstance().getOnlinePlayer(p.getUniqueId());
        PlayerExecutor playerExecutor = player.getPlayerExecutor();


        //Befehl: /rank prefix <Gruppe> <Prefix>
        //               arg 0   arg 1   arg 2

        //Befehl: /rank set <User> <Gruppe> <Zeit>
        //              arg 0 arg 1  arg 2   arg 3
        if(cmd.getName().equalsIgnoreCase("rank")) {
            if(p.hasPermission("Rank.Admin")) {
                if(args.length == 3) {
                    if (args[0].equalsIgnoreCase("prefix")) {
                        if (permissionPool.getGroups().containsKey(args[1])) {
                            permissionPool.getGroups().get(args[1]);
                            permissionGroup.setPrefix(args[2].replaceAll("&", "§"));
                            CloudAPI.getInstance().updatePermissionGroup(permissionGroup);
                            p.sendMessage(Main.pr + "Du hast den §aPrefix §7der §aGruppe §e" + permissionGroup.getName() + " §7zu §e" + permissionGroup.getPrefix() + " §ageändert§7!");
                        } else {
                            p.sendMessage(Main.pr + "Die angegebene §eGruppe §cexistiert nicht§7!");
                        }
                    } else {
                        p.sendMessage(Main.syntax + "/rank <set | prefix>");
                    }
                } else if(args.length == 4) {
                        if(args[0].equalsIgnoreCase("set")) {
                            if(permissionPool.getGroups().containsKey(args[2])) {
                                player.getPermissionEntity().getGroups().add(new GroupEntityData(args[2], 1L));
                                CloudAPI.getInstance().updatePlayer(player);
                                playerExecutor.kickPlayer(player, Main.pr + "Du hast einen neuen §eRang §aerhalten: §e" + player.getPermissionEntity().getHighestPermissionGroup(permissionPool).getName());
                                p.sendMessage(Main.pr + "Du hast den §eRang §7für §e" + player.getName() + " §7auf §e" + player.getPermissionEntity().getHighestPermissionGroup(permissionPool).getName() + " §agesetzt§7!");
                            } else {
                                p.sendMessage(Main.pr + "Die angegebene §eGruppe §cexistiert nicht§7!");
                            }
                    } else {
                        p.sendMessage(Main.syntax + "/rank <set | prefix>");
                    }
                } else {
                    p.sendMessage(Main.syntax + "/rank <set | prefix>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        }

        return false;
    }

}
