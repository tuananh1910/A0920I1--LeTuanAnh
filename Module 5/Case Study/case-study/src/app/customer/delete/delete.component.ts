import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from '../service/CustomerService';
import {Router} from '@angular/router';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  id: number;
  constructor(
    private customerService: CustomerService,
    private router: Router,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.id = data.id;
  }

  ngOnInit(): void {
  }

  onSubmit(id: any) {
    console.log(id);
    this.customerService.deleteCustomer(id).subscribe(
      (data) => {
        this.router.navigateByUrl('');
      }, error => console.log(error)

    );
  }
}
