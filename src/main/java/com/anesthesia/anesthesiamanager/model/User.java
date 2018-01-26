package com.anesthesia.anesthesiamanager.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

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

    private LinkedHashSet<Patient> listOfPatients;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
//        this.listOfPatients=new LinkedHashSet<Patient>();
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public LinkedHashSet<Patient> getListOfPatients() {
        return listOfPatients;
    }
}
