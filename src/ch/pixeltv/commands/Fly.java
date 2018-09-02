package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("fly")) {
            Player p = (Player) sender;
            if (p.hasPermission("System.Fly")) {
                if (args.length == 0) {
                    if (!Main.fly.contains(p)) {
                        Main.fly.add(p);
                        p.sendMessage(Main.pr + "Du §akannst nun §efliegen§7!");
                        p.setAllowFlight(true);
                    } else if (Main.fly.contains(p)) {
                        Main.fly.remove(p);
                        p.setAllowFlight(false);
                        p.sendMessage(Main.pr + "Du §ckannst nun nicht mehr §efliegen§7!");
                    }
                } else if (args.length == 1) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        Player target = Bukkit.getPlayer(args[1]);

                        if (!Main.fly.contains(target)) {
                            Main.fly.add(target);
                            target.setAllowFlight(true);
                            p.sendMessage(Main.pr + "§e" + target.getName() + " §akann nun §efliegen§7!");
                        } else if (Main.fly.contains(target)) {
                            Main.fly.remove(target);
                            target.setAllowFlight(false);
                            p.sendMessage(Main.pr + "§e" + target.getName() + " §ckann nun nicht mehr §efliegen§7!");
                        }
                    } else {
                        p.sendMessage(Main.pr + "§7Der angegebene §eSpieler §cexistiert nicht§7!");
                    }
                } else {
                    p.sendMessage(Main.syntax + "/fly <Spieler>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        }
        return true;
    }

}
