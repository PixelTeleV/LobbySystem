package ch.PixelTV.Main;

import ch.PixelTV.Commands.Build;
import ch.PixelTV.Commands.Fly;
import ch.PixelTV.Commands.GameMode;
import ch.PixelTV.Listeners.*;
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
        Bukkit.getConsoleSender().sendMessage("§7Licensed for: §aLocal Test Usage");
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§a§lPlugin activated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");

        instance = this;


        //Listeners
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new ch.PixelTV.Listeners.Build(), this);
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

        //Commands
        getCommand("gm").setExecutor(new GameMode());
        getCommand("build").setExecutor(new Build());
        getCommand("fly").setExecutor(new Fly());
    }


    public void onDisable() {
        //Disable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aLobbySystem");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §aBeta 1.0");
        Bukkit.getConsoleSender().sendMessage("§7Licensed for: §aLocal Test Usage");
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§c§lPlugin deactivated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
    }

    public static Main getInstance() {
        return instance;
    }

}
