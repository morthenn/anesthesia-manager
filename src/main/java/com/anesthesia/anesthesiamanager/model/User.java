package com.anesthesia.anesthesiamanager.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

@Entity
@Table
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Patient> listOfPatients;

    //JPA only - public no arg constructor
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
}
