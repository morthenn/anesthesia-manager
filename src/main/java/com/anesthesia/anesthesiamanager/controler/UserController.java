package com.anesthesia.anesthesiamanager.controler;

import com.anesthesia.anesthesiamanager.model.Patient;
import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.service.PatientService;
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

    @RequestMapping(value = "/api/users/", method = RequestMethod.GET)
    public List<User> list() {
        return userService.listUsers();
    }

    @RequestMapping(value = "/api/users/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) {
        return userService.findUser(username);
    }


    @GetMapping(value = "/api/users/{username}/patients")
    public List<Patient> getAllPatients(@PathVariable String username) {
        return userService.getPatients(username);
    }
}

