package com.anesthesia.anesthesiamanager.controler;

import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.service.UserNotFoundException;
import com.anesthesia.anesthesiamanager.service.UserService;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@RestController
@lombok.extern.slf4j.Slf4j
@RequestMapping("/api/users/{userId}/patients/")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @GetMapping("{patientId}")
    public Patient retrievePatientData(@PathVariable String userId,
                                       @PathVariable Long patientId) {
        return patientService.getPatientForUser(patientId);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<Patient> addPatient(@PathVariable Long userId,
                                              @Valid @RequestBody Patient newPatient) {
        log.info("Creating Patient : {} for user: {}", newPatient, userId);
        Patient patient = patientService.addPatient(newPatient,userId);
        if (patient!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(newPatient);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("{patientId}")
    @Transactional
    public ResponseEntity<Patient> updatePatient(@PathVariable Long userId,
                                              @PathVariable Long patientId,
                                              @Valid @RequestBody Patient patientUpdateBody) {
        log.info("Updating patient id : {}, with patient data : {} for user: {}", patientId, patientUpdateBody, userId);
        patientService.updatePatient(userId,patientId,patientUpdateBody);
        return ResponseEntity.status(HttpStatus.OK).body(patientUpdateBody);

    }
}

