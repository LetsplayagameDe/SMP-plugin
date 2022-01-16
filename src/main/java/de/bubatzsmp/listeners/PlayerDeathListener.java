package de.bubatzsmp.listeners;

import de.bubatzsmp.Bubatz;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        p.sendMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GOLD + "SMP" + ChatColor.DARK_GREEN + "]" + ChatColor.RED + "Death Coordinates: " + p.getLocation().getBlockX() + " " + p.getLocation().getBlockY() + " " + p.getLocation().getBlockZ() + " .");
    }

}
