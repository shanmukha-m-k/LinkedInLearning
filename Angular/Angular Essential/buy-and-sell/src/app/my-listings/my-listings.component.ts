import { Component, OnInit } from '@angular/core';
import { fakeListings } from '../../assets/dummy-data';
import { listings } from '../Model/listings';
import {  RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-my-listings',
  standalone: true,
  imports: [RouterLink,CommonModule],
  templateUrl: './my-listings.component.html',
  styleUrl: './my-listings.component.css'
})
export class MyListingsComponent implements OnInit {

  listings :listings[] = [];
  
  ngOnInit(): void {
    this.listings = fakeListings;
  }
  onDelete(listingId:string){
    alert(`Deleting Your Listing Id ${listingId}`)
  }
}
