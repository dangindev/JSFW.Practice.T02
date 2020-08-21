import { IAccessory, Accessory } from './../../models/Accessory';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, Validators, FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
// import { FormsModule } from "@angular/forms";

@Component({
  templateUrl: './accessory-detail.component.html',
  styleUrls: ['./accessory-detail.component.scss'],
})
export class AccessoryDetailComponent implements OnInit {
  licensePlate?: string;
  repairDate?: string;
  isSaving = false;
  accessories?: IAccessory[];
  isUpdated = false;

  registerAccessoryForm = this.fb.group({
    id: [''],
    name: ['', Validators.required],
    price: [''],
    statusDamaged: [''],
    repairStatus: [''],
  });

  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.licensePlate = params['licensePlate'];
      this.repairDate = params['repairDate'];
    });

    this.reloadCarAccessories();
  }

  reloadCarAccessories(): void {
    this.http
      .get<IAccessory[]>(
        `http://localhost:8080/api/v1/cars/${this.licensePlate}_${this.repairDate}/accessories`
      )
      .subscribe((accessories) => {
        this.accessories = accessories;
      });
  }

  resetform(): void {
    this.registerAccessoryForm.reset(this.accessories);
  }
  save(): void {
    this.isSaving = true;
    const accessory = this.createAccessoryFromForm();
    if (this.isUpdated) {
      this.http
        .put(
          `http://localhost:8080/api/v1/cars/${this.licensePlate}_${this.repairDate}/accessories/${accessory.id}`,
          accessory
        )
        .subscribe(
          () => {
            this.reloadCarAccessories();
            this.isSaving = false;
          },
          (error) => {
            this.reloadCarAccessories();
            this.isSaving = false;
          },
          () => {
            this.isSaving = false;
          }
        );
      return;
    }
    this.http
      .post(
        `http://localhost:8080/api/v1/cars/${this.licensePlate}_${this.repairDate}/accessories`,
        accessory
      )
      .subscribe(
        () => {
          this.reloadCarAccessories();
          this.isSaving = false;
        },
        (error) => {
          this.reloadCarAccessories();
          this.isSaving = false;
        },
        () => {
          this.isSaving = false;
        }
      );
  }

  edit(accessory: IAccessory): void {
    this.registerAccessoryForm.patchValue({
      id: accessory.id,
      name: accessory.name,
      price: accessory.price,
      statusDamaged: accessory.statusDamaged,
      repairStatus: accessory.repairStatus,
    });
    this.isUpdated = true;
  }

  delete(id: number): void {
    if (!confirm('Do you want to delete this a ccessory?')) return;
    this.http
      .delete(
        `http://localhost:8080/api/v1/cars/${this.licensePlate}_${this.repairDate}/accessories/${id}`
      )
      .subscribe(
        () => {
          this.reloadCarAccessories();
          // this.resetform();
        },
        (error) => {
          this.reloadCarAccessories();
        }
      );
  }

  private createAccessoryFromForm(): IAccessory {
    return {
      ...new Accessory(),
      id: this.registerAccessoryForm.get(['id'])?.value,
      name: this.registerAccessoryForm.get(['name'])?.value,
      price: this.registerAccessoryForm.get(['price'])?.value,
      statusDamaged: this.registerAccessoryForm.get(['statusDamaged'])?.value,
      repairStatus: this.registerAccessoryForm.get(['repairStatus'])?.value,
    };
  }
}
