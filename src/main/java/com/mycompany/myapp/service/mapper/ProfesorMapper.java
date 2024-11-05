package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Profesor;
import com.mycompany.myapp.service.dto.ProfesorDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {
    ProfesorDto toDto(Profesor profesor);

    Profesor toEntity(ProfesorDto profesorDto);

    List<ProfesorDto> toDtoList(List<Profesor> profesores);

    List<Profesor> toEntityList(List<ProfesorDto> profesoresDto);
}
