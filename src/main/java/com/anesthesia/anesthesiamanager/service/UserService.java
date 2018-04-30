package com.anesthesia.anesthesiamanager.service;

import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers() {
        log.info("Listing users");
        return (List<User>) userRepository.findAll();
    }

    public List<Patient> getUserPatients(Long userid) {
        List<Patient> patientsList =findUserById(userid).getListOfPatients();
        return patientsList.stream().sorted(Comparator.comparing(Patient::getId)).collect(Collectors.toList());
    }

    public List<User> findUser(String username) {
        log.info("Looking for username={}", username);
        return userRepository.findByUsername(username);
    }


    public User findUserById(Long userId) {
        return userRepository.findOne(userId);
    }
}
