import {Component, OnInit} from '@angular/core';

import {NotificationService} from '../service/notification.service'

@Component({
  selector: 'list-pagination-component',
  templateUrl: './listpagination.component.html',
  styleUrls: ['./listpagination.component.css']
})
export class ListpaginationComponent implements OnInit {
  logs: any[] = [];
  pageIndex = 1;
  pageSize = 5;
  totalCount = 0;
  pages: number = 0;


  constructor(private notificationService: NotificationService) {}

  ngOnInit() {
    this.loadData();
  }
  private loadData() {
    this.notificationService.findAll(this.pageSize.toString(),(this.pageIndex-1).toString())
      .subscribe(data => {
      this.logs = data.content;
      this.totalCount= data.totalElements;

    });
  }

  handlePageChange(event: number): void {
    console.log(event)
    this.pageIndex = event;
    this.loadData();
  }





}
