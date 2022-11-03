package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class MoneyTest {
    Money money;
    String denomination;

    @BeforeEach
    void setup(){
        money = mock(Money.class);
        denomination = "USD";
    }

    @Test
    void Money_Throw_NegativeAmountException(){
        assertThatThrownBy(()-> new Money(-1, denomination)).isInstanceOf(NegativeAmountException.class);
    }

    @Test
    void Money_Check_Created(){
        money = new Money(1000, denomination);
        assertThat(money).isNotNull();
    }

    @Test
    void Money_Check_Parameter(){
        long amount = 1000;
        money = new Money(amount, denomination);

        assertThat(money.getActualValue()).isEqualTo(amount);
    }

    @Test
    void Money_Check_CurrencyName(){
        long amount = 1000;
        money = new Money(amount, denomination);

        assertThat(money.getDenomination()).isEqualTo(denomination);
    }

    @Test
    void Money_toString(){
        long amount = 10;
        String tenDollar = "10$";

        money = new Money(amount, denomination);

        assertThat(money).hasToString(tenDollar);
    }

    @Test
    void Money_Compare_Same_Denomination(){
        long amount = 1000;
        Money money1 = new Money(amount, denomination);
        Money money2 = new Money(amount, denomination);

        assertThat(money1).isEqualTo(money2);
    }

    @Test
    void Money_Compare_Another_Denomination(){
        long amount = 1000;
        Money money1 = new Money(amount, denomination);
        Money money2 = new Money(amount, "WON");

        assertThat(money1).isNotEqualTo(money2);
    }

    @Test
    void Money_Add_Same_Denomination(){
        long amount = 1000;
        Money money1 = new Money(amount, denomination);
        Money money2 = new Money(2000, denomination);

        assertThat(money1.add(money1)).isEqualTo(money2);
    }
    @Test
    void Money_Add_Another_Denomination(){
        long amount = 1000;
        Money money1 = new Money(amount, denomination);
        Money money2 = new Money(2000, "WON");

        assertThat(money1.add(money1)).isNotEqualTo(money2);
    }

    @Test
    void Money_Add_toString(){
        long amount = 1000;
        Money money1 = new Money(amount, denomination);

        String dollar = "2000$";

        assertThat(money1.add(money1)).hasToString(dollar);
    }
    @Test
    void Money_Sub_BiggerMoney(){
        Money smallMoney = new Money(1000, denomination);
        Money bigMoney = new Money(2000, denomination);

        assertThatThrownBy(() -> smallMoney.sub(bigMoney))
                .isInstanceOf(NegativeAmountException.class);
    }
    @Test
    void Money_Dollar_Decimal(){

        money = new Money(5.25 , denomination);

        assertThat(money).hasToString("5.25$");
    }

    @Test
    void Money_Add_Dollar_Decimal(){

        money = new Money(5.25 , denomination);
        Money money2 = new Money(10.50,denomination);

        assertThat(money.add(money)).isEqualTo(money2);
    }
    @Test
    void Money_sub_Dollar_Decimal(){

        money = new Money(5.25 , denomination);
        Money money2 = new Money(10.50,denomination);

        assertThat(money2.sub(money)).isEqualTo(money);
    }






}