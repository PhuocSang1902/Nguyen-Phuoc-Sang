import {Component, OnInit} from '@angular/core';
import {ContractService} from '../service/contract.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Contract} from '../model/contract';
import {ContractDetail} from '../model/contract-detail';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  formSearch: FormGroup;
  temp: ContractDetail[] = [];
  contracts: Contract[] = [];
  page: number = 0;
  totalPage: number = 0;
  size: number = 0;
  contractTemp: Contract = {};

  constructor(private contractService: ContractService, private fb: FormBuilder) {
    this.formSearch = this.fb.group({
      search: ['']
    });
    this.getAll(this.page, this.formSearch.controls.search.value);
  }

  ngOnInit(): void {
  }

  // lấy danh sách hợp đồng
  getAll(page: number, search: string): void {
    if (search !== '') {
      this.contractService.getAllBySearch(this.page, search).subscribe(data => {
        this.contracts = data['content'];
        this.totalPage = data['totalPages'];
        this.page = data.pageable['pageNumber'];
        this.size = data['size'];
      }, error => {
      }, () => {
      });
    } else {
      this.contractService.getAll(this.page).subscribe(data => {
        this.contracts = data['content'];
        this.totalPage = data['totalPages'];
        this.page = data.pageable['pageNumber'];
        this.size = data['size'];
      }, error => {
      }, () => {
      });
    }
  }

  //Tới trang sau
  nextPage() {
    if (this.page < this.totalPage - 1) {
      this.page = this.page + 1;
      this.getAll(this.page, this.formSearch.controls.search.value);
    }
  }

  //Quay lại trang trước  nextPage() {
  previousPage() {
    if (this.page > 0) {
      this.page = this.page - 1;
      this.getAll(this.page, this.formSearch.controls.search.value);
    }
  }

  findContractDetail(item: Contract) {
    this.contractService.findContractDetailById(item).subscribe(data => {
      this.temp = data;
    }, error => {
    }, () => {
    });
  }


  //load lại list
  reloadList() {
    this.getAll(this.page, this.formSearch.controls.search.value);
  }

}
