import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, forkJoin, of, switchMap, tap } from 'rxjs';
import { AppConfig } from './models/app-config.interface';
import { AppConfigService } from './services/app-config-service/app-config.service';
import { ImagesConfig } from './models/app-image-config';

export function appInitializeFactory(
  httpClient: HttpClient,
  appConfigService: AppConfigService
): () => Observable<[AppConfig, ImagesConfig]> {
  return () =>
    httpClient.get<AppConfig>('./assets/configuration/config.json').pipe(
      switchMap(appConfig => {
        const params = new HttpParams().append('api_key', appConfig.apiKey);
        return forkJoin([
          of(appConfig),
          httpClient.get<ImagesConfig>(`${appConfig.apiUrl}/configuration`, { params: params }),
        ]);
      }),
      tap(([appConfig, imagesConfig]) => {
        appConfigService.setAppConfig(appConfig, imagesConfig);
      })
    );
}
