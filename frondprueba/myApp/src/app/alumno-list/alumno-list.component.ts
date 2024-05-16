import { Component, OnInit } from '@angular/core';
import { Alumno } from '../models/alumno.model';
import { AlumnoService } from '../alumno.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alumno-list',
  templateUrl: './alumno-list.component.html',
  styleUrls: ['./alumno-list.component.css']
})
export class AlumnoListComponent implements OnInit {
  alumnos!: Alumno[];

  constructor(private alumnoService: AlumnoService, private router: Router) { }

  ngOnInit(): void {
    this.obtenerAlumnos();
  }

  obtenerAlumnos(): void {
    this.alumnoService.getAlumnos().subscribe(alumnos => this.alumnos = alumnos);
  }

  editarAlumno(id: number): void {
    this.router.navigate(['/alumnos/editar', id]);
  }

  eliminarAlumno(id: number): void {
    if (confirm('¿Estás seguro de querer eliminar este alumno?')) {
      this.alumnoService.deleteAlumno(id).subscribe(() => {
        // Actualizar la lista de alumnos después de eliminar
        this.obtenerAlumnos();
      });
    }
  }
}
