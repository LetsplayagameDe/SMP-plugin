package de.bubatzsmp.commands;

import de.bubatzsmp.Bubatz;
import de.bubatzsmp.util.Schande;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SchandeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (s instanceof Player p) {
            Player sender = (Player) s;
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    Schande.sendSchande(sender, target);
                }
                else if (target == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', String.format(Bubatz.getBubatz().getConfig().getString("message.unknown_player"))));
                }
            } else
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', String.format(Bubatz.getBubatz().getConfig().getString("message.usage.schande"))));
        }

        return true;
    }
}
