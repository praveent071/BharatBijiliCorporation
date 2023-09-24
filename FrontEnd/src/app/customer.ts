import { MonthlyBill } from "./monthly-bill";   

export class Customer {
    customerId!: number;
    name!: string;
    email!: string;
    phoneNumber!: number;
    monthlyBills!: MonthlyBill[]; 
}

