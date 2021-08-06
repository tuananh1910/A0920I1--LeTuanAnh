import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {Customer} from '../model/Customer';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers: [CustomerService]
})
export class ListComponent implements OnInit {
  customers: Customer[];
  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.customerService.getCustomer().subscribe(
      (data) => {
        this.customers = data;
      }, error => console.log(error)
    );
  }

}
