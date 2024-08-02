import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ListingDataFormComponent } from '../listing-data-form/listing-data-form.component';

@Component({
  selector: 'app-new-listings',
  standalone: true,
  imports: [ListingDataFormComponent],
  templateUrl: './new-listings.component.html',
  styleUrl: './new-listings.component.css',
})
export class NewListingsComponent implements OnInit {
  constructor(private router: Router) { }

  ngOnInit(): void { }
  onSubmit() {
    alert('Creating new listing!!');
    this.router.navigateByUrl('/my-listings');
  }
}
