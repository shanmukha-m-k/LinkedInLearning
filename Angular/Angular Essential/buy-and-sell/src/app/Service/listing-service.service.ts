import { Injectable } from '@angular/core';
import { listings } from '../Model/listings';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers:new HttpHeaders({
    'Content-Type':'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})

export class ListingServiceService {



  url: String = "http://localhost:8080"
  constructor(private _http: HttpClient) { }

  getAllListing(): Observable<listings[]> {
    return this._http.get<listings[]>(`${this.url}/api/findAllListings`);
  }

  getListingById(id:String): Observable<listings> {
    return this._http.get<listings>(`${this.url}/api/findAllListings/${id}`);
  }
  // addViewListings(id:String): Observable<listings> {
  //   return this._http.post<listings>(`${this.url}/api/findAllListings/${id}/add-view`,{},httpOptions);
  // }

  deleteListingById(id:String): Observable<listings> {
    return this._http.delete<listings>(`${this.url}/api/listings/${id}`);
  }
  createListing(itemName:String,itemDescription:String,itemPrice:number){
    return this._http.post<listings>(`${this.url}/api/listings`,{itemName,itemDescription,itemPrice},httpOptions,);
  }
}
