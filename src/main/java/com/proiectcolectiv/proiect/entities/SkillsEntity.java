package com.proiectcolectiv.proiect.entities;

import javax.persistence.*;

@Entity
@Table(name = "skill", schema = "proiectcolectiv")
public class SkillsEntity {

    private int id;
    private String name;

    public SkillsEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SkillsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
