package de.bubatzsmp.util;

import org.bukkit.Location;

import java.io.Serializable;

public class Vector <T extends Number> implements Serializable {

    private final T x;
    private final T y;
    private final T z;

    private float yaw = 0;
    private float pitch = 0;


    public Vector(T x, T y, T z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Vector(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public T getZ() {
        return z;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }
}
