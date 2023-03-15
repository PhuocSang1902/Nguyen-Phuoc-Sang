import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {SignInForm} from "../common/entity/sign-in-form";
import {JwtResponse} from "../common/entity/jwt-response";
import {Customer} from "../customer/entity/customer";

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  private API_SIGNIN = 'http://localhost:8080/api/public/signin';
  private API_SIGNUP = 'http://localhost:8080/api/public/signup';

  constructor(private httpClient: HttpClient) {
  }

  signIn(signInForm: SignInForm): Observable<any> {
    return this.httpClient.post<JwtResponse>(this.API_SIGNIN, signInForm);
  }
  signUp(customer: Customer): Observable<any> {
    return this.httpClient.post<JwtResponse>(this.API_SIGNUP, customer);
  }
}
