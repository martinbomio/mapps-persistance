package com.mapps.model;

import javax.persistence.*;

/**
 * Representation of the Sports of the system
 */
@Entity
@Table(name = "Sports" )
public class Sport {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable=false)
    private String name;

    public Sport(){

    }
    public Sport(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
