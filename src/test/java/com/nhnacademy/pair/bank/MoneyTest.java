package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MoneyTest {
    Money money;
    String type;

    @BeforeEach
    void setup(){
        money = mock(Money.class);
        type = "USD";
    }

    @Test
    void Money_Throw_NegativeAmountException(){
        assertThatThrownBy(()-> new Money(-1,type)).isInstanceOf(NegativeAmountException.class);
    }

    @Test
    void Money_Check_Created(){
        money = new Money(1000,type);
        assertThat(money).isNotNull();
    }

    @Test
    void Money_Check_Parameter(){
        long amount = 1000;
        money = new Money(amount,type);

        assertThat(money.getAmount()).isEqualTo(amount);
    }

    @Test
    void Money_toString(){
        long amount = 10;
        String tenDollar = "10$";

        money = new Money(amount,type);

        assertThat(money).hasToString(tenDollar);
    }

}