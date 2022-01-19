package de.bubatzsmp;

import de.bubatzsmp.commands.ReleaseCommand;
import de.bubatzsmp.commands.SchandeCommand;
import de.bubatzsmp.commands.SpawnCommand;
import de.bubatzsmp.listeners.JoinListener;
import de.bubatzsmp.listeners.PlayerDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bubatz extends JavaPlugin {

    private static Bubatz main;

    public static Bubatz getBubatz() {
        return main;
    }

    @Override
    public void onEnable() {
        saveConfig();
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);

        getCommand("release").setExecutor(new ReleaseCommand());
        getCommand("schande").setExecutor(new SchandeCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());

        main = this;

        if (!getConfig().contains("message.joinmessage")) {
            getConfig().set("message.joinmessage", "&2%s ist BubatzSMP gejoint!");
            getConfig().set("message.quitmessage", "&c%s ist BubatzSMP gelaved!");
            getConfig().set("message.release", "&bBubatz SMP wurde Released!");
            getConfig().set("message.title", "&4Bubatz SMP Realeased!");
            getConfig().set("message.schande", "&2[&6SMP&2] &cSchande&2 geht raus an &c%S");
            getConfig().set("message.spawn", "&2[&6SMP&2] Du wirst in 5 sekunden Teleportiert!");
            getConfig().set("message.unknown_player", "&cSpieler exestiert nicht welche schande");
            getConfig().set("message.usage.schande", "&cBenutzung: /schande <Spieler>");
            getConfig().set("message.death", "&2[&6SMP&2] &cDeath Coordinates: %s");
            getConfig().set("spawn.x", 0.0);
            getConfig().set("spawn.y", 0.0);
            getConfig().set("spawn.z", 0.0);

            saveConfig();
            reloadConfig();
        }
    }

}
