import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { listings } from '../Model/listings';
import { fakeListings, fakeMyListings } from '../../assets/dummy-data';
import { CommonModule } from '@angular/common';
import { ListingServiceService } from '../Service/listing-service.service';

@Component({
  selector: 'app-listings-details',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './listings-details.component.html',
  styleUrl: './listings-details.component.css',
})
export class ListingsDetailsComponent implements OnInit {
  listings?: listings;
  constructor(private activatedRoute: ActivatedRoute,private listingService:ListingServiceService) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    this.listingService.getListingById(id).subscribe(
      listing=>{
        this.listings=listing;
      });

  }
}
