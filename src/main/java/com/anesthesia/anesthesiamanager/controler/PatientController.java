package com.anesthesia.anesthesiamanager.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@RestController
@RequestMapping("/api/patients/")
public class PatientController {

    private final Logger logger = LoggerFactory.getLogger(PatientController.class);


    @Autowired
    private PatientService patientService;

    @GetMapping("{patientId}")
    public Patient retrievePatientData(@PathVariable String patientId) {
        Long id = Long.parseLong(patientId);
        return patientService.getPatientForUser(id);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    @Transactional
    public ResponseEntity addPatient( @Valid @RequestBody Patient newPatient) {
        UriComponentsBuilder ucBuilder = null;
        logger.info("Creating Patient : {}", newPatient);
        if (patientService.isUserExist(newPatient)) {
            logger.error("Unable to create. A Patient with name {} already exist", newPatient.toString());
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        patientService.addPatient(newPatient);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/patients/{id}").buildAndExpand(newPatient.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);


    }


}

