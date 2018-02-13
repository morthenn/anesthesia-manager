package com.anesthesia.anesthesiamanager.controler;

import com.anesthesia.anesthesiamanager.model.User;
import com.anesthesia.anesthesiamanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@RestController
public class UserController {

    @Autowired
    private
    UserService userService;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> list(){
        return  userService.listUsers();
    }
}

