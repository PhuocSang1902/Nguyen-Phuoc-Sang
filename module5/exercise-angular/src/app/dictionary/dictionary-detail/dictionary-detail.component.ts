import {Component, OnInit} from '@angular/core';
import {DictionaryService} from '../dictionary.service';
import {ActivatedRoute} from '@angular/router';
import {Dictionary} from '../dictionary';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  dictionaryDetail: null | Dictionary = {id:'',name:''};

  constructor(private dictionaryService: DictionaryService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(data => {
      let id = data.get('id');
      if (id != null) {
        this.dictionaryDetail = this.dictionaryService.findById(id);
      }

    }, error => {

    }, () => {
    });
  }

  ngOnInit(): void {
  }

}
