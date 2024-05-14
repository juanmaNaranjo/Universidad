package com.onesystem.prueba.Pruebatecnica.model;


public class Alumno extends Persona implements Universidad {
    private Long id;
    private String numeroMatricula;
    private String programa;
    private double notaPromedio;

    // Constructor
    public Alumno(String nombreCompleto, String identificacion, String telefono, String email, String direccion, String genero,
                  String numeroMatricula, String programa, double notaPromedio) {
        super(nombreCompleto, identificacion, telefono, email, direccion, genero);
        this.numeroMatricula = numeroMatricula;
        this.programa = programa;
        this.notaPromedio = notaPromedio;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public double getNotaPromedio() {
        return notaPromedio;
    }

    public void setNotaPromedio(double notaPromedio) {
        this.notaPromedio = notaPromedio;
    }

    // Método específico para la clase Alumno
    public void estudiar() {
        System.out.println("El alumno " + getNombreCompleto() + " está estudiando.");
    }

    // Implementación del método abstracto comer para un alumno
    @Override
    public void comer() {
        System.out.println("El alumno " + getNombreCompleto() + " está comiendo.");
    }

    // Implementación del método abstracto descansar para un alumno
    @Override
    public void descansar() {
        System.out.println("El alumno " + getNombreCompleto() + " está descansando.");
    }

    // Implementación de los métodos de la interfaz Universidad
    @Override
    public void obtenerHorario() {
        // Ejemplo de implementación de obtenerHorario para un alumno
        System.out.println("El alumno " + getNombreCompleto() + " ha obtenido su horario.");
    }

    @Override
    public void irAClase() {
        // Ejemplo de implementación de irAClase para un alumno
        System.out.println("El alumno " + getNombreCompleto() + " está yendo a clase.");
    }

    @Override
    public void obtenerPrograma() {
        // Ejemplo de implementación de obtenerPrograma para un alumno
        System.out.println("El alumno " + getNombreCompleto() + " ha obtenido su programa.");
    }

    @Override
    public void obtenerPaseParqueadero() {
        // Ejemplo de implementación de obtenerPaseParqueadero para un alumno
        System.out.println("El alumno " + getNombreCompleto() + " ha obtenido su pase de parqueadero.");
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", numeroMatricula='" + numeroMatricula + '\'' +
                ", programa='" + programa + '\'' +
                ", notaPromedio=" + notaPromedio +
                '}';
    }
}