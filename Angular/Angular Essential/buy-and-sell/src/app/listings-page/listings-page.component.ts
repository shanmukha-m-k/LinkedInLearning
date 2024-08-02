import { Component, OnInit } from '@angular/core';
import { listings } from '../Model/listings';
import { fakeListings } from '../../assets/dummy-data';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listings-page',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './listings-page.component.html',
  styleUrl: './listings-page.component.css',
})
export class ListingsPageComponent implements OnInit {
  listings: listings[] = [];

  ngOnInit(): void {
    this.listings = fakeListings;
  }
}
