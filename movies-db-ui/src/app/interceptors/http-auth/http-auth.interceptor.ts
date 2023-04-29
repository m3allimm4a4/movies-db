import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from 'src/app/services/app-config-service/app-config.service';

@Injectable()
export class HttpAuthInterceptor implements HttpInterceptor {
  constructor(private appConfig: AppConfigService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const apiKey = this.appConfig.apiKey;
    const params = request.params.append('api_key', apiKey);
    const newRequest = request.clone({ params: params });
    return next.handle(newRequest);
  }
}
