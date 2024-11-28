package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Alumno;
import com.mycompany.myapp.domain.Materia;
import com.mycompany.myapp.domain.Nota;
import com.mycompany.myapp.service.dto.NotaDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotaMapper {
    // Mapea de entidad a DTO
    @Mapping(source = "valor", target = "valor")
    @Mapping(source = "alumno.dni", target = "alumnoId")
    @Mapping(source = "materia.id", target = "materiaId")
    NotaDto toDto(Nota nota);

    // Mapea de DTO a entidad
    @Mapping(source = "valor", target = "valor")
    @Mapping(target = "alumno", expression = "java(mapAlumno(notaDto.getAlumnoId()))")
    @Mapping(target = "materia", expression = "java(mapMateria(notaDto.getMateriaId()))")
    Nota toEntity(NotaDto notaDto);

    // Mapea una lista de entidades a una lista de DTOs
    List<NotaDto> toDtoList(List<Nota> notas);

    // Mapea una lista de DTOs a una lista de entidades
    List<Nota> toEntityList(List<NotaDto> notaDtos);

    // Métodos auxiliares para convertir IDs a objetos relacionados
    default Alumno mapAlumno(String alumnoId) {
        if (alumnoId == null) {
            return null;
        }
        Alumno alumno = new Alumno();
        alumno.setDni(alumnoId);
        return alumno;
    }

    default Materia mapMateria(Long materiaId) {
        if (materiaId == null) {
            return null;
        }
        Materia materia = new Materia();
        materia.setId(materiaId);
        return materia;
    }
}
