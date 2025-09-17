package com.ericchan.interview.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void fizzBuzzUpTo15_matchesExpectedSequence() {
        var fb = new FizzBuzz();
        List<String> result = fb.solve(15);

        assertThat(result).containsExactly(
            "1", "2", "Fizz", "4", "Buzz",
            "Fizz", "7", "8", "Fizz", "Buzz",
            "11", "Fizz", "13", "14", "FizzBuzz"
        );
    }

    @Test
    void fizzBuzzHandlesSmallNumbers() {
        var fb = new FizzBuzz();

        assertThat(fb.solve(1)).containsExactly("1");
        assertThat(fb.solve(2)).containsExactly("1", "2");
        assertThat(fb.solve(3)).containsExactly("1", "2", "Fizz");
        assertThat(fb.solve(5)).containsExactly("1", "2", "Fizz", "4", "Buzz");
    }

    @Test
    void fizzBuzzHandlesOnlyFizzBuzzAtEnd() {
        var fb = new FizzBuzz();

        // n = 30 should end with ... "FizzBuzz"
        List<String> result = fb.solve(30);

        assertThat(result.get(14)).isEqualTo("FizzBuzz"); // 15th element
        assertThat(result.get(29)).isEqualTo("FizzBuzz"); // 30th element
    }

    @Test
    void fizzBuzzEmptyInput_returnsEmptyList() {
        var fb = new FizzBuzz();
        assertThat(fb.solve(0)).isEmpty();
    }
}
