package ch.PixelTV.Commands;

import ch.PixelTV.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Build implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("build")) {
            Player p = (Player) sender;
            if (p.hasPermission("System.Build")) {
                if (args.length == 0) {
                    if (!Main.buildmode.contains(p)) {
                        Main.buildmode.add(p);
                        p.sendMessage(Main.pr + "Du §akannst nun §ebauen§7!");
                        p.setGameMode(GameMode.CREATIVE);
                    } else if (Main.buildmode.contains(p)) {
                        Main.buildmode.remove(p);
                        p.sendMessage(Main.pr + "Du §ckannst nun nicht mehr §ebauen§7!");
                        p.setGameMode(GameMode.SURVIVAL);
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        if (!Main.buildmode.contains(target)) {
                            Main.buildmode.add(target);
                            p.sendMessage(Main.pr + "§e" + target.getName() + " §akann nun §ebauen§7!");
                            target.setGameMode(GameMode.CREATIVE);
                        } else if (Main.buildmode.contains(target)) {
                            Main.buildmode.remove(target);
                            p.sendMessage(Main.pr + "§e" + target.getName() + " §ckann nun nicht mehr §ebauen§7!");
                            target.setGameMode(GameMode.SURVIVAL);
                        }
                    } else {
                        p.sendMessage(Main.pr + "§7Der angegebene §eSpieler §cexistiert nicht§7!");
                    }
                } else {
                    p.sendMessage(Main.syntax + "/build <Spieler>");
                }

            } else {
                p.sendMessage(Main.noperm);
            }
        }
        return true;

    }

}
