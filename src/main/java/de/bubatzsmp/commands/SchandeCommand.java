package de.bubatzsmp.commands;

import de.bubatzsmp.Bubatz;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SchandeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (s instanceof Player p) {
            if (args.length == 1) {
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

                if (target != null) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', String.format(Bubatz.getBubatz().getConfig().getString("message.schande"), target.getName())));

                } else
                    p.sendMessage(ChatColor.RED + "Spieler exestiert nicht welche schande");
            } else
                p.sendMessage(ChatColor.RED + "Benutzung: /schande <Spieler>");
        }

        return true;
    }
}
