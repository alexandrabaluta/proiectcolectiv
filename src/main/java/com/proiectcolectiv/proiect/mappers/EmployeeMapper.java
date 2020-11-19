package com.proiectcolectiv.proiect.mappers;

import com.proiectcolectiv.proiect.dtos.EmployeeDTO;
import com.proiectcolectiv.proiect.entities.EmployeeEntity;

public class EmployeeMapper {
    public static EmployeeEntity mapEmployeeDTOtoEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setIdEmployee(employeeDTO.getIdEmployee());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setPassword(employeeDTO.getPassword());
        return employeeEntity;
    }
    public static EmployeeDTO mapEmployeetoEmployeeDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setIdEmployee(employeeEntity.getIdEmployee());
        employeeDTO.setEmail(employeeEntity.getEmail());
        employeeDTO.setPassword(employeeEntity.getPassword());
        return employeeDTO;
    }
}
