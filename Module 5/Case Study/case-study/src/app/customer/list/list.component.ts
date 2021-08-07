import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {Customer} from '../model/Customer';
import {DeleteComponent} from '../delete/delete.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers: [CustomerService]
})
export class ListComponent implements OnInit {
  customers: Customer[];
  constructor(
    private customerService: CustomerService,
    public dialog: MatDialog

  ) { }

  ngOnInit(): void {
    this.customerService.getCustomer().subscribe(
      (data) => {
        console.log(data);
        this.customers = data;
      }, error => console.log(error)
    );
  }

  openDialogDelete(id: number) {
    const dialogRef = this.dialog.open(DeleteComponent,
      {data: {
          id
        },
        width: '400px'
      }
        );
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
