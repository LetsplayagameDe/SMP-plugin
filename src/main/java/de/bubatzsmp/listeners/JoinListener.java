package de.bubatzsmp.listeners;

import de.bubatzsmp.Bubatz;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class JoinListener implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(String.format(ChatColor.translateAlternateColorCodes('&', Bubatz.getBubatz().getConfig().getString("message.joinmessage")), e.getPlayer().getName()));
    }

    @EventHandler
    private void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage(String.format(ChatColor.translateAlternateColorCodes('&', Bubatz.getBubatz().getConfig().getString("message.quitmessage")), e.getPlayer().getName()));
    }

}
