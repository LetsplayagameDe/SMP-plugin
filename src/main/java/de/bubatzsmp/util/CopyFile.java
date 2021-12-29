package de.bubatzsmp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFile {
    // This Class is Used to move the plugin into the Server plugin's Folder !
    private static final File mavenbuild = new File("C:\\Users\\Jonas\\IdeaProjects\\Bubatz\\target\\BubatzRealease-1.0-SNAPSHOT.jar");
    private static final File serverplugin = new File("C:\\Users\\Jonas\\Desktop\\Neuer Ordner (4)\\plugins\\BubatzRealease-1.0-SNAPSHOT.jar");

    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {
        if (!serverplugin.exists() || !mavenbuild.exists()) {
            System.out.println("File konnte nicht gefunden werden!");
            throw new IllegalArgumentException();
        }

        try (FileChannel source = new FileInputStream(CopyFile.mavenbuild).getChannel();
             FileChannel destination = new FileOutputStream(CopyFile.serverplugin).getChannel()) {

            destination.transferFrom(source, 0, source.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
