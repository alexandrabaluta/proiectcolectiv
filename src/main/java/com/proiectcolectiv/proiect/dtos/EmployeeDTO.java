package com.proiectcolectiv.proiect.dtos;

public class EmployeeDTO {
    private int idEmployee;
    private String email;
    private String password;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int idEmployee, String email, String password) {
        this.idEmployee = idEmployee;
        this.email = email;
        this.password = password;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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
