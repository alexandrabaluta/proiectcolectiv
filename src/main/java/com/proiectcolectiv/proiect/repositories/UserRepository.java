package com.proiectcolectiv.proiect.repositories;

import com.proiectcolectiv.proiect.entities.EmployeeEntity;
import com.proiectcolectiv.proiect.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByUsername(String username);
    Optional<UserEntity> findUserByUsernameOrEmail(String username,String email);
    UserEntity getUserByUsername(String username);
    Optional<UserEntity> findUserEntityByUsername(String username);
    List<UserEntity> findAll();

}
