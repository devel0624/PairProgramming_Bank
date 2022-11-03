package com.nhnacademy.pair.bank;

public class NegativeAmountException extends RuntimeException{
    public NegativeAmountException(String message) {
        super("Negative Amount Exception "+message);
    }
}
