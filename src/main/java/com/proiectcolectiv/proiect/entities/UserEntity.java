package com.proiectcolectiv.proiect.entities;

import javax.persistence.*;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "password", nullable = true)
    private String password;


    @Column(name = "email", nullable = true)
    private String email;

    public String getProfilePicType() {
        return profilePicType;
    }

    public void setProfilePicType(String profilePicType) {
        this.profilePicType = profilePicType;
    }

    public String getProfilePicName() {
        return profilePicName;
    }

    public void setProfilePicName(String profilePicName) {
        this.profilePicName = profilePicName;
    }

    public UserEntity(String profilePicName, String profilePicType, byte[] profilePic) {
        this.profilePicName = profilePicName;
        this.profilePicType = profilePicType;
        this.profilePic = profilePic;
    }

    public UserEntity(Long id, String password, String email, byte[] profilePic, Role role) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.profilePic = profilePic;
        this.role = role;
    }

    public UserEntity() {

    }

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    @Column(name = "profilepic", nullable = true)
    private byte[] profilePic;

    @Column(name = "profilepictype", nullable = true)
    private String profilePicType;

    @Column(name = "profilepicname", nullable = true)
    private String profilePicName;
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getId() {
        return id;
    }


    public String getPasswordHash() {
        return password;
    }

    public void setPasswordHash(String passwordHash) {
        this.password = passwordHash;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email.replaceFirst("@.*", "@***") +
                ", password='" + password.substring(0, 10) +
                '}';
    }


}
