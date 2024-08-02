import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { listings } from '../Model/listings';

@Component({
  selector: 'app-listing-data-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './listing-data-form.component.html',
  styleUrl: './listing-data-form.component.css',
})
export class ListingDataFormComponent implements OnInit {
  @Input() buttonText: any;
  @Input() currentName =' ';
  @Input() currentDesc =' ';
  @Input() currentPrice;


  name: string = '';
  description: string = '';
  price: number;

  @Output() onSubmit = new EventEmitter<listings>();

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.name=this.currentName;
    this.description=this.currentDesc;
    this.price = this.currentPrice;
  }
  onButtonClicked() {
    this.onSubmit.emit({
      id: '',
      name: this.name,
      description: this.description,
      price: Number(this.price),
    });
  }
}
