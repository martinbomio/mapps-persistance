package com.mapps.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Representation of a training in the system
 */
@Entity
@Table(name="Trainings")
public class Training {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private Date date;
    private int participants;
    @Column(nullable=false)
    private long latOrigin;
    @Column(nullable=false)
    private long longOrigin;
    private int minBPM;
    private int maxBPM;
    @Column(nullable=false)
    @ManyToMany
    private Map<Athlete,Device> mapAthleteDevice;
    @Column(nullable=false)
    @OneToMany
    private ArrayList<Report> reports;
    @Column(nullable=false)
    @ManyToOne
    private Sport sport;
    @Column(nullable=false)
    @ManyToMany
    private Map <User,Permission> mapUserPermission;

    public Training(){

    }

    public Training(String name, Date date, int participants, long latOrigin, long longOrigin, int minBPM,
                    int maxBPM, Map<Athlete, Device> mapAthleteDevice, ArrayList<Report> reports, Sport sport,
                    Map<User, Permission> mapUserPermission) {
        this.name = name;
        this.date = date;
        this.participants = participants;
        this.latOrigin = latOrigin;
        this.longOrigin = longOrigin;
        this.minBPM = minBPM;
        this.maxBPM = maxBPM;
        this.mapAthleteDevice = mapAthleteDevice;
        this.reports = reports;
        this.sport = sport;
        this.mapUserPermission = mapUserPermission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public long getLatOrigin() {
        return latOrigin;
    }

    public void setLatOrigin(long latOrigin) {
        this.latOrigin = latOrigin;
    }

    public long getLongOrigin() {
        return longOrigin;
    }

    public void setLongOrigin(long longOrigin) {
        this.longOrigin = longOrigin;
    }

    public int getMinBPM() {
        return minBPM;
    }

    public void setMinBPM(int minBPM) {
        this.minBPM = minBPM;
    }

    public int getMaxBPM() {
        return maxBPM;
    }

    public void setMaxBPM(int maxBPM) {
        this.maxBPM = maxBPM;
    }

    public Map<Athlete, Device> getMapAthleteDevice() {
        return mapAthleteDevice;
    }

    public void setMapAthleteDevice(Map<Athlete, Device> mapAthleteDevice) {
        this.mapAthleteDevice = mapAthleteDevice;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Map<User, Permission> getMapUserPermission() {
        return mapUserPermission;
    }

    public void setMapUserPermission(Map<User, Permission> mapUserPermission) {
        this.mapUserPermission = mapUserPermission;
    }
}
