package com.onesystem.prueba.Pruebatecnica.controller;


import com.onesystem.prueba.Pruebatecnica.model.Profesor;
import com.onesystem.prueba.Pruebatecnica.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    // Endpoint para obtener todos los profesores
    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodosLosProfesores() {
        List<Profesor> profesores = profesorService.obtenerTodos();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    // Endpoint para obtener un profesor por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable("id") Long id) {
        Profesor profesor = profesorService.obtenerPorId(id);
        return new ResponseEntity<>(profesor, HttpStatus.OK);
    }

    // Endpoint para registrar un nuevo profesor
    @PostMapping
    public ResponseEntity<Profesor> registrarProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorService.registrar(profesor);
        return new ResponseEntity<>(nuevoProfesor, HttpStatus.CREATED);
    }

    // Endpoint para actualizar los datos de un profesor
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable("id") Long id, @RequestBody Profesor profesor) {
        Profesor profesorActualizado = profesorService.actualizar(id, profesor);
        return new ResponseEntity<>(profesorActualizado, HttpStatus.OK);
    }

    // Endpoint para eliminar un profesor por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable("id") Long id) {
        profesorService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}