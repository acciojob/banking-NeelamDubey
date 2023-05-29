package com.driver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {

    }

    public BankAccount() {
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        StringBuilder sb=new StringBuilder();
        for(int i=0;i< sb.length();i++)
        {
            if(sum>=9)
            {
                sb.append(9);
                sum-=9;
            }else {
                sb.append(sum);
                sum=0;
            }
            if(sum>0){
                throw new Exception("Account Number can not be generated");
            }return sb.toString();

        }

        return null;
    }

    public void deposit(double amount) {
       this.balance+=amount;
        //add amount to balance

    }

    public void withdraw(double amount) throws Exception {
        double remainBalance=this.balance-amount;
        if (remainBalance<this.minBalance){
            throw new Exception("Insufficient Balance");
        }else {
            this.balance-=amount;
        }
    }

}