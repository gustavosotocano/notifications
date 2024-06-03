import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {NotificationDto} from "../model/notification-dto";
import {Observable} from "rxjs";
import {NotificationResponse} from "../model/notification-response.interface";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private logUrl: string;

  constructor(private http: HttpClient) {
    this.logUrl = 'http://localhost:8090/notifications';
  }

  public save(notification: NotificationDto) {
    return this.http.post<NotificationDto>(this.logUrl+"/v1/send", notification);
  }
  public findAll(size: string,page: string): Observable<NotificationResponse> {

    const headers = new HttpHeaders({
      'GILA-X-SIZE': size,
      'GILA-X-PAGE': page,
    });
    return this.http.get<NotificationResponse>(this.logUrl+"/v1/logs" , {headers});
  }

}
