import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfesorService } from '../profesor.service';

@Component({
  standalone: true,
  selector: 'app-profesor-form',
  templateUrl: './profesor-form.component.html',
  styleUrls: ['./profesor-form.component.css']
})
export class ProfesorFormComponent implements OnInit {
[x: string]: any;
  profesorForm: FormGroup;
  profesorId: number = 0;

  constructor(
    private fb: FormBuilder,
    private profesorService: ProfesorService,
    private route: ActivatedRoute,
    public router: Router
  ) {
    this.profesorForm = this.fb.group({
      nombreCompleto: ['', Validators.required],
      identificacion: ['', Validators.required],
      salario: ['', Validators.required],
      dependencia: ['', Validators.required],
      materia: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.profesorId = this.route.snapshot.params['id'];
    if (this.profesorId) {
      this.profesorService.getProfesor(this.profesorId).subscribe(profesor => {
        this.profesorForm.patchValue(profesor);
      });
    }
  }

  onSubmit(): void {
    if (this.profesorForm.valid) {
      if (this.profesorId) {
        this.profesorService.updateProfesor({ id: this.profesorId, ...this.profesorForm.value })
          .subscribe(() => this.router.navigate(['/profesores']));
      } else {
        this.profesorService.createProfesor(this.profesorForm.value)
          .subscribe(() => this.router.navigate(['/profesores']));
      }
    }
  }
}
