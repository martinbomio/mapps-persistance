package com.mapps.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public Device(){

    }
    public Device(long diHigh,long dirLow,int panId){
        this.dirHigh=dirHigh;
        this.dirLow=dirLow;
        this.panId=panId;
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

}
