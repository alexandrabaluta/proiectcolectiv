package com.proiectcolectiv.proiect.mappers;


import com.proiectcolectiv.proiect.dtos.SupervisorDTO;

import com.proiectcolectiv.proiect.entities.SupervisorEntity;

public class SupervisorMapper {
    public static SupervisorEntity mapSupervisorDtoToSupervisor(SupervisorDTO supervisorDTO) {
        SupervisorEntity supervisorEntity = new SupervisorEntity();
        supervisorEntity.setIdSupervisor(supervisorDTO.getIdSupervisor());
        supervisorEntity.setEmail(supervisorDTO.getEmail());
        supervisorEntity.setPassword(supervisorDTO.getPassword());
        return supervisorEntity;
    }

    public static SupervisorDTO mapSupervisorToSupervisorDTO(SupervisorEntity supervisorEntity) {
        SupervisorDTO supervisorDTO = new SupervisorDTO();
        supervisorDTO.setIdSupervisor(supervisorEntity.getIdSupervisor());
        supervisorDTO.setEmail(supervisorEntity.getEmail());
        supervisorDTO.setPassword(supervisorEntity.getPassword());
        return supervisorDTO;
    }
}
