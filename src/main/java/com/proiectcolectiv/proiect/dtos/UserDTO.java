package com.proiectcolectiv.proiect.dtos;

import com.proiectcolectiv.proiect.entities.Role;
import com.proiectcolectiv.proiect.entities.UserEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

public class UserDTO {
    private String email;
    private String password;
    private Role role;

    public UserDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
