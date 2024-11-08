package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Preceptor;
import com.mycompany.myapp.repository.PreceptorRepository;
import com.mycompany.myapp.service.dto.PreceptorDto;
import com.mycompany.myapp.service.mapper.PreceptorMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PreceptorService {

    private final PreceptorRepository preceptorRepository;
    private final PreceptorMapper preceptorMapper;

    public PreceptorService(PreceptorRepository preceptorRepository, PreceptorMapper preceptorMapper) {
        this.preceptorRepository = preceptorRepository;
        this.preceptorMapper = preceptorMapper;
    }

    public List<PreceptorDto> getAllPreceptores() {
        List<Preceptor> preceptores = preceptorRepository.findAll();
        return preceptorMapper.toDtoList(preceptores);
    }

    public PreceptorDto findPreceptorById(String dni) {
        Preceptor preceptor = preceptorRepository.findById(dni).orElseThrow(() -> new RuntimeException("Preceptor no encontrado"));
        return preceptorMapper.toDto(preceptor);
    }

    public PreceptorDto savePreceptor(PreceptorDto preceptorDto) {
        Preceptor preceptor = preceptorMapper.toEntity(preceptorDto);
        Preceptor savedPreceptor = preceptorRepository.save(preceptor);
        return preceptorMapper.toDto(savedPreceptor);
    }

    public PreceptorDto updatePreceptor(String dni, PreceptorDto preceptorDto) {
        Preceptor existingPreceptor = preceptorRepository.findById(dni).orElseThrow(() -> new RuntimeException("Preceptor no encontrado"));

        existingPreceptor.setNombre(preceptorDto.getNombre());
        existingPreceptor.setApellido(preceptorDto.getApellido());
        existingPreceptor.setEmail(preceptorDto.getEmail());

        Preceptor updatedPreceptor = preceptorRepository.save(existingPreceptor);
        return preceptorMapper.toDto(updatedPreceptor);
    }

    public void deletePreceptor(String dni) {
        if (!preceptorRepository.existsById(dni)) {
            throw new RuntimeException("Preceptor no encontrado");
        }
        preceptorRepository.deleteById(dni);
    }
}
