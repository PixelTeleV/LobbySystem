package ch.pixeltv.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Items implements Listener {


    public static void gJItems(Player p) {

        ItemStack tp = new ItemStack(Material.COMPASS);
        ItemMeta tpm = tp.getItemMeta();
        tpm.setDisplayName("§bNavigator §8× §7Rechtsklick");
        tp.setItemMeta(tpm);

        ItemStack sv = new ItemStack(Material.BLAZE_ROD);
        ItemMeta svm = sv.getItemMeta();
        svm.setDisplayName("§bSichtbarkeit §8× §7Rechtsklick");
        sv.setItemMeta(svm);

        ItemStack eh = new ItemStack(Material.FISHING_ROD);
        ItemMeta ehm = eh.getItemMeta();
        ehm.setDisplayName("§bEnterhaken §8× §cComing soon");
        eh.setItemMeta(ehm);

        ItemStack kopf = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta kopfm = (SkullMeta) kopf.getItemMeta();
        kopfm.setOwner(p.getName());
        kopfm.setDisplayName("§bFreunde §8× §7Rechtsklick");
        kopf.setItemMeta(kopfm);

        p.getInventory().clear();
        p.getInventory().setItem(0, tp);
        p.getInventory().setItem(1, sv);
        p.getInventory().setItem(7, eh);
        p.getInventory().setItem(8, kopf);

    }

}
