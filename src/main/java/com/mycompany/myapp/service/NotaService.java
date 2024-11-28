package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Nota;
import com.mycompany.myapp.repository.NotaRepository;
import com.mycompany.myapp.service.dto.NotaDto;
import com.mycompany.myapp.service.mapper.NotaMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final NotaMapper notaMapper;

    public NotaService(NotaRepository notaRepository, NotaMapper notaMapper) {
        this.notaRepository = notaRepository;
        this.notaMapper = notaMapper;
    }

    public NotaDto createNota(NotaDto notaDto) {
        Nota nota = notaMapper.toEntity(notaDto);
        Nota savedNota = notaRepository.save(nota);
        return notaMapper.toDto(savedNota);
    }

    public List<NotaDto> getAllNotas() {
        return notaMapper.toDtoList(notaRepository.findAll());
    }

    public NotaDto getNotaById(Long id) {
        Nota nota = notaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota no encontrada con ID: " + id));
        return notaMapper.toDto(nota);
    }

    public NotaDto updateNota(Long id, NotaDto notaDto) {
        Nota existingNota = notaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota no encontrada con ID: " + id));

        existingNota.setValor(notaDto.getValor());
        existingNota.setFecha(notaDto.getFecha());

        Nota updatedNota = notaRepository.save(existingNota);
        return notaMapper.toDto(updatedNota);
    }

    public void deleteNota(Long id) {
        if (!notaRepository.existsById(id)) {
            throw new RuntimeException("Nota no encontrada con ID: " + id);
        }
        notaRepository.deleteById(id);
    }

    public List<NotaDto> findAllNotas(String alumnoDni) {
        // Consultar las notas de la base de datos
        List<Nota> notas = notaRepository.findByAlumnoDni(alumnoDni);

        // Mapear las entidades Nota a DTOs
        return notas
            .stream()
            .map(nota ->
                new NotaDto(
                    nota.getId(),
                    nota.getValor(),
                    nota.getFecha(),
                    nota.getAlumno().getDni(), // Asegúrate de que `getAlumno()` devuelve la relación correctamente
                    nota.getMateria().getId() // Asumiendo que `Materia` es una relación en `Nota`
                )
            )
            .collect(Collectors.toList());
    }
}
