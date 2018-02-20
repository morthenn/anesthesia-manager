package com.anesthesia.anesthesiamanager.service;

import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers() {
        logger.info("Listing users");
        return (List<User>) userRepository.findAll();
    }

    private boolean validateUser(String username) {
        return userRepository.existsByUsername(username) throw new UserNotFoundException(username);
        else return true;
    }

    public List<Patient> getPatients(String username) {
        List<Patient> patientsList = userRepository.findByUsername(username).getListOfPatients();
        patientsList.forEach(patient -> logger.info(patient.toString()));
        return patientsList.stream().sorted(Comparator.comparing(Patient::getId)).collect(Collectors.toList());
    }

    public User findUser(String username) {
        this.validateUser(username);
        logger.info("Looking for username={}", username);
        return userRepository.findByUsername(username);
    }
}
