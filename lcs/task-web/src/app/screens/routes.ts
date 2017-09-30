import {Routes} from '@angular/router';
import {DriverScreenComponent} from "./driver/driver-screen.component";

// Route Configuration
export const appRoutes: Routes = [

  {
    path: 'driver',
    component: DriverScreenComponent
  },
  {
    path: '',
    redirectTo: 'driver',
    pathMatch: 'full'
  }
];
