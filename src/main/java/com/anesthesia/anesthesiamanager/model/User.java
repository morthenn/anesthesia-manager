package com.anesthesia.anesthesiamanager.model;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

@Entity
@Table(name = "Doctor")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Patient> listOfPatients;
}
