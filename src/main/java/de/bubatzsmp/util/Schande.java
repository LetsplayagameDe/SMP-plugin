package de.bubatzsmp.util;

import de.bubatzsmp.Bubatz;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Schande {

    public static void sendSchande(Player player, Player target) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', String.format(Bubatz.getBubatz().getConfig().getString("message.schande"), target.getPlayer().getDisplayName())));
        target.playSound(target.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 5, 5);
        player.playSound(player.getLocation(), Sound.ENTITY_WITCH_CELEBRATE, 5, 5);
    }

    public static void sendSchandeFromServer(Player target) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', String.format(Bubatz.getBubatz().getConfig().getString("message.schande"), target.getPlayer().getDisplayName())));
        target.playSound(target.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 5, 5);
    }

}
