package com.mapps.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate.type.EncryptedStringType;

/**
 * Representation of the User of the system
 */
@Entity
@Table(name = "Users" )
@TypeDef(
        name="encryptedString",
        typeClass=EncryptedStringType.class,
        parameters= {
                @Parameter(name="encryptorRegisteredName", value="myHibernateStringEncryptor")
        }
)
public class User extends Person{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    @Type(type="encryptedString")
    private String password;

    public User() {
    }

    public User(String name, String lastName, Date birth, String gender,
                String email, String userName, String password){
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.userName = userName;
        this.password = password;
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
}
