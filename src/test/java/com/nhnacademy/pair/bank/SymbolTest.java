package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SymbolTest {

    SymbolCapture symbolCapture;

    @BeforeEach
    void setUp(){
        symbolCapture = new SymbolCapture();
    }

    @Test
    void Check_Symbol_ordinal(){

        assertAll(
                ()-> assertThat(Symbol.WON.ordinal()).isEqualTo(0),
                ()-> assertThat(Symbol.USD.ordinal()).isEqualTo(1)
        );
    }

    @Test
    void Check_Symbol_return(){
        String symbol = "$";

        assertThat(symbolCapture.getSymbol("USD")).isEqualTo(symbol);
    }

}
