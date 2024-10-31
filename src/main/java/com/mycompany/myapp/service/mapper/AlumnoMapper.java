package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Alumno;
import com.mycompany.myapp.service.dto.AlumnoDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    // Mapea de entidad a DTO
    AlumnoDto toDto(Alumno alumno);

    // Mapea de DTO a entidad
    Alumno toEntity(AlumnoDto AlumnoDto);

    // Mapea una lista de entidades a una lista de DTOs
    List<AlumnoDto> toDtoList(List<Alumno> alumnos);

    // Mapea una lista de DTOs a una lista de entidades
    List<Alumno> toEntityList(List<AlumnoDto> alumnosDto);
}
