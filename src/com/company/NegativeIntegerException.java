package com.company;

public class NegativeIntegerException extends Exception{
    NegativeIntegerException(){
        super("Input must be positive number");
    }
}
