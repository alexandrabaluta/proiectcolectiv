package com.proiectcolectiv.proiect.services;

import com.proiectcolectiv.proiect.entities.Skill;
import com.proiectcolectiv.proiect.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class SkillService {

    private final SkillRepository skillRepository;


    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Skill save(Skill skill) {
        Optional<Skill> optionalSkill;

        optionalSkill = skillRepository.findSkillBySkill(skill.getSkill());

        Skill p1 =  optionalSkill.isPresent() ? null : skillRepository.save(skill);

        return ofNullable(p1)
                .orElseThrow(() -> new EntityExistsException("Skill already exist: " + skill.getSkill()));
    }

}
