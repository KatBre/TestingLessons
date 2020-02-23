package org.kb;


public class Calculator {
    private Subcalculator subcalculator;

    public Calculator(Subcalculator subcalculator) {

        this.subcalculator = subcalculator;
    }


    public int add(int... numbers) {
        int result = 0;
        for (int number : numbers) {
            result = subcalculator.add(result, number);
        }
        return result;
    }
}