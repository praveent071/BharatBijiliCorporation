import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PaymentMethodComponent } from './payment-method/payment-method.component';
import { DebitcardComponent } from './credit/debitcard/debitcard.component';
import { WalletComponent } from './wallet/wallet.component';
import { CreditcardComponent } from './creditcard/creditcard.component';
import { BilldetailsComponent } from './billdetails/billdetails.component';
import { InvoiceComponent } from './invoice/invoice.component';

const routes: Routes = [
  {
    path:'login',
    component:LoginComponent,
  },
  {
    path:"payment-method/:selectedBillId",
    component:PaymentMethodComponent,
  },
  {
    path:"debit/:id",
    component:DebitcardComponent
  },
  {
    path:"wallet/:id",
    component:WalletComponent
  },
  {
    path:"credit/:selectedBillId",
    component:CreditcardComponent
  },{
    path:"bill/:customerId",
    component:BilldetailsComponent
  },
  {
    path:"",
    redirectTo:"login",
    pathMatch:'full'
  },
  {
    path:"invoice",
    component:InvoiceComponent
  },
  {
    path:"payment-method",
    component:PaymentMethodComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
