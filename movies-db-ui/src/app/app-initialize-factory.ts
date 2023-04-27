import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { AppConfig } from './app-config-service/app-config.interface';
import { AppConfigService } from './app-config-service/app-config.service';

export function appInitializeFactory(
  httpClient: HttpClient,
  appConfigService: AppConfigService
): () => Observable<AppConfig> {
  return () =>
    httpClient
      .get<AppConfig>('./assets/configuration/config.json')
      .pipe(tap(config => appConfigService.setAppConfig(config)));
}
