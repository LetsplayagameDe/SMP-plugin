package de.bubatzsmp.util;

import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.util.*;

public class CopyFile {
    // This Class is Used to move the plugin into the Server plugin's Folder !
    private static final File mavenJar = new File("C:\\Users\\Jonas\\IdeaProjects\\Bubatz\\target\\BubatzRealease-1.0-SNAPSHOT.jar");
    private static final File pluginJar = new File("C:\\Users\\Jonas\\Desktop\\Neuer Ordner (4)\\plugins\\BubatzRealease-1.0-SNAPSHOT.jar");

    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {
        if (!pluginJar.exists() || !mavenJar.exists()) {
            System.out.println("File konnte nicht gefunden werden!");
            throw new IllegalArgumentException();
        }

        try (FileChannel source = new FileInputStream(CopyFile.mavenJar).getChannel();
             FileChannel destination = new FileOutputStream(CopyFile.pluginJar).getChannel()) {

            destination.transferFrom(source, 0, source.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
