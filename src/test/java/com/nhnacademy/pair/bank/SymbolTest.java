package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SymbolTest {

    SymbolCapture symbolCapture;

    @BeforeEach
    void setUp(){
        symbolCapture = new SymbolCapture();
    }

    @Test
    void Check_Symbol_Ordinal(){

        assertAll(
                ()-> assertThat(Symbol.KRW.ordinal()).isEqualTo(0),
                ()-> assertThat(Symbol.USD.ordinal()).isEqualTo(1)
        );
    }

    @Test
    void Check_Symbol_return(){
        String symbol = "$";

        assertThat(symbolCapture.getSymbol("USD")).isEqualTo(symbol);
    }

    @Test
    void Check_exchangeRate(){
        double exchangeRate = 1;

        assertThat(symbolCapture.getExchangeRate("USD")).isEqualTo(exchangeRate);
    }

    @Test
    void Check_InvalidValue_denomination(){
        assertThatThrownBy(()-> symbolCapture.checkName("sda")).isInstanceOf(InvalidDenominationException.class);
    }

    @Test
    void getMinpoint(){
        Money money = new Money(1000,"KRW");
//        assertThat(money.getMinPoint()).isEqualTo(10);
    }


}
