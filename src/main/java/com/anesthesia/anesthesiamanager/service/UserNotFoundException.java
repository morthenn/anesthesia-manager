package com.anesthesia.anesthesiamanager.service;

/**
 * Created by Michal-morthenn on 20/02/2018.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super("could not find user '" + userId + "'.");
    }
}
