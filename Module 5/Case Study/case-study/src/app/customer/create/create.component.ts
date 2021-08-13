import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';
import {TypeCustomerService} from '../service/TypeCustomerService';
import {TypeCustomer} from '../model/TypeCustomer';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import {Customer} from '../model/Customer';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
  providers: [CustomerService, TypeCustomerService]
})
export class CreateComponent implements OnInit {
  createForm: FormGroup;
  typeCustomers: TypeCustomer[];

  constructor(
    private customerService: CustomerService,
    private typeCustomerService: TypeCustomerService,
    private router: Router
  ) {
    this.typeCustomerService.getTypeCustomer().subscribe(
      (data) => {
        console.log(data);
        this.typeCustomers = data;
        console.log(this.typeCustomers);
      }
    );
  }

  ngOnInit(): void {

    this.createForm = new FormGroup({
      name: new FormControl(null, [
        Validators.required, Validators.minLength(3)]),
      birthDate: new FormControl(null, Validators.required),
      idCard: new FormControl(
        null, [
        Validators.required, Validators.pattern('^[0-9]{10}$')]),
      phone: new FormControl(
        null, [
          Validators.required, Validators.pattern('^(\\+?\d{1,4}[\s-])?(?!0+\s+,?$)\\d{10}\s*,?$')]),
      email: new FormControl(
        null, [
          Validators.required, Validators.email]),
      address: new FormControl(null, Validators.required),
      typeCustomer: new FormControl(null, Validators.required)
    });
  }

  onSubmit(createFormCustomer: FormGroup) {
    console.log(createFormCustomer.value);
    this.customerService.addCustomer(createFormCustomer.value).subscribe(
      (data) => {
        this.router.navigateByUrl('');
      }, error => console.log(error)
    );
  }
}
