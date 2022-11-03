package com.nhnacademy.pair.bank;

import java.util.Arrays;

public enum Symbol {
    KRW("₩",1000),
    USD("$",1);


    private final String symbol;
    private final double exchangeRate;
    Symbol(String symbol, double exchangeRate) {
        this.symbol = symbol;
        this.exchangeRate = exchangeRate;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
}

