package com.anesthesia.anesthesiamanager.service;

import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.repository.PatientRepository;
import com.anesthesia.anesthesiamanager.repository.UserRepository;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    public Patient getPatientForUser(Long patientId) {
        return patientRepository.findOne(patientId);
    }

    public Patient addPatient(Patient patient, Long userId) {
        if (!patientRepository.exists(patient.getId())) {
            User user = userRepository.findOne(userId);
            patient.setUser(user);
            patientRepository.save(patient);
            return patient;
        }
        return null;
    }

    public Patient updatePatient(Long userId,Long patientId, Patient patientUpdateBody) {
        Patient existingPatient = patientRepository.findOne(patientId);
        if (existingPatient == null) return null;
        patientUpdateBody.setId(patientId);
        patientUpdateBody.setUser(existingPatient.getUser());
        patientRepository.save(patientUpdateBody);
        return patientUpdateBody;
    }
}
