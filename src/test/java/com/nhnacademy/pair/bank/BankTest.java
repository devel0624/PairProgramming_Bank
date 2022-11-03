package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BankTest {

    Bank bank;
    String USD;
    String WON;

    @BeforeEach
    void setup(){
        bank = new FakeBank();
        USD = "USD";
        WON = "WON";

    }

    @Test
    void Bank_Exchange_WONtoUSD(){
        long amount = 1000;
        Money won = new Money(amount,WON);
        Money dollar = new Money(1,USD);
        String USD = "USD";

        assertThat(bank.exchange(won,USD)).isEqualTo(dollar);
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