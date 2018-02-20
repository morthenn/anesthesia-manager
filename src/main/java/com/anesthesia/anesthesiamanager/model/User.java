package com.anesthesia.anesthesiamanager.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Data
@Entity
@NoArgsConstructor

public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @NotNull
    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Patient> listOfPatients = new LinkedList<>();

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
