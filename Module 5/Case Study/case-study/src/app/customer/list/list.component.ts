import {Component, OnInit, ViewChild} from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {Customer} from '../model/Customer';
import {DeleteComponent} from '../delete/delete.component';
import {MatDialog} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {FormGroup} from '@angular/forms';
import {ChartModule, CategoryService, LineSeriesService} from '@syncfusion/ej2-angular-charts';
// import {Chart} from 'chart.js';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers: [CustomerService, LineSeriesService, CategoryService]
})
export class ListComponent implements OnInit {
  customers: Customer[];
  searchContact: string;
  page = 1;
  // @ViewChild(MatPaginator) paginator: MatPaginator;
  // customerMatTable: MatTableDataSource<Customer>;
  dataChart: number;
  // tslint:disable-next-line:ban-types
  xAxis: Object;
  constructor(
    private customerService: CustomerService,
    public dialog: MatDialog
  ) {
    this.dataChart = 100;
    this.xAxis = {
      valueType: 'Category'
    };
  }

  ngOnInit(): void {
    this.customerService.getCustomer().subscribe(
      (data) => {
        console.log(data);
        this.customers = data;
        // this.customerMatTable = new MatTableDataSource<Customer>(data);
        // this.customerMatTable.paginator = this.paginator;
      }, error => console.log(error)
    );
  }

  openDialogDelete(id: string) {
    const dialogRef = this.dialog.open(DeleteComponent,
      {
        data: {
          id
        },
        width: '400px'
      }
    );
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      this.ngOnInit();
    });
  }

  onSearchClear() {
    this.searchContact = '';
    this.ngOnInit();
  }

  search() {
    this.customerService.searchCustomer(this.searchContact).subscribe(
      (data) => {
        this.customers = data;
        console.log(data);
        console.log(this.customers);
      }, error => console.log(error)
    );
    // this.customerMatTable.filter = this.searchContact.trim().toLowerCase();
  }

  voiceSearch() {

  }
}
