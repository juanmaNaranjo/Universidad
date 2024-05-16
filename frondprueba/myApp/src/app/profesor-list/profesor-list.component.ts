import { Component, OnInit } from '@angular/core';
import { Profesor } from '../models/profesor.model';
import { ProfesorService } from '../profesor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profesor-list',
  templateUrl: './profesor-list.component.html',
  styleUrls: ['./profesor-list.component.css']
})
export class ProfesorListComponent implements OnInit {
  profesores: Profesor[] = [];

  constructor(private profesorService: ProfesorService, private router: Router) { }

  ngOnInit(): void {
    this.obtenerProfesores();
  }

  obtenerProfesores(): void {
    this.profesorService.getProfesores().subscribe(profesores => this.profesores = profesores);
  }

  editarProfesor(id: number): void {
    this.router.navigate(['/profesores/editar', id]);
  }

  eliminarProfesor(id: number): void {
    if (confirm('¿Estás seguro de querer eliminar este profesor?')) {
      this.profesorService.deleteProfesor(id).subscribe(() => {
        // Actualizar la lista de profesores después de eliminar
        this.obtenerProfesores();
      });
    }
  }
}
