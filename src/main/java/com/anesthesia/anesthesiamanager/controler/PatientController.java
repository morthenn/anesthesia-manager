package com.anesthesia.anesthesiamanager.controler;

import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.service.UserNotFoundException;
import com.anesthesia.anesthesiamanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/users/{username}/patients/")
public class PatientController {

    private final Logger logger = LoggerFactory.getLogger(PatientController.class);


    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @GetMapping("{patientId}")
    public Patient retrievePatientData(@PathVariable String username,@PathVariable String patientId) {
        Long id = Long.parseLong(patientId);
        return patientService.getPatientForUser(id);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<?> addPatient(@PathVariable String username, @Valid @RequestBody Patient newPatient) {

        User user = userService.findUser(username);
        logger.info("Creating Patient : {} for user: {}", newPatient, user.getUsername());
        if ( user != null ) {
            newPatient.setUser(user);
            Patient patient = patientService.addPatient(newPatient);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(patient.getId()).toUri();

            return ResponseEntity.created(location).build();
        } else return ResponseEntity.noContent().build();
    }

}

