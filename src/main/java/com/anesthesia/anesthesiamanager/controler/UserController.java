package com.anesthesia.anesthesiamanager.controler;

import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@RestController
public class UserController {

    @Autowired
    private
    UserService userService;

    //TODO Fix user being able to watch all patients - not only his

    @RequestMapping(value = "/api/users/", method = RequestMethod.GET)
    public List<User> list() {
        return userService.listUsers();
    }

    @RequestMapping(value = "/api/users/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }


    @GetMapping(value = "/api/users/{userId}/patients")
    public List<Patient> getAllPatients(@PathVariable Long userId) {
        return userService.getUserPatients(userId);
    }
}

