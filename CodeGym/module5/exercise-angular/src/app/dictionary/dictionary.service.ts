import {Injectable} from '@angular/core';
import {Dictionary} from './dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaryList: Dictionary[]
  constructor() {
    this.dictionaryList= [
    {id: 'dog', name: 'con chó'},
    {id: 'cat', name: 'con mèo'},
    {id: 'bird', name: 'con chim'},
    {id: 'fish', name: 'con cá'},
    {id: 'rabbit', name: 'con thỏ'},
    {id: 'tiger', name: 'con hổ'}
  ];

  }

  findById(id: string):null|Dictionary {
    let dictionaries = this.dictionaryList.filter(element => element.id === id)
    if (dictionaries.length === 0){
      return null;
    }else {
      return dictionaries[0];
    }
  }

}
