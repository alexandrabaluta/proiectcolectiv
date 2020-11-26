package com.proiectcolectiv.proiect.services;

import com.proiectcolectiv.proiect.entities.EmployeeEntity;
import com.proiectcolectiv.proiect.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }


}
