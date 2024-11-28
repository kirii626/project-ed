package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.AlumnoDto;
import com.mycompany.myapp.service.dto.NotaDto;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExportAlumnosFromExcel {

    private final AlumnoService alumnoService;
    private final FaltaService faltaService;
    private final NotaService notaService;
    private final MesaExamenService mesaExamenService;

    public ExportAlumnosFromExcel(
        AlumnoService alumnoService,
        FaltaService faltaService,
        NotaService notaService,
        MesaExamenService mesaExamenService
    ) {
        this.alumnoService = alumnoService;
        this.faltaService = faltaService;
        this.notaService = notaService;
        this.mesaExamenService = mesaExamenService;
    }

    // Metodo para crear encabezados
    private void createHeaderRow(Sheet sheet, String[] headers) {
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }
    }

    // Metodo para llenar filas de datos
    private void createDataRows(Sheet sheet, List<AlumnoDto> alumnos) {
        for (int i = 0; i < alumnos.size(); i++) {
            AlumnoDto alumno = alumnos.get(i);
            Row row = sheet.createRow(i + 1); // +1 porque la fila 0 es para el encabezado

            // Datos simples
            row.createCell(0).setCellValue(alumno.getDni());
            row.createCell(1).setCellValue(alumno.getNombre());
            row.createCell(2).setCellValue(alumno.getApellido());
            row.createCell(3).setCellValue(alumno.getEmail());
            row.createCell(4).setCellValue(alumno.getPreceptorDni());
            System.out.println("dni alumno:" + alumno.getDni());
            // Total de faltas
            Integer totalFaltas = faltaService.findAllFaltas(alumno.getDni());
            row.createCell(5).setCellValue(totalFaltas);

            // Notas
            List<NotaDto> notas = notaService.findAllNotas(alumno.getDni());
            row
                .createCell(6)
                .setCellValue(
                    notas != null && !notas.isEmpty()
                        ? notas
                            .stream()
                            .map(n -> String.format("%.2f (Fecha: %s)", n.getValor(), n.getFecha())) // Formatea la nota con fecha
                            .collect(Collectors.joining(", ")) // Concatenar como texto
                        : "N/A"
                );

            // Mesas de Examen
            List<Long> mesasExamen = mesaExamenService.findAllMesaExamen(alumno.getDni());
            row
                .createCell(7)
                .setCellValue(
                    mesasExamen != null && !mesasExamen.isEmpty()
                        ? mesasExamen.stream().map(String::valueOf).collect(Collectors.joining(", ")) // Concatenar como texto
                        : "N/A"
                );
        }
    }

    // Exportar alumnos con DNI específicos
    public byte[] exportAlumnosWithDni(long[] dnis) throws IOException {
        List<AlumnoDto> filteredAlumnos = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook();

        // Obtener alumnos filtrados por DNI
        for (long dni : dnis) {
            try {
                AlumnoDto alumno = alumnoService.findAlumnoById(String.valueOf(dni));
                filteredAlumnos.add(alumno);
            } catch (RuntimeException e) {
                System.err.println("No se encontró alumno con DNI: " + dni);
            }
        }

        // Si no se encontraron alumnos, exportar todos
        if (filteredAlumnos.isEmpty()) {
            System.err.println("No se encontraron alumnos con los DNIs proporcionados. Exportando todos los alumnos.");
            return exportAll();
        }

        // Crear hoja y agregar encabezados
        Sheet sheet = workbook.createSheet("exportById");
        String[] headers = { "DNI", "Nombre", "Apellido", "Email", "Preceptor DNI", "Total Faltas", "Notas", "Mesas de Examen" };
        createHeaderRow(sheet, headers);
        createDataRows(sheet, filteredAlumnos);

        // Escribir datos en un ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close(); // Importante cerrar el workbook
        return outputStream.toByteArray();
    }

    // Exportar todos los alumnos
    public byte[] exportAll() throws IOException {
        List<AlumnoDto> listAlumnos = alumnoService.getAllAlumnos();
        Workbook workbook = new XSSFWorkbook();

        // Crear hoja y agregar encabezados
        Sheet sheet = workbook.createSheet("Alumnos");
        String[] headers = { "DNI", "Nombre", "Apellido", "Email", "Preceptor DNI", "Total Faltas", "Notas", "Mesas de Examen" };
        createHeaderRow(sheet, headers);
        createDataRows(sheet, listAlumnos);

        // Escribir datos en un ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close(); // Importante cerrar el workbook
        return outputStream.toByteArray();
    }
}
