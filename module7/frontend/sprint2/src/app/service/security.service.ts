import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {SignInForm} from "../common/entity/sign-in-form";
import {JwtResponse} from "../common/entity/jwt-response";

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  private API_SIGNIN = 'http://localhost:8080/api/public/signin';

  constructor(private httpClient: HttpClient) {
  }

  signIn(signInForm: SignInForm): Observable<any> {
    return this.httpClient.post<JwtResponse>(this.API_SIGNIN, signInForm);
  }
}
