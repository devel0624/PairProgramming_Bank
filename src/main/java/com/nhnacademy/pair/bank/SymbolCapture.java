package com.nhnacademy.pair.bank;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SymbolCapture {
    public String getSymbol(String currencyName){
        return Arrays.stream(Symbol.values())
                .filter(symbol -> symbol.name().equals(currencyName))
                .collect(Collectors.toList())
                .get(0)
                .getSymbol();
    }

}