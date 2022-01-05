package de.bubatzsmp.commands;

import de.bubatzsmp.Bubatz;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (s instanceof Player p) {
            double[] coords = new double[]{
                    Bubatz.getBubatz().getConfig().getDouble("spawn.x"),
                    Bubatz.getBubatz().getConfig().getDouble("spawn.y"),
                    Bubatz.getBubatz().getConfig().getDouble("spawn.z")
            };

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Bubatz.getBubatz().getConfig().getString("message.spawn")));

            Bukkit.getScheduler().runTaskLater(Bubatz.getBubatz(), () -> p.teleport(new Location(Bukkit.getWorld("world"), coords[0], coords[1], coords[2])), 100);
        }

        return true;
    }
}
