package com.proiectcolectiv.proiect.entities;

import javax.persistence.*;

@Entity
@Table(name = "readonlyuser", schema = "proiectcolectiv")
public class ReadonlyuserEntity {
    private int idreadonlyuser;
    private String email;
    private String password;

    @Id
    @Column(name = "IDREADONLYUSER")
    public int getIdReadOnlyUser() {
        return idreadonlyuser;
    }

    public void setIdReadOnlyUser(int idreadonlyuser) {
        this.idreadonlyuser = idreadonlyuser;
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

        ReadonlyuserEntity that = (ReadonlyuserEntity) o;

        if (idreadonlyuser != that.idreadonlyuser) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idreadonlyuser;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
