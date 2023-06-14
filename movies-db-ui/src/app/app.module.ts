import { HttpClientModule } from '@angular/common/http';
import { NgModule, isDevMode } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ServiceWorkerModule } from '@angular/service-worker';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [AppComponent, NavbarComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: !isDevMode(),
      // Register the ServiceWorker as soon as the application is stable
      // or after 30 seconds (whichever comes first).
      registrationStrategy: 'registerWhenStable:30000',
    }),
  ],
  // providers: [
  // {
  //   provide: APP_INITIALIZER,
  //   useFactory: appInitializeFactory,
  //   deps: [HttpClient, AppConfigService],
  //   multi: true,
  // },
  // {
  //   provide: HTTP_INTERCEPTORS,
  //   useClass: HttpAuthInterceptor,
  //   multi: true,
  // },
  // ],
  bootstrap: [AppComponent],
})
export class AppModule {}
