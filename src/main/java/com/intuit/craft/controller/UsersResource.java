package com.intuit.craft.controller;

import com.intuit.craft.dto.UsersDTO;
import com.intuit.craft.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path ="/api")
public class UsersResource {
    private final Logger log = LoggerFactory.getLogger(UsersResource.class);

    @Autowired
    private  UserService userService;

    /**
     * GET /users : get all users.
     *
     * @return the ResponseEntity with status 200 (OK) and with body all users
     */
    @GetMapping(path = "users", produces = "application/json")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        log.debug("to get all the users from the table.");
        List<UsersDTO> users= userService.findAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
