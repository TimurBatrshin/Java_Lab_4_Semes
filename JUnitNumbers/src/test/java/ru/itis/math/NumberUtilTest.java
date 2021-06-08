package ru.itis.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("NumbersUtil is working when")
public class NumberUtilTest {
    private final NumbersUtil numbersUtil = new NumbersUtil();

    @DisplayName("isPrime() is working")
    @Nested
    class ForIsPrime {
        @ParameterizedTest(name = "throws exception on {0}")
        @ValueSource(ints = {0, 1})
        public void on_problems_number_throws_exception(int problemNumber) {
            assertThrows(IncorrectNumberException.class, () -> numbersUtil.isPrime(problemNumber));
        }

        @ParameterizedTest(name = "return <true> on {0}")
        @ValueSource(ints = {2, 3, 7, 113, 31, 41})
        public void on_prime_numbers_return_true(int primeNumber) {
            assertTrue(numbersUtil.isPrime(primeNumber));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ValueSource(ints = {121, 169})
        public void on_sqr_numbers_return_false(int sqrNumber) {
            assertFalse(numbersUtil.isPrime(sqrNumber));
        }

        @ParameterizedTest(name = "return false on {0}")
        @ArgumentsSource(value = CompositeNumbersProvider.class)
        public void on_composite_numbers_return_false(int compositeNumber) {
            assertFalse(numbersUtil.isPrime(compositeNumber));
        }
    }

    @Nested
    @DisplayName("gcd() is working")
    class ForGcd {
        @ParameterizedTest(name = "return {2} on a = {0} and b = {1}")
        @CsvFileSource(files = "src\\test\\resources\\gcd.csv")
        public void return_correct_gcd(int a, int b, int expected) {
            assertThat(numbersUtil.gcd(a, b), is(equalTo(expected)));
        }
    }

}
