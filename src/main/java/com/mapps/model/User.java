package com.mapps.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representation of the User of the system
 */
@Entity
@Table(name = "Users" )
public class User extends Person{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @ManyToOne
    private Institution institution;
    @ManyToOne
    private Role role;

    public User() {
    }

    public User(String name, String lastName, Date birth, String gender,
                String email, String userName, String password, Institution institution, Role role){
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.institution = institution;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
