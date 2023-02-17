package com.techelevator.VendingMachine;

import java.math.BigDecimal;

public class Money {
    private BigDecimal balance = new BigDecimal("0.00");


    public BigDecimal getBalance() {
        return this.balance;
    }

    public void insertCash(BigDecimal input) {
        balance = balance.add(input);
    }

    public void reduceBalance(BigDecimal price) {
        if (balance.compareTo(price) >= 0) {
            balance = balance.subtract(price);

        } else {
            System.out.println("Don't have enough!");
        }

    }


        //check to see if balance is greater than item price using .compareTo()
        //set balance = balance.subtract(purchaseprice);

//    public int number5Cents;
//    public int number10Cents;
//    public int number20Cents;
//    public int number50Cents;
//    public int number100Cents;
//    public Money(int enteredMoney) {
//        this.number5Cents = enteredMoney[0];
//        this.number10Cents = enteredMoney[1];
//        this.number20Cents = enteredMoney[2];
//        this.number50Cents = enteredMoney[3];
//        this.number100Cents = enteredMoney[4];
//
//    }


}