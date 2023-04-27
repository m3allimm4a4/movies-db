import { Injectable } from '@angular/core';
import { AppConfig } from './app-config.interface';

@Injectable({
  providedIn: 'root',
})
export class AppConfigService {
  private appConfig: AppConfig = { apiUrl: '', apiKey: '' };

  public setAppConfig(appConfig: AppConfig) {
    this.appConfig = appConfig;
  }

  public getAppConfig() {
    return { ...this.appConfig };
  }
}
