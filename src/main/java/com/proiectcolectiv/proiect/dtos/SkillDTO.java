package com.proiectcolectiv.proiect.dtos;

import com.sun.istack.NotNull;

public class SkillDTO {
    private int id;
    private String skill;

    public SkillDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
