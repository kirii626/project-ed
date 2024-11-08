package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.PreceptorService;
import com.mycompany.myapp.service.dto.PreceptorDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/preceptor")
public class PreceptorController {

    private final PreceptorService preceptorService;

    public PreceptorController(PreceptorService preceptorService) {
        this.preceptorService = preceptorService;
    }

    @GetMapping("/all")
    public List<PreceptorDto> getAllPreceptores() {
        return preceptorService.getAllPreceptores();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<PreceptorDto> findPreceptorById(@PathVariable String dni) {
        try {
            PreceptorDto preceptor = preceptorService.findPreceptorById(dni);
            return ResponseEntity.ok(preceptor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<PreceptorDto> savePreceptor(@RequestBody PreceptorDto preceptorDto) {
        PreceptorDto createdPreceptor = preceptorService.savePreceptor(preceptorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPreceptor);
    }

    @PutMapping("/update/{dni}")
    public ResponseEntity<PreceptorDto> updatePreceptor(@PathVariable String dni, @RequestBody PreceptorDto preceptorDto) {
        try {
            PreceptorDto updatedPreceptor = preceptorService.updatePreceptor(dni, preceptorDto);
            return ResponseEntity.ok(updatedPreceptor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Void> deletePreceptor(@PathVariable String dni) {
        try {
            preceptorService.deletePreceptor(dni);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
