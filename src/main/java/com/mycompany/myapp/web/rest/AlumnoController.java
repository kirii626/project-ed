package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.AlumnoService;
import com.mycompany.myapp.service.ExportAlumnosFromExcel;
import com.mycompany.myapp.service.dto.AlumnoDto;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;
    private final ExportAlumnosFromExcel exportAlumnosFromExcel;

    public AlumnoController(AlumnoService alumnoService, ExportAlumnosFromExcel exportAlumnosFromExcel) {
        this.alumnoService = alumnoService;
        this.exportAlumnosFromExcel = exportAlumnosFromExcel;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AlumnoDto>> getListAlumnos() {
        List<AlumnoDto> alumnoDtoList = alumnoService.getAllAlumnos();
        return ResponseEntity.ok(alumnoDtoList);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<AlumnoDto> getAlumnoById(@PathVariable String dni) {
        AlumnoDto alumnoDto = alumnoService.findAlumnoById(dni);
        return ResponseEntity.ok(alumnoDto);
    }

    @PostMapping("/add")
    public ResponseEntity<AlumnoDto> addAlumno(@RequestBody AlumnoDto alumnoDto) {
        alumnoService.saveAlumno(alumnoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDto);
    }

    @PutMapping("/update/{dni}")
    public ResponseEntity<AlumnoDto> editAlumno(@PathVariable String dni, @RequestBody AlumnoDto alumnoDto) {
        AlumnoDto updatedAlumno = alumnoService.updateAlumno(dni, alumnoDto);
        return ResponseEntity.ok(updatedAlumno);
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable String dni) {
        alumnoService.deleteAlumno(dni);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/export/alumnos")
    public ResponseEntity<byte[]> exportAlumnos(HttpServletRequest httpServletRequest, @RequestBody long[] dni) throws IOException {
        byte[] excelByte;
        if (dni != null && dni.length > 0) {
            excelByte = exportAlumnosFromExcel.exportAlumnosWithDni(dni);
        } else {
            excelByte = exportAlumnosFromExcel.exportAll();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "alumnos.xlsx");

        return new ResponseEntity<>(excelByte, headers, HttpStatus.OK);
    }
}
