package com.anesthesia.anesthesiamanager.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

@Entity
@Table(name = "DOCTORS")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Min(5)
    @Max(25)
    private String username;

    @NotNull
    @Min(5)
    @Max(25)
    private String password;

    @OneToMany(mappedBy = "doctor")
    private Set<Patient> listOfPatients;
}
