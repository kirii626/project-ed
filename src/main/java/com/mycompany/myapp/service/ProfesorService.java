package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Profesor;
import com.mycompany.myapp.repository.ProfesorRepository;
import com.mycompany.myapp.service.dto.ProfesorDto;
import com.mycompany.myapp.service.mapper.ProfesorMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    public ProfesorService(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
    }

    public List<ProfesorDto> getAllProfesores() {
        List<Profesor> profesores = profesorRepository.findAll();
        return profesorMapper.toDtoList(profesores);
    }

    public ProfesorDto findProfesorById(String dni) {
        Profesor profesor = profesorRepository.findById(dni).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        return profesorMapper.toDto(profesor);
    }

    public ProfesorDto saveProfesor(ProfesorDto profesorDto) {
        Profesor profesor = profesorMapper.toEntity(profesorDto);
        Profesor savedProfesor = profesorRepository.save(profesor);
        return profesorMapper.toDto(savedProfesor);
    }

    public ProfesorDto updateProfesor(String dni, ProfesorDto profesorDto) {
        Profesor existingProfesor = profesorRepository.findById(dni).orElseThrow(() -> new RuntimeException("Profesor encontrado"));

        existingProfesor.setNombre(profesorDto.getNombre());
        existingProfesor.setApellido(profesorDto.getApellido());
        existingProfesor.setEmail(profesorDto.getEmail());

        Profesor updatedProfesor = profesorRepository.save(existingProfesor);
        return profesorMapper.toDto(updatedProfesor);
    }

    public void deleteProfesor(String dni) {
        if (!profesorRepository.existsById(dni)) {
            throw new RuntimeException("Profesor no encontrado");
        }
        profesorRepository.deleteById(dni);
    }
}
