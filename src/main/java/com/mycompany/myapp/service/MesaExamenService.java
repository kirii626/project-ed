package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.MesaExamen;
import com.mycompany.myapp.repository.MesaExamenRepository;
import com.mycompany.myapp.service.dto.MesaExamenDto;
import com.mycompany.myapp.service.mapper.MesaExamenMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesaExamenService {

    private final MesaExamenRepository mesaExamenRepository;
    private final MesaExamenMapper mesaExamenMapper;

    public MesaExamenService(MesaExamenRepository mesaExamenRepository, MesaExamenMapper mesaExamenMapper) {
        this.mesaExamenRepository = mesaExamenRepository;
        this.mesaExamenMapper = mesaExamenMapper;
    }

    public List<MesaExamenDto> getAllMesasExamen() {
        List<MesaExamen> mesasExamen = mesaExamenRepository.findAll();
        return mesaExamenMapper.toDtoList(mesasExamen);
    }

    public MesaExamenDto getMesaExamenById(Long id) {
        MesaExamen mesaExamen = mesaExamenRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Mesa de Examen no encontrada con ID: " + id));
        return mesaExamenMapper.toDto(mesaExamen);
    }

    public MesaExamenDto createMesaExamen(MesaExamenDto mesaExamenDto) {
        MesaExamen mesaExamen = mesaExamenMapper.toEntity(mesaExamenDto);
        mesaExamen.setId(null);
        MesaExamen savedMesaExamen = mesaExamenRepository.save(mesaExamen);
        return mesaExamenMapper.toDto(savedMesaExamen);
    }

    public MesaExamenDto updateMesaExamen(Long id, MesaExamenDto mesaExamenDto) {
        MesaExamen existingMesaExamen = mesaExamenRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Mesa de Examen no encontrada con ID: " + id));

        existingMesaExamen.setFecha(mesaExamenDto.getFecha());
        existingMesaExamen.setProfesor(mesaExamenMapper.toEntity(mesaExamenDto).getProfesor());
        existingMesaExamen.setMateria(mesaExamenMapper.toEntity(mesaExamenDto).getMateria());

        MesaExamen updatedMesaExamen = mesaExamenRepository.save(existingMesaExamen);
        return mesaExamenMapper.toDto(updatedMesaExamen);
    }

    public void deleteMesaExamen(Long id) {
        if (!mesaExamenRepository.existsById(id)) {
            throw new RuntimeException("Mesa de Examen no encontrada con ID: " + id);
        }
        mesaExamenRepository.deleteById(id);
    }

    public List<Long> findAllMesaExamen(String alumnoDni) {
        return mesaExamenRepository.findIdsByAlumnoDni(alumnoDni);
    }
}
