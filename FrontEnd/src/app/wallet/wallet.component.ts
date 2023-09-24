import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';
import * as e from 'cors';
import { ActivatedRoute, Router } from '@angular/router';
import { Transaction } from '../tranaction';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {
  id!:number;
  walletId: string="";
  walletName: string="";
  errorMessage!: string;
  successMessage!: string;

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
  wallet(){
    this.pay.checkwallet(this.id,this.walletId,this.walletName).subscribe(
      (response)=>{
        console.log(response)
        this.transaction = response;
        this.successMessage = 'Payment successful. Thank you!';
        this.router.navigate(["./invoice"])
        sessionStorage.setItem("id",this.transaction.id.toString());
        sessionStorage.setItem("amount",this.transaction.amount.toString());

      },
      (error)=>{
        console.log('Error:', error);
        alert(error.message)
      }
    )
  }

}
