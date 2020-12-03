package com.proiectcolectiv.proiect.controllers;

import com.proiectcolectiv.proiect.dtos.ProjectDTO;
import com.proiectcolectiv.proiect.dtos.UserDTO;
import com.proiectcolectiv.proiect.entities.ProjectsEntity;
import com.proiectcolectiv.proiect.entities.UserEntity;
import com.proiectcolectiv.proiect.services.ProjectService;
import com.proiectcolectiv.proiect.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/administrator")
public class AdministratorRestController {

    @Autowired
    private ProjectService projectService;

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<ProjectsEntity> findAll() {
        return projectService.findAll();
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    ProjectsEntity addProject(@RequestBody ProjectDTO projectDTO) {
        ProjectsEntity projectsEntity = new ProjectsEntity();
        projectsEntity.setName(projectDTO.getName());
        projectsEntity.setNameCustomer(projectDTO.getNameCustomer());
        projectsEntity.setStartDate(projectDTO.getStartDate());
        projectsEntity.setDescription(projectDTO.getDescription());
        projectsEntity.setEndDate(projectDTO.getEndDate());

        return projectService.save(projectsEntity);
    }


}
