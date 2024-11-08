package com.mycompany.myapp.web;

import com.mycompany.myapp.service.HorarioService;
import com.mycompany.myapp.service.dto.HorarioDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/horarios")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<HorarioDto>> getAllHorarios() {
        List<HorarioDto> horarios = horarioService.getAllHorarios();
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDto> getHorarioById(@PathVariable Long id) {
        HorarioDto horario = horarioService.getHorarioById(id);
        return ResponseEntity.ok(horario);
    }

    @PostMapping("/add")
    public ResponseEntity<HorarioDto> createHorario(@RequestBody HorarioDto horarioDto) {
        HorarioDto createdHorario = horarioService.createHorario(horarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHorario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioDto> updateHorario(@PathVariable Long id, @RequestBody HorarioDto horarioDto) {
        HorarioDto updatedHorario = horarioService.updateHorario(id, horarioDto);
        return ResponseEntity.ok(updatedHorario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id) {
        horarioService.deleteHorario(id);
        return ResponseEntity.noContent().build();
    }
}
