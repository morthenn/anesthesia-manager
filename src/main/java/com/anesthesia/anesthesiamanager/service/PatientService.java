package com.anesthesia.anesthesiamanager.service;

import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Service
public class PatientService {
    @Autowired
    private
    PatientRepository patientRepository;

    public Patient retrieveCourses(Long studentId) {
        return patientRepository.findOne(studentId);
    }

//    public List<Patient> getPatients() {
//       return Comparator comparator = Comparator.comparing(::getId);
//        list.sort(comparator));
//    }
}
