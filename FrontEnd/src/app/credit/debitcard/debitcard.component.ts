import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from 'src/app/payment.service';
import { Transaction } from 'src/app/tranaction';

@Component({
  selector: 'app-debitcard',
  templateUrl: './debitcard.component.html',
  styleUrls: ['./debitcard.component.css']
})
export class DebitcardComponent implements OnInit {
  id!:number;
  acc!:string;
  cvv: any ="";
  month: any ="";
  year: any ="";
  errorMessage: string="";
  successMessage: string="";
  transaction!:Transaction;

  constructor(private pay:PaymentService,private route: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    const storedBillId = sessionStorage.getItem('selectedBillId');
    if (storedBillId) {
      this.id = +storedBillId; // Parse as a number
    } else {
    }
    console.log(this.id)
  }

  debitcard(){
    this.pay.checkdebit(this.acc, this.cvv,this.id, this.month, this.year).subscribe(
      (response)=>{
        console.log(response)
        console.log(this.acc)
        this.successMessage = 'Payment successful. Thank you!';
        this.router.navigate(["./invoice"])
        sessionStorage.setItem("id",this.transaction.id.toString());
        sessionStorage.setItem("amount",this.transaction.amount.toString());
      },
      (error: HttpErrorResponse) => {
        console.log("error", error);
        alert(error.message);
      }
    );
  }
  

}
