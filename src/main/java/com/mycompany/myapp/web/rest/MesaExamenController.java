package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.MesaExamenService;
import com.mycompany.myapp.service.dto.MesaExamenDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/mesas-examen")
public class MesaExamenController {

    private final MesaExamenService mesaExamenService;

    public MesaExamenController(MesaExamenService mesaExamenService) {
        this.mesaExamenService = mesaExamenService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MesaExamenDto>> getAllMesasExamen() {
        List<MesaExamenDto> mesasExamen = mesaExamenService.getAllMesasExamen();
        return ResponseEntity.ok(mesasExamen);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaExamenDto> getMesaExamenById(@PathVariable Long id) {
        MesaExamenDto mesaExamen = mesaExamenService.getMesaExamenById(id);
        return ResponseEntity.ok(mesaExamen);
    }

    @PostMapping("/add")
    public ResponseEntity<MesaExamenDto> createMesaExamen(@RequestBody MesaExamenDto mesaExamenDto) {
        MesaExamenDto createdMesaExamen = mesaExamenService.createMesaExamen(mesaExamenDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMesaExamen);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MesaExamenDto> updateMesaExamen(@PathVariable Long id, @RequestBody MesaExamenDto mesaExamenDto) {
        MesaExamenDto updatedMesaExamen = mesaExamenService.updateMesaExamen(id, mesaExamenDto);
        return ResponseEntity.ok(updatedMesaExamen);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMesaExamen(@PathVariable Long id) {
        mesaExamenService.deleteMesaExamen(id);
        return ResponseEntity.noContent().build();
    }
}
