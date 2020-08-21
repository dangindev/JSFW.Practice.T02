import { AccessoryDetailComponent } from './screens/accessory-detail/accessory-detail.component';
import { NewCarComponent } from './screens/new-car/new-car.component';
import { HomeComponent } from './screens/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'new-car',
    component: NewCarComponent,
  },
  {
    path: 'accessory-detail',
    component: AccessoryDetailComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
