import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {TokenService} from "../../service/token.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  checkLogin = false;
  name: string | null | undefined;
  roles: string[] = [];
  idAccount: string | null | undefined;

  constructor(private tokenService: TokenService,
              private router: Router,
  ) {
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.checkLogin = true;
      this.name = this.tokenService.getName();
      this.roles = this.tokenService.getRole();
      this.idAccount = this.tokenService.getId();
    }
  }
  logOut(): void {
    window.localStorage.clear();
    this.router.navigateByUrl('/').then(() => {
      location.reload();
    });
  }

}
