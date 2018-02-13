package com.anesthesia.anesthesiamanager.repository;

import com.anesthesia.anesthesiamanager.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {

}
