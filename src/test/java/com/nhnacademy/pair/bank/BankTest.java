package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BankTest {
    Bank bank;

    //SUT
    String USD;
    String KRW;

    //DOC
    SymbolCapture symbolCapture;
    Money money;

    @BeforeEach
    void setup(){
        bank = new FakeBank();

        USD = "USD";
        KRW = "KRW";

    }

    @Test
    void Bank_Exchange_WONtoUSD(){
        long amount = 10;
        Money won = new Money(amount,KRW);
        Money dollar = new Money(0.01,USD);
        String USD = "USD";

        assertThat(bank.exchange(won,USD)).isEqualTo(dollar);
    }
    @Test
    void Bank_Exchange_toString(){
        long amount = 3000;
        Money won = new Money(amount,KRW);
        String dollar = "3.0$";

        assertThat(bank.exchange(won,USD)).hasToString(dollar);
    }



}
class FakeBank implements Bank{
    @Override
    public Money exchange(Money money, String denomination) {
        SymbolCapture symbolCapture = new SymbolCapture();
        double exchangeRate = symbolCapture.getExchangeRate(denomination)/symbolCapture.getExchangeRate(money.getDenomination());

        double exchange = exchangeRate * money.getActualValue();

        return new Money(exchange,denomination);
    }
}