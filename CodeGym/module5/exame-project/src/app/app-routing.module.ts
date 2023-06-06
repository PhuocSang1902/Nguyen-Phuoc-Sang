import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoHangComponent} from './lo-hang/lo-hang.component';
import {LoHangCreateComponent} from './lo-hang-create/lo-hang-create.component';

const routes: Routes = [
  {path: '', component: LoHangComponent},
  {path: 'lo-hang/create', component: LoHangCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
