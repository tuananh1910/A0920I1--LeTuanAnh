import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {TypeCustomerService} from '../service/TypeCustomerService';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormArray, FormControl, FormGroup} from '@angular/forms';
import {TypeCustomer} from '../model/TypeCustomer';
import {Customer} from '../model/Customer';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
  providers: [CustomerService, TypeCustomerService]
})
export class UpdateComponent implements OnInit {
  updateForm: FormGroup;
  typeCustomers: TypeCustomer[];
  editCustomer: Customer;
  id: number;
  constructor(
    private customerService: CustomerService,
    private typeCustomerService: TypeCustomerService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap)  => {
      console.log('param' + paramMap.get('id'));
      this.id = Number(paramMap.get('id'));
      console.log(this.id);
      this.customerService.findCustomerById(this.id).subscribe(
        (data) => {
          this.editCustomer = data;
          console.log(this.editCustomer);
          this.updateForm = new FormGroup({
            id: new FormControl(this.editCustomer.id),
            name: new FormControl(this.editCustomer.name),
            date: new FormControl(),
            idCard: new FormControl(this.editCustomer.idCard),
            phone: new FormControl(this.editCustomer.phone),
            email: new FormControl(this.editCustomer.email),
            address: new FormControl(this.editCustomer.address),
            typeCustomer: new FormArray([])
          });
        }
      );
      this.typeCustomerService.getTypeCustomer().subscribe(
        (data) => {
          this.typeCustomers = data;
        }
      );
    });
    // this.updateForm.patchValue({
    //   id: this.editCustomer.id,
    //   name: this.editCustomer.name,
    //   date: this.editCustomer.birthDate
    // });
  }

  onSubmit(updateForm: FormGroup) {
    this.customerService.updateCustomer(updateForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl('');
      }, error => console.log(error)
    );
  }
}
