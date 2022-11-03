package com.nhnacademy.pair.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BankTest {

    NHNBank bank;

    @BeforeEach
    void setup(){
        bank = mock(NHNBank.class);
    }


}