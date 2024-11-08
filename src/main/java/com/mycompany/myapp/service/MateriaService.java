package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Materia;
import com.mycompany.myapp.repository.MateriaRepository;
import com.mycompany.myapp.service.dto.MateriaDto;
import com.mycompany.myapp.service.mapper.MateriaMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {

    private final MateriaMapper materiaMapper;
    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaMapper materiaMapper, MateriaRepository materiaRepository) {
        this.materiaMapper = materiaMapper;
        this.materiaRepository = materiaRepository;
    }

    public List<MateriaDto> getAllMaterias() {
        List<Materia> materiaList = materiaRepository.findAll();
        return materiaMapper.toDtoList(materiaList);
    }

    public MateriaDto findMateriaById(Long id) {
        Materia materia = materiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Materia no encontrada"));
        return materiaMapper.toDto(materia);
    }

    public MateriaDto saveMateria(MateriaDto materiaDto) {
        System.out.println("materiaa" + materiaDto);
        Materia materia = materiaMapper.toEntity(materiaDto);
        materia.setNombre(materiaDto.getNombre());
        Materia savedMateria = materiaRepository.save(materia);
        System.out.println("materia guardada " + savedMateria);
        return materiaMapper.toDto(savedMateria);
    }

    public MateriaDto updateMateria(Long id, MateriaDto materiaDto) {
        Materia materia = materiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materia.setNombre(materiaDto.getNombre());

        Materia updatedMateria = materiaRepository.save(materia);
        return materiaMapper.toDto(updatedMateria);
    }

    public void deleteMateria(Long id) {
        if (!materiaRepository.existsById(id)) {
            throw new RuntimeException("Materia no encontrada");
        }
        materiaRepository.deleteById(id);
    }
}
