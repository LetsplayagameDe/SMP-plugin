package de.bubatzsmp.listeners;

import de.bubatzsmp.Bubatz;
import de.bubatzsmp.util.Schande;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = e.getEntity().getPlayer();
            p.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', Bubatz.getBubatz().getConfig().getString("message.death")), p.getLocation().getBlockX() + " " + p.getLocation().getBlockY() + " " + p.getLocation().getBlockZ()));
            Schande.sendSchandeFromServer(p);
        }

    }

}
