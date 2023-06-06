import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  countryList = [
    {id: 1, name: 'India'},
    {id: 2, name: 'USA'},
    {id: 3, name: 'England'}
  ];
  public registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')]],
      passwordGroup: this.formBuilder.group({
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', Validators.required]
      }, {validators: this.comparePassword}),
      country: ['', Validators.required],
      age: ['', [Validators.required, Validators.min(18)]],
      gender: ['', Validators.required],
      phone: ['', [Validators.required, Validators.pattern('^{+84}[0-9]{9}$')]]
    },[Validators.required]);
  }


  get email() {
    return this.registerForm.get('email');
  }

  get password() {
    return this.registerForm.get('passwordGroup')?.get('password');
  }

  get confirmPassword() {
    return this.registerForm.get('passwordGroup')?.get('confirmPassword');
  }

  get age() {
    return this.registerForm.get('age');
  }

  get gender() {
    return this.registerForm.get('gender');
  }

  get phone() {
    return this.registerForm.get('phone');
  }

  get country() {
    return this.registerForm.get('country');
  }

  ngOnInit(): void {
  }

  comparePassword(c: any) {
    return (c?.controls.password?.value === c?.controls.confirmPassword?.value) ? null : {'duplicated': true};
  }

  submitForm() {
    console.log(this.registerForm.controls.passwordGroup);
    console.log(this.registerForm);
  }
}
