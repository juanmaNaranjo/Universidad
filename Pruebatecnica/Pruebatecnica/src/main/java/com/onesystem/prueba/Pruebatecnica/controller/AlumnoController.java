package com.onesystem.prueba.Pruebatecnica.controller;



import com.onesystem.prueba.Pruebatecnica.model.Alumno;
import com.onesystem.prueba.Pruebatecnica.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // Endpoint para obtener todos los alumnos
    @GetMapping
    public ResponseEntity<List<Alumno>> obtenerTodosLosAlumnos() {
        List<Alumno> alumnos = alumnoService.obtenerTodos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    // Endpoint para obtener un alumno por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable("id") Long id) {
        Alumno alumno = alumnoService.obtenerPorId(id);
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    // Endpoint para registrar un nuevo alumno
    @PostMapping
    public ResponseEntity<Alumno> registrarAlumno(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoService.registrar(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }

    // Endpoint para actualizar los datos de un alumno
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable("id") Long id, @RequestBody Alumno alumno) {
        Alumno alumnoActualizado = alumnoService.actualizar(id, alumno);
        return new ResponseEntity<>(alumnoActualizado, HttpStatus.OK);
    }

    // Endpoint para eliminar un alumno por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id") Long id) {
        alumnoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}