package com.company;

public class NegativeDoubleException extends Exception{
    NegativeDoubleException(){
        super("Input must be positive number");
    }
}
