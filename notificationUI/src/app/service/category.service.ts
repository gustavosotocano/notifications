import { Injectable } from '@angular/core';
// @ts-ignore
import { Observable } from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {CategoryDto} from "../model/category-dto";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private categoryUrl: string;
  constructor(private http: HttpClient) {
    this.categoryUrl = 'http://localhost:8090';
  }
  public findAll(): Observable<CategoryDto[]> {
    return this.http.get<CategoryDto[]>(this.categoryUrl+"/v1/categories");
  }
}
