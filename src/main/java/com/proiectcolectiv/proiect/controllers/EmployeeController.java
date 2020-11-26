package com.proiectcolectiv.proiect.controllers;
import com.proiectcolectiv.proiect.entities.EmployeeEntity;
import com.proiectcolectiv.proiect.services.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/users/get", method = RequestMethod.GET)

    public List<EmployeeEntity> findAll() {
        return employeeService.findAll();
    }
}
