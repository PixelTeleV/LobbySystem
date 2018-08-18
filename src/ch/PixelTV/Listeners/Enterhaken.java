package ch.PixelTV.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Enterhaken implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onFish(PlayerFishEvent event) {
        Player p = event.getPlayer();
        Fish h = event.getHook();
        if (((event.getState() == PlayerFishEvent.State.IN_GROUND)
                || (event.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY))
                || (event.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT)))
                && (Bukkit
                .getWorld(event.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(),
                        h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ())
                .getType() != Material.AIR)) {
            Location lc = p.getLocation();
            Location to = event.getHook().getLocation();

            lc.setY(lc.getY() + 0.5D);
            p.teleport(lc);
            p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);

            double g = -0.08D;
            double d = to.distance(lc);
            double t = d;
            double v_x = (1.0D + 0.07D * t) * (to.getX() - lc.getX()) / t;
            double v_y = (1.0D + 0.03D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
            double v_z = (1.0D + 0.07D * t) * (to.getZ() - lc.getZ()) / t;

            Vector v = p.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            p.setVelocity(v);
        }
    }

}
