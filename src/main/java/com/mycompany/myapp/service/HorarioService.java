package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Horario;
import com.mycompany.myapp.repository.HorarioRepository;
import com.mycompany.myapp.service.dto.HorarioDto;
import com.mycompany.myapp.service.mapper.HorarioMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;
    private final HorarioMapper horarioMapper;

    public HorarioService(HorarioRepository horarioRepository, HorarioMapper horarioMapper) {
        this.horarioRepository = horarioRepository;
        this.horarioMapper = horarioMapper;
    }

    public List<HorarioDto> getAllHorarios() {
        List<Horario> horarios = horarioRepository.findAll();
        return horarioMapper.toDtoList(horarios);
    }

    public HorarioDto getHorarioById(Long id) {
        Horario horario = horarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        return horarioMapper.toDto(horario);
    }

    public HorarioDto createHorario(HorarioDto horarioDto) {
        Horario horario = horarioMapper.toEntity(horarioDto);
        Horario savedHorario = horarioRepository.save(horario);
        return horarioMapper.toDto(savedHorario);
    }

    public HorarioDto updateHorario(Long id, HorarioDto horarioDto) {
        Horario horarioExistente = horarioRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));

        horarioExistente.setDia(horarioDto.getDia());
        horarioExistente.setHoraInicio(horarioDto.getHoraInicio());
        horarioExistente.setHoraFin(horarioDto.getHoraFin());
        horarioExistente.setMateria(horarioMapper.toEntity(horarioDto).getMateria());
        horarioExistente.setProfesor(horarioMapper.toEntity(horarioDto).getProfesor());

        Horario updatedHorario = horarioRepository.save(horarioExistente);
        return horarioMapper.toDto(updatedHorario);
    }

    public void deleteHorario(Long id) {
        if (!horarioRepository.existsById(id)) {
            throw new RuntimeException("Horario no encontrado con ID: " + id);
        }
        horarioRepository.deleteById(id);
    }
}
