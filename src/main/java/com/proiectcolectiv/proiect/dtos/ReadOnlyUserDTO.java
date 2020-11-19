package com.proiectcolectiv.proiect.dtos;

public class ReadOnlyUserDTO {
    private int idReadOnlyUser;
    private String email;
    private String password;

    public ReadOnlyUserDTO() {
    }

    public ReadOnlyUserDTO(int idReadOnlyUser, String email, String password) {
        this.idReadOnlyUser = idReadOnlyUser;
        this.email = email;
        this.password = password;
    }

    public int getIdReadOnlyUser() {
        return idReadOnlyUser;
    }

    public void setIdReadOnlyUser(int idReadOnlyUser) {
        this.idReadOnlyUser = idReadOnlyUser;
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
}
