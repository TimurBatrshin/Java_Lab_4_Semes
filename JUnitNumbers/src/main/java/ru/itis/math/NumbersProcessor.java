package ru.itis.math;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class NumbersProcessor {

    private NumbersToBooleanMapper mapper;

    public NumbersProcessor(NumbersToBooleanMapper mapper) {
        this.mapper = mapper;
    }

    List<Boolean> map(List<Integer> numbers) {
        List<Boolean> result = new ArrayList<>();
        for (Integer value : numbers) {
            result.add(mapper.map(value));
        }
        return result;
    }
}
