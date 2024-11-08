package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Horario;
import com.mycompany.myapp.service.dto.HorarioDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HorarioMapper {
    // Mapea de entidad a DTO
    @Mapping(source = "materia.id", target = "materiaId")
    @Mapping(source = "profesor.dni", target = "profesorDni")
    HorarioDto toDto(Horario horario);

    // Mapea de DTO a entidad
    @Mapping(source = "materiaId", target = "materia.id")
    @Mapping(source = "profesorDni", target = "profesor.dni")
    Horario toEntity(HorarioDto horarioDto);

    // Mapea una lista de entidades a una lista de DTOs
    List<HorarioDto> toDtoList(List<Horario> horarios);

    // Mapea una lista de DTOs a una lista de entidades
    List<Horario> toEntityList(List<HorarioDto> horarioDtos);
}
