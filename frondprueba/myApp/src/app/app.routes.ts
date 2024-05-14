// src/app/app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlumnoListComponent } from './alumno-list/alumno-list.component';
import { ProfesorListComponent } from './profesor-list/profesor-list.component';
import { AlumnoFormComponent } from './alumno-form/alumno-form.component';
import { ProfesorFormComponent } from './profesor-form/profesor-form.component';

const routes: Routes = [
  { path: '', redirectTo: '/alumnos', pathMatch: 'full' },
  { path: 'alumnos', component: AlumnoListComponent },
  { path: 'profesores', component: ProfesorListComponent },
  { path: 'alumno-form', component: AlumnoFormComponent },
  { path: 'profesor-form', component: ProfesorFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
