package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.ProfesorService;
import com.mycompany.myapp.service.dto.AlumnoDto;
import com.mycompany.myapp.service.dto.ProfesorDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/profesor")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping("/all")
    public List<ProfesorDto> getAllProfesores() {
        return profesorService.getAllProfesores();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<ProfesorDto> findProfesorById(@PathVariable String dni) {
        try {
            ProfesorDto profesor = profesorService.findProfesorById(dni);
            return ResponseEntity.ok(profesor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ProfesorDto> addProfesor(@RequestBody ProfesorDto profesorDto) {
        ProfesorDto createdProfesor = profesorService.saveProfesor(profesorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfesor);
    }

    @PutMapping("/update/{dni}")
    public ResponseEntity<ProfesorDto> updateProfesor(@PathVariable String dni, @RequestBody ProfesorDto profesorDto) {
        try {
            ProfesorDto updatedProfesor = profesorService.updateProfesor(dni, profesorDto);
            return ResponseEntity.ok(updatedProfesor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable String dni) {
        try {
            profesorService.deleteProfesor(dni);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
