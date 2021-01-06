package com.proiectcolectiv.proiect.controllers;

import com.proiectcolectiv.proiect.entities.ProjectsEntity;
import com.proiectcolectiv.proiect.entities.Skill;
import com.proiectcolectiv.proiect.entities.SkillOfUser;
import com.proiectcolectiv.proiect.entities.UserEntity;
import com.proiectcolectiv.proiect.services.EmployeeService;
import com.proiectcolectiv.proiect.services.ProjectService;
import com.proiectcolectiv.proiect.services.SkillService;
import com.proiectcolectiv.proiect.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private SkillService skillService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/get/project", method = RequestMethod.GET)
    public List<ProjectsEntity> findAll() {
        return projectService.findAll();
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/get/skill", method = RequestMethod.GET)
    public List<Skill> findAllSkills() {
        return skillService.findAll();
    }


    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/get/user", method = RequestMethod.GET)
    public UserEntity getUserData(@RequestParam String email) {
        return userService.findOne(email);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/add/skill", method = RequestMethod.POST)
    public SkillOfUser addSkillToUser(@RequestParam Long userId, @RequestParam Long skillId, @RequestParam int grade) {
        return employeeService.saveSkill(userId,skillId,grade);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/add/project", method = RequestMethod.POST)
    public SkillOfUser addProjectToUser(@RequestParam Long userId, @RequestParam Long projectId) {
        return employeeService.saveProject(userId,projectId);
    }
}
