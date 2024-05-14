package com.onesystem.prueba.Pruebatecnica.model;

public class Profesor extends Persona implements Universidad {

    private Long id;
    private double salario;
    private String dependencia;
    private String materia;

    // Constructor
    public Profesor(String nombreCompleto, String identificacion, String telefono, String email, String direccion, String genero,
                    double salario, String dependencia, String materia) {
        super(nombreCompleto, identificacion, telefono, email, direccion, genero);
        this.salario = salario;
        this.dependencia = dependencia;
        this.materia = materia;
    }

    // Métodos específicos para la clase Profesor
    public void calificar() {
        // Lógica para calificar
        System.out.println("El profesor " + getNombreCompleto() + " está calificando.");
    }

    public void prepararClase() {
        // Lógica para preparar clase
        System.out.println("El profesor " + getNombreCompleto() + " está preparando clase.");
    }

    // Implementación de los métodos abstractos de la clase Persona
    @Override
    public void comer() {
        // Implementación de comer para un profesor
        System.out.println("El profesor " + getNombreCompleto() + " está comiendo.");
    }

    @Override
    public void descansar() {
        // Implementación de descansar para un profesor
        System.out.println("El profesor " + getNombreCompleto() + " está descansando.");
    }

    // Implementación de los métodos de la interfaz Universidad
    @Override
    public void obtenerHorario() {
        // Implementación de obtenerHorario para un profesor
        System.out.println("El profesor " + getNombreCompleto() + " está obteniendo su horario.");
    }

    @Override
    public void irAClase() {
        // Implementación de irAClase para un profesor
        System.out.println("El profesor " + getNombreCompleto() + " está yendo a clase.");
    }

    @Override
    public void obtenerPrograma() {
        // Implementación de obtenerPrograma para un profesor
        System.out.println("El profesor " + getNombreCompleto() + " está obteniendo el programa.");
    }

    @Override
    public void obtenerPaseParqueadero() {
        // Implementación de obtenerPaseParqueadero para un profesor
        System.out.println("El profesor " + getNombreCompleto() + " está obteniendo el pase de parqueadero.");
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", salario=" + salario +
                ", dependencia='" + dependencia + '\'' +
                ", materia='" + materia + '\'' +
                '}';
    }
}