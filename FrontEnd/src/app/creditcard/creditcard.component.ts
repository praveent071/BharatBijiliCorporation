import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';
import { error } from 'console';
import { ActivatedRoute, Router } from '@angular/router';
import { Transaction } from '../tranaction';

@Component({
  selector: 'app-creditcard',
  templateUrl: './creditcard.component.html',
  styleUrls: ['./creditcard.component.css']
})
export class CreditcardComponent implements OnInit {
  id!: number;
  acc!:string;
  cvv: any ="";
  month: any ="";
  year: any ="";
  errorMessage: string="";
  successMessage: string="";
  transaction!:Transaction;

  constructor(private pay:PaymentService,private route: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
   
    this.id =+this.route.snapshot.params['selectedBillId'];
    console.log(this.id);
  }
  creditcard(){
    this.pay.checkcredit(this.acc, this.cvv,this.id, this.month, this.year).subscribe(
      (response)=>{
        console.log(response)
        console.log(this.acc)
        this.successMessage = 'Payment successful. Thank you!';
        console.log("success");
        this.router.navigate(["./invoice"])
        sessionStorage.setItem("id",this.transaction.id.toString());
        sessionStorage.setItem("amount",this.transaction.amount.toString());

      },
      (error)=>{
        console.log("error",error)
        alert(error.message)
       }
      
    )
  }

}
