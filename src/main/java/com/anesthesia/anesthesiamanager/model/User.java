package com.anesthesia.anesthesiamanager.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

@Entity
@Table(name = "Doctor")
public class User {

    @OneToMany(mappedBy = "doctor")
    private Set<Patient> listOfPatients;
}
