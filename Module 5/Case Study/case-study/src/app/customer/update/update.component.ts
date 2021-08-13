import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {TypeCustomerService} from '../service/TypeCustomerService';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';
import {TypeCustomer} from '../model/TypeCustomer';
import {Customer} from '../model/Customer';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
  providers: [CustomerService, TypeCustomerService]
})
export class UpdateComponent implements OnInit {
  updateForm = new FormGroup({
    id: new FormControl(),
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
          // this.updateForm = new FormGroup({
          //   id: new FormControl(this.editCustomer.id),
          //   name: new FormControl(this.editCustomer.name),
          //   birthDate: new FormControl(this.editCustomer.birthDate),
          //   idCard: new FormControl(this.editCustomer.idCard),
          //   phone: new FormControl(this.editCustomer.phone),
          //   email: new FormControl(this.editCustomer.email),
          //   address: new FormControl(this.editCustomer.address),
          //   typeCustomer: new FormControl(this.editCustomer.typeCustomer.nameTypeCustomer)
          // });
          this.updateForm.setValue(data);
        }
      );
      this.typeCustomerService.getTypeCustomer().subscribe(
        (data) => {
          this.typeCustomers = data;
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
