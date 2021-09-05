import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {TypeCustomerService} from '../service/TypeCustomerService';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../model/CustomerType';
import {Customer} from '../model/Customer';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
  providers: [CustomerService, TypeCustomerService]
})
export class UpdateComponent implements OnInit {
  updateForm = new FormGroup({
    id: new FormControl(null),
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
  customerTypes: CustomerType[];
  editCustomer: Customer;
  id: string;
  constructor(
    private customerService: CustomerService,
    private typeCustomerService: TypeCustomerService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap)  => {
      console.log('param' + paramMap.get('id'));
      this.id = (paramMap.get('id'));
      this.customerService.findCustomerById(this.id).subscribe(
        (data) => {
          this.editCustomer = data;
          console.log(this.editCustomer);
          this.updateForm.setValue(data);
        }
      );
      this.typeCustomerService.getTypeCustomer().subscribe(
        (data) => {
          this.customerTypes = data;
        }
      );
    });
  }

  onSubmit(updateForm: FormGroup) {
    this.customerService.updateCustomer(updateForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl('');
      }, error => console.log(error)
    );
  }
}
