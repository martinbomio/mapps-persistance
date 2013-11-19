package com.mapps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mapps.interfaces.DataParser;

/**
 * Representation of the data packet from de IMU sensor. Concrete component on a likewise
 * decorator pattern.
 */
@Entity
@Table(name = "IMUData")
public class IMUData implements DataParser{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private int accelX;
    @Column(nullable = false)
    private int accelY;
    @Column(nullable = false)
    private int accelZ;
    @Column(nullable = false)
    private int yaw;
    @Column(nullable = false)
    private int pitch;
    @Column(nullable = false)
    private int roll;

    public IMUData() {
    }

    public IMUData(int accelX, int accelY, int accelZ, int yaw, int pitch, int roll) {
        this.accelX = accelX;
        this.accelY = accelY;
        this.accelZ = accelZ;
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccelX() {
        return accelX;
    }

    public void setAccelX(int accelX) {
        this.accelX = accelX;
    }

    public int getAccelY() {
        return accelY;
    }

    public void setAccelY(int accelY) {
        this.accelY = accelY;
    }

    public int getAccelZ() {
        return accelZ;
    }

    public void setAccelZ(int accelZ) {
        this.accelZ = accelZ;
    }

    public int getYaw() {
        return yaw;
    }

    public void setYaw(int yaw) {
        this.yaw = yaw;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public void populate(String data) {
    //TODO:implement populate on IMUDATA
    }
}
