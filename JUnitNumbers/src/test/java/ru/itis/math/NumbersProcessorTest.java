package ru.itis.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("NumbersProcessorTest is working when")
@ExtendWith(MockitoExtension.class)
class NumbersProcessorTest {

    private final static List<Boolean> EXPECTED = Arrays.asList(true, true, false, true, false);
    @Mock
    private NumbersToBooleanMapper mapper;

    private NumbersProcessor processor;

    @BeforeEach
    public void setUp() {
        lenient().when(mapper.map(0)).thenThrow(IncorrectNumberException.class);
        lenient().when(mapper.map(7)).thenReturn(true);
        lenient().when(mapper.map(3)).thenReturn(true);
        lenient().when(mapper.map(10)).thenReturn(false);
        lenient().when(mapper.map(11)).thenReturn(true);
        lenient().when(mapper.map(121)).thenReturn(false);
        processor = new NumbersProcessor(mapper);
    }

    @ParameterizedTest(name = "return correct vector for {0}")
    @MethodSource(value = "correctNumbers")
    public void return_correct_list_for_numbers(List<Integer> numbers) {
        List<Boolean> actual = processor.map(numbers);
        assertThat(actual, containsInAnyOrder(EXPECTED.toArray()));
    }

    @ParameterizedTest(name = "throws exception for {0}")
    @MethodSource(value = "incorrectNumbers")
    public void throws_exception(List<Integer> numbers) {
        assertThrows(IncorrectNumberException.class, () -> processor.map(numbers));
    }

    public static Stream<Arguments> correctNumbers() {
        return Stream.of(Arguments.of(Arrays.asList(7, 3, 10, 11, 121)));
    }

    public static Stream<Arguments> incorrectNumbers() {
        return Stream.of(Arguments.of(Collections.singletonList(0)));
    }
}