package com.proiectcolectiv.proiect.services;

import com.lowagie.text.DocumentException;
import com.proiectcolectiv.proiect.entities.ProjectsEntity;
import com.proiectcolectiv.proiect.entities.Skill;
import com.proiectcolectiv.proiect.entities.SkillOfUser;
import com.proiectcolectiv.proiect.entities.UserEntity;
import com.proiectcolectiv.proiect.repositories.ProjectRepository;
import com.proiectcolectiv.proiect.repositories.SkillOfUserRepository;
import com.proiectcolectiv.proiect.repositories.SkillRepository;
import com.proiectcolectiv.proiect.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final UserRepository userRepository;
    private final SkillOfUserRepository skillOfUserRepository;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public EmployeeService(UserRepository userRepository, SkillOfUserRepository skillOfUserRepository, SkillRepository skillRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.skillOfUserRepository = skillOfUserRepository;
        this.skillRepository = skillRepository;
        this.projectRepository = projectRepository;
    }



    public SkillOfUser saveProject(Long userId, Long projectId) {
        Optional<UserEntity> optionalUser;
        optionalUser = userRepository.findById(userId);

        Optional<ProjectsEntity> optionalProject;
        optionalProject = projectRepository.findById(projectId);

        if(optionalUser.isEmpty()){
            throw new ServiceException("No such user");
        }
        if(optionalProject.isEmpty()){
            throw new ServiceException("No such project");
        }

        List<ProjectsEntity> projectList = optionalUser.get().getProjects();
        projectList.add(optionalProject.get());
        optionalUser.get().setProjects(projectList);
        userRepository.save(optionalUser.get());
        return null;
    }

    public SkillOfUser saveSkill(Long userId, Long skillId, int grade) {
        Optional<UserEntity> optionalUser;
        optionalUser = userRepository.findById(userId);

        Optional<Skill> optionalSkill;
        optionalSkill = skillRepository.findById(skillId);

        if(optionalUser.isEmpty()){
            throw new ServiceException("No such user");
        }
        if(optionalSkill.isEmpty()){
            throw new ServiceException("No such skill");
        }

        Optional<SkillOfUser> hasUserSkill;
        hasUserSkill = skillOfUserRepository.findSkillOfUserByUserAndSkills(optionalUser.get(),optionalSkill.get());

        if(!hasUserSkill.isEmpty()){
            throw new ServiceException("Skill already exists");
        }else{

            SkillOfUser s = new SkillOfUser();
            s.setUser(optionalUser.get());
            s.setSkill(optionalSkill.get());
            s.setGrade(grade);

            skillOfUserRepository.save(s);
        }

        return null;
    }
}
