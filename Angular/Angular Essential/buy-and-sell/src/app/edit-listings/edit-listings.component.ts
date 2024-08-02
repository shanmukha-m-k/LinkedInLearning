import { Component, OnInit } from '@angular/core';
import { ListingDataFormComponent } from '../listing-data-form/listing-data-form.component';
import { ActivatedRoute, Router } from '@angular/router';
import { fakeListings } from '../../assets/dummy-data';
import { listings } from '../Model/listings';

@Component({
  selector: 'app-edit-listings',
  standalone: true,
  imports: [ListingDataFormComponent],
  templateUrl: './edit-listings.component.html',
  styleUrl: './edit-listings.component.css',
})
export class EditListingsComponent implements OnInit {
  listings:listings;
  constructor(private activatedRoute: ActivatedRoute,private router: Router) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.paramMap.get('id');

    this.listings = fakeListings.find((listings) => listings.id === id);
  }
  onSubmit() {
    alert('Saving Changes to the listing!!');
    this.router.navigateByUrl('/my-listings');
  }
}
