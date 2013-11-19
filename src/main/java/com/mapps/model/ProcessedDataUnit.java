package com.mapps.model;

import javax.persistence.*;

/**
 * Representation of a processed data unit in the system
 */
@Entity
@Table(name="ProcessedDtaUnits")
public class ProcessedDataUnit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}