import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PaymentService } from '../payment.service';
import { UsersData } from '../update-search/update-search.component';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  [x: string]: Object;

  constructor(private paymentService: PaymentService, @Inject(MAT_DIALOG_DATA) public data:UsersData) { }

  ngOnInit(): void {
   
  }

}
