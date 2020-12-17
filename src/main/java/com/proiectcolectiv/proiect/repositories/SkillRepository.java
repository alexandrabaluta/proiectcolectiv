package com.proiectcolectiv.proiect.repositories;

import com.proiectcolectiv.proiect.entities.ProjectsEntity;
import com.proiectcolectiv.proiect.entities.SkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<SkillsEntity, Long> {
    public List<SkillsEntity> findAll();
}
