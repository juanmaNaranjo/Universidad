// alumno-list.component.ts

import { Component, OnInit } from '@angular/core';
import { AlumnoService } from '../alumno.service';
import { Alumno } from '../models/alumno.model';

@Component({
  selector: 'app-alumno-list',
  templateUrl: './alumno-list.component.html',
  styleUrls: ['./alumno-list.component.css']
})
export class AlumnoListComponent implements OnInit {
  alumnos: Alumno[];

  constructor(private alumnoService: AlumnoService) { }

  ngOnInit(): void {
    this.obtenerAlumnos();
  }

  obtenerAlumnos(): void {
    this.alumnoService.obtenerAlumnos().subscribe(alumnos => {
      this.alumnos = alumnos;
    });
  }
}

