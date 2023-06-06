import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoHang} from '../model/lo-hang';

@Injectable({
  providedIn: 'root'
})
export class LoHangService {
  urlLoHang = 'http://localhost:8080/lo-hang';

  constructor(private httpClient: HttpClient) {
  }

  getAllLoHang(page: number): Observable<any> {
    return this.httpClient.get<any>(this.urlLoHang + '?page=' + page);
  }

  createLoHang(loHang: LoHang): Observable<LoHang> {
    return this.httpClient.post(this.urlLoHang, loHang);
  }

  deleteLoHang(loHang: LoHang): Observable<LoHang> {
    return this.httpClient.delete(this.urlLoHang + '/' + loHang.idLoHang);
  }


  searchLoHang(name: any, ngayHetHan: any): Observable<LoHang[]> {
    return this.httpClient.get<LoHang[]>(this.urlLoHang + '?ma_like=' + name + '&ngayHetHang_like=' + ngayHetHan);
  }

  getById(loHang: LoHang): Observable<LoHang>  {
    return this.httpClient.get(this.urlLoHang + '/' + loHang.idLoHang)
  }

  editLoHang(loHang: LoHang) {
    return this.httpClient.patch(this.urlLoHang, loHang);
  }
}
