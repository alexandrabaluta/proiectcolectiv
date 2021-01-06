package com.proiectcolectiv.proiect.entities;

import javax.persistence.*;
@Entity
@Table(name = "user_project")
public class ProjectOfUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectsEntity project;
}
