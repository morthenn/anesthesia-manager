package com.anesthesia.anesthesiamanager.service;

import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientForUser(Long patientId) {
        return patientRepository.findOne(patientId);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public boolean isUserExist(Patient patient) {
        return patientRepository.exists(patient.getId());
    }
}
