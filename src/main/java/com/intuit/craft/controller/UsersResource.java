package com.intuit.craft.controller;

import com.intuit.craft.dto.ProfileDTO;
import com.intuit.craft.dto.UsersDTO;
import com.intuit.craft.entity.Users;
import com.intuit.craft.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<ProfileDTO>> getAllUsers() {
        log.debug("to get all the users from the table.");
        List<ProfileDTO> users= userService.findAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping(path = "users/profile", produces = "application/json")
    public ResponseEntity<ProfileDTO> findByUserName( @RequestParam String username) {
        log.debug("to get   users from users table by username.");
        ProfileDTO users= userService.findByUserName(username);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping(path = "users", produces = "application/json")
    public ResponseEntity registerUser(@RequestBody UsersDTO usersDTO) {
            Users newUser = userService.registerUser(usersDTO);
            return new ResponseEntity(newUser, HttpStatus.OK);
        }
    }
