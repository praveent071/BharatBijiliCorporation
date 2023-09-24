import { Injectable } from '@angular/core';
import jsPDF from 'jspdf';
import { InvoiceComponent } from './invoice/invoice.component';


@Injectable({
  providedIn: 'root'
})
export class PdfseviseService {
  
  constructor() {
 
   }
  generatePdf(receiptData: any) {
    const doc = new jsPDF();
    doc.text('Receipt', 105, 10, { align: 'center' });
    doc.setFontSize(12);
    doc.text(`Transaction ID: ${receiptData.tid}`, 10, 20);
    doc.text(`Payment Amount: ${receiptData.amount}`, 10, 30);
    doc.text(`Reference Number: ${receiptData.ReferenceNumber}`, 10, 40);

    doc.save('receipt.pdf');
  }
}
