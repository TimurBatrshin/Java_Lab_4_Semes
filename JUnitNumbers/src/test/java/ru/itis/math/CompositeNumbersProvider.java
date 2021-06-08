package ru.itis.math;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class CompositeNumbersProvider implements ArgumentsProvider {
    private static final int NUMBER_COUNT = 5;
    private static final int HEIGHT = 100;
    private static final int LOW = 4;
    private final Random random = new Random();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            int first = LOW + random.nextInt(HEIGHT);
            int second = LOW + random.nextInt(HEIGHT);
            int compositeNumber = first * second;
            arguments.add(Arguments.of(compositeNumber));
        }
        return arguments.stream();
    }
}
