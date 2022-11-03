package com.nhnacademy.pair.bank;

public class Money implements Currency{
    long amount;

    public Money(long amount, int i) {
        check_Amount(amount);
        this.amount = amount;
    }

    private void check_Amount(long amount){
        if(amount < 0){
            throw new NegativeAmountException(String.valueOf(amount));
        }
    }

    public long getAmount() {
        return amount;
    }
}
