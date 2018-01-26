package com.anesthesia.anesthesiamanager.repository;

import com.anesthesia.anesthesiamanager.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {
}
