package de.bubatzsmp.listeners;

import de.bubatzsmp.Bubatz;
import org.bukkit.ChatColor;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class JoinListener implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(String.format(ChatColor.translateAlternateColorCodes('&', Bubatz.getBubatz().getConfig().getString("message.joinmessage")), e.getPlayer().getDisplayName()));
    }

    @EventHandler
    private void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage(String.format(ChatColor.translateAlternateColorCodes('&', Bubatz.getBubatz().getConfig().getString("message.quitmessage")), e.getPlayer().getDisplayName()));
    }

    @EventHandler
    private void onSpawn(EntitySpawnEvent e) {
        if (e.getEntity() instanceof ElderGuardian bob) {
            bob.setCustomName(ChatColor.GREEN + "Bob");
            bob.setCustomNameVisible(true);
        }
    }
}
