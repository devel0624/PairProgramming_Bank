package com.nhnacademy.pair.bank;

public class DollarFactory extends MoneyFactory{
    @Override
    protected Money createMoney(long amount) {
        return new Money(1000L,1);
    }
}
