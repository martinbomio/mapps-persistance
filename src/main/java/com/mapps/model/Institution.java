package com.mapps.model;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate.type.EncryptedStringType;

import javax.persistence.*;
import java.util.Date;

/**
 * Representation of the Institution of the system
 */
@Entity
@Table(name = "Institutions" )


public class Institution {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable=false)
    private String name;
    private String description;

    public Institution(){

    }
    public Institution(String name, String description){
        this.name = name;
        this.description = description;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
          this.name=name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

}
