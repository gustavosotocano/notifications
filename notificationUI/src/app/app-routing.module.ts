import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientFormComponent } from './client-form/client-form.component';
import {  ListpaginationComponent } from './listpagination/listpagination.component';

const routes: Routes = [

  { path: 'logs', component: ListpaginationComponent },
  { path: 'clients', component: ClientFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
