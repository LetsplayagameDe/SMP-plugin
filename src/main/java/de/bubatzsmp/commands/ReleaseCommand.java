package de.bubatzsmp.commands;

import de.bubatzsmp.Bubatz;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class ReleaseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (s.hasPermission("bubatz.realease")) {
            Bukkit.getWorld("world").getWorldBorder().setSize(7500);
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Bubatz.getBubatz().getConfig().getString("message.release")));

            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, 1);

                Bukkit.getScheduler().runTaskLater(Bubatz.getBubatz(), () -> {
                    p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_SHOOT, 1, 1);
                    p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE_FAR, 1, 1);
                    p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR, 1, 1);
                    p.setHealth(20);
                }, 10L);

                p.spawnParticle(Particle.TOTEM, p.getLocation(), 100);
                p.sendTitle(ChatColor.translateAlternateColorCodes('&', Bubatz.getBubatz().getConfig().getString("message.title")), "");
            }
        }

        return true;
    }

}
