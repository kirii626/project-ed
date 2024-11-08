package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.MesaExamen;
import com.mycompany.myapp.service.dto.MesaExamenDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MesaExamenMapper {
    // Mapea de entidad a DTO
    @Mapping(source = "profesor.dni", target = "profesorDni")
    @Mapping(source = "materia.id", target = "materiaId")
    MesaExamenDto toDto(MesaExamen mesaExamen);

    // Mapea de DTO a entidad
    @Mapping(source = "profesorDni", target = "profesor.dni")
    @Mapping(source = "materiaId", target = "materia.id")
    MesaExamen toEntity(MesaExamenDto mesaExamenDto);

    // Mapea una lista de entidades a una lista de DTOs
    List<MesaExamenDto> toDtoList(List<MesaExamen> mesasExamen);

    // Mapea una lista de DTOs a una lista de entidades
    List<MesaExamen> toEntityList(List<MesaExamenDto> mesasExamenDto);
}
