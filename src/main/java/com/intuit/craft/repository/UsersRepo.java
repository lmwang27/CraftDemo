package com.intuit.craft.repository;

import com.intuit.craft.entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long>{
    //List<Users> findAll();
    Optional<Users> findAllByUsernameAndPassword(String username, String password);
    Optional<Users> findAllByUsername(String username);
    Optional<Users> findAllByEmail(String email);
}
