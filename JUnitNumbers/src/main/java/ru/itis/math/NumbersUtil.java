package ru.itis.math;


public class NumbersUtil implements NumbersToBooleanMapper {
    public boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            throw new IncorrectNumberException();
        }

        if (number == 2 || number == 3) {
            return true;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    @Override
    public boolean map(int value) {
        return isPrime(value);
    }
}
