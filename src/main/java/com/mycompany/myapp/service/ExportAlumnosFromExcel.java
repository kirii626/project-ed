package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.AlumnoDto;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportAlumnosFromExcel {

    @Autowired
    private AlumnoService alumnoService;

    public byte[] exportAlumnosWithDni(long[] dnis) throws IOException {
        List<AlumnoDto> filteredAlumnos = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook();

        for (long dni : dnis) {
            try {
                AlumnoDto alumno = alumnoService.findAlumnoById(String.valueOf(dni));
                filteredAlumnos.add(alumno);
            } catch (RuntimeException e) {
                // Si no encuentra un alumno, lo ignoramos o puedes manejarlo según prefieras
                System.err.println("No se encontró alumno con DNI: " + dni);
            }
        }

        var sheet = workbook.createSheet("exportById");
        var headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("dni");
        headerRow.createCell(1).setCellValue("nombre");
        headerRow.createCell(2).setCellValue("apellido");
        headerRow.createCell(3).setCellValue("email");
        for (int i = 0; i < filteredAlumnos.size(); i++) {
            AlumnoDto alumno = filteredAlumnos.get(i);
            var row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(alumno.getDni());
            row.createCell(1).setCellValue(alumno.getNombre());
            row.createCell(2).setCellValue(alumno.getApellido());
            row.createCell(3).setCellValue(alumno.getEmail());
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        return outputStream.toByteArray();
    }

    public byte[] exportAll() {
        List<AlumnoDto> listAlumnos = alumnoService.getAllAlumnos();
        return null;
    }
}
