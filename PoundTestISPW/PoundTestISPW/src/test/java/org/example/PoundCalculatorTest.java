package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PoundCalculatorTest {

    @Test
    void converterTest() {
        // uso una variabile booleana per verificare se 3 kg sono maggiori di 6 pound
        Boolean check;
        // calcolo il valore in pound di 3 kg
        Double pound = PoundCalculator.converter(3.0);
        // verifico il valore restituito
        if (pound > 6f){
            check = true;
        } else {
            check = false;
        }
        // infine verifico che check sia true
        assertTrue(check);
    }
}