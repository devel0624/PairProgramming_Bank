package com.nhnacademy.pair.bank;

public class Money implements Currency{
    long amount;

    String symbol;

    public Money(long amount, String currencyName) {
        check_Amount(amount);
        this.amount = amount;

        SymbolCapture symbolCapture = new SymbolCapture();
        this.symbol = symbolCapture.getSymbol(currencyName);
    }

    private void check_Amount(long amount){
        if(amount < 0){
            throw new NegativeAmountException(String.valueOf(amount));
        }
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return amount + symbol;
    }
}
