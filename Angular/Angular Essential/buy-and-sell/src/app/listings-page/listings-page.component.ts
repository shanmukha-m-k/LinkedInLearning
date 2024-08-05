import { Component, OnInit } from '@angular/core';
import { listings } from '../Model/listings';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ListingServiceService } from '../Service/listing-service.service';

@Component({
  selector: 'app-listings-page',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './listings-page.component.html',
  styleUrl: './listings-page.component.css',
})
export class ListingsPageComponent implements OnInit {
  listings: listings[] = [];
  constructor(private listingService:ListingServiceService){}

  ngOnInit(): void {
this.listingService.getListing().subscribe(list=>this.listings=list)
  }
}
