package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Alumno;
import com.mycompany.myapp.repository.AlumnoRepository;
import com.mycompany.myapp.service.dto.AlumnoDto;
import com.mycompany.myapp.service.mapper.AlumnoMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    public AlumnoService(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    public List<AlumnoDto> getAllAlumnos() {
        return alumnoMapper.toDtoList(alumnoRepository.findAll());
    }

    public AlumnoDto findAlumnoById(String dni) {
        Alumno alumno = alumnoRepository.findById(dni).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        return alumnoMapper.toDto(alumno);
    }

    public void saveAlumno(AlumnoDto alumnoDTO) {
        Alumno alumno = alumnoMapper.toEntity(alumnoDTO);
        alumnoRepository.save(alumno);
    }
}
