import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlumnoListComponent } from './alumno-list/alumno-list.component';
import { AlumnoFormComponent } from './alumno-form/alumno-form.component';
import { ProfesorListComponent } from './profesor-list/profesor-list.component';
import { ProfesorFormComponent } from './profesor-form/profesor-form.component';

export const routes: Routes = [
  { path: 'alumnos', component: AlumnoListComponent },
  { path: 'alumnos/agregar', component: AlumnoFormComponent },
  { path: 'alumnos/editar/:id', component: AlumnoFormComponent },
  { path: 'profesores', component: ProfesorListComponent },
  { path: 'profesores/agregar', component: ProfesorFormComponent },
  { path: 'profesores/editar/:id', component: ProfesorFormComponent },
  { path: '', redirectTo: '/alumnos', pathMatch: 'full' },
  { path: '**', redirectTo: '/alumnos', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
