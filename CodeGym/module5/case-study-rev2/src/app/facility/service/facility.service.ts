import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Facility} from '../model/facility';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  urlFacility = 'http://localhost:3000/facility';

  constructor(private httpClient: HttpClient) {
  }

//lấy danh sách dịch vụ
  getAll(): Observable<any> {
    // return this.httpClient.get<Facility[]>(this.urlFacility);
    return this.httpClient.get('http://localhost:8080/facilities');
  }

//Tạo mới dịch vụ
  create(facility: Facility): Observable<Facility> {
    // return this.httpClient.post(this.urlFacility, facility);
    return this.httpClient.post('http://localhost:8080/facilities', facility);
  }

  getById(id: number) {
    // return this.httpClient.get(this.urlFacility + '/' + id);
    return this.httpClient.get('http://localhost:8080/facilities/' + id);
  }

  update(facility: Facility) {
    return this.httpClient.patch('http://localhost:8080/facilities/' + facility.id, facility);
  }

  deleteById(facility: Facility) {
    return this.httpClient.delete('http://localhost:8080/facilities/' + facility.id);
  }

  getListFacility(): Observable<Facility[]> {
    return this.httpClient.get<Facility[]>('http://localhost:8080/facilities/select-list');
  }
}
