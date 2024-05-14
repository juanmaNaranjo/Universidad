package com.onesystem.prueba.Pruebatecnica.repositorie;


import com.onesystem.prueba.Pruebatecnica.model.Alumno;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlumnoRepository {

    private List<Alumno> alumnos = new ArrayList<>();
    private long idCounter = 0;

    // Método para obtener todos los alumnos
    public List<Alumno> obtenerTodos() {
        return new ArrayList<>(alumnos);
    }

    // Método para obtener un alumno por su ID
    public Alumno obtenerPorId(Long id) {
        Optional<Alumno> alumno = alumnos.stream().filter(a -> a.getId().equals(id)).findFirst();
        return alumno.orElse(null);
    }

    // Método para registrar un nuevo alumno
    public Alumno registrar(Alumno alumno) {
        alumno.setId(++idCounter);
        alumnos.add(alumno);
        return alumno;
    }

    // Método para actualizar los datos de un alumno
    public Alumno actualizar(Long id, Alumno alumnoActualizado) {
        Alumno alumnoExistente = obtenerPorId(id);
        if (alumnoExistente != null) {
            alumnoExistente.setNombreCompleto(alumnoActualizado.getNombreCompleto());
            alumnoExistente.setIdentificacion(alumnoActualizado.getIdentificacion());
            alumnoExistente.setTelefono(alumnoActualizado.getTelefono());
            alumnoExistente.setEmail(alumnoActualizado.getEmail());
            alumnoExistente.setDireccion(alumnoActualizado.getDireccion());
            alumnoExistente.setGenero(alumnoActualizado.getGenero());
            alumnoExistente.setNumeroMatricula(alumnoActualizado.getNumeroMatricula());
            alumnoExistente.setPrograma(alumnoActualizado.getPrograma());
            alumnoExistente.setNotaPromedio(alumnoActualizado.getNotaPromedio());
            return alumnoExistente;
        }
        return null;
    }

    // Método para eliminar un alumno por su ID
    public void eliminar(Long id) {
        alumnos.removeIf(a -> a.getId().equals(id));
    }
}
