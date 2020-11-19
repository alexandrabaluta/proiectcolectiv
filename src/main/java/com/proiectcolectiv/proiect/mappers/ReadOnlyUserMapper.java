package com.proiectcolectiv.proiect.mappers;

import com.proiectcolectiv.proiect.dtos.ReadOnlyUserDTO;
import com.proiectcolectiv.proiect.entities.ReadonlyuserEntity;

public class ReadOnlyUserMapper {
    public static ReadonlyuserEntity mapReadOnlyUserDTOtoReadonlyuser(ReadOnlyUserDTO readOnlyUserDTO){
        ReadonlyuserEntity readonlyuserEntity = new ReadonlyuserEntity();
        readonlyuserEntity.setIdReadOnlyUser(readOnlyUserDTO.getIdReadOnlyUser());
        readonlyuserEntity.setEmail(readOnlyUserDTO.getEmail());
        readonlyuserEntity.setPassword(readOnlyUserDTO.getPassword());
        return readonlyuserEntity;
    }
    public static ReadOnlyUserDTO mapReadOnlyUsertoReadonlyuserDTO(ReadonlyuserEntity readonlyuserEntity){
        ReadOnlyUserDTO readOnlyUserDTO=new ReadOnlyUserDTO();
        readOnlyUserDTO.setIdReadOnlyUser(readonlyuserEntity.getIdReadOnlyUser());
        readOnlyUserDTO.setEmail(readonlyuserEntity.getEmail());
        readOnlyUserDTO.setPassword(readonlyuserEntity.getPassword());
        return readOnlyUserDTO;
    }
}
