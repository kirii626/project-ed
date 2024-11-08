package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Falta;
import com.mycompany.myapp.service.dto.FaltaDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FaltaMapper {
    @Mapping(source = "alumno.dni", target = "alumnoDni") // Mapea el dni del alumno
    FaltaDto toDto(Falta falta);

    // Mapea de DTO a entidad
    @Mapping(source = "alumnoDni", target = "alumno.dni") // Mapea el dni del alumno
    Falta toEntity(FaltaDto faltaDto);

    // Mapea una lista de entidades a una lista de DTOs
    List<FaltaDto> toDtoList(List<Falta> faltas);

    // Mapea una lista de DTOs a una lista de entidades
    List<Falta> toEntityList(List<FaltaDto> faltaDtos);
}
