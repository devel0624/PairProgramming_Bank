package com.nhnacademy.pair.bank;

public class Money{
    private final long amount;

    private final String symbol;
    private final String denomination;

    public Money(long amount, String denomination) {
        check_Amount(amount);
        this.amount = amount;

        SymbolCapture symbolCapture = new SymbolCapture();
        this.symbol = symbolCapture.getSymbol(denomination);

        this.denomination = denomination;
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

    @Override
    public boolean equals(Object money) {
        if( this.denomination.equals( ((Money)money).getDenomination()) ){
            return this.getAmount() == ((Money)money).getAmount();
        }
        return false;
    }

    public Money add(Money money1) {
        return  new Money(this.amount + money1.getAmount(), denomination);
    }

    public String getDenomination() {
        return denomination;
    }
}
