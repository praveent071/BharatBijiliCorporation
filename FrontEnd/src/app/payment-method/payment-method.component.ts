import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-payment-method',
  templateUrl: './payment-method.component.html',
  styleUrls: ['./payment-method.component.css']
})
export class PaymentMethodComponent implements OnInit {
  paymentAmount: any='';
  selectedBillId!: number;
  constructor(private pay: PaymentService,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.paymentAmount=sessionStorage.getItem("selectedAmount")
    this.selectedBillId =+this.route.snapshot.params['selectedBillId'];
    console.log(this.selectedBillId);
      
  
   
  }
  
  payWithCreditCard(){
    this.router.navigate(['/credit',this.selectedBillId])
  }
  payWithDebitCard(){
    this.router.navigate(['./debit',this.selectedBillId])
  }
  payWithWallet(){
    this.router.navigate(['./wallet',this.selectedBillId])
  }

    
  
}
