package com.example.demo.ThreadStudy.callable;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    int number;

    public CallableTask(int number) {
        this.number = number;
    }

    public Integer call() throws InvalidParamaterException {
        int fact=1;
        if(number < 0)
            throw new InvalidParamaterException("Number must be positive");

        for(int count=number;count>1;count--){
            fact=fact * count;
        }

        return fact;
    }

    private class InvalidParamaterException extends Exception {
        public InvalidParamaterException(String message) {
            super(message);
        }
    }
}
