package com.mapps.model;

import javax.persistence.*;

/**
 * Representation of the Permissions of the system
 */
@Entity
@Table(name = "Permissions" )
public class Permission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable=false)
    private String name;

    public Permission(){

    }
    public Permission(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
