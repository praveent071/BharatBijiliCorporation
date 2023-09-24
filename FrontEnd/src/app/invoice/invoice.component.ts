import { Component, OnInit } from '@angular/core';
import { PdfseviseService } from '../pdfsevise.service';
import { PaymentService } from '../payment.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {
  paymentAmount: any='';
  ReferenceNumber: string = '';
  localDate: string = '';
  transaction: any;
  id!: any;
  paymentmethod!:any;
  constructor(private pdfService: PdfseviseService,private paymentService: PaymentService,private route: ActivatedRoute,private pay:PaymentService) { }

  ngOnInit(): void {
   this.id = sessionStorage.getItem('id');
   this.paymentAmount=sessionStorage.getItem("amount");
  }
  downloadReceipt(){
      const receiptData = {
        paymentAmount: this.paymentAmount,
        ReferenceNumber : this.generateRandomReferenceNumber(8),
        tid : this.id,
        amount : this.paymentAmount,

      };
      console.log('Receipt Data:', receiptData);
      this.pdfService.generatePdf(receiptData);
  
}
logout(){
 
}
generateRandomReferenceNumber(length: number): string {
  const characters = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
  let result = '';
  const charactersLength = characters.length;
  
  for (let i = 0; i < length; i++) {
    const randomIndex = Math.floor(Math.random() * charactersLength);
    result += characters.charAt(randomIndex);
  }
  console.log('Generated Reference Number:', result);
  
  return result;
}
}


