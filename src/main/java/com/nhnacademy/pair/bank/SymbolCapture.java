package com.nhnacademy.pair.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SymbolCapture {
    public String getSymbol(String denomination){
        return Arrays.stream(Symbol.values())
                .filter(symbol -> symbol.name().equals(denomination))
                .collect(Collectors.toList())
                .get(0)
                .getSymbol();
    }

    public double getExchangeRate(String denomination) {
        return Arrays.stream(Symbol.values())
                .filter(symbol -> symbol.name().equals(denomination))
                .collect(Collectors.toList())
                .get(0)
                .getExchangeRate();
    }

    public void checkName(String denomination) {
          List<Symbol> list = Arrays.stream(Symbol.values())
                .filter(x -> x.name().equals(denomination))
                .collect(Collectors.toList());

          if(list.isEmpty()){
            throw new InvalidDenominationException(denomination);
        }
    }
}