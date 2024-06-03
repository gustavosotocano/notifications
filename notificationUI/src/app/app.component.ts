import {Component} from '@angular/core';

import {ActivatedRoute, Router} from "@angular/router";

import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;

  constructor(private dialog: MatDialog, private route: ActivatedRoute,
               private router: Router) {


    this.title = 'Notifications';
  }

}
