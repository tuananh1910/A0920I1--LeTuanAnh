import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {FormArray, FormControl, FormGroup} from '@angular/forms';
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
      name: new FormControl(),
      date: new FormControl(),
      idCard: new FormControl(),
      phone: new FormControl(),
      email: new FormControl(),
      address: new FormControl(),
      typeCustomer: new FormArray([])
    });
  }

  onSubmit(createFormCustomer: FormGroup) {
    console.log(createFormCustomer);
    this.customerService.addCustomer(createFormCustomer.value).subscribe(
        (data) => {
          this.router.navigateByUrl('');
        }, error => console.log(error)
      );
  }
}
