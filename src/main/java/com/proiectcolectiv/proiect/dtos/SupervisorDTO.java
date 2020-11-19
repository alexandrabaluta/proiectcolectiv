package com.proiectcolectiv.proiect.dtos;

public class SupervisorDTO {
    private int idSupervisor;
    private String email;
    private String password;

    public SupervisorDTO(int idSupervisor, String email, String password) {

        this.idSupervisor = idSupervisor;
        this.email = email;
        this.password = password;
    }

    public SupervisorDTO() {

    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
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
