import { Injectable } from '@angular/core';
import { AppConfig } from 'src/app/models/app-config.interface';
import { ImagesConfig } from 'src/app/models/app-image-config';

@Injectable({
  providedIn: 'root',
})
export class AppConfigService {
  private _apiUrl = '';
  private _apiKey = '';
  private _imagesConfig: ImagesConfig = {} as ImagesConfig;

  public setAppConfig(appConfig: AppConfig, imagesBaseUrl: ImagesConfig) {
    this._apiUrl = appConfig.apiUrl;
    this._apiKey = appConfig.apiKey;
    this._imagesConfig = imagesBaseUrl;
  }

  public get apiUrl() {
    return this._apiUrl;
  }

  public get apiKey() {
    return this._apiKey;
  }

  public getImageUrl(imageFilePath: string | null): string {
    if (!imageFilePath) {
      return '';
    }
    return `${this._imagesConfig.images.secure_base_url}/${this._imagesConfig.images.backdrop_sizes[0]}${imageFilePath}`;
  }
}
