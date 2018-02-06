package com.anesthesia.anesthesiamanager.controler;

import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/api/patients/{patientId}")
    public Patient retrievePatientData(@PathVariable String patientId) {
        Long id = Long.parseLong(patientId);
        return patientService.retrieveCourses(id);
    }

//    @GetMapping("/api/patients")
//    public List<Patient> getAllPatients() {
//        return patientService.getPatients();
//    }
}

