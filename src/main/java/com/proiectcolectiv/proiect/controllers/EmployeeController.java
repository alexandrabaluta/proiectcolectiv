package com.proiectcolectiv.proiect.controllers;

import com.lowagie.text.DocumentException;
import com.proiectcolectiv.proiect.entities.*;
import com.proiectcolectiv.proiect.services.EmployeeService;
import com.proiectcolectiv.proiect.services.ProjectService;
import com.proiectcolectiv.proiect.services.SkillService;
import com.proiectcolectiv.proiect.services.UserService;
import io.swagger.annotations.Api;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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

    @RequestMapping(value = "/pdfreport/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfReport(@PathVariable("id") Long id) throws IOException, DocumentException {

        UserEntity userEntity = userService.findById(id).get();
        ByteArrayInputStream bis = GeneratePdfReport.employeeReport(userEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
