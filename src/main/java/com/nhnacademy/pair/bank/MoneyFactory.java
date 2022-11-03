package com.nhnacademy.pair.bank;

public abstract class MoneyFactory {

    public Money getMoney(long amount){
        Money money = createMoney(amount);
        return money;
    }

    protected abstract Money createMoney(long amount);
}
