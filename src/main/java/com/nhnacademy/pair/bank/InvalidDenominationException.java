package com.nhnacademy.pair.bank;

public class InvalidDenominationException extends RuntimeException{
    public InvalidDenominationException(String denomination) {
        super("Invalid Denomination Exception : "+denomination);
    }
}
