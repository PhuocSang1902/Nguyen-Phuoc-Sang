import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {YoutubePlaylistComponent} from './youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './youtube-playlist/youtube-player/youtube-player.component';
import {DictionaryComponent} from './dictionary/dictionary.component';
import {DictionaryDetailComponent} from './dictionary/dictionary-detail/dictionary-detail.component';
import {ProductListComponent} from './productManager/product-list/product-list.component';
import {ProductCreateComponent} from './productManager/product-create/product-create.component';
import {ProductEditComponent} from './productManager/product-edit/product-edit.component';

const routes: Routes = [
  {
    path: 'youtube', component: YoutubePlaylistComponent, children: [
      {path: ':id', component: YoutubePlayerComponent}
    ]
  },
  {
    path: 'dictionary', component: DictionaryComponent, children: [
      {path: 'detail/:id', component: DictionaryDetailComponent}
    ]
  },
  {path:'product/list', component:ProductListComponent},
  {path:'product/create', component:ProductCreateComponent},
  {path:'product/edit/:id', component:ProductEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
