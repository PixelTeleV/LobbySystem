package ch.pixeltv.main;

import ch.pixeltv.commands.Fly;
import ch.pixeltv.commands.GameMode;
import ch.pixeltv.commands.Rank;
import ch.pixeltv.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Main extends JavaPlugin {

    public static ArrayList<Player> buildmode = new ArrayList<>();
    public static ArrayList<Player> fly = new ArrayList<>();
    public static ArrayList<Player> pall = new ArrayList<>();
    public static ArrayList<Player> pnone = new ArrayList<>();

    public static String pr = "§8┃ §eLobby§8» §7";
    public static String noperm = pr + "Du hast §ckeinen Zugriff §7auf diesen Befehl!";
    public static String syntax = pr + "§cSyntax: §a";

    public static Main instance;

    public void onEnable() {
        //Enable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aLobbySystem");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §aBeta 1.0");
        Bukkit.getConsoleSender().sendMessage("§7Licensed for: §aEpicPixelMC.de");
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§a§lPlugin activated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");

        instance = this;


        //listeners
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new Build(), this);
        pm.registerEvents(new Damage(), this);
        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Kick(), this);
        pm.registerEvents(new Quit(), this);
        pm.registerEvents(new Weather(), this);
        pm.registerEvents(new FoodLevel(), this);
        pm.registerEvents(new Drop(), this);
        pm.registerEvents(new PickUp(), this);
        pm.registerEvents(new Enterhaken(), this);
        pm.registerEvents(new Items(), this);
        pm.registerEvents(new Compass(), this);
        pm.registerEvents(new Interact(), this);
        pm.registerEvents(new InvInteract(), this);
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(new Tablist(), this);

        //commands
        getCommand("gm").setExecutor(new GameMode());
        getCommand("build").setExecutor(new ch.pixeltv.commands.Build());
        getCommand("fly").setExecutor(new Fly());
        getCommand("rank").setExecutor(new Rank());
    }


    public void onDisable() {
        //Disable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aLobbySystem");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §aBeta 1.0");
        Bukkit.getConsoleSender().sendMessage("§7Licensed for: §aEpicPixelMC.de");
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§c§lPlugin deactivated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
    }

    public static Main getInstance() {
        return instance;
    }

}
