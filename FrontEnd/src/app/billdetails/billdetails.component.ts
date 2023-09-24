import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SessionService } from '../session.service';
import { MonthlyBill } from '../monthly-bill';

@Component({
  selector: 'app-billdetails',
  templateUrl: './billdetails.component.html',
  styleUrls: ['./billdetails.component.css']
})
export class BilldetailsComponent implements OnInit {

  bills1: MonthlyBill[] = [];
  bills2: MonthlyBill[] = [];

  customerId:any="";
  selectedBillId!:number;
  selectedAmount!:any;

  constructor(private pay: PaymentService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
   this.customerId=+this.route.snapshot.params['customerId']
   this.processSelectedBills();
   this.PaidBills()
  }

  processSelectedBills(){   
    this.pay.getBillsByCustomerId(this.customerId).subscribe(response =>{
      this.bills1=response;
      console.log(response);

    })
  
  }
  onEdit(bill:MonthlyBill){
    this.selectedBillId=bill.id;
    this.selectedAmount=bill.amount;
    console.log(this.selectedBillId);
    sessionStorage.setItem('selectedBillId', this.selectedBillId.toString());
    sessionStorage.setItem('selectedAmount',this.selectedAmount)
    this.router.navigate(['payment-method',this.selectedBillId])
  }


  PaidBills(){
    this.pay.getPaidBills(this.customerId).subscribe(response=>{
      this.bills2=response;
    })
  }

  
}








