package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MoneyFactoryTest {

    MoneyFactory dollarFactory;

    @BeforeEach
    void setup(){
        dollarFactory = mock(DollarFactory.class);
    }

    @Test
    void is_Factory_Worked(){

        long amount = 1000L;
        int CURRENCY_TYPE = 1;

//        Money dollar = new Money(amount, 1);


//        dollarFactory.getMoney();

//        when().thenReturn(dollar);



        verify(dollarFactory).createMoney(amount);
    }

}
