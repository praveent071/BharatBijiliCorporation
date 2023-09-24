import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PaymentService } from '../payment.service';
import { HttpClient } from '@angular/common/http';
import { SessionService } from '../session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  customerId: string ="";
  otp: string ="";
  randomFourDigitNumber!: number;
  otpd: boolean=true;
matchopt:boolean=false;
  constructor(private pay: PaymentService,private router:Router,private sessionService: SessionService) { }
  
  ngOnInit(): void {
    document.body.className="bg-image";
    this.login()

  }
  generateOtp() {
    this.randomFourDigitNumber = Math.floor(1000 + Math.random() * 9000);
    alert(this.randomFourDigitNumber);
    this.otpd = false;
  } 
  login() {
    if(this.otp===this.randomFourDigitNumber.toString()){
      this.pay.getlogin(this.customerId)
      .subscribe(response => {
        if(response!=null){
          this.matchopt=true;
          this.router.navigate(['./bill',this.customerId]);
        }
      });
     }
  }
}
