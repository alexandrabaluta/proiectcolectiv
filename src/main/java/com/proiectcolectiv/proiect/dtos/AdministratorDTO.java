package com.proiectcolectiv.proiect.dtos;

public class AdministratorDTO {
    public AdministratorDTO() {

    }

    public int getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(int idAdministrator) {
        this.idAdministrator = idAdministrator;
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

    private int idAdministrator;
    private String email;
    private String password;

    public AdministratorDTO(int idAdministrator, String email, String password) {
        this.idAdministrator = idAdministrator;
        this.email = email;
        this.password = password;
    }

}
