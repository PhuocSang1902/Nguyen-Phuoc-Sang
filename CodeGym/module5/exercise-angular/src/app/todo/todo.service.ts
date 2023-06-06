import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Todo} from './todo';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  urlStudent = "http://localhost:3000/toDos"
  constructor(private httpClient: HttpClient) { }
  getAll(){
    return this.httpClient.get<Todo[]>(this.urlStudent);
  }

  deleteTodo(id: number|undefined) : Observable<Todo> {
    return this.httpClient.delete(this.urlStudent+'/'+ id);
  }
}
