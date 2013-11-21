package com.mapps.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representation of the Role of a User in the system.
 */
@Entity
@Table(name = "Roles")
public class Role {
    private RoleType role;

    public enum RoleType {
        ADMINISTRATOR, TRAINER, USER;
    };
    @Id
    @Enumerated(EnumType.ORDINAL)
    public RoleType getRole(){
        return role;
    }

    public void setRole(RoleType role){
        this.role = role;
    }
}
