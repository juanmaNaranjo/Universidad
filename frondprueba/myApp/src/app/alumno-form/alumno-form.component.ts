import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AlumnoService } from '../alumno.service';

@Component({
  standalone: true,
  selector: 'app-alumno-form',
  templateUrl: './alumno-form.component.html',
  styleUrls: ['./alumno-form.component.css']
})
export class AlumnoFormComponent implements OnInit {
  alumnoForm: FormGroup;
  alumnoId: number  = 0;


  constructor(
    private fb: FormBuilder,
    private alumnoService: AlumnoService,
    private route: ActivatedRoute,
    public router: Router,
  ) {
    this.alumnoForm = this.fb.group({
      nombreCompleto: ['', Validators.required],
      identificacion: ['', Validators.required],
      numeroMatricula: ['', Validators.required],
      programa: ['', Validators.required],
      notaPromedio: ['', [Validators.required, Validators.min(0), Validators.max(10)]]
    });
  }

  ngOnInit(): void {
    this.alumnoId = this.route.snapshot.params['id'];
    if (this.alumnoId) {
      this.alumnoService.getAlumno(this.alumnoId).subscribe(alumno => {
        this.alumnoForm.patchValue(alumno);
      });
    }
  }

  onSubmit(): void {
    if (this.alumnoForm.valid) {
      if (this.alumnoId) {
        this.alumnoService.updateAlumno({ id: this.alumnoId, ...this.alumnoForm.value })
          .subscribe(() => this.router.navigate(['/alumnos']));
      } else {
        this.alumnoService.createAlumno(this.alumnoForm.value)
          .subscribe(() => this.router.navigate(['/alumnos']));
      }
    }
  }
}
