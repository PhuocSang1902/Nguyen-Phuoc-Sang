import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {ToastrService} from "ngx-toastr";
import {TokenService} from "../service/token.service";

@Injectable({
  providedIn: 'root'
})
export class AdminUserGuard implements CanActivate {
  constructor(private tokenService: TokenService,
              private toast: ToastrService,
              private router: Router
  ) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.tokenService.getToken()) {
      if (JSON.stringify(this.tokenService.getRole()) === JSON.stringify(['ROLE_ADMIN'])) {
        return true;
      }else if (JSON.stringify(this.tokenService.getRole()) === JSON.stringify(['ROLE_USER'])){return true}else {
        this.toast.warning('Bạn không đủ quyền, vui lòng đăng nhập để tiếp tục.', 'Thông báo');
        this.router.navigateByUrl('');
        return false;
      }
    } else {
      this.router.navigateByUrl('');
      return false;
    }
  }
}
