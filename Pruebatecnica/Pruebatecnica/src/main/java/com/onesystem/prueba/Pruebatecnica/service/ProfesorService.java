package com.onesystem.prueba.Pruebatecnica.service;

import com.onesystem.prueba.Pruebatecnica.model.Profesor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private List<Profesor> profesores = new ArrayList<>();
    private long idCounter = 0;

    // Método para obtener todos los profesores
    public List<Profesor> obtenerTodos() {
        return new ArrayList<>(profesores);
    }

    // Método para obtener un profesor por su ID
    public Profesor obtenerPorId(Long id) {
        Optional<Profesor> profesor = profesores.stream().filter(p -> p.getId().equals(id)).findFirst();
        return profesor.orElse(null);
    }

    // Método para registrar un nuevo profesor
    public Profesor registrar(Profesor profesor) {
        profesor.setId(++idCounter);
        profesores.add(profesor);
        return profesor;
    }

    // Método para actualizar los datos de un profesor
    public Profesor actualizar(Long id, Profesor profesorActualizado) {
        Profesor profesorExistente = obtenerPorId(id);
        if (profesorExistente != null) {
            profesorExistente.setNombreCompleto(profesorActualizado.getNombreCompleto());
            profesorExistente.setIdentificacion(profesorActualizado.getIdentificacion());
            profesorExistente.setTelefono(profesorActualizado.getTelefono());
            profesorExistente.setEmail(profesorActualizado.getEmail());
            profesorExistente.setDireccion(profesorActualizado.getDireccion());
            profesorExistente.setGenero(profesorActualizado.getGenero());
            profesorExistente.setSalario(profesorActualizado.getSalario());
            profesorExistente.setDependencia(profesorActualizado.getDependencia());
            profesorExistente.setMateria(profesorActualizado.getMateria());
            return profesorExistente;
        }
        return null;
    }

    // Método para eliminar un profesor por su ID
    public void eliminar(Long id) {
        profesores.removeIf(p -> p.getId().equals(id));
    }
}



