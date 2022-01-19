package de.bubatzsmp.util;

import de.bubatzsmp.Bubatz;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Schande {

    public static void sendSchande(Player player, Player target) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', String.format(Bubatz.getBubatz().getConfig().getString("message.schande"), target.getPlayer().getName())));
        target.playSound(target.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 5, 5);
        player.playSound(player.getLocation(), Sound.ENTITY_WITCH_CELEBRATE, 5, 5);
        if (Bubatz.getBubatz().getConfig().get("Schande." + target.getUniqueId()) == null) {
            Bubatz.getBubatz().getConfig().set("Schande." + target.getUniqueId().toString(), 0);
        }
        long schande = Bubatz.getBubatz().getConfig().getLong("Schande." + target.getUniqueId());
        Bubatz.getBubatz().getConfig().set("Schande." + target.getUniqueId().toString(), schande + 1);

        Bubatz.getBubatz().saveConfig();
        Bubatz.getBubatz().reloadConfig();
    }

    public static void sendSchandeFromServer(Player target) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', String.format(Bubatz.getBubatz().getConfig().getString("message.schande"), target.getPlayer().getName())));
        target.playSound(target.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 5, 5);
        if (Bubatz.getBubatz().getConfig().get("Schande." + target.getUniqueId()) == null) {
            Bubatz.getBubatz().getConfig().set("Schande." + target.getUniqueId().toString(), 0);
        }
        long schande = Bubatz.getBubatz().getConfig().getLong("Schande." + target.getUniqueId());
        Bubatz.getBubatz().getConfig().set("Schande." + target.getUniqueId().toString(), schande + 1);

        Bubatz.getBubatz().saveConfig();
        Bubatz.getBubatz().reloadConfig();
    }

}
