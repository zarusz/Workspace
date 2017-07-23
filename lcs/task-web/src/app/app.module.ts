import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from "@angular/router";
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';

import {ScreensModule} from "./screens/screens.module";
import {CoreModule} from "./core/core.module";
import {WidgetsModule} from "./widgets/widgets.module";

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule,
    FormsModule,
    CoreModule,
    WidgetsModule,
    ScreensModule
  ],
  declarations: [
    AppComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
