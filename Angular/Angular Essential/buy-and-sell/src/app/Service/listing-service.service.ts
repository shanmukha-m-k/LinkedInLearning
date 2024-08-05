import { Injectable } from '@angular/core';
import { listings } from '../Model/listings';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListingServiceService {
  constructor(private _http:HttpClient) { }
  getListing():Observable<listings[]>{
    return this._http.get<listings[]>('http://localhost:8080/api/findAllStudents');
  }
}
