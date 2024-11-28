package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Falta;
import com.mycompany.myapp.repository.FaltaRepository;
import com.mycompany.myapp.service.dto.FaltaDto;
import com.mycompany.myapp.service.mapper.FaltaMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FaltaService {

    private final FaltaRepository faltaRepository;
    private final FaltaMapper faltaMapper;

    public FaltaService(FaltaRepository faltaRepository, FaltaMapper faltaMapper) {
        this.faltaRepository = faltaRepository;
        this.faltaMapper = faltaMapper;
    }

    public List<FaltaDto> getAllFaltas() {
        List<Falta> faltas = faltaRepository.findAll();
        return faltaMapper.toDtoList(faltas);
    }

    public FaltaDto findFaltaById(Long id) {
        Falta falta = faltaRepository.findById(id).orElseThrow(() -> new RuntimeException("Falta no encontrada con ID: " + id));
        return faltaMapper.toDto(falta);
    }

    public FaltaDto saveFalta(FaltaDto faltaDto) {
        Falta falta = faltaMapper.toEntity(faltaDto);
        Falta savedFalta = faltaRepository.save(falta);
        return faltaMapper.toDto(savedFalta);
    }

    public FaltaDto updateFalta(Long id, FaltaDto faltaDto) {
        Falta existingFalta = faltaRepository.findById(id).orElseThrow(() -> new RuntimeException("Falta no encontrada con ID: " + id));

        // Actualizar los campos
        existingFalta.setFecha(faltaDto.getFecha());
        existingFalta.setJustificada(faltaDto.isJustificada());
        // Asegurarse de actualizar la relación con Alumno si es necesario
        if (faltaDto.getAlumnoDni() != null) {
            existingFalta.getAlumno().setDni(faltaDto.getAlumnoDni());
        }

        Falta updatedFalta = faltaRepository.save(existingFalta);
        return faltaMapper.toDto(updatedFalta);
    }

    /**
     * Eliminar una falta por ID.
     * @param id ID de la falta a eliminar
     */
    public void deleteFalta(Long id) {
        if (!faltaRepository.existsById(id)) {
            throw new RuntimeException("Falta no encontrada con ID: " + id);
        }
        faltaRepository.deleteById(id);
    }

    public Integer findAllFaltas(String dni) {
        List<Falta> faltas = faltaRepository.findByAlumnoDni(dni);
        return (faltas != null) ? faltas.size() : 0;
    }
}
