package com.mapps.model;


import javax.persistence.*;

/**
Representation of the device in the system
 */
@Entity
@Table(name = "Devices" )
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable=false)
    private long dirHigh;
    @Column(nullable=false)
    private long dirLow;
    private int panId;
    @ManyToOne
    private Institution institution;
    private boolean available;

    public Device(){

    }
    public Device(long diHigh, long dirLow, int panId, Institution institution){
        this.institution = institution;
        this.dirHigh=dirHigh;
        this.dirLow=dirLow;
        this.panId=panId;
        this.available = true;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public long getDirHigh(){
        return dirHigh;
    }
    public void setDirHigh(long dirHigh){
        this.dirHigh=dirHigh;
    }
    public long getDirLow(){
        return dirLow;
    }
    public void setDirLow(long dirLow){
        this.dirLow=dirLow;
    }
    public int getPanId(){
        return panId;
    }
    public void setPanId(int panId){
        this.panId=panId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
