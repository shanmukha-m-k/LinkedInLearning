import { Routes } from '@angular/router';
import { ListingsPageComponent } from './listings-page/listings-page.component';
import { ListingsDetailsComponent } from './listings-details/listings-details.component';
import { ContactPageComponent } from './contact-page/contact-page.component';
import { EditListingsComponent } from './edit-listings/edit-listings.component';
import { MyListingsComponent } from './my-listings/my-listings.component';
import { NewListingsComponent } from './new-listings/new-listings.component';

export const routes: Routes = [
    {path:'',redirectTo:'/listings',pathMatch:'full'},
    {path:'listings',component:ListingsPageComponent,pathMatch:"full"},
    {path:'listings/:id',component:ListingsDetailsComponent},
    {path:'contact/:id',component:ContactPageComponent},
    {path:'edit-listings/:id',component:EditListingsComponent},
    {path:'my-listings',component:MyListingsComponent},
    {path:'new-listings',component:NewListingsComponent}




];
