package com.nhnacademy.pair.bank;

import java.util.Arrays;

public enum Symbol {
    WON("₩"),
    USD("$");


    private final String symbol;
    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

}

