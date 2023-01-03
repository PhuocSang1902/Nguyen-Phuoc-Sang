import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Facility} from '../model/facility';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RentTypeService {
  urlRentType = 'http://localhost:3000/rent-type';

  constructor(private httpClient: HttpClient) {
  }

  //lấy danh sách kiểu thuê
  getAll(): Observable<Facility[]> {
    // return this.httpClient.get<Facility[]>(this.urlRentType);
    return this.httpClient.get<Facility[]>('http://localhost:8080/rent-types');
  }
}
