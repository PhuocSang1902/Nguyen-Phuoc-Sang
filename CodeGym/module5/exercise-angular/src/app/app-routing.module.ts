import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {YoutubePlaylistComponent} from './youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './youtube-playlist/youtube-player/youtube-player.component';
import {DictionaryComponent} from './dictionary/dictionary.component';
import {DictionaryDetailComponent} from './dictionary/dictionary-detail/dictionary-detail.component';
import {TodoComponent} from './todo/todo.component';

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
  {path: 'product', loadChildren: () => import('./productManager/product.module').then(module => module.ProductModule)},
  {path: 'category', loadChildren: () => import('./category/category/category.module').then(module =>module.CategoryModule)},
  {path: 'todo', component: TodoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
