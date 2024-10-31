package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.AlumnoService;
import com.mycompany.myapp.service.dto.AlumnoDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AlumnoDto>> getListAlumnos() {
        List<AlumnoDto> alumnoDtoList = alumnoService.getAllAlumnos();
        return ResponseEntity.ok(alumnoDtoList);
    }
}
