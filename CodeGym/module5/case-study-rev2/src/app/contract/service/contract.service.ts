import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Contract} from '../model/contract';
import {Customer} from '../../customer/model/customer';
import {ContractDetail} from '../model/contract-detail';
import {AttachFacility} from '../model/attach-facility';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor(private httpClient: HttpClient) {
  }

  getAll(page: number): Observable<any> {
    // return this.httpClient.get(this.urlCustomer);
    return this.httpClient.get('http://localhost:8080/contracts?page=' + page);
  }

  getAllBySearch(page: number, search: string): Observable<any> {
    // return this.httpClient.get(this.urlCustomer);
    return this.httpClient.get('http://localhost:8080/contracts/search/' + search + '?page=' + page);
  }

  create(value: Contract): Observable<Customer> {
    return this.httpClient.post('http://localhost:8080/contracts', value);
  }

  findContractDetailById(contract: Contract): Observable<ContractDetail[]> {
    return this.httpClient.get<ContractDetail[]>('http://localhost:8080/contract-details/' + contract.id);
  }
  getAllAttachFacility(): Observable<AttachFacility[]> {
    return this.httpClient.get<AttachFacility[]>('http://localhost:8080/attach-facilities');
  }

  addContractDetail(contractDetail: ContractDetail) {
    return this.httpClient.post('http://localhost:8080/contract-details', contractDetail);
  }
}
