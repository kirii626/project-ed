package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Alumno;
import com.mycompany.myapp.domain.Preceptor;
import com.mycompany.myapp.repository.PreceptorRepository;
import com.mycompany.myapp.service.dto.AlumnoDto;
import java.util.List;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = { PreceptorResolver.class })
public interface AlumnoMapper {
    @Mapping(source = "preceptor.dni", target = "preceptorDni")
    AlumnoDto toDto(Alumno alumno);

    @Mapping(source = "preceptorDni", target = "preceptor", qualifiedByName = "preceptorDniToEntity")
    Alumno toEntity(AlumnoDto alumnoDto);

    List<AlumnoDto> toDtoList(List<Alumno> alumnos);
    List<Alumno> toEntityList(List<AlumnoDto> alumnosDto);
}

// Servicio auxiliar para resolver el Preceptor
@Component
class PreceptorResolver {

    private final PreceptorRepository preceptorRepository;

    @Autowired
    public PreceptorResolver(PreceptorRepository preceptorRepository) {
        this.preceptorRepository = preceptorRepository;
    }

    @Named("preceptorDniToEntity")
    public Preceptor map(String preceptorDni) {
        return preceptorRepository
            .findById(preceptorDni)
            .orElseThrow(() -> new RuntimeException("Preceptor not found with dni: " + preceptorDni));
    }
}
