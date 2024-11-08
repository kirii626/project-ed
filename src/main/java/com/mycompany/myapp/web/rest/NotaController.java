package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.NotaService;
import com.mycompany.myapp.service.dto.NotaDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    // Obtener todas las notas
    @GetMapping("/all")
    public ResponseEntity<List<NotaDto>> getAllNotas() {
        List<NotaDto> notas = notaService.getAllNotas();
        return ResponseEntity.ok(notas);
    }

    // Obtener una nota por ID
    @GetMapping("/{id}")
    public ResponseEntity<NotaDto> getNotaById(@PathVariable Long id) {
        try {
            NotaDto nota = notaService.getNotaById(id);
            return ResponseEntity.ok(nota);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Crear una nueva nota
    @PostMapping("/add")
    public ResponseEntity<NotaDto> createNota(@RequestBody NotaDto notaDto) {
        NotaDto createdNota = notaService.createNota(notaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNota);
    }

    // Actualizar una nota existente
    @PutMapping("/update/{id}")
    public ResponseEntity<NotaDto> updateNota(@PathVariable Long id, @RequestBody NotaDto notaDto) {
        try {
            NotaDto updatedNota = notaService.updateNota(id, notaDto);
            return ResponseEntity.ok(updatedNota);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Eliminar una nota por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        try {
            notaService.deleteNota(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
