package com.nhnacademy.pair.bank;

public class NotAllowedDecimalCurrencyException extends RuntimeException{
    public NotAllowedDecimalCurrencyException(String denomination) {
        super("Not Allowed Decimal Currency : " + denomination);
    }
}
