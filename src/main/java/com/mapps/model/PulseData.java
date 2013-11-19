package com.mapps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mapps.interfaces.DataParser;

/**
 * Representation of a data packet from the Heart Rate Monitor. Concrete component on a likewise
 * decorator pattern.
 */
@Entity
@Table(name = "PulseData")
public class PulseData implements DataParser{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    private int BPM;

    public PulseData() {
    }

    public PulseData(int BPM) {
        this.BPM = BPM;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBPM() {
        return BPM;
    }

    public void setBPM(int BPM) {
        this.BPM = BPM;
    }

    @Override
    public void populate(String data) {
        //TODO: implmenet populate on PulseData
    }
}
