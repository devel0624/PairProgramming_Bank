package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolTest {

    @Test
    void Check_Symbol(){
        assertThat(Symbol.WON.getCode()).isEqualTo(1);
    }
}
