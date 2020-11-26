package com.proiectcolectiv.proiect.repositories;

import com.proiectcolectiv.proiect.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findEmployeeEntityByEmail(String email);


    List<EmployeeEntity> findAll();

}
