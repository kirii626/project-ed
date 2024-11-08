package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Nota;
import com.mycompany.myapp.repository.NotaRepository;
import com.mycompany.myapp.service.dto.NotaDto;
import com.mycompany.myapp.service.mapper.NotaMapper;
import java.util.List;
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

        existingNota.setValor(notaDto.getNota());
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
}
