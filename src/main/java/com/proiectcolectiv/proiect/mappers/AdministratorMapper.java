package com.proiectcolectiv.proiect.mappers;

import com.proiectcolectiv.proiect.dtos.AdministratorDTO;
import com.proiectcolectiv.proiect.entities.AdministratorEntity;

import java.util.HashSet;
import java.util.Set;

public class AdministratorMapper {
    public static AdministratorEntity mapAdministratorDtoToAdministrator(AdministratorDTO administratorDTO) {
        AdministratorEntity administratorEntity = new AdministratorEntity();
        administratorEntity.setIdAdministrator(administratorDTO.getIdAdministrator());
        administratorEntity.setEmail(administratorDTO.getEmail());
        administratorEntity.setPassword(administratorDTO.getPassword());


        return administratorEntity;
    }

    public static AdministratorDTO mapAdministratorToAdministratorDTO(AdministratorEntity administratorEntity) {
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setIdAdministrator(administratorEntity.getIdAdministrator());
        administratorDTO.setEmail(administratorEntity.getEmail());
        administratorDTO.setPassword(administratorEntity.getPassword());


        return administratorDTO;
    }
}
