package com.nhnacademy.pair.bank;

public enum Symbol {
    WON("W",1),
    USD("$",2);


    private final String symbol;
    private final int code;
    Symbol(String symbol , int code) {
        this.symbol = symbol;
        this.code = code;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getCode() {
        return this.code;
    }
}

