package com.mapps.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mapps.interfaces.DataParser;
import com.mapps.utils.Constants;

/**
 * Represent the data unit that works as input for the Kalman Filter. This object
 * contains all the data necessary for a prediction. A concrete Decorator on the
 * decorator pattern.
 */
public class RawDataUnit implements DataParser{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @OneToMany
    private List<IMUData> imuData;
    @OneToMany
    private List<GPSData> gpsData;
    @OneToMany
    private List<PulseData> pulseData;
    @ManyToOne
    private Device device;
    @Column(nullable = false)
    private Long timestamp;
    @Column(nullable = false)
    private boolean readed;
    @Temporal(TemporalType.DATE)
    private Date date;

    public RawDataUnit(List<IMUData> imuData, List<GPSData> gpsData, List<PulseData> pulseData,
                       Device device, Long timestamp, boolean readed, Date date) {
        this.imuData = imuData;
        this.gpsData = gpsData;
        this.pulseData = pulseData;
        this.device = device;
        this.timestamp = timestamp;
        this.readed = readed;
        this.date = date;
    }

    public RawDataUnit() {
    }
    public RawDataUnit(String data) {
        this.populate(data);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<IMUData> getImuData() {
        return imuData;
    }

    public void setImuData(List<IMUData> imuData) {
        this.imuData = imuData;
    }

    public List<GPSData> getGpsData() {
        return gpsData;
    }

    public void setGpsData(List<GPSData> gpsData) {
        this.gpsData = gpsData;
    }

    public List<PulseData> getPulseData() {
        return pulseData;
    }

    public void setPulseData(List<PulseData> pulseData) {
        this.pulseData = pulseData;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void populate(String data) {
        if (data == null){
            throw new IllegalArgumentException();
        }
        String[] separetedData = data.split(",");
        if (separetedData.length >0 ){
            imuData = new ArrayList<IMUData>();
            gpsData = new ArrayList<GPSData>();
            pulseData = new ArrayList<PulseData>();
        }
        for(String d : separetedData){
            String[] sensorData = d.split(":");
            if( sensorData[0].equals(Constants.GPSDELIMETER)){
                GPSData gps = new GPSData(sensorData[1]);
                gpsData.add(gps);
                PulseData pulse = new PulseData(sensorData[2]);
                pulseData.add(pulse);
            }else if( sensorData[0].equals(Constants.IMUDELIMETER)){
                for(int i = 1; i< sensorData.length; i++){
                    IMUData imu = new IMUData(sensorData[i]);
                    imuData.add(imu);
                }
            }
        }
    }
}
