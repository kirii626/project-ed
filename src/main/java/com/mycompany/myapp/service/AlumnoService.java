package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Alumno;
import com.mycompany.myapp.domain.Preceptor;
import com.mycompany.myapp.repository.AlumnoRepository;
import com.mycompany.myapp.repository.PreceptorRepository;
import com.mycompany.myapp.service.dto.AlumnoDto;
import com.mycompany.myapp.service.mapper.AlumnoMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final PreceptorRepository preceptorRepository;
    private final AlumnoMapper alumnoMapper;

    public AlumnoService(AlumnoRepository alumnoRepository, PreceptorRepository preceptorRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.preceptorRepository = preceptorRepository;
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

    @Transactional
    public AlumnoDto updateAlumno(String dni, AlumnoDto alumnoDto) {
        Alumno existingAlumno = alumnoRepository.findById(dni).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        existingAlumno.setNombre(alumnoDto.getNombre());
        existingAlumno.setApellido(alumnoDto.getApellido());
        existingAlumno.setEmail(alumnoDto.getEmail());

        if (alumnoDto.getPreceptorDni() != null) {
            Preceptor preceptor = preceptorRepository
                .findById(alumnoDto.getPreceptorDni())
                .orElseThrow(() -> new RuntimeException("Preceptor no encontrado"));
            existingAlumno.setPreceptor(preceptor);
        }

        alumnoRepository.save(existingAlumno);

        return alumnoMapper.toDto(existingAlumno);
    }

    public void deleteAlumno(String dni) {
        if (alumnoRepository.existsById(dni)) {
            alumnoRepository.deleteById(dni);
        } else {
            throw new RuntimeException("Alumno no encontrado");
        }
    }
}
