package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Horario;
import com.mycompany.myapp.domain.Materia;
import com.mycompany.myapp.domain.MesaExamen;
import com.mycompany.myapp.domain.Nota;
import com.mycompany.myapp.service.dto.MateriaDto;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MateriaMapper {
    @Mapping(target = "horariosId", source = "horarios")
    @Mapping(target = "notasId", source = "notas")
    @Mapping(target = "mesasExamenId", source = "mesasExamen")
    MateriaDto toDto(Materia materia);

    @Mapping(target = "horarios", ignore = true) // Se puede mapear manualmente si es necesario
    @Mapping(target = "notas", ignore = true)
    @Mapping(target = "mesasExamen", ignore = true)
    Materia toEntity(MateriaDto materiaDto);

    List<MateriaDto> toDtoList(List<Materia> materias);

    List<Materia> toEntityList(List<MateriaDto> materiaDtos);

    // Métodos personalizados para mapear relaciones
    default List<Long> mapHorarios(Set<Horario> horarios) {
        return horarios
            .stream()
            .map(Horario::getId) // Convierte cada Horario en su ID
            .collect(Collectors.toList());
    }

    default List<Long> mapNotas(Set<Nota> notas) {
        return notas
            .stream()
            .map(Nota::getId) // Convierte cada Nota en su ID
            .collect(Collectors.toList());
    }

    default List<Long> mapMesasExamen(Set<MesaExamen> mesasExamen) {
        return mesasExamen
            .stream()
            .map(MesaExamen::getId) // Convierte cada MesaExamen en su ID
            .collect(Collectors.toList());
    }
}
