package com.anesthesia.anesthesiamanager.service;

import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Service
public class UserService {
    @Autowired
    private
    UserRepository userRepository;

    public List<User> listUsers() {
        return (List<User>) userRepository.findAll();
    }
}
