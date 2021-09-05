import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';
import {TypeCustomerService} from '../service/TypeCustomerService';
import {CustomerType} from '../model/CustomerType';
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
  customerTypes: CustomerType[];

  constructor(
    private customerService: CustomerService,
    private typeCustomerService: TypeCustomerService,
    private router: Router
  ) {
    this.typeCustomerService.getTypeCustomer().subscribe(
      (data) => {
        console.log(data);
        this.customerTypes = data;
        console.log(this.customerTypes);
      }
    );
  }

  ngOnInit(): void {

    this.createForm = new FormGroup({
      id: new FormControl(null, [Validators.required, Validators.pattern('KH-\\d{4}')]),
      name: new FormControl(null, [
        Validators.required, Validators.minLength(3)]),
      birthday: new FormControl(null, Validators.required),
      idCard: new FormControl(
        null, [
        Validators.required, Validators.pattern('^[0-9]{10}$')]),
      phone: new FormControl(
        null, [
          Validators.required, Validators.pattern('^(\\+?\d{1,4}[\s-])?(?!0+\s+,?$)\\d{10}\s*,?$')]),
      gender: new FormControl(null, Validators.required),
      email: new FormControl(
        null, [
          Validators.required, Validators.email]),
      address: new FormControl(null, Validators.required),
      customerType: new FormControl(null, Validators.required)
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
