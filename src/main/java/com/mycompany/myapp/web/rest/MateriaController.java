package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.MateriaService;
import com.mycompany.myapp.service.dto.MateriaDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping("/all")
    public List<MateriaDto> getAllMaterias() {
        return materiaService.getAllMaterias();
    }

    @GetMapping("{id}")
    public ResponseEntity<MateriaDto> findMateriaById(@PathVariable Long id) {
        try {
            MateriaDto materiaDto = materiaService.findMateriaById(id);
            return ResponseEntity.ok(materiaDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<MateriaDto> saveMateria(@RequestBody MateriaDto materiaDto) {
        MateriaDto createdMateria = materiaService.saveMateria(materiaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMateria);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MateriaDto> updateMateria(@PathVariable Long id, @RequestBody MateriaDto materiaDto) {
        try {
            MateriaDto updatedMateria = materiaService.updateMateria(id, materiaDto);
            return ResponseEntity.ok(updatedMateria);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Long id) {
        try {
            materiaService.deleteMateria(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
