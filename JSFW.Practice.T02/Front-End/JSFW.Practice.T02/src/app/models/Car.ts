export interface ICar {
  licensePlate?: string;
  repairDate?: string;
  customerName?: string;
  catalogs?: string;
  carMaker?: string;
}

export class Car implements ICar {
  constructor(
    public licensePlate?: string,
    public repairDate?: string,
    public customerName?: string,
    public catalogs?: string,
    public carMaker?: string
  ) {}
}
