import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";

import {DriverScreenComponent} from "./driver/driver-screen.component";
import {appRoutes} from "./routes";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  declarations: [
    DriverScreenComponent
  ]
})
export class ScreensModule {
}
