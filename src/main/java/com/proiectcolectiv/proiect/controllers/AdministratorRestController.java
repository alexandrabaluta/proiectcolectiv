package com.proiectcolectiv.proiect.controllers;

import com.proiectcolectiv.proiect.dtos.ProjectDTO;
import com.proiectcolectiv.proiect.dtos.UserDTO;
import com.proiectcolectiv.proiect.entities.ProjectsEntity;
import com.proiectcolectiv.proiect.entities.UserEntity;
import com.proiectcolectiv.proiect.services.AdministratorService;
import com.proiectcolectiv.proiect.services.ProjectService;
import com.proiectcolectiv.proiect.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequestMapping("/administrator")
public class AdministratorRestController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AdministratorService administratorService;

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<ProjectsEntity> findAll() {
        return projectService.findAll();
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
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

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody
    UserEntity addUser(@RequestBody UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setEmail(userDTO.getEmail());
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPasswordHash(encryptedPassword);
        user.setRole(userDTO.getRole());
        user.setProfilePic(null);
        user.setProfilePicName("");
        user.setProfilePicType("");

        return administratorService.save(user);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public @ResponseBody
    UserEntity updateUser(@RequestBody UserDTO userDTO) {
        Optional<UserEntity> user = administratorService.findUserByEmail(userDTO.getEmail());
        if(user.isPresent()) {
            UserEntity user1=user.get();
            String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
            user1.setPasswordHash(encryptedPassword);
            user1.setRole(userDTO.getRole());
            user1.setProfilePic(null);
            user1.setProfilePicName("");
            user1.setProfilePicType("");
            return administratorService.update(user1);
        }
        return null;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder2() {
        return new BCryptPasswordEncoder();
    }

}
