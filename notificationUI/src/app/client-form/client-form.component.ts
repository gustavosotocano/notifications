import { Component } from '@angular/core';
import {CategoryDto} from "../model/category-dto";
import {CategoryService} from "../service/category.service";
import { NotificationService } from '../service/notification.service';
import {NotificationDto} from "../model/notification-dto";

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {
  notificationDto: NotificationDto;
  categoryDtos!: CategoryDto[];
  response:boolean ;
  constructor(
    private notificationService: NotificationService,
    private categoryService: CategoryService,

    ) {
    this.notificationDto = new NotificationDto();
    this.response=false;
  }

  ngOnInit() {
    this.callService();
  }

  callService(){

    this.categoryService.findAll().subscribe((data: CategoryDto[] ) => {
      this.categoryDtos = data;
    });
  }

  onSubmit() {
    this.notificationService.save(this.notificationDto)
      .subscribe(result => {
        this.response=true;
        this.notificationDto=new NotificationDto();
      }, error => {
        console.error(error);
      });
  }



}
