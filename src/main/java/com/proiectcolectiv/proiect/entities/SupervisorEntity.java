package com.proiectcolectiv.proiect.entities;

import javax.persistence.*;

@Entity
@Table(name = "supervisor", schema = "proiectcolectiv")
public class SupervisorEntity {
    private int idsupervisor;
    private String email;
    private String password;

    @Id
    @Column(name = "IDSUPERVISOR")
    public int getIdSupervisor() {
        return idsupervisor;
    }

    public void setIdSupervisor(int idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupervisorEntity that = (SupervisorEntity) o;

        if (idsupervisor != that.idsupervisor) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsupervisor;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
