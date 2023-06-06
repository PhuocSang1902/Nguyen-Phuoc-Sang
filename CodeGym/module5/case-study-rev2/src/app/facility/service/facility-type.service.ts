import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Facility} from '../model/facility';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FacilityTypeService {
  urlFacilityType = 'http://localhost:3000/facility-type';

  constructor(private httpClient: HttpClient) {
  }

  //lấy danh sách loại dịch vụ
  getAll(): Observable<Facility[]> {
    // return this.httpClient.get<Facility[]>(this.urlFacilityType);
    return this.httpClient.get<Facility[]>('http://localhost:8080/facility-types');
  }
}
