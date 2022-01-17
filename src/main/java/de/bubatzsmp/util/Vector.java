package de.bubatzsmp.util;

import java.io.Serializable;

import static org.bukkit.util.NumberConversions.square;

public class Vector<T extends Number> implements Serializable {

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

    public double distance(Vector<T> vec) {
        return Math.sqrt(
                square(this.x.doubleValue() - vec.getX().doubleValue()) +
                        square(this.y.doubleValue() - vec.getY().doubleValue()) +
                        square(this.z.doubleValue() - vec.getZ().doubleValue())
        );
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

    @Override
    public Vector<T> clone() {
        try {
            return (Vector<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
