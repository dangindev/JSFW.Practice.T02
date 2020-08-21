export interface IAccessory {
  id?: number;
  name?: string;
  price?: number;
  statusDamaged?: string;
  repairStatus?: string;
}

export class Accessory implements IAccessory {
  constructor(
    public id?: number,
    public name?: string,
    public price?: number,
    public statusDamaged?: string,
    public repairStatus?: string
  ) {}
}
