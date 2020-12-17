package com.proiectcolectiv.proiect.controllers;

import com.proiectcolectiv.proiect.entities.SkillsEntity;
import com.proiectcolectiv.proiect.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @GetMapping(path= "/skills")
    public ResponseEntity<List<SkillsEntity>> retrieveSkills(){
        try{
            List<SkillsEntity> skills = new ArrayList<>();
            skillRepository.findAll().forEach(skills::add);
            if(skills.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(skills, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @PostMapping(path= "/skills")
    public ResponseEntity<SkillsEntity> saveSkill (@RequestBody SkillsEntity skill) {
        try{
            Random x = new Random();
            SkillsEntity _skill = skillRepository.save(new SkillsEntity(x.nextInt(), skill.getName()));
            return new ResponseEntity<>(_skill, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
   }
}
