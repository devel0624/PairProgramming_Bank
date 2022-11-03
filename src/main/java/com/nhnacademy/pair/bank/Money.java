package com.nhnacademy.pair.bank;

public class Money{
    private final long amount;
    private final String symbol;
    private final String denomination;

    private double minPoint;

    public Money(long amount, String denomination) {
        checkNegativeAmount(amount);

        SymbolCapture symbolCapture = new SymbolCapture();

        minPoint = (symbolCapture.getExchangeRate(denomination)/100);



        this.amount = amount;

        this.denomination = denomination;

        this.symbol = symbolCapture.getSymbol(denomination);

        this.minPoint = 1;
    }

    public Money(double amount, String denomination) {
        this((long)(amount * 100), denomination);
        checkAllowedDecimal(denomination);
        this.minPoint = 0.01;
    }

    private static void checkAllowedDecimal(String denomination) {
        if(!denomination.equalsIgnoreCase("USD")){
            throw new NotAllowedDecimalCurrencyException(denomination);
        }
    }

    private void checkNegativeAmount(long amount){
        if(amount < 0){
            throw new NegativeAmountException(String.valueOf(amount));
        }
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return getActualValue() + symbol;
    }

    public double getActualValue() {
        return amount * minPoint;
    }

    @Override
    public boolean equals(Object money) {
        if( this.denomination.equals( ((Money)money).getDenomination()) ){
            return this.getActualValue() == ((Money)money).getActualValue();
        }
        return false;
    }

    public Money add(Money money) {
        return  new Money(this.getActualValue() + money.getActualValue(), denomination);
    }

    public Money sub(Money money) {
        return  new Money(this.getActualValue() - money.getActualValue(), denomination);
    }

    public String getDenomination() {
        return denomination;
    }
}
