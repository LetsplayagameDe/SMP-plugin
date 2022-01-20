package de.bubatzsmp.commands;

import de.bubatzsmp.Bubatz;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player player) {
            Bukkit.getScheduler().runTaskLater(Bubatz.getBubatz(), () -> player.teleport(player.getBedSpawnLocation()), 100);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',Bubatz.getBubatz().getConfig().getString("message.bed")));
        } else {
            sender.sendMessage("Only players.");
        }
        return false;
    }
}
