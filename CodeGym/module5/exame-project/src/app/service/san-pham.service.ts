import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {LoHang} from '../model/lo-hang';
import {SanPham} from '../model/san-pham';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SanPhamService {

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<SanPham[]> {
    return this.httpClient.get<SanPham[]>('http://localhost:8080/san-pham');
  }
}
