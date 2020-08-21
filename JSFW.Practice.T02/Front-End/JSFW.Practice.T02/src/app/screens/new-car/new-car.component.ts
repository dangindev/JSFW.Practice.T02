import { ICar, Car } from './../../models/Car';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-car',
  templateUrl: './new-car.component.html',
  styleUrls: ['./new-car.component.scss'],
})
export class NewCarComponent implements OnInit {
  isSaving = false;
  viewAccessoryDetail = false;

  registerCarForm = this.fb.group({
    licensePlate: ['', Validators.required],
    repairDate: ['', Validators.required],
    customerName: ['', Validators.required],
    catalog: [''],
    carMaker: [''],
  });

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {}
  save(): void {
    this.isSaving = true;
    const newCar = this.createCarFromForm();
    this.http.post('http://localhost:8080/api/v1/cars', newCar).subscribe(
      () => {
        this.viewAccessoryDetail = true;
      },
      () => {
        this.viewAccessoryDetail = true;
      },
      () => {
        this.isSaving = false;
      }
    );
  }

  accessoryDetail(): void {
    this.router.navigate([
      '/accessory-detail',
      {
        licensePlate: this.registerCarForm.get('licensePlate')?.value,
        repairDate: this.registerCarForm.get('repairDate')?.value,
      },
    ]);
  }

  private createCarFromForm(): ICar {
    return {
      ...new Car(),
      licensePlate: this.registerCarForm.get(['licensePlate'])?.value,
      repairDate: this.registerCarForm.get(['repairDate'])?.value,
      customerName: this.registerCarForm.get(['customerName'])?.value,
      catalogs: this.registerCarForm.get(['catalog'])?.value,
      carMaker: this.registerCarForm.get(['carMaker'])?.value,
    };
  }
}
