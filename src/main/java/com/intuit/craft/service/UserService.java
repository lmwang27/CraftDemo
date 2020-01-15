package com.intuit.craft.service;

import com.intuit.craft.dto.UsersDTO;
import com.intuit.craft.entity.Users;
import com.intuit.craft.repository.UsersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * for user register, login
 **/

@Service
@Transactional
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UsersRepo userRepository;

    public Users registerUser(UsersDTO userDTO, String password) {
        if(isExistOrNot(userDTO)){
            log.debug("created new user failed, a user named "+ userDTO.getUsername()+" already existed.");
            return new Users();
        }
        Users newUser = new Users();
        newUser.setUsername(userDTO.getUsername());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPicUrl(userDTO.getPicUrl());
        userRepository.saveAndFlush(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    public Boolean isExistOrNot(UsersDTO usersDTO){
        Optional<Users> user = userRepository.findAllByUsername(usersDTO.getUsername());
        if (user.isPresent()){
            return true;
        }else{
            return false;
        }
    }

    public List<UsersDTO> findAllUsers(){
        List<Users> results = userRepository.findAll();
        ArrayList<UsersDTO> users = new ArrayList<>();
        for(Users user : results){
            UsersDTO u = new UsersDTO();
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            u.setPicUrl(user.getPicUrl());
            users.add(u);
        }
        return users;
    }
}
