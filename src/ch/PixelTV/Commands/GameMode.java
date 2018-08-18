package ch.PixelTV.Commands;

import ch.PixelTV.Main.Main;
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
public class GameMode implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
            if(p.hasPermission("System.GameMode")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("0")) {
                        p.setGameMode(org.bukkit.GameMode.SURVIVAL);
                        p.sendMessage(Main.pr + "§7Du bist nun im §e" + p.getGameMode() + " §aModus§7!");
                    }

                    if(args[0].equalsIgnoreCase("1")) {
                        p.setGameMode(org.bukkit.GameMode.CREATIVE);
                        p.sendMessage(Main.pr + "§7Du bist nun im §e" + p.getGameMode() + " §aModus§7!");
                    }

                    if(args[0].equalsIgnoreCase("2")) {
                        p.setGameMode(org.bukkit.GameMode.ADVENTURE);
                        p.sendMessage(Main.pr + "§7Du bist nun im §e" + p.getGameMode() + " §aModus§7!");
                    }

                    if(args[0].equalsIgnoreCase("3")) {
                        p.setGameMode(org.bukkit.GameMode.SPECTATOR);
                        p.sendMessage(Main.pr + "§7Du bist nun im §e" + p.getGameMode() + " §aModus§7!");
                    }
                } else if(args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if(p.hasPermission("System.GameMode.others")) {
                        if(p.getName() == target.getName()) {
                            p.sendMessage("§7Um deinen eigenen Spielmodus zu ändern, benutze bitte: §a/gm <0 | 1 | 2 | 3>");
                        } else {
                            if (args[0].equalsIgnoreCase("0")) {
                                target.setGameMode(org.bukkit.GameMode.SURVIVAL);
                                p.sendMessage(Main.pr + "§e" + target.getName() + "§7ist nun im §e" + p.getGameMode() + " §aModus§7!");
                                p.sendMessage(Main.pr + "§7Du bist nun im §e" + p.getGameMode() + " §aModus§7!");
                            }

                            if (args[0].equalsIgnoreCase("1")) {
                                target.setGameMode(org.bukkit.GameMode.CREATIVE);
                                p.sendMessage(Main.pr + "§e" + target.getName() + "§7ist nun im §e" + p.getGameMode() + " §aModus§7!");
                                p.sendMessage(Main.pr + "§7Du bist nun im §e" + p.getGameMode() + " §aModus§7!");
                            }

                            if (args[0].equalsIgnoreCase("2")) {
                                target.setGameMode(org.bukkit.GameMode.ADVENTURE);
                                p.sendMessage(Main.pr + "§e" + target.getName() + "§7ist nun im §e" + p.getGameMode() + " §aModus§7!");
                                p.sendMessage(Main.pr + "§7Du bist nun im §e" + p.getGameMode() + " §aModus§7!");
                            }

                            if (args[0].equalsIgnoreCase("3")) {
                                target.setGameMode(org.bukkit.GameMode.SPECTATOR);
                                p.sendMessage(Main.pr + "§e" + target.getName() + "§7ist nun im §e" + p.getGameMode() + " §aModus§7!");
                                p.sendMessage(Main.pr + "§7Du bist nun im §e" + p.getGameMode() + " §aModus§7!");
                            }
                        }
                    } else {
                        p.sendMessage("§7Du §cdarfst nicht §aden Spielmodus §7von anderen Spielern §aändern§7!");
                    }
                } else {
                    p.sendMessage(Main.syntax + "/gm <0 | 1 | 2 | 3> <Spieler>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        }

        return false;
    }
}
