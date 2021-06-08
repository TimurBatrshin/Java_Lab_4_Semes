package ru.itis.math;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        NumbersUtil numbersUtil = new NumbersUtil();
        NumbersProcessor processor = new NumbersProcessor(numbersUtil);
        System.out.println(processor.map(Arrays.asList(2, 3, 169, 152)));
    }
}
