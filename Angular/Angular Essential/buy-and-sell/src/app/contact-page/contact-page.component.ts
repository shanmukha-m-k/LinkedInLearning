import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { fakeListings } from '../../assets/dummy-data';
import { listings } from '../Model/listings';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contact-page',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './contact-page.component.html',
  styleUrl: './contact-page.component.css',
})
export class ContactPageComponent implements OnInit {
  email: string = '';
  message: string = '';

  listings?: listings;
  constructor(private activatedRoute: ActivatedRoute, private route: Router) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.paramMap.get('id');

    this.listings = fakeListings.find((listings) => listings.id === id);
    this.message = `Hi I'm Interested In your ${this.listings?.name.toLowerCase()}!`;
  }

  sendMessage() {
    alert('Your Message has Been Sent!');
    this.route.navigateByUrl('/listings');
  }
}
