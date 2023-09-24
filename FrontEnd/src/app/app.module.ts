import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { PaymentMethodComponent } from './payment-method/payment-method.component';
import { HttpClientModule } from '@angular/common/http';
import { DebitcardComponent } from './credit/debitcard/debitcard.component';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import { WalletComponent } from './wallet/wallet.component';
import { BilldetailsComponent } from './billdetails/billdetails.component';
import { CreditcardComponent } from './creditcard/creditcard.component';
import { InvoiceComponent } from './invoice/invoice.component';
import {MatRadioModule} from '@angular/material/radio';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PaymentMethodComponent,
    DebitcardComponent,
    WalletComponent,
    BilldetailsComponent,
    CreditcardComponent,
    InvoiceComponent
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatInputModule,
    BrowserAnimationsModule,MatButtonModule,MatIconModule,MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
