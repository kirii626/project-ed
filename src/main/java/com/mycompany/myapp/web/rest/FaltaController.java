package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.FaltaService;
import com.mycompany.myapp.service.dto.FaltaDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/faltas")
public class FaltaController {

    private final FaltaService faltaService;

    public FaltaController(FaltaService faltaService) {
        this.faltaService = faltaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FaltaDto>> getAllFaltas() {
        List<FaltaDto> faltas = faltaService.getAllFaltas();
        return ResponseEntity.ok(faltas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaltaDto> getFaltaById(@PathVariable Long id) {
        try {
            FaltaDto falta = faltaService.findFaltaById(id);
            return ResponseEntity.ok(falta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<FaltaDto> saveFalta(@RequestBody FaltaDto faltaDto) {
        FaltaDto createdFalta = faltaService.saveFalta(faltaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFalta);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FaltaDto> updateFalta(@PathVariable Long id, @RequestBody FaltaDto faltaDto) {
        try {
            FaltaDto updatedFalta = faltaService.updateFalta(id, faltaDto);
            return ResponseEntity.ok(updatedFalta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFalta(@PathVariable Long id) {
        try {
            faltaService.deleteFalta(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
