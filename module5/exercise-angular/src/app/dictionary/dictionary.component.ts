import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DictionaryService} from './dictionary.service';
import {Dictionary} from './dictionary';

@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {
  dictionaryList: Dictionary[];

  constructor(private dictionaryService: DictionaryService) {
    this.dictionaryList = this.dictionaryService.dictionaryList;
  }

  ngOnInit(): void {
  }


}
