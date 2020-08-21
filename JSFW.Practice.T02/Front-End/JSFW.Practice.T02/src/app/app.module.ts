import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BannerComponent } from './banner/banner.component';
import { FooterComponent } from './footer/footer.component';
import { MenuLeftComponent } from './menu-left/menu-left.component';
import { HomeComponent } from './screens/home/home.component';
import { NewCarComponent } from './screens/new-car/new-car.component';
import { AccessoryDetailComponent } from './screens/accessory-detail/accessory-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    BannerComponent,
    MenuLeftComponent,
    HomeComponent,
    NewCarComponent,
    AccessoryDetailComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
