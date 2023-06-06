import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-facility-create-form',
  templateUrl: './facility-create-form.component.html',
  styleUrls: ['./facility-create-form.component.css']
})
export class FacilityCreateFormComponent implements OnInit {
  facilityForm: FormGroup = new FormGroup({});
  regexNumber: RegExp = /[0-9]*/;
  constructor(private formBuilder: FormBuilder) {
    this.facilityForm = formBuilder.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required]],
      area: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      cost: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      maxPeople: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      facilityType: ['', [Validators.required]],
      rentType: ['', [Validators.required]]
    })
  }

  ngOnInit(): void {
  }

  submitFacility() {

  }
}
