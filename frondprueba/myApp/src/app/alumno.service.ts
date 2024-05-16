import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Alumno } from './models/alumno.model';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {
  private baseUrl = 'http://localhost:8080/api/alumnos';

  constructor(private http: HttpClient) {}

  getAlumnos(): Observable<Alumno[]> {
    return this.http.get<Alumno[]>(this.baseUrl);
  }

  getAlumno(id: number): Observable<Alumno> {
    return this.http.get<Alumno>(`${this.baseUrl}/${id}`);
  }

  createAlumno(alumno: Alumno): Observable<Alumno> {
    return this.http.post<Alumno>(this.baseUrl, alumno);
  }

  updateAlumno(alumno: Alumno): Observable<Alumno> {
    return this.http.put<Alumno>(`${this.baseUrl}/${alumno.id}`, alumno);
  }

  deleteAlumno(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
