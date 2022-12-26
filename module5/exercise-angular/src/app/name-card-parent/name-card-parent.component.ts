import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-name-card-parent',
  templateUrl: './name-card-parent.component.html',
  styleUrls: ['./name-card-parent.component.css']
})
export class NameCardParentComponent implements OnInit {

  cardNameParent: string = 'Professional Dev';
  emailParent: string = 'prodev@codegym.vn';
  phoneParent: string = '0123456789';
  constructor() {
  }

  ngOnInit(): void {
  }

}
