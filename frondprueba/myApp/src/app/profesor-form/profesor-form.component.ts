// src/app/profesor-form/profesor-form.component.ts
import { Component } from '@angular/core';
import { ProfesorService } from '../profesor.service';
import { Profesor } from '../models/profesor.model';

@Component({
  selector: 'app-profesor-form',
  templateUrl: './profesor-form.component.html',
  styleUrls: ['./profesor-form.component.css']
})
export class ProfesorFormComponent {
  profesor: Profesor = { id: null, nombreCompleto: '', identificacion: '', salario: 0, dependencia: '', materia: '' };

  constructor(private profesorService: ProfesorService) { }

  guardarProfesor(): void {
    this.profesorService.guardarProfesor(this.profesor);
    this.profesor = { id: null, nombreCompleto: '', identificacion: '', salario: 0, dependencia: '', materia: '' };
  }
}
